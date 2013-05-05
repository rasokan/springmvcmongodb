package com.learn.springmvcmongodb.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springmvcmongodb.domain.User;
import com.learn.springmvcmongodb.repository.RoleRepository;
import com.learn.springmvcmongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Boolean delete(User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser == null) {
			return false;
		}

		// We must delete both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		roleRepository.delete(existingUser.getRole());
		userRepository.delete(existingUser);
		return true;
	}

	public User update(User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser == null) {
			return null;
		}

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.getRole().setRole(user.getRole().getRole());

		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		roleRepository.save(existingUser.getRole());
		return userRepository.save(existingUser);
	}

	public User read(User user) {
		return user;
	}

	public List<User> readAll() {
		return userRepository.findAll();
	}

	public User create(User user) {

	

		user.setId(UUID.randomUUID().toString());
		user.getRole().setId(UUID.randomUUID().toString());
		
		System.out.println("Entering into User service" + user.getFirstName()
				+ user.getLastName() + user.getId());

		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		roleRepository.save(user.getRole());
		return userRepository.save(user);
	}

}

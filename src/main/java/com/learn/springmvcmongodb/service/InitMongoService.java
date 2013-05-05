package com.learn.springmvcmongodb.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.learn.springmvcmongodb.domain.Role;
import com.learn.springmvcmongodb.domain.User;

public class InitMongoService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void init() {

		// Drop existing collections
		mongoTemplate.dropCollection("role");
		mongoTemplate.dropCollection("user");

		Role adminRole = new Role();
		adminRole.setId(UUID.randomUUID().toString());
		adminRole.setRole(1);

		Role userRole = new Role();
		userRole.setId(UUID.randomUUID().toString());
		userRole.setRole(2);

		User john = new User();
		john.setId(UUID.randomUUID().toString());
		john.setFirstName("John");
		john.setLastName("Smith");
		john.setPassword("21232f297a57a5a743894a0e4a801fc3");
		john.setRole(adminRole);
		john.setUsername("john");

		User jane = new User();
		jane.setId(UUID.randomUUID().toString());
		jane.setFirstName("Jane");
		jane.setLastName("Adams");
		jane.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
		jane.setRole(userRole);
		jane.setUsername("jane");

		mongoTemplate.insert(john, "user");
		mongoTemplate.insert(jane, "user");
		mongoTemplate.insert(adminRole, "role");
		mongoTemplate.insert(userRole, "role");
	}

}
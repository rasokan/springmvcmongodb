package com.learn.springmvcmongodb.dto;

import java.util.List;

import com.learn.springmvcmongodb.domain.User;

public class UserListDTO {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

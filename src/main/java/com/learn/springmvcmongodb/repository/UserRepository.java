package com.learn.springmvcmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springmvcmongodb.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
}

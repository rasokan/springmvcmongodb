package com.learn.springmvcmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springmvcmongodb.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}

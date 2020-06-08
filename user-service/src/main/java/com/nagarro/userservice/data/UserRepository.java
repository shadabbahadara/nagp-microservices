package com.nagarro.userservice.data;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.userservice.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}

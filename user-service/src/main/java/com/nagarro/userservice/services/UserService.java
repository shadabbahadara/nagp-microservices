package com.nagarro.userservice.services;

import com.nagarro.userservice.models.User;

public interface UserService {
	User getUser(int userId);

	User createUser(User user);
}

package com.nagarro.userservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.userservice.data.UserRepository;
import com.nagarro.userservice.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			// TODO NOT-FOUND 4040 exception
		}
		return user.get();
//		return new User("name", "23", "abs@gmail.com");
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}

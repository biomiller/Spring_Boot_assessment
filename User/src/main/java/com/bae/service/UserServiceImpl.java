package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo=userRepo;
	}

	@Override
	public String createUser(User user) {
		userRepo.save(user);
		return("Created new user");
	}

	@Override
	public String getUser(Long userId) {
		if (userRepo.existsById(userId)) {
			return("User exists.");
		} else {
			return("User does not exist.");
		}
	}

}

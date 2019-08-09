package com.bae.service;

import java.util.Optional;

import com.bae.entity.User;

public interface UserService {
	
	String createUser(User user);
	Optional<User> getUser(Long id);
	boolean findUser(Long id);

}

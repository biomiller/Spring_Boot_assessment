package com.bae.service;

import com.bae.entity.User;

public interface UserService {
	
	String createUser(User user);
	String getUser(Long userId);

}

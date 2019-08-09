package com.bae.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService=userService;
	}
	
	@PostMapping(value="/createUser", consumes="application/json")	
	public ResponseEntity<String> createUser(@RequestBody User user){
		
		ResponseEntity<String> response = new ResponseEntity<String>(userService.createUser(user),HttpStatus.OK);
		
		return(response);
		
	}
	
	@GetMapping(value="/getUser/{id}", produces="application/json")	
	public Optional<User> getUser(@PathVariable("id") Long id){
		
		return userService.getUser(id);
		
		
	}

}

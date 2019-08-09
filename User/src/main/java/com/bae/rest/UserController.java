package com.bae.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping(value="/createUser", consumes="application/json")	
	public ResponseEntity<String> createUser(@RequestBody User user){
		
		ResponseEntity<String> response = new ResponseEntity<String>(userService.createUser(user),HttpStatus.OK);
		
		return(response);
		
	}
	
	@GetMapping(value="/getUser/{userId}")	
	public ResponseEntity<String> getUser(@PathParam("userId") Long userId){
		
		ResponseEntity<String> response = new ResponseEntity<String>(userService.getUser(userId),HttpStatus.OK);
		
		return(response);
		
	}

}

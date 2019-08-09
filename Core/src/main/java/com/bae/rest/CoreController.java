package com.bae.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.CoreServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/core")
public class CoreController {
	
	private CoreServiceImpl coreService;
	
	@Autowired
	public CoreController(CoreServiceImpl coreService) {
		this.coreService=coreService;
	}
	
	
	@GetMapping(value="/pokemonNumber/{userId}/{number}", produces="applicatiom/json")
	public String getPokemonByNum(@PathVariable("userId") int userId, @PathVariable("number") int number) throws JsonParseException, JsonMappingException, IOException {
		return coreService.getPokemonByNum(userId, number);
	}
	
	@GetMapping(value="/pokemonName/{userId}/{name}", produces="applicatiom/json")
	public String getPokemonByName(@PathVariable("userId") int userId, @PathVariable("name") String name) throws JsonParseException, JsonMappingException, IOException {
		return coreService.getPokemonByName(userId, name);
	}
	
	@PostMapping(value="/createUser", consumes="application/json")
	public String createUser(@RequestBody String user) {
		return coreService.createUser(user);
	}
	
	
	

}

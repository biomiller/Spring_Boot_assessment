package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.CoreServiceImpl;

@RestController
@RequestMapping("/core")
public class CoreController {
	
	private CoreServiceImpl coreService;
	
	@Autowired
	public CoreController(CoreServiceImpl coreService) {
		this.coreService=coreService;
	}
	
	
	@GetMapping(value="/{userId}/{pokeNum}", produces="applicatiom/json")
	public String getPokemonByNum(@PathVariable("userId") int userId, @PathVariable("pokeNum") int pokeNum) {
		return coreService.getPokemonByNum(userId, pokeNum);
	}
	
	@GetMapping(value="/{userId}/{pokeName}", produces="applicatiom/json")
	public String getPokemonByNum(@PathVariable("userId") int userId, @PathVariable("pokeName") String pokeName) {
		return coreService.getPokemonByName(userId, pokeName);
	}
	
	@PostMapping(value="/createUser", consumes="application/json")
	public String createUser(@RequestBody String user) {
		return coreService.createUser(user);
	}
	
	
	

}

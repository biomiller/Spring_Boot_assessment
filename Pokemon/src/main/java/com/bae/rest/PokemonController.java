package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.PokemonServiceImpl;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	private PokemonServiceImpl pokemonService;
	
	@Autowired
	public PokemonController(PokemonServiceImpl pokemonService) {
		this.pokemonService=pokemonService;
	}
	
	

	@GetMapping(value = "/{id}/{number}", produces="application/json")
	public Object getPokemonByNum(@PathVariable("id") Long id, @PathVariable("number") String number){
				
		ResponseEntity<Object> response = new ResponseEntity<Object>(pokemonService.getPokemonByNum(id,number),HttpStatus.OK);
		
		return(response.getBody());
	
	}
	
	@GetMapping("/{id}/{name}")
	public ResponseEntity<Object> getPokemonByName(@PathVariable("id") Long id, @PathVariable("name") String name){
		ResponseEntity<Object> response = new ResponseEntity<Object>(pokemonService.getPokemonByName(id, name),HttpStatus.OK);
		
		return(response);
	
	}


}


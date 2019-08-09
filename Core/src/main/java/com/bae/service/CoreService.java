package com.bae.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface CoreService {
	
	String getPokemonByNum(int userId, int pokeNum) throws JsonParseException, JsonMappingException, IOException;
	String getPokemonByName(int userId, String pokeName) throws JsonParseException, JsonMappingException, IOException;
	String createUser(String user);
	
	
	

}

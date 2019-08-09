package com.bae.service;

public interface CoreService {
	
	String getPokemonByNum(int userId, int pokeNum);
	String getPokemonByName(int userId, String pokeName);
	String createUser(String user);
	
	
	

}

package com.bae.service;

import com.bae.entity.User;

public interface CoreService {
	
	String createUser(User user);
	String getPokemonByNum(int userId, int pokeNum);
	String getPokemonByName(int userId, String pokeName);
	
	
	

}

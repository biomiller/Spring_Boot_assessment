package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.User;

public class CoreServiceImpl implements CoreService {
	
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public CoreServiceImpl(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate=restTemplate;
		this.jmsTemplate=jmsTemplate;
	}


	@Override
	public String createUser(User user) {
		ResponseEntity<String> exchangeCreateUser = restTemplate.postForEntity("http://localhost:8081/user/", 
				user, String.class);
		
		return exchangeCreateUser.getBody();
	}

	@Override
	public String getPokemonByNum(int userId, int pokeNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPokemonByName(int userId, String pokeName) {
		// TODO Auto-generated method stub
		return null;
	}

}

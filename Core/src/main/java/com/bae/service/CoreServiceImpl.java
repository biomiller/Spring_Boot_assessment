package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

@Service
public class CoreServiceImpl implements CoreService {
	
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public CoreServiceImpl(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate=restTemplate;
		this.jmsTemplate=jmsTemplate;
	}


	@Override
	public String createUser(String user) {
				
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<String>(user,header);

		
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/user/createUser", 
				request, String.class);
		
		return response.getBody();
	}

	@Override
	public String getPokemonByNum(int userId, int number) {
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/pokemon/{userid}/{number}", 
				HttpMethod.GET, null, String.class);
		
		if(response != null) {
			return(response.getBody());
		} else {
			return("User does not exist.");
		}
	}

	@Override
	public String getPokemonByName(int userId, String pokeName) {
		// TODO Auto-generated method stub
		return null;
	}

}

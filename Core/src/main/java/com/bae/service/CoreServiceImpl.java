package com.bae.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.Search;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String getPokemonByNum(int userId, int number) throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/pokemon/"+userId+"/"+number, 
				HttpMethod.GET, null, String.class);
		
		if(response.getBody() != null) {
			
			
			ResponseEntity<String> exchangeUser = restTemplate.exchange("http://localhost:8081/user/getUser/" + userId, 
					HttpMethod.GET, null, String.class);
						
			ObjectMapper mapper = new ObjectMapper();
			
			Search search = mapper.readValue(exchangeUser.getBody(), Search.class);
			
			search.setSearchNum(number);
			
			jmsTemplate.convertAndSend("SearchQueue", search);
			
			return(response.getBody());
		} else {
			return("{\"User\":\"Does not exist.\"}");
		}
	}

	@Override
	public String getPokemonByName(int userId, String name) throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/pokemon/"+userId+"/"+name, 
				HttpMethod.GET, null, String.class);
		
		if(response.getBody() != null) {
			ResponseEntity<String> exchangeUser = restTemplate.exchange("http://localhost:8081/user/getUser/" + userId, 
					HttpMethod.GET, null, String.class);
						
			ObjectMapper mapper = new ObjectMapper();
			
			Search search = mapper.readValue(exchangeUser.getBody(), Search.class);
			
			search.setSearchTerm(name);
			
			jmsTemplate.convertAndSend("SearchQueue", search);
			
			return(response.getBody());
		} else {
			return("{\"User\":\"Does not exist.\"}");
		}
	}

}

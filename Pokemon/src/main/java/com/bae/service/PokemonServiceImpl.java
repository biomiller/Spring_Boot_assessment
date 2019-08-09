package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

	private RestTemplate restTemplate;

	@Autowired
	public PokemonServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<Object> getPokemonByNum(Long id, String number) {

		ResponseEntity<String> exchangeGetUser = restTemplate.exchange("http://localhost:8081/user/getUser/" + id,
				HttpMethod.GET, null, String.class);

		if (exchangeGetUser != null) {

			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

			HttpEntity<Object> entity = new HttpEntity<Object>("parameters", headers);

			return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + number, HttpMethod.GET, entity,
					Object.class);

		}

		return (null);
	}

	public ResponseEntity<Object> getPokemonByName(Long id, String name) {

		ResponseEntity<String> exchangeGetUser = restTemplate.exchange("http://localhost:8081/user/getUser/" + id,
				HttpMethod.GET, null, String.class);

		if (exchangeGetUser != null) {

			HttpHeaders headers = new HttpHeaders();
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

			HttpEntity<Object> entity = new HttpEntity<Object>("parameters", headers);

			return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + name, HttpMethod.GET, entity,
					Object.class);

		}

		return (null);
	}

}

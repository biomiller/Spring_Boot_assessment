package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.bae.entity.Search;
import com.bae.repository.SearchRepository;


@Service
public class Receiver {
	
	@Autowired
	private SearchRepository mongoRepo;
		
	@JmsListener(destination = "SearchQueue", containerFactory = "myFactory")
	public void receiveSearch(Search search) {
		String receiveSearch = "< Search Received >" + search.getMemberNumber() + ">";
		System.out.println(receiveSearch);
		mongoRepo.insert(search);

		
	}
	
	
		
	
}

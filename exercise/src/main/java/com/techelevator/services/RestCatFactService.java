package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		return restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
	}

}
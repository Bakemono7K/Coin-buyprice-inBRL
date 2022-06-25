package com.educandoweb.workshop.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.educandoweb.workshop.models.Coin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JPYService {

	public Coin getJPY() throws JsonMappingException, JsonProcessingException {

		RestTemplate rt = new RestTemplate();
		RestTemplateBuilder rtb = new RestTemplateBuilder();
		rt = rtb.build();

		ResponseEntity<String> response = rt.getForEntity("https://api.hgbrasil.com/finance/quotations?key=ae812229",
				String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode data = root.path("results");
		Double buyPrice = data.findPath("JPY").findValue("buy").asDouble();
		String name = data.findPath("JPY").findValue("name").toString();
		Coin JPY = new Coin(name, buyPrice);
		return JPY;
	}
	
}

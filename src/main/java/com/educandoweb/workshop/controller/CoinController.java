package com.educandoweb.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshop.models.Coin;
import com.educandoweb.workshop.services.DollarService;
import com.educandoweb.workshop.services.EURService;
import com.educandoweb.workshop.services.JPYService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	DollarService dollarService;
	@Autowired
	EURService EURService;
	@Autowired
	JPYService JPYService;

	@GetMapping("/USD")
	public Coin USDPrice() throws JsonMappingException, JsonProcessingException {
	
		return dollarService.getDollar();
	}
	@GetMapping("/EUR")
	public Coin EURPrice() throws JsonMappingException, JsonProcessingException {
	
		return EURService.getEUR();
	}
	@GetMapping("/JPY")
	public Coin JPYPrice() throws JsonMappingException, JsonProcessingException {
	
		return JPYService.getJPY();
	}

}

package com.educandoweb.workshop.models;

public class Coin {
	
	private String name;
	private double BRL;
	
	public Coin () {
		
	}

	public Coin(String name, double price) {
		this.name = name;
		this.BRL = price;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return BRL;
	}
	public void setPrice(double buy) {
		this.BRL = buy;
	}
	
	
}

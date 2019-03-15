package com.simplegame.fastone.controller;

public enum StagesEnun {
	
	APARTMENT("apartment"),
	COFFEESHOP("coffeeshop"),
	START("start");
	
	private String key;
	
	StagesEnun(String key){
		this.key = key;
	}
	
	public String getStage() {
		return this.key;
	}

}

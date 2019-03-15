package com.simplegame.fastone.model;

public class Item {
	
	private String name;
	private String descrition;
	private float points;

	public Item(String name, String descrition, float points) {
		super();
		this.name = name;
		this.descrition = descrition;
		this.points = points;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	
	

}

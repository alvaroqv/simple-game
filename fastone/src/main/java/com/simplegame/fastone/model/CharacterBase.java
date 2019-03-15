package com.simplegame.fastone.model;

import java.io.Serializable;
import java.util.List;

public abstract class CharacterBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7698666268103977221L;
	private String name;
	private String perfil;
	private float strength;
	private float health;
	private float experience;
	private List<Item> itens;
	
	public CharacterBase() {
		
	}
	
	public CharacterBase(String name, float strength, float health) {
		super();
		this.name = name;
		this.strength = strength;
		this.health = health;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getStrength() {
		return strength;
	}
	public void setStrength(float strength) {
		this.strength = strength;
	}
	public float getHealth() {
		return health;
	}
	public void setHealth(float health) {
		this.health = health;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public abstract float attack();
	
	public abstract float die();

	public boolean isCreated() {
		return (this.name != null ) & (this.perfil != null) ;
	}
	

}

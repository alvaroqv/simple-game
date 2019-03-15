package com.simplegame.fastone.model;

import java.io.Serializable;
import java.util.Random;

public class CharacterFriendsGame extends CharacterBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1641413149979768799L;

	public CharacterFriendsGame() {
		
	}

	public CharacterFriendsGame(String name, float strength, float health) {
		super(name, strength, health);
	}

	@Override
	public float attack() {
		Random random = new Random();
		int nAleatorio = random.nextInt(10);
		
		return this.getHealth()* nAleatorio;
	}

	@Override
	public float die() {
		// TODO Auto-generated method stub
		return 0;
	}

}

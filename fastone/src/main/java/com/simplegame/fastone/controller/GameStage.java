package com.simplegame.fastone.controller;

import java.util.List;

import com.simplegame.fastone.command.CommandEvent;
import com.simplegame.fastone.model.CharacterBase;
import com.simplegame.fastone.model.Item;

public abstract class GameStage implements IStage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8628287291551811863L;
	private String stage;
	private String description;
	private CharacterBase player;
	private List<CharacterBase> enemies;
	private List<CommandEvent> events;
	private List<Item> itens;


	public String getStage() {
		return stage;
	}

	protected void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public CharacterBase getPlayer() {
		return player;
	}

	protected void setPlayer(CharacterBase player) {
		this.player = player;
	}

	public List<CharacterBase> getEnemies() {
		return enemies;
	}

	protected void setEnemies(List<CharacterBase> enemies) {
		this.enemies = enemies;
	}

	public List<CommandEvent> getEvents() {
		return events;
	}

	protected void setEvents(List<CommandEvent> events) {
		this.events = events;
	}

	public List<Item> getItens() {
		return itens;
	}

	protected void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
 
}

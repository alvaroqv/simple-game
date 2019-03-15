package com.simplegame.fastone.controller;

import java.io.Serializable;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.model.CharacterBase;

public interface IStage extends Serializable{

	public void action(String command, CharacterBase player, AppContext context);
	
}

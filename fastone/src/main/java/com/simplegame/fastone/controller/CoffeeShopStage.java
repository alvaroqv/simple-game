package com.simplegame.fastone.controller;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.model.CharacterBase;
import com.simplegame.fastone.utils.MsgLoader;

public class CoffeeShopStage implements IStage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2019950368205785538L;

	@Override
	public void action(String command, CharacterBase player,  AppContext context) {
	 MsgLoader.printMsg("This Stage is not done. Please wait for the next release");
	 context.setStage(null);
	}

}

package com.simplegame.fastone;

import java.io.Serializable;

import com.simplegame.fastone.controller.IStage;
import com.simplegame.fastone.model.CharacterBase;

public class AppContext implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1942781157943314575L;

	private static final AppContext INSTANCE = new AppContext();
	
	private boolean quit = false;
	private CharacterBase player;
	private IStage stage;
	
    public static AppContext getInstance() {
        return INSTANCE;
    }

	public boolean quit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	public CharacterBase getPlayer() {
		return player;
	}

	public void setPlayer(CharacterBase player) {
		this.player = player;
	}

	public IStage getStage() {
		return stage;
	}

	public void setStage(IStage stage) {
		this.stage = stage;
	}
	

}

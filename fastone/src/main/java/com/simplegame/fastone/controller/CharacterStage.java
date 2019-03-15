package com.simplegame.fastone.controller;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.model.CharacterBase;
import com.simplegame.fastone.utils.MsgLoader;

public class CharacterStage implements IStage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4705000999157877714L;
	int step = 0;
	CharacterBase character;
	AppContext context;
	
	public void action(String command, CharacterBase character, AppContext context) {
		
		this.character = character;
		this.context = context;
		
		switch (this.step) {
			case 0:
				this.initialStep();
				break;
			case 1:
				this.stepOne(command);
				break;
			case 2:
				this.stepTwo(command);
				break;

		default:
			break;
		}
		

	}
	
	private void  initialStep(){
		this.step = 1;
		MsgLoader.printMsgKey("game.player.name");
	}

	private void stepTwo(String command) {
			if(command == null || command.isEmpty()) {
				MsgLoader.printMsgKey("game.invalid.key");
				
			}else if("1".equals(command) || "2".equals(command)){
				MsgLoader.printMsgKey("game.perfil.select");
				character.setPerfil(command);
				MsgLoader.printMsg(command);
				MsgLoader.printMsgKey("game.selected");
				this.step = 3;
				this.context.setStage(null);
			}
	}

	private void stepOne(String command) {
		
		
		if(character.getName() == null) {
			MsgLoader.printMsgKey("game.player.welcome");
			MsgLoader.printMsg(command);
			character.setName(command);
			MsgLoader.printMsgKey("game.player.perfil");
			this.step = 2;
		}
	}

}

package com.simplegame.fastone.controller;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.model.CharacterBase;
import com.simplegame.fastone.utils.MsgLoader;

public class ApartamentStage implements IStage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4353609450707108361L;
	int step = 0;
	CharacterBase character;
	AppContext context;

	@Override
	public void action(String command, CharacterBase player, AppContext context) {
		
		this.context = context;
		this.character = player;
		

		switch (this.step) {
		case 0:
			this.initialStep();
			break;
		case 1:
			this.step1(command);
			break;
		case 2:
			this.step2(command);
			break;
		case 3:
			this.step3(command);
			break;
		case 31:
			this.step31(command);
			break;		
		case 4:
			this.step4(command);
			break;
		case 41:
			this.step41(command);
			break;
		case 5:
			this.step5(command);
			break;
		case 51:
			this.step51(command);
			break;
		case 6:
			this.step6(command);
			break;	

		default:
			break;
		}
	}
	
	private void  initialStep(){
		this.step = 1;
		MsgLoader.printMsgKey("game.apart.welcome");
	}

	private void step1(String command) {
		if( "explore".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.explore");
			this.step = 2;
		}
	}
	
	private void step2(String command) {
		if("forward".equals(command)) {
			MsgLoader.printMsgKey("game.apart.forwardtable");
			this.step = 3;
		}
		if("left".equals(command)) {
			MsgLoader.printMsgKey("game.apart.leftcouch");
			this.step = 31;
		}
	}
	
	private void step3(String command) {
		if( "get".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.getpizza");
			this.step = 4;
		}
		if("left".equals(command)) {
			MsgLoader.printMsgKey("game.apart.leftcouch");
			this.step = 31;
		}
	}
	
	private void step31(String command) {
		if( "forward".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.backross");
			this.step = 41;
		}
	}
	
	private void step4(String command) {
		if( "left".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.leftcouch");
			this.step = 5;
		}
	}
	
	private void step41(String command) {
		if( "back".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.backtable");
			this.step = 3;
		}
		if( "attack".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.hitross");
			this.step = 51;
		}
	}
	
	private void step5(String command) {
		if( "forward".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.forwardross");
			this.step = 6;
		}
	}
	
	private void step6(String command) {
		if( "share".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.share");
			this.context.setStage(null);
			this.step = 99;
		}
		if( "attack".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.hitross");
			this.context.setQuit(true);
			this.step = 5;
		}
	}
	
	private void step51(String command) {
		if( "back".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.backtable");
			this.step = 3;
		}
		if( "attack".equals(command) ) {
			MsgLoader.printMsgKey("game.apart.gameover");
			this.context.setQuit(true);
			this.step = 99;
		}
	}

}

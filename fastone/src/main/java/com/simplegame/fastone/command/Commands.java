package com.simplegame.fastone.command;

public enum Commands {
	
	MOVE_FORWARD("foward"),
	MOVE_BACK("back"),
	MOVE_LEFT("left"),
	MOVE_RIGHT("right"),
	ATTACK("attack"),
	EXPLORE("explore"),
	SHARE("share"),
	SAVE("save"),
	GET_ITEM("get"),
	LOAD_GAME("load"),
	HELP("help");
	
	private String key;
	
	Commands(String key){
		this.key = key;
	}
	
	public String getCommand() {
		return this.key;
	}
	

}

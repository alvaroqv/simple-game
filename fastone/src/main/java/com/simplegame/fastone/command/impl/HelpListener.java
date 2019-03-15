package com.simplegame.fastone.command.impl;

import com.simplegame.fastone.command.CommandEvent;
import com.simplegame.fastone.command.CommandListener;
import com.simplegame.fastone.utils.MsgLoader;

public class HelpListener implements CommandListener{

	@Override
	public void execute(CommandEvent event) {
		MsgLoader.printMsgKey("menu.commands");
	}

}

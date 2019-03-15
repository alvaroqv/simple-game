package com.simplegame.fastone.command.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.command.CommandEvent;
import com.simplegame.fastone.command.CommandListener;
import com.simplegame.fastone.utils.MsgLoader;

public class SaveListener implements CommandListener{

	@Override
	public void execute(CommandEvent event) {
		MsgLoader.printMsgKey("game.saved");
		this.saveObject(event.getContext());
	}
	
	private void saveObject(AppContext context) {
		// write object to file
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("game.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(context);
			oos.close();
		} catch (IOException e) {
			System.out.println("Erro to Save Game");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

}

package com.simplegame.fastone.command.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.command.CommandEvent;
import com.simplegame.fastone.command.CommandListener;
import com.simplegame.fastone.utils.MsgLoader;

public class LoadListener implements CommandListener{

	@Override
	public void execute(CommandEvent event) {
		MsgLoader.printMsgKey("game.saved");
		this.loadObject(event.getContext());
		this.welcomeMsg(event.getContext());
	}
	
	private void welcomeMsg(AppContext context) {
		System.out.println("Welcome Back!");
		if(context.getPlayer() != null && context.getPlayer().isCreated()) {
			System.out.println("Player name:"+context.getPlayer().getName());
			System.out.println("Player perfil:"+context.getPlayer().getPerfil());
		}
		
		System.out.println("Stage:");
	}
	
	private void loadObject(AppContext context) {
		// read object from file
		FileInputStream fis;

		try {
			fis = new FileInputStream("game.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			context = (AppContext) ois.readObject();
			ois.close();
		} catch ( IOException | ClassNotFoundException e) {
			System.out.println("Erro to Load Game");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

}

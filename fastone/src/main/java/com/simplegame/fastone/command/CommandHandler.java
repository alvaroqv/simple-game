package com.simplegame.fastone.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.simplegame.fastone.AppContext;
import com.simplegame.fastone.exception.BaseGameException;

/**
 * 
 * @author alvaro
 *
 */
public class CommandHandler {
	
	private static final CommandHandler INSTANCE = new CommandHandler();
	private Map<String,CommandEvent> commands;
	
	private CommandHandler() { 
			this.commands = new ConcurrentHashMap<String,CommandEvent>();
			try {
				commands = CommandFactory.getCommandMap();
			} catch (BaseGameException e) {
				System.out.println("Erro to Load Game");
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
    }
     
    public static CommandHandler getInstance() {
        return INSTANCE;
    }
	
	public void execute(String key, AppContext context){
		if(this.commands.containsKey(key)) {
			this.commands.get(key).execute(context);
		}
	}

}

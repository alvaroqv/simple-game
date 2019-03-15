package com.simplegame.fastone.command;

import java.util.ArrayList;
import java.util.List;

import com.simplegame.fastone.AppContext;

/**
 * 
 * @author alvaro
 *
 */
public abstract class CommandEvent {
	
	private String name;
	private String id;
	private String description;
	private List<CommandListener> commandListeners;
	private AppContext context;
	
	public CommandEvent(String id, String name, String description) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.commandListeners = new ArrayList<CommandListener>();
	}
	
	public void execute(AppContext context) {
		this.context = context;
		commandListeners.stream().forEach(listener -> listener.execute(this));
	}
	
	public List<CommandListener> getCommandListeners(){
		return this.commandListeners;
	}

	public void addCommandListener(CommandListener listener) {
		if(this.commandListeners == null) {
			this.commandListeners = new ArrayList<CommandListener>();
		}
		commandListeners.add(listener);
		
	}
	
	public boolean removeCommandListener(CommandListener listener) {
		if(this.commandListeners == null) {
			return false;
		}
		return commandListeners.remove(listener);
		
	}
	
	public AppContext getContext() {
		return this.context;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

}

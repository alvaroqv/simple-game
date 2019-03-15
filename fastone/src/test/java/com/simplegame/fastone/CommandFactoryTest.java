package com.simplegame.fastone;

import static org.junit.Assert.*;

import org.junit.Test;

import com.simplegame.fastone.command.CommandFactory;
import com.simplegame.fastone.exception.BaseGameException;

public class CommandFactoryTest {

	@Test
	public void testLoadXML() {
		try {
			assertTrue(CommandFactory.getCommandList().size() != 0);
		} catch (BaseGameException e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testLoadListeners() {
		try {
			CommandFactory.getCommandList().stream().forEach(c -> c.execute(AppContext.getInstance()));
		} catch (BaseGameException e) {
			e.printStackTrace();
		}
	
	}

}

package com.simplegame.fastone;

import org.junit.Test;

import com.simplegame.fastone.command.CommandHandler;
import com.simplegame.fastone.exception.BaseGameException;

public class CommandHandlerTest {

	@Test
	public void test() throws BaseGameException {
		CommandHandler.getInstance().execute("help",AppContext.getInstance());
	}

}

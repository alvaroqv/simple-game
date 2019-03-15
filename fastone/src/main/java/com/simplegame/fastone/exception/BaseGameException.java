package com.simplegame.fastone.exception;

import com.simplegame.fastone.utils.MsgLoader;

public class BaseGameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2499578780276787371L;
	
	
	
	public BaseGameException(String message) {
		super(MsgLoader.getMsgByKey(message));
	}
	
	public BaseGameException(String message, Throwable cause) {
		super(MsgLoader.getMsgByKey(message),cause);
	}

}

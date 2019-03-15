package com.simplegame.fastone.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MsgLoader {
	
	static final ResourceBundle bundle = ResourceBundle.getBundle("msg", Locale.US);
	public static String getMsgByKey(String key) {
		return bundle.getString(key);
	}
	
	public static void printMsgKey(String key) {
		MsgLoader.printMsg(MsgLoader.getMsgByKey(key));
	}
	
	public static void printMsg(String msg) {
		System.out.println(msg);
	}

}

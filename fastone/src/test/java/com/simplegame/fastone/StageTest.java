package com.simplegame.fastone;

import static org.junit.Assert.*;

import org.junit.Test;

import com.simplegame.fastone.controller.StagesEnun;

public class StageTest {

	@Test
	public void test() {
		
		assertTrue(StagesEnun.APARTMENT.getStage().equals("apartment"));
		assertTrue(StagesEnun.COFFEESHOP.getStage().equals("coffeeshop"));
		assertTrue(StagesEnun.START.getStage().equals("start"));
		
	}

}

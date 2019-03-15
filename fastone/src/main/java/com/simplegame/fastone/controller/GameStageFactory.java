package com.simplegame.fastone.controller;

public class GameStageFactory {
	

	public static IStage getStageApartament() {
		return new ApartamentStage();
	}

	public static IStage getStageCoffeeShop() {
		return new CoffeeShopStage();
	}

	public static IStage getStageStart() {
		return new CharacterStage();
	}

}

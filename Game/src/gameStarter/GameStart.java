package gameStarter;

import java.awt.Color;

import eg.edu.alexu.csd.oop.game.GameEngine;
import gameWorld.GameWorld;

public class GameStart {
	
	public static void main(String[] args) {

		GameEngine.start("Very Simple Game in 99 Line of Code", new GameWorld(700, 700), Color.white);
	}
	


}

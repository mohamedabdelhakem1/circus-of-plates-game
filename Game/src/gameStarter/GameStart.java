package gameStarter;

import java.awt.image.BufferedImage;
import java.io.File;

import eg.edu.alexu.csd.oop.game.GameEngine;
import gameWorld.GameWorld;

public class GameStart {
	public static void main(String[] args) {
		
		GameEngine.start("",new GameWorld(700, 700, 0, 50)); 
	}
}

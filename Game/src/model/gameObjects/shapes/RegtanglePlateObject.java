package model.gameObjects.shapes;


import java.awt.image.BufferedImage;

import model.gameObjects.shapes.plate.PlateFlyWeight;

import java.awt.*;

public class RegtanglePlateObject extends ImageObject {
	private PlateFlyWeight flyWeight;
	public RegtanglePlateObject (int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		flyWeight = PlateFlyWeight.getInstance();
		spriteImages[0] = flyWeight.getRectangularPlate(color, width, height);
		setVisible(true);
	}
	
}
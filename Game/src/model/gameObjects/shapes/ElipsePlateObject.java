package model.gameObjects.shapes;


import java.awt.*;
import java.awt.geom.Ellipse2D;

import model.gameObjects.shapes.plate.PlateFlyWeight;

public class ElipsePlateObject extends ImageObject {
	private PlateFlyWeight flyWeight;
	public ElipsePlateObject(int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		flyWeight = PlateFlyWeight.getInstance();
		spriteImages[0] = flyWeight.getOvalPlate(color, width, height);
		setVisible(true);
	}
}
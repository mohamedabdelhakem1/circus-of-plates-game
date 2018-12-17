package gameObjects;


import java.awt.image.BufferedImage;
import java.awt.*;

public class RegtanglePlateObject extends Plate {

	public RegtanglePlateObject (int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		spriteImages[0] = PlateFlyWeight.getRectangularPlate(color, width, height);
		setVisible(true);
	}
}
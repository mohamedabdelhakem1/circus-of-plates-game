package model.gameObjects.shapes;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HarleyQuinnObject extends Plate {

	public HarleyQuinnObject(int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		try {
			spriteImages[0] = ImageIO.read(HarleyQuinnObject.class.getResource("/res/harley.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
	}

}

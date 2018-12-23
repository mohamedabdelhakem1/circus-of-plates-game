package model.gameObjects.shapes;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BatmanObject extends ImageObject {

	public BatmanObject(int posX, int posY, int width, int height, Color color) {
		super(posX, posY, width, height, color);
		try {
			spriteImages[0] = ImageIO.read(BatmanObject.class.getResource("/res/Batman_Logo_04.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(true);
	}
}

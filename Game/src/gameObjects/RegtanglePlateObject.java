package gameObjects;


import java.awt.image.BufferedImage;
import java.awt.*;

public class RegtanglePlateObject extends Plate {

	public RegtanglePlateObject (int posX, int posY, int width, int hight, Color color) {
		super(posX, posY, width, hight, color);
		spriteImages[0] = new BufferedImage(width, 40,	BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = spriteImages[0].createGraphics();
		g2.setPaint(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(20));// thickness of the line
		g2.draw(new Rectangle.Double(posX, posY, width, hight));
	}
}
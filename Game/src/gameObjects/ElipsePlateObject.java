package gameObjects;


import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ElipsePlateObject extends Plate {
	public ElipsePlateObject(int posX, int posY, int width, int hight, Color color) {
		super(posX, posY, width, hight, color);
		Graphics2D g2 = spriteImages[0].createGraphics();
		g2.setPaint(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(20));// thickness of the line
		g2.draw(new Ellipse2D.Double(posX, posY, width, hight));
	}
}
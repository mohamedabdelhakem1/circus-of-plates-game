package gameObjects.shapes;

import java.awt.*;
import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import plateFlyWeight.Observer;

public abstract class Plate implements GameObject, Observer {

	protected BufferedImage[] spriteImages = new BufferedImage[1];
	protected boolean attached = false;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isVisible;
	protected Boolean stopMoving = false;
	protected Color color;

	public Plate(int posX, int posY, int width, int height, Color color) {
		x = posX;
		y = posY;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public int getX() {
		
		return x;
	}

	@Override
	public void setX(int mX) {
	
		if(stopMoving) {
			
			return;
		}
		this.x = mX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		if (!attached ) {
			this.y = mY;
		}
		
	}

	

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	public Color getColor() {
		return color;
	}

	public void setVisible(boolean visible) {
		this.isVisible = visible;
	}

	@Override
	public void updateCoordinates(int x) {
		this.x = x;

	}
	@Override
	public void setattached(boolean s) {
		attached = s;
	}
	@Override
	public void setStopMoving(boolean s) {
		stopMoving = s;
	}
	public boolean getattached() {
		return attached;
	}
	public boolean getStopmoving() {
		return stopMoving;
	}
}


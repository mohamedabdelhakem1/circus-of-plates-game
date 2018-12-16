package gameObjects;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Stack implements GameObject{
	
	private int positionX;
	private int positionY;
	private int width ;
	private int height;
	private boolean visible = true;
	private BufferedImage[] clownImage = new BufferedImage[1];
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
	
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return null;
	}

}

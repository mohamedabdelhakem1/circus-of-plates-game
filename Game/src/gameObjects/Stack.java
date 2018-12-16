package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Stack implements GameObject {

	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean visible = true;
	private ArrayList<Plate> plates;
	private BufferedImage[] stackImage = new BufferedImage[1];
	private boolean leftLimit = false;
	private boolean rightLimit = false;

	public Stack(int x, int y) {
		positionX = x;
		positionY = y;
		try {
			stackImage[0] = ImageIO.read(new File("stack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = stackImage[0].getWidth();
		height = stackImage[0].getHeight();

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return positionX;
	}

	@Override
	public void setX(int x) {
		positionX = x;

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return positionY;
	}

	@Override
	public void setY(int y) {
		return;
		// positionY = y;

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return stackImage;
	}

	public void setLeftLimit(boolean setLeftLimit) {
		leftLimit = setLeftLimit;
	}

	public void setRightLimit(boolean setRightLimit) {
		rightLimit = setRightLimit;
	}

}

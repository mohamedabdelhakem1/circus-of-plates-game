package gameObjects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import clownBuilder.LeftStack;
import clownBuilder.RightStack;
import clownBuilder.Stack;
import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private boolean visible = true;

	private Stack leftStack;
	private Stack rightStack;

	private BufferedImage[] clownImage = new BufferedImage[1];

	public Clown(int positionX, int positionY) {

		this.positionX = positionX;
		this.positionY = positionY;

		try {
			clownImage[0] = ImageIO.read(new File("joker.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = clownImage[0].getWidth();
		height = clownImage[0].getHeight();
	}

	@Override
	public int getX() {

		return positionX;
	}

	@Override
	public void setX(int x) {
		leftStack.setPositionX(x + 51);
		rightStack.setPositionX(x + 157);
		positionX = x;

	}

	@Override
	public int getY() {

		return positionY;
	}

	@Override
	public void setY(int y) {
		// positionY = y;

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
		// TODO Auto-generated method stub
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return clownImage;
	}

	public void SetLeftStack(Stack leftStack) {
		this.leftStack = leftStack;
	}

	public Stack getLeftStack() {
		return leftStack;
	}

	public void setRightStack(Stack rightStack) {
		this.rightStack = rightStack;
	}

	public Stack getRightStack() {
		return rightStack;
	}

	
}

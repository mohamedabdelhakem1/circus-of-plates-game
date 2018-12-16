package gameObjects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {
	private int positionX;
	private int positionY;
	private int width ;
	private int height;
	private boolean visible = true;
	private ArrayList<Plate> leftStack;
	
	private ArrayList<Plate> rightStack;
	int stackCapacity = 0;
	

	private BufferedImage[] clownImage = new BufferedImage[1];
	
	public Clown(int positionX, int positionY, int stackCapacity ) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		this.stackCapacity = stackCapacity;
		
		
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
		positionX = x;

	}

	@Override
	public int getY() {

		return positionY;
	}

	@Override
	public void setY(int y) {
		//positionY = y;
		
	}

	@Override
	public int getWidth() {

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
		return clownImage;
	}
	
	
	public void addPlateToLeftStack(Plate plate) {
		
		leftStack.add(plate);
		
	}
	public void addPlateToRightStack(Plate plate) {
		
		rightStack.add(plate);
		
	}
	
	public ArrayList<Plate> getLeftStack() {
		return leftStack;
	}

	public ArrayList<Plate> getRightStack() {
		return rightStack;
	}
	
	public int getStackCapacity() {
		return stackCapacity;
	}


}

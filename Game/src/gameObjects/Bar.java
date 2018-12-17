package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Bar implements GameObject{
	private int positionX;
	private int positionY;
	private int width ;
	private int height;
	private boolean visible = true;
	private BufferedImage[] barImage = new BufferedImage[1];
	public Bar(int leftOrRightBar) {
		try {
			barImage[0] = ImageIO.read(new File("Bar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = barImage[0].getWidth() ;
		height = barImage[0].getHeight() ;
		
		if(leftOrRightBar == 1) {
			positionX = 0;
		}else {
			positionX = 400;
		}
		positionY = 0;
		
		width = 100;
		height = 100;
		
		
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
		positionY = y;
		
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
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return barImage;
	}

}

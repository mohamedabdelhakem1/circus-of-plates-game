package gameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Plate implements GameObject{

	protected BufferedImage[] spriteImages = new BufferedImage[1];

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isVisible;


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
		this.x = mX;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int mY) {
		
		 this.y = mY;
	}

	

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
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

	public Color getColor () {
		return color;
	}

	public void setVisible(boolean visible){
		this.isVisible = visible;
	}
	
	
	
}

//	public static final int SPRITE_HEIGHT = 5;
//	private static final int MAX_MSTATE = 1;
//	// an array of sprite images that are drawn sequentially
//	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
//	private int x;
//	private int y;
//	private int width;
//	private boolean visible;
//	private boolean horizontalOnly;
//
//	public BarObject(int posX, int posY, int width, boolean horizontalOnly, Color color){
//		this.x = posX;
//		this.y = posY;
//		this.width = width;
//		this.horizontalOnly = horizontalOnly;
//		this.visible = true;
//		// create a bunch of buffered images and place into an array, to be displayed sequentially
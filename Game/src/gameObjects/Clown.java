package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
		if (x == 0 || x == 1105) {
			notifyStacks();
			notifyStopStacks(true);
		} else {
			notifyStopStacks(false);
		}
		leftStack.setPositionX(x + 51);
		rightStack.setPositionX(x + 157);

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


	public boolean intersectStacks(Plate p) {
		int delta = 80;
		if ((Math.abs(p.getX() - rightStack.getPositionX()) <= delta)
				&& (Math.abs(p.getY() - rightStack.getPositiony()) == 0)) {
			rightStack.addPlate(p);
			notifyStacks();
			p.setattached();
			return true;
		} else if ((Math.abs(p.getX() - leftStack.getPositionX()) <= delta)
				&& (Math.abs(p.getY() - leftStack.getPositiony()) == 0)) {
			leftStack.addPlate(p);
			notifyStacks();
			p.setattached();
			return true;

		}
		return false;
	}

	private void notifyStacks() {
		leftStack.notifyPlates(positionX);
		rightStack.notifyPlates(positionX);
	}

	private void notifyStopStacks(boolean s) {
		leftStack.StopMoving(s);
		rightStack.StopMoving(s);
	}

}

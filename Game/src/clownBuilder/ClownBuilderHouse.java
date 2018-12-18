package clownBuilder;

import gameObjects.Clown;

public class ClownBuilderHouse implements ClownBuilder {
	private Stack leftStack;
	private Stack rightStack;
	private int positionX;
	private int positionY;
	private int leftStackCapacity;
	private int rightStackCapacity;

	private Clown clown;

	@Override
	public void createLeftStack() {
		leftStack = new LeftStack();
	}

	@Override
	public void createRightStack() {
		rightStack = new RightStack();

	}

	@Override
	public void setLeftCapacity(int capacity) {
		leftStack.setCapacity(capacity);

	}

	@Override
	public void setRightCapacity(int capacity) {
		rightStack.setCapacity(capacity);

	}

	@Override
	public void addStacksToClown() {
	clown.SetLeftStack(leftStack);
	clown.setRightStack(rightStack);	
	}
	
	@Override
	public Clown getClown() {
		return clown;
	}
	
	@Override
	public void setClownIntitialPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	@Override
	public void buildClown() {
		clown = new Clown(positionX, positionY);
	}

	@Override
	public void setStackSPositions() {
		leftStack.setPositionX(positionX + 51);
		leftStack.setPositionY(positionY);
		rightStack.setPositionX(positionX + 157);
		rightStack.setPositionY(positionY);	
	}

	
}

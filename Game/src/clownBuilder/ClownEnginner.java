package clownBuilder;

import gameObjects.Clown;

public class ClownEnginner {
	private ClownBuilder clownBuilderHouse;
	private int positionX;
	private int positionY;
	private int leftStackCapacity;
	private int rightStackCapacity;
	
	public ClownEnginner(int PositionX, int positionY, int leftStackCapacity, int rightStackCapacity) {
		clownBuilderHouse = new ClownBuilderHouse();
		this.positionX = PositionX;
		this.positionY = positionY;
		this.leftStackCapacity = leftStackCapacity;
		this.rightStackCapacity = rightStackCapacity;
	}
	
	public void makeClown() {
		clownBuilderHouse.setClownIntitialPosition(positionX, positionY);
		clownBuilderHouse.buildClown();
		clownBuilderHouse.createLeftStack();
		clownBuilderHouse.createRightStack();
		clownBuilderHouse.setLeftCapacity(leftStackCapacity);
		clownBuilderHouse.setRightCapacity(rightStackCapacity);
		clownBuilderHouse.addStacksToClown();
	}
	
	public Clown getClown() {
		return clownBuilderHouse.getClown();
	}

}

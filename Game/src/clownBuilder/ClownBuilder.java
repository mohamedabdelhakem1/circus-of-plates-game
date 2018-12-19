package clownBuilder;

import clownBuilder.stack.StackIF;
import gameObjects.Clown;

public interface ClownBuilder {
	
	public void createLeftStack();
	public void createRightStack();
	public void setLeftCapacity(int capacity);
	public void setRightCapacity(int capacity);
	public void addStacksToClown();
	public void setStackSPositions();
	public void setClownIntitialPosition(int positionX, int positionY);
	public void buildClown();
	public Clown getClown();
	
	

}

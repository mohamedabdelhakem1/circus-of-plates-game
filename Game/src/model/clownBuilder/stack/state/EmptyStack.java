package model.clownBuilder.stack.state;

import java.util.ArrayList;

import model.clownBuilder.stack.StackIF;
import model.gameObjects.shapes.Plate;

public class EmptyStack implements StackState {
	private StackIF stack;

	public EmptyStack(StackIF stack) {
		this.stack = stack;
	}

	@Override
	public boolean AddPlate(Plate plate) {
		stack.getStack().add(plate);
		plate.setY(stack.getLimit());
		stack.setLimit(stack.getLimit() - 15);
		plate.setX(stack.getPositionX());
		stack.setState(stack.getUnfullstackState());
		return true;
	}

	@Override
	public boolean removePlate(Plate plate) {	
		return false;
	}

	@Override
	public ArrayList<Plate> checkConsecutivePlate() {
		return new ArrayList<>();
	}

}

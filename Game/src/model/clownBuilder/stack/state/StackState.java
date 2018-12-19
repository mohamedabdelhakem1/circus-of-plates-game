package model.clownBuilder.stack.state;

import java.util.ArrayList;

import model.gameObjects.shapes.Plate;

public interface StackState {
	public boolean AddPlate(Plate plate);
	public boolean removePlate(Plate plate);
	public ArrayList<Plate> checkConsecutivePlate();
}

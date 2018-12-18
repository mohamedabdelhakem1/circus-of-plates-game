package clownBuilder.stack;

import java.util.ArrayList;

import gameObjects.Plate;

public interface StackState {
	public boolean AddPlate(Plate plate);
	public boolean removePlate(Plate plate);
	public ArrayList<Plate> checkConsecutivePlate();
}

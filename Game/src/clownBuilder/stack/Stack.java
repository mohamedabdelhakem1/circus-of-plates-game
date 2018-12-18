package clownBuilder.stack;

import java.util.ArrayList;
import gameObjects.Plate;

public class Stack implements StackIF {

	private StackState fullstate;
	private StackState unfullstate;
	private StackState emptyState;
	private StackState currentstate;
	private int capacity;
	private ArrayList<Plate> plates;
	private int positionX;
	private int positionY;
	private int stackbottom = 62;
	private int limit = 480 + 62;
	private int RelativeXtoClown; // 51-40 for left // 157-40 for the right

	public Stack(int x) {
		plates = new ArrayList<Plate>();
		RelativeXtoClown = x;
		fullstate = new FullStack(this);
		unfullstate = new UnfullStack(this);
		emptyState = new EmptyStack(this);
		currentstate = emptyState;
	}
	@Override
	public StackState getEmptyState() {
		
		return null;
	}
	@Override
	public StackState getFullstackState() {
		return fullstate;
	}
	@Override
	public StackState getUnfullstackState() {
		return unfullstate;
	}
	@Override
	public void setState(StackState state) {
		currentstate = state;
	}

	@Override
	public void setStack(ArrayList<Plate> plates) {
		this.plates = plates;
	}

	@Override
	public ArrayList<Plate> getStack() {
		// TODO Auto-generated method stub
		return plates;
	}

	@Override
	public boolean addPlate(Plate plate) {
		if (plates.size() == capacity) {
			currentstate = fullstate;
		} else if (plates.size() < capacity) {
			currentstate = unfullstate;
		}
		return currentstate.AddPlate(plate);
	}

	@Override
	public boolean removePlate(Plate plate) {
		return currentstate.removePlate(plate);
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;

	}

	@Override
	public int getCapacity() {

		return capacity;
	}

	@Override
	public int getSize() {
		return plates.size();
	}

	@Override
	public int getPositionX() {
		return positionX;
	}

	@Override
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	@Override
	public int getPositiony() {
		return positionY;
	}

	@Override
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public void notifyPlates(int x) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).updateCoordinates(x + RelativeXtoClown);
		}
	}

	@Override
	public void StopMoving(boolean s) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).setStopMoving(s);
		}

	}

	@Override
	public int getLimit() {
		return limit;
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}
	@Override
	public ArrayList<Plate> checkStack() {
		return currentstate.checkConsecutivePlate();
	}
	


}

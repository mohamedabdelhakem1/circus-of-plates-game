package clownBuilder.stack;

import java.util.ArrayList;

import gameObjects.Plate;

public class LeftStack implements Stack {
	

	private int capacity;
	private int size = 0;
	private ArrayList<Plate> plates ;
	private int positionX;
	private int positionY;
	private int stackbottom = 62;
	private int limit = 480 + 62;


	public LeftStack() {
		plates = new ArrayList<Plate>();
	}
	

	@Override
	public void setStack(ArrayList<Plate> plates) {
		// TODO Auto-generated method stub
		this.plates = plates;
	}

	@Override
	public ArrayList<Plate> getStack() {
		// TODO Auto-generated method stub
		return plates;
	}

	@Override
	public boolean addPlate(Plate plate) {

		System.out.println(positionY);
		if(plates.size() == 0) {
			plates.add(plate);
			plate.setY(limit);
			size++;
			limit -=15;
			plate.setX(positionX);
			return true;
		}else if (size < capacity) {
			plate.setY(limit);
			plates.add(plate);
			size++;
			limit-= 15;
			plate.setX(positionX);
			return true;
		}
		
		return false;

	}
	@Override
	public boolean removePlate(int positionFromTop) {
		// TODO Auto-generated method stub
		return false;
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
		return size;
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
			plates.get(i).updateCoordinates(x+51-40);
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

}

package clownBuilder;

import java.util.ArrayList;

import gameObjects.Plate;

public class LeftStack implements Stack {
	
	
	private int capcity;
	private int size = 0;
	private ArrayList<Plate> plates ;
	private int positionX;
	private int positionY;
	
	

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePlate(int positionFromTop) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCapacity(int capacity) {
		this.capcity = capacity;
		
	}

	@Override
	public int getCapacity() {
	
		return capcity;
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


}

package clownBuilder;

import java.util.ArrayList;

import gameObjects.Plate;

public class RightStack implements Stack {


	
	private int capcity;
	private int size = 0;
	private ArrayList<Plate> plates;
	
	public RightStack(){
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
}

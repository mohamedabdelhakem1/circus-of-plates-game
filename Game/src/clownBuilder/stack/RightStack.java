package clownBuilder.stack;

import java.util.ArrayList;

import gameObjects.Plate;

public class RightStack implements Stack {


	private int capcity;

	private int size = 0;
	private ArrayList<Plate> plates;
	private int positionX;
	private int positionY;
	private int stackbottom = 62;
	public RightStack() {
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


		if(plates.size() == 0) {
			plates.add(plate);
			plate.setY(positionY+stackbottom);
			size++;
			plate.setX(positionX);
			return true;
		}else if (size < capcity) {
			plate.setY(plates.get(0).getY()-(plates.size()*15));
			plates.add(plate);
			size++;
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
		// TODO Auto-generated method stub
		return positionX;
	}

	@Override
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	@Override
	public int getPositiony() {
		// TODO Auto-generated method stub
		return positionY;
	}

	@Override
	public void setPositionY(int positionY) {
		this.positionY = positionY;

	}

	@Override
	public void notifyPlates(int x) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).updateCoordinates(x+157-40);
		}
	}

	@Override
	public void StopMoving(boolean s) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).setStopMoving(s);
		}
	}

	@Override
	public void setLimit(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

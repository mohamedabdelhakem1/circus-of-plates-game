package clownBuilder;

import java.util.ArrayList;

import gameObjects.Plate;

public interface Stack {
	
	public void setStack(ArrayList<Plate> plates);
	
	public ArrayList<Plate> getStack();
	
	public boolean addPlate(Plate plate);
	
	public boolean removePlate(int positionFromTop);
	
	public void setCapacity(int capacity);
	
	public int getCapacity();
	
	public int getSize();
	
	public int getPositionX();

	public void setPositionX(int positionX);

	public int getPositiony() ;

	public void setPositionY(int positiony) ;
	
	public void notifyPlates(int x);
	
	

}

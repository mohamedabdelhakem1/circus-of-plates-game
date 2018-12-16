package gameWorld;

import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.INITIALIZE;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import gameObjects.ClownObject;

public class GameWorld implements World{
	private final List<GameObject> constantObjects ;
	private final List<GameObject> movingObjects ;
	private final List<GameObject> controllableObjects ;
	private final int width;
	private final int height;
	private int plateSpeed,clownSpeed;
	public GameWorld(int width, int height, int plateSpeed, int clownSpeed) {
		this.plateSpeed = plateSpeed;
		this.clownSpeed = clownSpeed;
		this.width =  width;
		this.height =  height;
		constantObjects = new LinkedList<GameObject>();
		movingObjects = new LinkedList<GameObject>();
		controllableObjects = new LinkedList<GameObject>();
		initialize();
	}

	private void initialize() {
		controllableObjects.add(new ClownObject(400, 400, "res\\joker.png"));
		
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return constantObjects;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		
		return movingObjects;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		
		return controllableObjects;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return plateSpeed;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return clownSpeed;
	}

}

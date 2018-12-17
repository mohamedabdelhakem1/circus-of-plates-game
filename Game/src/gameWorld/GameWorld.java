package gameWorld;

import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.INITIALIZE;

import clownBuilder.ClownEnginner;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import gameObjects.Clown;



public class GameWorld implements World {
	private int score = 0;
	private long endTime, startTime = System.currentTimeMillis();
	private int width;
	private int height;
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	
	public GameWorld(int height, int width) {
		this.width = width;
		this.height = height;

		ClownEnginner clownEnginner = new ClownEnginner(100, 400, 20, 20);
		clownEnginner.makeClown();
		
		control.add(clownEnginner.getClown());
	}

	@Override
	public List<GameObject> getConstantObjects() {

		// TODO Auto-generated method stub
		return constant;

	}

	@Override
	public List<GameObject> getMovableObjects() {

		// TODO Auto-generated method stub
		return moving;

	}

	@Override
	public List<GameObject> getControlableObjects() {

		// TODO Auto-generated method stub
		return control;

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
		return true;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {

		
		return 10;

	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub

		return 40;

	}

}

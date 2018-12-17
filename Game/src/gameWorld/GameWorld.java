package gameWorld;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.INITIALIZE;

import clownBuilder.ClownEnginner;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import gameObjects.Clown;
import gameObjects.Plate;
import gameObjects.PlateFactory;

public class GameWorld implements World {
	private int score = 0;
	private long endTime, startTime = System.currentTimeMillis();
	private int width;
	private int height;
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	private PlateFactory factory;

	public GameWorld(int height, int width) {
		this.width = width;
		this.height = height;
		factory = PlateFactory.getInstance();
		ClownEnginner clownEnginner = new ClownEnginner(100, 400, 20, 20);
		clownEnginner.makeClown();
		control.add(clownEnginner.getClown());
		for (int i = 0; i < 6; i++) {
			moving.add(factory.getPlate(width,height));	
		}	
	}
	
	
	@Override
	public boolean refresh() {
		for(GameObject plate : moving) {
			plate.setY(plate.getY()+2);
			plate.setX(plate.getX() + (Math.random() > 0.5 ? 1 : -1));
			if(plate.getY()== height) {
				plate.setY(0);
			}
		}
		
		return true;
	}
	@Override
	public List<GameObject> getConstantObjects() {
		return constant;

	}

	@Override
	public List<GameObject> getMovableObjects() {
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return control;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
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

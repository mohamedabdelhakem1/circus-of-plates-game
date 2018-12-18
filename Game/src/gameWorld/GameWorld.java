package gameWorld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import clownBuilder.ClownEngineer;
import clownBuilder.stack.StackIF;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import gameObjects.Clown;
import gameObjects.Plate;
import plateFlyWeight.PlateFactory;

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

		ClownEngineer clownEnginner = new ClownEngineer(100, 480, 14, 14);

		clownEnginner.makeClown();
		control.add(clownEnginner.getClown());
		for (int i = 0; i < 6; i++) {

			moving.add(factory.getPlate(width, height));

		}

	}

	@Override
	public boolean refresh() {

		for (GameObject plate : moving.toArray(new GameObject[moving.size()])) {
			plate.setY(plate.getY() + 2);
			plate.setX(plate.getX() + (Math.random() > 0.5 ? 1 : -1));
			if (((Clown) control.get(0)).intersectStacks((Plate) plate)) {
				moving.remove(plate);
				control.add(plate);
				if(((Clown) control.get(0)).CheckScore(control)) {
					score++;
				}
				moving.add(factory.getPlate(width, height));
			} else if (plate.getY() >= height) {
				plate.setY(0);
				plate.setX((new Random()).nextInt(width));

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
		return "score :" + String.valueOf(score);
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

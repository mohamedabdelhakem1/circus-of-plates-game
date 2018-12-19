package model.gameWorld;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import model.clownBuilder.ClownEngineer;
import model.gameObjects.Clown;

import model.gameObjects.shapes.Plate;

import model.gameObjects.shapes.plate.PlateFactory;
import model.gameStrategy.DifficultyFactory;
import model.gameStrategy.GameStrategyIF;
import model.memento.Caretaker;
import model.memento.Memento;
import model.memento.Originator;
import model.memento.SnapShotCommand;
import starter.GameStart;

public class GameWorld implements World {
	private Integer speed;
	private Integer controlspeed;
	private int score = 0;
	private long endTime, startTime = System.currentTimeMillis();
	private int width;
	private int height;
	private List<GameObject> constant = new LinkedList<GameObject>();
	private List<GameObject> moving = new LinkedList<GameObject>();
	private List<GameObject> control = new LinkedList<GameObject>();
	private PlateFactory factory;
	private ClownEngineer clownEngineer;
	private Clown clown;
	private DifficultyFactory difficultyFactory;
	private GameStrategyIF strategy;

	public GameWorld(int height, int width, String difficulty) {
		this.width = width;
		this.height = height;
		difficultyFactory = new DifficultyFactory();
		strategy = difficultyFactory.getDifficulty(difficulty);
		strategy.setGamePlay(factory, control, moving, clown, width, height, this);
		
	}

	@Override
	public boolean refresh() {
		if(System.currentTimeMillis() - startTime > 10000) {
			setSpeed(0);
		}
		for (GameObject plate : moving.toArray(new GameObject[moving.size()])) {
			plate.setY(plate.getY() + 2);
			plate.setX(plate.getX() + (Math.random() > 0.5 ? 1 : -1));
			if (((Clown) control.get(0)).intersectStacks((Plate) plate)) {
				moving.remove(plate);
				control.add(plate);
				if (((Clown) control.get(0)).CheckScore(control)) {
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
		return height;
	}

	@Override
	public String getStatus() {
		return "score :" + String.valueOf(score);
	}

	@Override
	public int getSpeed() {
	
		return speed;
	}

	@Override
	public int getControlSpeed() {
		return controlspeed;
	}

	public void setControlSpeed(int controlspeed) {
		this.controlspeed = controlspeed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setClowns(Clown clown) {
		this.clown = clown; 
	}
	public void setPlatesFactory(PlateFactory factory) {
		this.factory = factory; 
	}
	public void loadCheckpoint(int i) {
		SnapShotCommand command = new SnapShotCommand(this);
		command.execute(i);
		command.loadSnapShot();
	}

	public void setMemento(Memento memento) {
		score = memento.getScore();
		constant = memento.getConstant();
		control = memento.getControl();
		moving = memento.getMoving();
	}

	public void saveSnapshot() {
		Originator originator = new Originator();
		originator.set(score, moving, control, constant, clown);
		Caretaker.addMemento(originator.storeInMemento());
	}
}

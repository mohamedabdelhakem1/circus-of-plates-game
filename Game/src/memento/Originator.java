package memento;

import java.util.LinkedList;
import java.util.List;

import clownBuilder.ClownEngineer;
import clownBuilder.stack.Stack;
import clownBuilder.stack.StackIF;
import clownBuilder.stack.Iterator.Iterator;
import eg.edu.alexu.csd.oop.game.GameObject;
import gameObjects.Clown;
import gameObjects.shapes.ElipsePlateObject;
import gameObjects.shapes.Plate;
import gameObjects.shapes.RegtanglePlateObject;

// Memento Design Pattern

public class Originator {
	private Iterator iterator;
	private int score;
	private List<GameObject> constant;
	private List<GameObject> moving;
	private List<GameObject> control;
	private Clown clown;

	public void set(int score, List<GameObject> moving, List<GameObject> control, List<GameObject> constant,
			Clown clown) {
		this.moving = moving;
		this.control = control;
		this.score = score;
		this.constant = constant;
		this.clown = clown;
	}

	public Memento storeInMemento() {
		List<GameObject> controlMemento = new LinkedList<GameObject>();
		// clown memento
		ClownEngineer clownEnginner = new ClownEngineer(clown.getX(), clown.getY(), clown.getLeftStack().getCapacity(),
				clown.getLeftStack().getCapacity());
		Stack left = clown.getLeftStack().DeepClone();
		Stack right = clown.getRightStack().DeepClone();
		clownEnginner.makeClown();
		Clown newClown = clownEnginner.getClown();
		newClown.SetLeftStack(left);
		newClown.setRightStack(right);
		controlMemento.add(newClown);
		// controlled plates

		for (iterator = left.getIterator(); iterator.hasNext();) {
			Plate plate = (Plate) iterator.next();
			controlMemento.add(plate);
		}

		for (iterator = right.getIterator(); iterator.hasNext();) {
			Plate plate = (Plate) iterator.next();
			controlMemento.add(plate);
		}
		// constant objects
		List<GameObject> constantMemento = new LinkedList<GameObject>();
		for (GameObject gameObject : constant) {

		}
		// moving plates

		List<GameObject> movingMemento = new LinkedList<GameObject>();
		for (GameObject plate : moving) {
			Plate plateTemp;
			if (plate instanceof RegtanglePlateObject) {
				plateTemp = new RegtanglePlateObject(plate.getX(), plate.getY(), 80, 15,
						((RegtanglePlateObject) plate).getColor());
			} else {
				plateTemp = new ElipsePlateObject(plate.getX(), plate.getY(), 80, 15,
						((ElipsePlateObject) plate).getColor());
			}
			movingMemento.add(plateTemp);
		}
		return new Memento(score, movingMemento, controlMemento, constantMemento);
	}

	public void RestoreFromMemento(Memento memento) {
		this.moving = memento.getMoving();
		this.control = memento.getControl();
		this.score = memento.getScore();
		this.constant = memento.getConstant();
		for (GameObject clown : control) {
			if (clown instanceof Clown) {
				this.clown = (Clown) clown;
			}
		}
	}
}
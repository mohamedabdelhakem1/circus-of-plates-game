package memento;

import java.util.LinkedList;
import java.util.List;

import clownBuilder.ClownEngineer;
import eg.edu.alexu.csd.oop.game.GameObject;
import gameObjects.Clown;
import gameObjects.ElipsePlateObject;
import gameObjects.Plate;
import gameObjects.RegtanglePlateObject;

// Memento Design Pattern

public class Originator{
		
	private int score;
	private List<GameObject> constant;
	private List<GameObject> moving;
	private List<GameObject> control;
	private Clown clown;
		
		
		public void set(int score, List<GameObject> moving, List<GameObject> control ,List<GameObject> constant , Clown clown) { 
			this.moving = moving;
			this.control = control;
			this.score = score;
			this.constant = constant;
			this.clown = clown;
		}

	
		
		public Memento storeInMemento() { 
			List<GameObject> controlMemento = new LinkedList<GameObject>();
			ClownEngineer clownEnginner = new ClownEngineer(clown.getX(), clown.getY(), 20, 20);
			clownEnginner.makeClown();
			controlMemento.add(clownEnginner.getClown());
			// controlled plates
			for (GameObject plate : control) {
				Plate plateTemp;
				if (plate instanceof RegtanglePlateObject) {
					plateTemp = new RegtanglePlateObject(plate.getX(), plate.getY(), 80, 15,
							((RegtanglePlateObject) plate).getColor());
					controlMemento.add(plateTemp);
				} else if (plate instanceof ElipsePlateObject){
					plateTemp = new ElipsePlateObject(plate.getX(), plate.getY(), 80, 15,
							((RegtanglePlateObject) plate).getColor());
					controlMemento.add(plateTemp);
				}
			}
			//constant objects
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
							((RegtanglePlateObject) plate).getColor());
				}
				movingMemento.add(plateTemp);
			}
			return new Memento(score, movingMemento, controlMemento ,constantMemento);
		}
		  
	}
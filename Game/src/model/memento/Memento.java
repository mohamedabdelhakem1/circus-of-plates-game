package model.memento;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

//Memento Design Pattern
//Used stores an objects state at a point in time
//so it can be returned to that state later. It
//simply allows you to undo/redo changes on an Object

public class Memento {
	
	// The article stored in memento Object
	
	private int score;
	private List<GameObject> constant;
	private List<GameObject> moving;
	private List<GameObject> control;

	// Save a new article String to the memento Object
	
	public Memento(int score, List<GameObject> moving, List<GameObject> control ,List<GameObject> constant ) {
		this.moving = moving;
		this.control = control;
		this.score = score;
		this.constant = constant;
	}
	
	// Return the value stored in article 
	
	public int getScore() {
		return score;
	}

	public List<GameObject> getConstant() {
		return constant;
	}

	public List<GameObject> getControl() {
		return control;
	}

	public List<GameObject> getMoving() {
		return moving;
	}
	
}
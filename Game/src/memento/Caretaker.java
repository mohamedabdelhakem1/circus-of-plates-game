package memento;
//Memento Design Pattern Tutorial

import java.util.ArrayList;

 public class Caretaker {

	private static ArrayList<Memento> GameCheckPoints = new ArrayList<Memento>();
	private Caretaker() {
		
	}
	public static void addMemento(Memento m) {
		GameCheckPoints.add(m);
	}

	public static Memento getMemento(int index) {
		return GameCheckPoints.get(index);
	}
}
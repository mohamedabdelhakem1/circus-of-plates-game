package model.memento;
//Memento Design Pattern Tutorial

import java.util.ArrayList;

import javax.swing.JOptionPane;

 public class Caretaker {

	private static ArrayList<Memento> GameCheckPoints = new ArrayList<Memento>();
	private Caretaker() {
		
	}
	public static void addMemento(Memento m) {
		GameCheckPoints.add(m);
	}

	public static Memento getMemento(int index) {
		try {
			return GameCheckPoints.get(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no saved snapshots");
			return null;
		}
	
	}
}
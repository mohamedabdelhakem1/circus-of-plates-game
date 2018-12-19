package gameObjects.shapes.plate;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import gameObjects.shapes.Plate;

public class PlatesPool {
	private static PlatesPool pool;
	private static List<Plate> platesPoolUnused;
	private static Random random;

	private PlatesPool() {
		platesPoolUnused = new LinkedList<>();
		random = new Random();
	}

	public static PlatesPool getInstance() {
		if (pool == null) {
			pool = new PlatesPool();
		}
		return pool;
	}

	public Plate PopPlate() {
		if (platesPoolUnused.size() == 0) {
			return null;
		}
		return platesPoolUnused.remove(random.nextInt(platesPoolUnused.size()));
	}

	public void PushPlate(Plate plate) {
		
		platesPoolUnused.add(plate);
	}
}

package gameObjects;

import java.awt.Color;
import java.util.Random;

public class PlateFactory {
	private static PlateFactory factory;
	private static Random randomGenerator;
	private final Color[] colors = new Color[] { Color.black, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.MAGENTA,
			Color.GRAY, Color.YELLOW, Color.ORANGE, Color.GREEN, Color.PINK, Color.LIGHT_GRAY, Color.red };

	private PlateFactory() {
		randomGenerator = new Random();
	}

	public static PlateFactory getInstance() {
		if (factory == null) {
			factory = new PlateFactory();
		}
		return factory;
	}

	public Plate getPlate(int width, int height) {
		int PlateType = randomGenerator.nextInt(2);
		Plate plate;
		if (PlateType == 0) {	
			plate = new RegtanglePlateObject(Math.abs(randomGenerator.nextInt(width-80)), 20, 80, 15, colors[randomGenerator.nextInt(colors.length)]);
		} else {	
			plate = new ElipsePlateObject(Math.abs(randomGenerator.nextInt(width-80)), 20, 80, 15, colors[randomGenerator.nextInt(colors.length)]);
		}

		return plate;
	}

}

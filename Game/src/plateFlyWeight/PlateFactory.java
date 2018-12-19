package plateFlyWeight;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import gameObjects.shapes.ElipsePlateObject;
import gameObjects.shapes.Plate;
import gameObjects.shapes.RegtanglePlateObject;

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
			// dynamic loading

			Class<? extends Plate> s = load("gameObjects.shapes.RegtanglePlateObject");
			Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
			try {
				Constructor constructor = s.getConstructor(parameterTypes);
				plate = (Plate) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
						randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(3)]);
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				plate = null;
				e.printStackTrace();
			}
			// plate = new
			// RegtanglePlateObject(Math.abs(randomGenerator.nextInt(width-80)),randomGenerator.nextInt(80)
			// , 80, 15, colors[randomGenerator.nextInt(3)]);
		} else {
			Class<? extends Plate> s = load("gameObjects.shapes.ElipsePlateObject");
			Class[] parameterTypes = new Class[] { int.class, int.class, int.class, int.class, Color.class };
			try {
				Constructor constructor = s.getConstructor(parameterTypes);
				plate = (Plate) constructor.newInstance(Math.abs(randomGenerator.nextInt(width - 80)),
						randomGenerator.nextInt(80), 80, 15, colors[randomGenerator.nextInt(3)]);
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				plate = null;
				e.printStackTrace();
			}
			// plate = new ElipsePlateObject(Math.abs(randomGenerator.nextInt(width - 80)),
			// randomGenerator.nextInt(80),80, 15, colors[randomGenerator.nextInt(3)]);
		}

		return plate;
	}

	public Class<? extends Plate> load(String className) {
		Class LoadedClass = null;
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			LoadedClass = classLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			System.out.println("error");
		}

		return LoadedClass;

	}
}

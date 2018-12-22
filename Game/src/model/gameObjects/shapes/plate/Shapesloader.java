package model.gameObjects.shapes.plate;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import model.gameObjects.shapes.Plate;

public class Shapesloader {
	private static Shapesloader shapesloader;
	private static Map<String, Class<? extends Plate>> classes ;
	private Shapesloader() {
		classes = new HashMap<>();
		load();
	}
	public static Shapesloader getInstance() {
		if(shapesloader ==  null) {
			shapesloader = new Shapesloader();
		}
		return shapesloader;
	}
	public void load() {
		JarFile file;
		try {//PlateClasses.jar
			//C:/Users/SHIKO/git/circusofplates/Game/
			file = new JarFile("PlateClasses.jar");
			URL[] urls = { new URL("jar:file:" + "PlateClasses.jar" + "!/") };
			ClassLoader classLoad = URLClassLoader.newInstance(urls);
			classLoad = new URLClassLoader(urls);
			Enumeration<JarEntry> enumeration = file.entries();
			while (enumeration.hasMoreElements()) {
				JarEntry jarEntry = enumeration.nextElement();
				if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
					continue;
				}
				String classname = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
				classname = classname.replace('/', '.');
				Class c = classLoad.loadClass(classname);
				classes.put(c.getName(),c);
				
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public Class<? extends Plate> load(String string) {
		return classes.get(string);
	}
	public Map<String, Class<? extends Plate>> loadAllclasses() {
		return classes;
	}
}

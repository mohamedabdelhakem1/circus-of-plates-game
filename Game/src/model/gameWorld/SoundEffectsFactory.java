package model.gameWorld;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.gameObjects.Clown;

public class SoundEffectsFactory {
	private static Thread thread1;
	private static Player player1;
	private static Thread thread2;
	public SoundEffectsFactory() {
		Runnable runnable = new Runnable() {
			public void run() {
			
					playMainTheme("resources/joker.mp3");
				
			}
		};
		thread1 = new Thread(runnable);
		thread1.start();
	}

	private void playMainTheme(String path) {
		File soundFile = new File(path);
		FileInputStream audioIn;
		try {
			try {
				audioIn = new FileInputStream(soundFile);
				player1 = new Player(audioIn);
				player1.play();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void playJokerLaugh() {

		Runnable runnable = new Runnable() {
			public void run() {
				
					playMainTheme("resources/jokerLaugh.mp3");
					thread2.stop();
				
			}
		};
		thread2 = new Thread(runnable);
		thread2.start();
	}
	public void destroy() {
		if(player1 !=  null) {
			player1.close();
		}
		
		
	}
}

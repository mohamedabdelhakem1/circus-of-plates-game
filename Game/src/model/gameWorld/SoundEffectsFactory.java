package model.gameWorld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.gameObjects.Clown;

public class SoundEffectsFactory {
	public SoundEffectsFactory() {
		Runnable runnable = new Runnable() {
			public void run() {
				while(true) {
					playMainTheme();
				}
			}
		};
		new Thread(runnable).start();
	}

	private void playMainTheme() {
		File soundFile = new File(Clown.class.getResource("/res/joker.mp3").getFile()); // you could also get the sound
																						// file with an URL
		FileInputStream audioIn;
		try {
			try {
				audioIn = new FileInputStream(soundFile);
				Player player = new Player(audioIn);
				player.play();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

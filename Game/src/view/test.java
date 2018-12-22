package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.omg.Messaging.SyncScopeHelper;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class test {

	public static void main(String[] args) {
		  // Open an audio input stream.           
        File soundFile = new File("C:/Users/SHIKO/Desktop/XMen.mp3"); //you could also get the sound file with an URL
        FileInputStream audioIn;
		
		try {
			try {
				audioIn = new FileInputStream(soundFile);
				Player player = new Player(audioIn);
				System.out.println();
				player.play();
				System.out.println("ddd");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		} catch (   JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}              
    
	}

}

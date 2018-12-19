package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import gameWorld.GameWorld;

public class GameStart {
	
	public static void main(String[] args) {

		/* allow pause, resume, and restart multiple worlds in the same frame */
		JMenuBar  menuBar = new JMenuBar();;
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem SnapshotMenuItem = new JMenuItem("snapshot");
		JMenuItem LoadSnapshot = new JMenuItem("load");
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menu.add(SnapshotMenuItem);
		menu.add(LoadSnapshot);
		menuBar.add(menu);
		GameWorld gameWorld = new GameWorld(700, 1300);
		final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", gameWorld, menuBar, Color.white);

		
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
	/*		JFrame frame = new JFrame("new game");
			frame.add(new JPanel());
			JOptionPane.showMessageDialog(frame,
				    "Eggs are not supposed to be green.");
			*/
			gameController.changeWorld(new GameWorld(700, 1300));
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		SnapshotMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameWorld.saveSnapshot();
				
			}
		});
		LoadSnapshot.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameWorld.loadCheckpoint(0);
			}
		});
		
	}
	


}

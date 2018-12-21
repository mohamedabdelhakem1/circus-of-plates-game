package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import model.gameWorld.GameWorld;
import model.memento.Caretaker;
import view.MainMenu;

public class Controller {
	private MainMenu mainMenu;

	public Controller(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
		mainMenu.addStartListener(new startListener());
	}

	class startListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JMenuBar menuBar = new JMenuBar();
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

			GameWorld gameWorld = GameWorld.getInstance(700, 1300, mainMenu.getSelectedDifficulty());
			final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code", gameWorld,
					menuBar, Color.white);

			newMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					gameController.changeWorld(GameWorld.getInstance(700, 1300, mainMenu.getSelectedDifficulty()));
				}
			});
			pauseMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameController.pause();
				}
			});
			resumeMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameController.resume();
				}
			});
			SnapshotMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameWorld.saveSnapshot();

				}
			});
			LoadSnapshot.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Object[] possibilities = new Object[Caretaker.NumberOfCheckpoints()];
					for (int i = 0; i < possibilities.length; i++) {
						possibilities[i] = "checkpoint " + String.valueOf(i + 1);
					}
					String s = (String) JOptionPane.showInputDialog(new JFrame(), "load checkpoint",
							"select the prefered checkPoint", JOptionPane.PLAIN_MESSAGE,
							new ImageIcon("Batman_Logo_04.png"), possibilities, "ham");

					// If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						
						gameWorld.loadCheckpoint(Integer.parseInt(s.substring(s.length() -1 , s.length())) - 1);
					}
					
				}
			});

		}

	}
}
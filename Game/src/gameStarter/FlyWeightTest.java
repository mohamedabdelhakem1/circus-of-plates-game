package gameStarter;

//The Flyweight design pattern is used when you need to
//create a large number of similar objects

//To reduce memory this pattern shares Objects that are 
//the same rather than creating new ones

import javax.swing.*;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FlyWeightTest extends JFrame {

	private static final long serialVersionUID = 1L;

	JButton startDrawing;

	int windowWidth = 1750;
	int windowHeight = 1000;

	// A new rectangle is created only if a new color is needed

	Color[] shapeColor = { Color.orange, Color.red, Color.yellow, Color.blue, Color.pink, Color.cyan, Color.magenta,
			Color.black, Color.gray };

	public static void main(String[] args) {

		new FlyWeightTest();

	}

	public FlyWeightTest(){
		
		// Create the frame, position it and handle closing it
		
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Flyweight Test");
		
		JPanel contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout());
		
		final JPanel  drawingPanel  = new JPanel();
		
		startDrawing = new JButton("Button 1");
		
		contentPane.add(drawingPanel,  BorderLayout.CENTER);
		
		contentPane.add(startDrawing, BorderLayout.SOUTH);
		
		startDrawing.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
	            Graphics g = drawingPanel.getGraphics();
	            
	            
	            long startTime = System.currentTimeMillis();
	        	BufferedImage plate = new BufferedImage(80, 15,	BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = plate.createGraphics();
				g2.setStroke(  new BasicStroke(3));
				g2.setColor(Color.black);
				g2.drawOval(0, 0, 79, 14);
				g2.setPaint(Color.RED);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.fillOval(2, 2, 76, 11);
				
	            drawingPanel.getGraphics().drawImage(plate, 500, 500, null);
	            long endTime = System.currentTimeMillis();

	            System.out.println("That took " + (endTime - startTime) + " milliseconds");
	            
	         }
	      });
		
		this.add(contentPane);
		
		this.setVisible(true);
		
	}

	// Picks random x & y coordinates

	private int getRandX() {
		return (int) (Math.random() * windowWidth);
	}

	private int getRandY() {
		return (int) (Math.random() * windowHeight);
	}

	// Picks a random Color from the 9 available

	private Color getRandColor() {
		Random randomGenerator = new Random();

		int randInt = randomGenerator.nextInt(9);

		return shapeColor[randInt];

	}

}
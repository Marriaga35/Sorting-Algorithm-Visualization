package InventoryTrackingSytem;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas
{
	private static final long serialVersionUID = 7067109205977516820L;	

	public Window(int width, int height, String title, InventoryTrackingSystem ITS) 
	{
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(ITS);
		frame.setVisible(true);
		ITS.start();

	}

}

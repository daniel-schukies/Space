package GUI;


import java.awt.Color;

import javax.swing.*;

public class Game extends JFrame{
	
	public Game(String title)
	{
		super(title);
		
		
		
		this.setSize(800, 600);
		
		this.add(new MyCanvas());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	
	}

}

package GUI;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class MyCanvas extends Canvas{
	public void paint(final Graphics g)
	{
		//super.paint(g);
		

		this.setBackground(Color.white);
		
		g.setColor(Color.BLACK);
		g.drawRect(20, 20, 80, 80);
	}

}

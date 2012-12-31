package Entity;
import java.awt.*;

public class Ship {
	private int xPos, yPos, width, height;
	private int xSpeed = 2;
	private int ySpeed = 2;
	private int yDir = 1;
	private int xDir = 1;
	private  Color colour = new Color(0,255,255);
	
	

	

	
	public Ship(int xPos, int yPos, int width, int height)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
	}
	
	public void move()
	{
		xPos = xPos + (xSpeed * xDir);
		yPos = yPos + (ySpeed * yDir);
	}
	
	public void draw()
	{
		
	}
}
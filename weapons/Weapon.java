package weapons;

import java.awt.Dimension;
import java.awt.Image;

import java.awt.Rectangle;

import java.io.IOException;

import javax.imageio.ImageIO;


public abstract class Weapon 
{

    private double xPosition, yPosition;
    private static Image weaponImage;
    boolean isVisible;
    private int width, height;

    private static int weaponCounter = 0;
    private final int WEAPON_SPEED = 2;
    private Dimension space;
    private double[] direction;
    private int[] startPosition;


    public Weapon(int x, int y, int[] dir, Dimension space) 
    {
    	
    	if(Weapon.weaponCounter == 0)
    	{
    		Image ii;
			try 
			{
				ii = ImageIO.read(this.getClass().getResource("/resource/cat.png"));
				Weapon.weaponImage = ii.getScaledInstance(120, 120, 0);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	Weapon.weaponCounter++;
    	System.out.println("weapons:" + Weapon.weaponCounter);
    	
        isVisible = true;
        width = 25;
        height = 25;
        
        this.direction = new double[2];
        this.startPosition = new int[2];
        
        // Richtungsvektor
        this.direction[0] = dir[0] -x ;
        this.direction[1] = dir[1] -y ;
        
        /*
        //Normieren
        this.dir[0] = (this.dir[0] / Math.sqrt( (this.dir[0]*this.dir[0]) + (this.dir[1]*this.dir[1])-2 )) ;
        this.dir[1] = (this.dir[1] / Math.sqrt( (this.dir[1]*this.dir[1]) + (this.dir[0]*this.dir[0])-2 )) ;
        */
        //System.out.println("x: " + this.dir[0] + "Y: " + this.dir[1]);
        
        this.startPosition[0] = x;
        this.startPosition[1] = y;
        
        this.xPosition = x;
        this.yPosition = y;
        
        this.space = space;
    }


    public void move() 
	{
		
	    xPosition +=  0.01*this.direction[0];
	    yPosition +=  0.01*this.direction[1];
	    
	    if(xPosition > this.space.getWidth() || yPosition > this.space.getHeight())
	    {
	    	this.setVisible(false);
	    }
	    
	   // if (x > this.space.getWidth())
	        //visible = false;
	}


	public void setVisible(Boolean visible) 
	{
	    this.isVisible = visible;
	}
	
	public void setImage(String filename)
	{
		
	}


	public boolean getIsVisible() 
	{
	    return isVisible;
	}


	public Image getImage() 
    {
        return weaponImage;
    }

    public Rectangle getBounds()
	{
	    return new Rectangle((int)xPosition, (int)yPosition, width, height);
	}


	public double getX()
    {
        return xPosition;
    }

    public double getY() 
    {
        return yPosition;
    }
}

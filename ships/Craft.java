package ships;

import math.Vektor;
import math.ImageRotate;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import weapons.Missile;


public class Craft
{

    private String craft = "/resource/star.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private BufferedImage image;
    private BufferedImage orgImage;
    private ArrayList missiles;
    private Dimension space;
    private double degree;
    private int[] oldMousePos;
    private int[] mousePosition;


    public Craft(Dimension space, int[] mousePosition) 
    {
    	this.degree = 0;
    	this.oldMousePos = new int[2];
    	this.oldMousePos[0] = 0;
    	this.oldMousePos[1] = 1;
    	this.mousePosition = mousePosition;
    	
        try 
        {
			BufferedImage image = ImageIO.read(getClass().getResource(craft));
	        BufferedImage resized = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
	        
	        Graphics g = resized.getGraphics();
	        g.drawImage(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH), 0, 0,null);
	        
	        this.image = resized;
	        this.orgImage = resized;
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		

        width = 200;
        height = 200;
        missiles = new ArrayList();
        visible = true;
        x = 40;
        y = 60;
        this.space = space;
    }


    public void move() 
    {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        
        //System.out.println("OLD-Mouse: " + this.oldMousePos[0] + " | " + this.oldMousePos[1] + " Neue Mouse-Pos " + this.mousePosition[0] + " | " + this.mousePosition[1] );

        double newDegree = Vektor.getSchnittwinkel(x, y, this.oldMousePos[0], this.oldMousePos[1], x, y, this.mousePosition[0], this.mousePosition[1]);
        
        this.oldMousePos[0] = this.mousePosition[0];
        this.oldMousePos[1] = this.mousePosition[1];

    	if(!Double.isNaN(newDegree))
    	{
    		int steigung = 0;
    		
    		try
    		{
    			steigung = (this.oldMousePos[1]-this.mousePosition[1]) / (this.oldMousePos[0]-this.mousePosition[0]);
    		}
    		catch(ArithmeticException e)
    		{
    			steigung = 0;
    		}
    		
    		//System.out.println("Steigung: " + steigung);

    		if( steigung > 0)
    		{
    			degree += newDegree;
    			
    			//System.out.println("Ende: " + degree);
    		}
    		else
    		{
    			degree -= newDegree;
    		}
    		image = ImageRotate.rotateImage(this.orgImage, degree);
    	}
    	else
    	{
    		newDegree = 0;
    	}

    }

    public int getX() 
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Image getImage() 
    {
        return image;
    }

    public ArrayList getMissiles() 
    {
        return missiles;
    }

    public void setVisible(boolean visible) 
    {
        this.visible = visible;
    }

    public boolean isVisible() 
    {
        return visible;
    }

    public Rectangle getBounds() 
    {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) 
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE)
        {
            fire();
        }

        if (key == KeyEvent.VK_A) 
        {
            dx = -1;
        }

        if (key == KeyEvent.VK_D)
        {
            dx = 1;
        }

        if (key == KeyEvent.VK_W) 
        {
            dy = -1;
        }

        if (key == KeyEvent.VK_S) 
        {
            dy = 1;
        }
    }

    @SuppressWarnings("unchecked")
	public void fire() 
    {
        missiles.add(new Missile(x + width/2, y + height/2, this.mousePosition, this.space));
        
        

    } 
        
        
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) 
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) 
        {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) 
        {
            dy = 0;
        }
    }




}
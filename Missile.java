import java.awt.Dimension;
import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile {

    private double x, y;
    private Image image;
    boolean visible;
    private int width, height;

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    private Dimension space;
    private double[] dir;
    private int[] startPosition;
    private int cnt;

    public Missile(int x, int y, int[] dir, Dimension space) 
    {

        ImageIcon ii = new ImageIcon(this.getClass().getResource("star.png"));
        image = ii.getImage().getScaledInstance(25, 25, 0);
        visible = true;
        width = 25;
        height = 25;
        
        this.cnt = 0;
        
        this.dir = new double[2];
        this.startPosition = new int[2];
        
        // Richtungsvektor
        this.dir[0] = dir[0] -x ;
        this.dir[1] = dir[1] -y ;
        
        /*
        //Normieren
        this.dir[0] = (this.dir[0] / Math.sqrt( (this.dir[0]*this.dir[0]) + (this.dir[1]*this.dir[1])-2 )) ;
        this.dir[1] = (this.dir[1] / Math.sqrt( (this.dir[1]*this.dir[1]) + (this.dir[0]*this.dir[0])-2 )) ;
        */
        System.out.println("x: " + this.dir[0] + "Y: " + this.dir[1]);
        
        this.startPosition[0] = x;
        this.startPosition[1] = y;
        
        this.x = x;
        this.y = y;
        
        this.space = space;
    }


    public Image getImage() 
    {
        return image;
    }

    public double getX()
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }

    public boolean isVisible() 
    {
        return visible;
    }

    public void setVisible(Boolean visible) 
    {
        this.visible = visible;
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public void move() 
    {
    	
        x +=  0.01*this.dir[0];
        y +=  0.01*this.dir[1];
        
        this.cnt++;
       // if (x > this.space.getWidth())
            //visible = false;
    }
}
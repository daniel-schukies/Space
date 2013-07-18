import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Alien {

	private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    private Dimension space;

    public Alien(int x, int y, Dimension space) 
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("gegner.gif"));
        image = ii.getImage().getScaledInstance(50, 50, 0);
        width = 50;
        height = 50;
        System.out.println("" +image.getHeight(null));
        visible = true;
        this.x = x;
        this.y = y;
        this.space = space;
    }


    public void move() {
        if (x < 0) 
            x = (int)this.space.getWidth();
        x -= 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
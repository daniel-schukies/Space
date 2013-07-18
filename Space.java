import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Space extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

    private Timer timer;
    private Craft craft;
    private ArrayList aliens;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    private int[] mousePosition;
    

    public Space() 
    {
    	this.mousePosition = new int[2];
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(new Color(33,33,24));
        setDoubleBuffered(true);
        ingame = true;
        
        this.addMouseListener(this);
        
        this.addMouseMotionListener(this);

        setSize(1200, 800);

        craft = new Craft(this.getSize(), this.mousePosition);

        initAliens();

        timer = new Timer(5, this);
        timer.start();
    }

    public void addNotify() 
    {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }

    @SuppressWarnings("unchecked")
	public void initAliens() 
    {
        aliens = new ArrayList(); 
        
        Random r = new Random();

        for (int i=0; i< 10; i++ ) 
        {
            aliens.add(new Alien( r.nextInt(this.getWidth()), r.nextInt(this.getHeight()), this.size() ) );
           
        }
        
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
    }


    public void paint(Graphics g) 
    {
        super.paint(g);
        ingame = true;
        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (craft.isVisible())
                g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),this);

            ArrayList ms = craft.getMissiles();



            for (int i = 0; i < aliens.size(); i++) 
            {
                Alien a = (Alien)aliens.get(i);
                if (a.isVisible())
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
            
            for (int i = 0; i < ms.size(); i++) 
            {
                Missile m = (Missile)ms.get(i);
                g2d.drawImage(m.getImage(), (int)Math.round(m.getX()), (int)Math.round(m.getY()), this);
            }

            g2d.setColor(Color.WHITE);
            g2d.drawString("Aliens left: " + aliens.size(), 5, 15);


        }
        else 
        {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                         B_HEIGHT / 2);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        if (aliens.size()==0) 
        {
            ingame = false;
        }

        ArrayList ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) 
        {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }

        for (int i = 0; i < aliens.size(); i++) 
        {
            Alien a = (Alien) aliens.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens.remove(i);
        }

        craft.move();
        checkCollisions();
        repaint();  
    }

    public void checkCollisions() 
    {

        Rectangle r3 = craft.getBounds();

        /*for (int j = 0; j<aliens.size(); j++) 
        {
            Alien a = (Alien) aliens.get(j);
            Rectangle r2 = a.getBounds();

            if (r3.intersects(r2)) 
            {
                craft.setVisible(false);
                a.setVisible(false);
                ingame = false;
                System.out.println("Crash");
            }
            else
            {
            	//System.out.println("No Crash");
            }
        }*/

        ArrayList ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) 
        {
            Missile m = (Missile) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<aliens.size(); j++) 
            {
                Alien a = (Alien) aliens.get(j);
                Rectangle r2 = a.getBounds();

                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    a.setVisible(false);
                }
            }
        }
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }


	@Override
	public void mouseDragged(MouseEvent e) {
		this.craft.fire();
		System.out.println("X: " + e.getXOnScreen());
		this.mousePosition[0] = e.getXOnScreen();
		this.mousePosition[1] = e.getYOnScreen();
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		this.mousePosition[0] = e.getXOnScreen();
		this.mousePosition[1] = e.getYOnScreen();
		

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.craft.fire();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
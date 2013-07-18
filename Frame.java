import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() 
    {
    	//System.setProperty("sun.java2d.opengl","True");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Collision");
       // setResizable(false);
        
        add(new Space());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
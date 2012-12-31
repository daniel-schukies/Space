import java.awt.*;

public class MyCanvas extends Canvas {
	public void paint(final Graphics g)
	{
		  g.drawRect(50, 50, 200, 200);
		  g.setColor(Color.BLACK);
		  g.drawLine(20, 20, 80, 80);
	}
}

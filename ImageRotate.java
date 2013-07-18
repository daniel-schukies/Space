import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class ImageRotate
{
 
    /**
     * @param args
     */
    /*public static void main(String[] args) throws Exception 
    {
        BufferedImage image = ImageIO.read(new File("c:/Winter_big.jpg"));
        BufferedImage rotatedImage = rotateImage(image, 90.0);
        ImageIO.write(rotatedImage, "jpeg", new File("c:/Winter_big_rot.jpg"));
    }*/
 
    public static BufferedImage rotateImage(BufferedImage src, double degrees) 
    {
    	/*
        AffineTransform affineTransform = AffineTransform.getRotateInstance(Math.toRadians(degrees), src.getWidth() / 2.0, src.getHeight() / 2.0);
        
      //  affineTransform.translate(-src.getWidth()/2, -src.getHeight()/2);
        
        BufferedImage rotatedImage = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        
        Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
        
        g.setTransform(affineTransform);
        g.drawImage(src, 0, 0, null);
        
        return rotatedImage;*/
    	
    	int w = src.getWidth();  
    	int h = src.getHeight();  
    	BufferedImage newImage = new BufferedImage(src.getWidth() , src.getHeight(), src.getType());
    	Graphics2D g2 = newImage.createGraphics();
    	g2.rotate(Math.toRadians(degrees), w/2, h/2);  
    	g2.drawImage(src,null,0,0);
    	return newImage;  
    }
}
package math;

public class Vektor 
{
	public static double getSchnittwinkel(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
	{
		int[] richtungsvektor1 = new int[2];

		richtungsvektor1[0] = x2 - x1;
		richtungsvektor1[1] = y2 - y1;
		
		int[] richtungsvektor2 = new int[2];

		richtungsvektor2[0] = x3 - x4;
		richtungsvektor2[1] = y3 - y4;
	
				
		int skalarprodukt = (richtungsvektor1[0] * richtungsvektor2[0]) + (richtungsvektor1[1] * richtungsvektor2[1]);
		

		double vektorbetrag1 = Math.sqrt( (richtungsvektor1[0] * richtungsvektor1[0]) + ( richtungsvektor1[1] * richtungsvektor1[1]) );
		double vektorbetrag2 = Math.sqrt( (richtungsvektor2[0] * richtungsvektor2[0]) + ( richtungsvektor2[1] * richtungsvektor2[1]) );
		
		double winkel = Math.toDegrees(Math.acos( skalarprodukt / (vektorbetrag1*vektorbetrag2) ));
		
		//System.out.println("New Winkel: " + (360-(winkel*2)) + " acos: " + (skalarprodukt / (vektorbetrag1*vektorbetrag2))  + "Neu: " + Math.toDegrees( Math.acos( skalarprodukt / (vektorbetrag1*vektorbetrag2) )) + "Neuer Versuch: " + Math.toDegrees(Math.acos(Math.sin(Math.acos( skalarprodukt / (vektorbetrag1*vektorbetrag2) )))));
		
		
		return 360-(winkel*2);		
	}
	
}

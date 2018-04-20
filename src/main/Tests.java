package main;
import java.util.HashMap;

import graphics.Finestra;
import graphics.Taulell;

public class Tests 
{
	static Taulell t = new Taulell();
    static Finestra f = new Finestra(t);
	static int [][] mapa1 = {
			{6,6,6,6,6,6,9,9,9,9,9,9,9,9,6,6},
       		{6,6,6,6,6,0,0,0,0,0,0,0,0,0,6,6},
       		{6,6,6,6,0,0,0,0,0,0,0,0,0,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,8,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,8,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{23,23,23,7,7,7,7,7,7,7,7,7,6,6,6,6},
       		};
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
			t.setActimatges(false);
	        t.setActcolors(true);
	        t.setActlletres(false);
	        t.setActborde(false);
	        
	        
	        t.dibuixa(mapa1);
	}

}

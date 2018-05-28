package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import characters.GameCharacter;
import characters.Link;
import main.CodigoNES;
import terrain.GameMap;
import terrain.MrWorldwide;

public class FileManager
{
	public static void saveMaps()
	{
	GameMap[][] mundo = CodigoNES.World();
	
	FileOutputStream fos = null;
	
	try {
		fos = new FileOutputStream("map/mapas.dat");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ObjectOutputStream oos = null;
	
	try {
		oos = new ObjectOutputStream(fos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(int i = 0; i<mundo.length; i++) {
		for(int j = 0; j<mundo[0].length; j++) {
			
	try {
		oos.writeObject(mundo[i][j]);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
	
	try {
		oos.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	
	public static GameMap[][] loadMaps()
	{
		GameMap[][] mundo = MrWorldwide.getWorld();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("map/mapas.dat");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream ois = null;
		
		try {
			 ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0;
		int j = 0;
		int maps = 0;
		
		while(true)
		{
			Object temp = null;
			
			try {
				temp = ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
			
			if(temp == null) break;
			
					
			mundo[i][j] = (GameMap) temp;
			maps++;
			
			if(j<mundo.length-1) {
			j++;
			}else {
				j = 0;
				i++;
			}
			
		}
		
		int cuantos = mundo.length*mundo[0].length;
		
		if(maps<cuantos)
		{
			System.out.println("Has cargado "+maps+" mapas y deberian haber-se cargado "+cuantos);
		}
		
		return mundo;
	}
	

	
	public static int[] loadMapLink()
	{
		int[] position = new int[4];
				
		for(int i = 0; i<CodigoNES.mundo.length; i++)
		{
			for(int j = 0; j<CodigoNES.mundo[0].length; j++)
			{
				
				GameMap temp = CodigoNES.mundo[i][j];
				for(int k = 0; k<temp.HEIGHT; k++)
				{
					for(int l = 0; l<temp.WIDTH; l++)
					{
						if(temp.getChar(k, l) instanceof Link)
						{
							position[0]=i;
							position[1]=j;
							position[2]=k;
							position[3]=l;
							return position; 
						}
					}
				}
				
				
			}
		}
		return position;
		
	}
	
	
	
}

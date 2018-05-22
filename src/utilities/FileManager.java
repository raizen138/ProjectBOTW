package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import terrain.GameMap;
import terrain.MrWorldwide;

public class FileManager
{
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
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(temp == null) break;
					
			mundo[i][j] = (GameMap) temp;
			maps++;
			
			if(i<mundo.length) {
			i++;
			}else {
				i = 0;
				j++;
			}
			
		}
		int cuantos = mundo.length*mundo[0].length;
		
		if(maps<cuantos)
		{
			System.out.println("Has cargado "+maps+" mapas y deberian haber-se cargado "+cuantos);
		}
		
		return mundo;
	}
}

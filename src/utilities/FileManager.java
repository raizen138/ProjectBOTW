package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import terrain.GameMap;

public class FileManager
{
	public static GameMap[] loadMaps()
	{
		ArrayList<GameMap> maps = new ArrayList<>();
		
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
					
			maps.add((GameMap) temp);
		}
		
		GameMap[] ret = new GameMap[maps.size()];
		
		ret = maps.toArray(ret);
		
		return ret;
	}
}

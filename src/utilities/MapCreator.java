package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import terrain.GameMap;
import terrain.Tile;

public class MapCreator {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File mapas = new File("map/mapas.txt");
		
		Scanner sc = null;
		
		try {
			 sc = new Scanner(mapas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		GameMap[] maps = new GameMap[6];
		
		for(int i = 0; i < maps.length; i++)
		{
			maps[i] = new GameMap(null);
		}
		
		for(int i = 0; i<6; i++)
		{
			maps[i].setName(sc.nextLine());
			
			for(int j = 0; j<GameMap.HEIGHT-1; j++)
			{
				for(int k = 0; k<GameMap.WIDTH-1;k++)
				{
					
					Tile casilla = new Tile();

					if(sc.next().equals("s"))
					{
						casilla.setCollider(true);
					}
					else
					{
						casilla.setCollider(false);
					}
					
					maps[i].setTile(casilla, j, k);

				}
			}
			
			
		}
		
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
		
		for (int i = 0; i < maps.length; i++)
		{
			try
			{
				oos.writeObject(maps[i]);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

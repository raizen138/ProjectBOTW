package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import characters.Enemy;
import characters.GameCharacter;
import characters.Link;
import interactables.Button;
import interactables.Chest;
import interactables.Drop;
import interactables.Npc;
import interactables.Overworld;
import items.Weapon;
import main.CodigoNES;
import terrain.GameMap;
import terrain.MrWorldwide;
import terrain.Tile;


public class MapCreator {
	
	final static int[] chestrange = {18, 46};
	final static String[] chestsprites = {"spr/cofreC.png", "spr/cofreA.png"};
	final static int[] botonrange = {5, 47};
	final static String[] botonsprites = {"spr/botonD.png", "spr/botonA.png"};
	final static int[] viejorange = {17, 48};
	final static String[] viejosprites = {"spr/viejo1.png", "spr/viejo2.png"};
	final static int[] espadarange = {49};
	final static String[] espadasprites = {"spr/espadaOW.png"};
	final static int[] linkRange = { 1, 2, 3, 4, 13, 14, 15, 16, 19, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
			39, 40, 41, 42, 43, 44, 45 };
	final static String[] linkSprites = { "spr/linkSP.png", "spr/linkAP.png", "spr/linkDP.png", "spr/linkWP.png",
			"spr/linkWeP.png", "spr/linkAeP.png", "spr/linkSeP.png", "spr/linkDeP.png", "spr/linkTP.png",
			"spr/linkWN.png", "spr/linkAN.png", "spr/linkSN.png", "spr/linkDN.png", "spr/linkWE.png", "spr/linkAE.png",
			"spr/linkSE.png", "spr/linkDE.png", "spr/linkWeE.png", "spr/linkAeE.png", "spr/linkSeE.png",
			"spr/linkDeE.png", "spr/linkWL.png", "spr/linkAL.png", "spr/linkSL.png", "spr/linkDL.png",
			"spr/linkWeL.png", "spr/linkAeL.png", "spr/linkSeL.png", "spr/linkDeL.png", "spr/linkD.png" };
	public static Weapon sword = new Weapon(20, "spr/espada.png", 2, 3);
	public static Weapon fists = new Weapon(0, "", 99, 1);
	public static Weapon lance = new Weapon(21, "spr/lanza.png", 5, 2);
	public static Link link = new Link(linkRange, linkSprites, 3, fists);
	public static Chest cofre = new Chest(chestsprites, chestrange);
	public static Npc viejo = new Npc(viejosprites, viejorange, sword, "Anciano");
	public static Button boton1 = new Button(botonsprites, botonrange);
	public static Button boton2 = new Button(botonsprites, botonrange);
	public static Overworld espada = new Overworld(espadasprites, espadarange ,sword);
	public static Drop moblind = new Drop(lance);

	public static void main(String[] args)
	{
		// 
		
		String path = "map/mapas.txt";
		
		
		File mapas = new File(path);
		
		Scanner sc = null;
		
		try {
			 sc = new Scanner(mapas);
		} catch (FileNotFoundException e) {
			// 
			e.printStackTrace();
			System.exit(1);
		}
		
		GameMap[][] maps = MrWorldwide.getWorld();
		
		for(int i = 0; i < maps.length; i++)
		{
			for(int j = 0; j<maps[0].length; j++) 
			{
				maps[i][j] = new GameMap(null);
			}
		}
		
		int[] moblinRange = { 8 };
		String[] moblinSprites = { "spr/mobSP.png" };

		
		
		
		for(int i = 0; i<maps.length; i++)
		{
			for(int l = 0; l<maps[0].length; l++)
			{	
			if(i==0 && l==0) {
				
			}else {
				sc.nextLine();
			}
			String name = sc.nextLine();	
			System.out.println(name);
			System.out.println("mapa "+i+" "+l);
			maps[i][l].setName(name);
			if(!name.equals("null")) 
			{
			for(int j = 0; j<GameMap.HEIGHT; j++)
			{
				for(int k = 0; k<GameMap.WIDTH;k++)
				{
	
					String in = sc.next();
					Tile casilla = new Tile();

					if(in.equals("s"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
					}
					else
					if(in.equals("n"))
					{
						casilla.setCollider(false);
						maps[i][l].setTile(casilla, j, k);
					} 
					else 
					
						
					if(in.equals("c"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(cofre, j, k);
					}
					else
					
					
					if(in.equals("v"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(viejo, j, k);
					}
					else
					
					if(in.equals("e"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(espada, j, k);
					}
					else
					
					if(in.equals("b1"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(boton1, j, k);
					}
					else
					if(in.equals("b2"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(boton2, j, k);
					}
					else
						
					if(in.equals("l"))
					{
						casilla.setCollider(false);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setGameCharacter(link, j, k);
					}
					else
					
					if(in.equals("m"))
					{
						casilla.setCollider(false);
						maps[i][l].setTile(casilla, j, k);
						Enemy moblines = new Enemy(moblinRange, moblinSprites, 3, fists, moblind, j, k);
						maps[i][l].setMob(moblines);
						maps[i][l].setGameCharacter(moblines, j, k);
					}
					else
					
						
					if(in.equals("w"))
					{
						casilla.setWater(true);
						maps[i][l].setTile(casilla, j, k);
					}
					
				
					


				}
			}
			
				
			}
			}
		}
		
		FileOutputStream fos = null;
		
		try
		{
			fos = new FileOutputStream("map/mapas.dat");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		for (int i = 0; i < maps.length; i++)
		{
			for (int j = 0; j<maps[0].length; j++)
			{
			try
			{
				oos.writeObject(maps[i][j]);
			}
			catch (IOException e)
			{
				// 
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
		

		
		/*
		try {
			FileInputStream fis = new FileInputStream("map/mapas.dat");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			GameMap[][] world = new GameMap[3][3];
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					world[i][j] = (GameMap) ois.readObject();
				}
			}
			
			Scanner input = new Scanner(System.in);
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(world[i][j] != null)
					{
						GameMap current = world[i][j];
						
						for(int i2 = 0; i2 < GameMap.HEIGHT; i2++)
						{
							for(int j2 = 0; j2 < GameMap.WIDTH; j2++)
							{
								System.out.println(current.getChar(i2, j2));
							}
						}
						
						input.nextLine();
					}
				}
			}
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
	}

}

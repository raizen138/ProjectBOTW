package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import characters.Enemy;
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
import terrain.Water;

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
	static Weapon sword = new Weapon(20, "spr/espada.png", 2, 3);
	static Weapon fists = new Weapon(0, "", 99, 1);
	static Weapon lance = new Weapon(21, "spr/lanza.png", 5, 2);
	public static Link link = new Link(linkRange, linkSprites, 3, fists);
	public static Chest cofre = new Chest(chestsprites, chestrange);
	public static Npc viejo = new Npc(viejosprites, viejorange, sword, "Anciano");
	public static Button boton = new Button(botonsprites, botonrange);
	public static Overworld espada = new Overworld(espadasprites, espadarange ,sword);
	public static Drop moblind = new Drop(lance);

	public static void main(String[] args)
	{
		// 
		File mapas = new File("map/mapas.txt");
		
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

		Tile casilla = new Tile();
		Water agua = new Water();
		
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
			if(!name.equals("null")) 
			{
			maps[i][l].setName(name);
			
			
			for(int j = 0; j<GameMap.HEIGHT; j++)
			{
				for(int k = 0; k<GameMap.WIDTH;k++)
				{
	
					String in = sc.next();
					
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
					
					if(in.equals("b"))
					{
						casilla.setCollider(true);
						maps[i][l].setTile(casilla, j, k);
						maps[i][l].setInteractable(boton, j, k);
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
						Enemy moblines = new Enemy(moblinRange, moblinSprites, 3, fists, moblind);
						maps[i][l].setGameCharacter(moblines, j, k);
					}
					else
					
						
					if(in.equals("w"))
					{
						maps[i][l].setTile(agua, j, k);
					}
					
				
					


				}
			}
			}
			}
		}
		
		FileOutputStream fos = null;
		
		try {
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
			try
			{
				oos.writeObject(maps[i]);
			}
			catch (IOException e)
			{
				// 
				e.printStackTrace();
			}
		}
		
	}

}

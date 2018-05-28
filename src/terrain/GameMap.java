package terrain;

import java.io.Serializable;
import java.util.ArrayList;

import characters.Enemy;
import characters.GameCharacter;
import interactables.Interactable;
import utilities.Sound;

public class GameMap implements Serializable
{
	public static final int HEIGHT = 11;
	public static final int WIDTH = 16;
	
	private String name = new String();
	
	private String music;
	
	
	
	//public int[][] layout;
	
	private String BgImg = new String();
	
	private ArrayList<Enemy> enemigos = new ArrayList<Enemy>();
	
	
	
	private Tile[][] tileLayout;
	
	private GameCharacter[][] charLayout;

	private Interactable[][] interLayout;
	
	
	public GameMap(String name)
	{
		this.name = name;
		tileLayout = new Tile[11][16];
		charLayout = new GameCharacter[11][16];
		interLayout = new Interactable[11][16];
	}

	public int[][] toIntMap()
	{
		int[][] interesante = new int[11][16];
		
		for (int i = 0; i < interesante.length; i++) {
			for (int j = 0; j < interesante[0].length; j++) {
				
			try {
				interesante[i][j] = getInter(i, j).getcurrentSprite();
			} catch (Exception e) {
				interesante[i][j] = 0;
			}
				
			}
		}
		
		return interesante;
		
	}
	
	public int[][] toOverride()
	{
		int[][] charizard = new int[11][16];
		
		for (int i = 0; i < charizard.length; i++) {
			for (int j = 0; j < charizard[0].length; j++) {
				
				try {
					charizard[i][j] = getChar(i, j).getCurrentSprite();
				} catch (Exception e) {
					charizard[i][j] = 0;
				}
				
			}
		}
		return charizard;
	}
	
	
	public void setMob(Enemy mob)
	{
		enemigos.add(mob);
	}
	
	public ArrayList<Enemy> Mob()
	{
		return enemigos;
	}
	
	
	public void setTile(Tile tile, int row, int col)
	{
		this.tileLayout[row][col] = tile;
	}
	
	public void setBackground(String path)
	{
		this.BgImg = path;
	}
	
	public void setMusic(String sound)
	{
		this.music = sound;
	}	
	
	public void setInteractable(Interactable inter, int row, int col)
	{
		interLayout[row][col] = inter;
	}
	
	public void setGameCharacter(GameCharacter gc, int row, int col)
	{
		charLayout[row][col] = gc;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setExit(Exit exit, int row, int col)
	{
		tileLayout[row][col] = exit;
	}
	
	
	public Tile getTile(int row, int col)
	{
		return tileLayout[row][col];
	}
	
	public Interactable getInter(int row, int col)
	{
		return interLayout[row][col];
	}
	
	public GameCharacter getChar(int row, int col)
	{
		return charLayout[row][col];
	}
	
	public String getBgImg()
	{
		return BgImg;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getMusic()
	{
		return music;
	}
	
}

package terrain;

import characters.GameCharacter;
import interactables.Interactable;

public class GameMap 
{
	public static final int HEIGHT = 11;
	public static final int WIDTH = 16;
	
	private String name = new String();
	
	
	
	//public int[][] layout;
	
	private String BgImg = new String();
	
	
	
	private Tile[][] tileLayout;
	
	private GameCharacter[][] charLayout;

	private Interactable[][] interLayout;
	
	
	public GameMap(String name)
	{
		this.name = name;
		tileLayout = new Tile[11][16];
	}

	
	public void setTile(Tile tile, int row, int col)
	{
		this.tileLayout[row][col] = tile;
	}
	
	public void setBackground(String path)
	{
		this.BgImg = path;
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
}

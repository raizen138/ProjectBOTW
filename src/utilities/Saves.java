package utilities;

import java.io.Serializable;
import java.util.ArrayList;

import main.CodigoNES;

public class Saves extends ArrayList<Save> implements Serializable
{
	
	public static void save() 
	{
		
	}
	
	public static void load() 
	{
		
	}
	
}

class Save
{
	String mapName;
	
	int linkX, linkY, mapEnemies;
	
	Save()
	{
		mapName = CodigoNES.CurrentMap().name;
		mapEnemies = CodigoNES.CurrentMap().nEnemy;
		linkX =	CodigoNES.link.x();
		linkY =	CodigoNES.link.y();
	}
}
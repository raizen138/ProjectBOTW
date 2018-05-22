package terrain;

import java.io.Serializable;

public class MrWorldwide implements Serializable
{
	private static GameMap[][] mapeado;
	
	
	public static GameMap[][] getWorld() 
	{
		 
		if (mapeado == null) 
		{
			mapeado = new GameMap[3][3];
		}
		
		return mapeado;
		
	}
	
	
}

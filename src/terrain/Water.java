package terrain;
import main.CodigoNES;

public class Water {

	private static Water instance;
	
	private int[] range = {22, 23, 28};

	public boolean isWater(int i, int j) 
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		
		for(int k = 0; k < range.length; k++)
		{	
		if(currentMap.exitLayout[i][j] == range[k])
		{
			return true;
		}
		}
		return false;
	}
	
	public static Water getInstance()
	{
		if(instance == null)
		{
			instance = new Water();
		}
		
		return instance;
	}
}

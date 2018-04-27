package graphics;

import main.CodigoNES;

public class Hud {

	private static Hud instance;		
	
	private int maxHearths = 3;
	
	/**
	 * 
	 * @param health
	 * @return
	 * 
	 * 51 lleno
	 * 52 medio
	 * 53 vacío
	 * 
	 */
	
	public int[][] getLayout(int health)
	{
		int hudpos = 11;
		
		int[][] layout = new int[2][CodigoNES.MAP_WIDTH];
		
		int heartsdisplayed = 0;
		int maxdisp; 
		
		while(health > 0)
		{
			if(health > 1)
			{
				layout[0][hudpos] = 51;
				health -= 2;
				heartsdisplayed++;
				hudpos++;
			}
			else if(health == 1)
			{
				layout[0][hudpos] = 52;
				health -= 1;
				heartsdisplayed++;
				hudpos++;
			}
			
			
		}
		for(int i = 0; i < maxHearths - heartsdisplayed; i++)
		{
			layout[0][hudpos] = 53;
			hudpos++;
		}
		
		return layout;
	}
	
	public static Hud instance()
	{
		if(instance == null)
		{
			instance = new Hud();
		}
		
		return instance;
	}
	
}

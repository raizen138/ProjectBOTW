package graphics;


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
	
	public int[][] getLayout(int health, int[][] map)
	{
		int hudpos = 27;
		
		
		int heartsdisplayed = 0;
		
		while(health > 0)
		{
			if(health > 1)
			{
				map[2][hudpos] = 51;
				health -= 2;
				heartsdisplayed++;
				hudpos++;
			}
			else if(health == 1)
			{
				map[2][hudpos] = 52;
				health -= 1;
				heartsdisplayed++;
				hudpos++;
			}
			
			
		}
		for(int i = 0; i < maxHearths - heartsdisplayed; i++)
		{
			map[2][hudpos] = 53;
			hudpos++;
		}
		
		return map;
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

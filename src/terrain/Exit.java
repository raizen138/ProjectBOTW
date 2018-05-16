package terrain;

public class Exit extends Tile
{
	private String mapTo;
	
	
	
	
	public Exit(String mapTo)
	{
		this.mapTo = mapTo;
	}
	
	public String mapTo()
	{
		return mapTo;
	}
}

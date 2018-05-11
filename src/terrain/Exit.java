package terrain;

public class Exit extends Tile
{
	private String mapTo;
	
	private int row;
	private int col;
	
	public Exit(String mapTo, int row, int col)
	{
		this.mapTo = mapTo;
		this.row = row;
		this.col = col;
	}
	
	public int[] exitCondition()
	{
		return new int[] {row, col};
	}
	
	public String mapTo()
	{
		return mapTo;
	}
}

package terrain;

public class Tile
{
	private boolean isCollider;
	
	public void setCollider(boolean col)
	{
		isCollider = col;
	}
	
	public boolean isCollider()
	{
		return isCollider;
	}
}

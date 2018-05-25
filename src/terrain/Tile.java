package terrain;

import java.io.Serializable;

public class Tile implements Serializable
{
	private boolean isCollider;
	private boolean isWater;
	
	public void setCollider(boolean col)
	{
		isCollider = col;
	}
	
	public void setWater(boolean wat)
	{
		isWater = wat;
	}
	
	public boolean isCollider()
	{
		return isCollider;
	}
	
	public boolean isWater()
	{
		return isWater;
	}
	
}

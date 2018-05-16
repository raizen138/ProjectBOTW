package terrain;

import java.io.Serializable;

public class Tile implements Serializable
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

package items;

import java.io.Serializable;

public class Item implements Serializable
{

	public int range;
	String sprite;
	
	
	public Item(int newRange, String allSprites)
	{
		range = newRange;
		sprite = allSprites;
	}
	
	
	public int[] getRange()
	{
		int[] ranged = {range};
		return ranged;
	}
	
	public String[] getSprite()
	{
		String[] sprites = {sprite};
		return sprites;
	}
	
	
}

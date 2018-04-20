package interactables;

public abstract class Interactable 
{
	int[] range;
	String[] sprites;
	
	
	public Interactable(String[] newSprites, int[] newRange)
	{
		sprites = newSprites;
		range = newRange;

	}
	
	
	




	public abstract void interactWith(int x2, int y2);


	public void writeRange(String[] spriteArray)
	{
		for(int i = 0; i < range.length; i++)
		{
			spriteArray[range[i]] = sprites[i];
		}
	}

	
	
	
	
}

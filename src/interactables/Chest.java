package interactables;
import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.GameMap;

public class Chest extends Interactable
{
	
	private Item drop;
	
	private boolean open = false;
	
	public Chest(String[] newSprites, int[] newRange) 
	{
		super(newSprites, newRange);	
		range[0] = 18;
		range[1] = 46;
	}
	
	public void setDrop(Item newDrop) 
	{
		drop = newDrop;
	}
	
	public Item drop() 
	{
		if(!open) 
		{
		open = true;
		return drop;
		}
		
		return null;
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		Link link = CodigoNES.getLink();
		
		if (!open) 
		{
		if(link.giveItem(drop)) {
			open = true;	
		}
		
		
		}
	}
	
	public int getcurrentSprite()
	{
		if(open)
		{
			return range[1];
		}
		else
		{
			return range[0];
		}
	}
	
	public void setOpen()
	{
		open = true;
	}

}

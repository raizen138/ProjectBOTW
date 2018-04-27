package interactables;
import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.MapChunk;

public class Chest extends Interactable
{
	
	Item drop;
	
	public Chest(String[] newSprites, int[] newRange, Item newDrop) 
	{
		super(newSprites, newRange);	
		drop = newDrop;
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		
		if (currentMap.layout[x2][y2] == range[0]) 
		{
		if(link.giveItem(drop)) {
			currentMap.layout[x2][y2] = range[1];	
		}
		
		
		}
	}

}

package interactables;

import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.GameMap;


public class Overworld extends Interactable {
	
	Item drop;

	public Overworld(String[] newSprites, int[] newRange, Item newDrop) {
		super(newSprites, newRange);
		drop = newDrop;
	}
	
	public int getcurrentSprite()
	{
		return range[0];
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		
		if(link.giveItem(drop)) 
		{
			currentMap.setInteractable(null, x2, y2);
		}
		
		
		
	}

}

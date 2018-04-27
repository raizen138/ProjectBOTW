package interactables;

import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.MapChunk;

public class Overworld extends Interactable {
	
	Item drop;

	public Overworld(String[] newSprites, int[] newRange, Item newDrop) {
		super(newSprites, newRange);
		drop = newDrop;
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		
		if(link.giveItem(drop)) {
			currentMap.layout[x2][y2] = 0;	
			currentMap.interLayout[x2][y2] = null;	
		}
		
		
		
	}

}

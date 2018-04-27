package interactables;

import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.MapChunk;

public class Npc extends Interactable{

	int estado = 0;
	Item drop;
	String name = new String();
	
	public Npc(String[] newSprites, int[] newRange, Item newDrop, String newName) 
	{
		super(newSprites, newRange);
		drop = newDrop;	
		name = newName;
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		if(estado == 0)
		{
			currentMap.layout()[x2][y2] = range[1];
			CodigoNES.view();
			if(drop != null)
			{
				if(link.giveItem(drop)) {
					estado++;
					
				}
			}
		}
		else if(estado == 1)
		{
			
		}
		else if(estado == 2)
		{
			
		}
		
	}

}

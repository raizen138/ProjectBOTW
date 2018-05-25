package interactables;

import characters.Link;
import items.Item;
import main.CodigoNES;
import terrain.GameMap;

public class Npc extends Interactable{

	boolean sleep = true;
	int estado = 0;
	Item drop;
	String name = new String();
	
	public Npc(String[] newSprites, int[] newRange, Item newDrop, String newName) 
	{
		super(newSprites, newRange);
		drop = newDrop;	
		name = newName;
	}
	
	
	public int getcurrentSprite()
	{
		if(sleep)
		{
			return range[0];
		}
		else
		{
			return range[1];
		}
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		if(estado == 0)
		{
			sleep = false;
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

package interactables;

import characters.Link;
import items.Item;
import main.CodigoNES;

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
		Link link = CodigoNES.getLink();
		if(estado == 0)
		{
			
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

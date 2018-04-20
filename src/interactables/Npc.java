package interactables;

import items.Item;

public class Npc extends Interactable{

	int estado = 0;
	Item drop;
	
	public Npc(String[] newSprites, int[] newRange, Item newDrop) 
	{
		super(newSprites, newRange);
		drop = newDrop;	
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		if(estado == 0)
		{
			
			if(drop != null)
			{
				
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

package interactables;

import characters.Link;
import items.Item;
import items.Weapon;
import main.CodigoNES;
import terrain.GameMap;

public class Drop extends Interactable
{

	Item droped;
	

	public Drop(Item newItem) 
	{
		super(newItem.getSprite(), newItem.getRange());
		droped = newItem;
	}
	
	@Override
	public void interactWith(int x2, int y2) 
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		Link link = CodigoNES.getLink();
		
		if(droped instanceof Weapon) {
		if(link.giveItem(droped)) 
		{
			currentMap.setInteractable(null, x2, y2);
		}
		}
		
	}
	
	public int getcurrentSprite()
	{
		return range[0];
	}

}

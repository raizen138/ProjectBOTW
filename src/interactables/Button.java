package interactables;

import main.CodigoNES;
import terrain.GameMap;

public class Button extends Interactable
{

	private boolean activated = false;
	
	public Button(String[] newSprites, int[] newRange) {
		super(newSprites, newRange);
		
	}

	public int getcurrentSprite()
	{
		if(activated)
		{
			return range[1];
		}
		else
		{
			return range[0];
		}
	}
	
	
	@Override
	public void interactWith(int x2, int y2) 
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		if (!activated) 
		{
			if (currentMap.getName().equals("Camara Resurrección"))
			{	
			currentMap.setBackground("map/mapa0abierto.jpg");
			currentMap.setExit(CodigoNES.exitmap0, 5, 15);
			currentMap.setExit(CodigoNES.exitmap0, 6, 15);
			}
			if (currentMap.getName().equals("Santuario Resurrección"))
			{	
			currentMap.setBackground("map/mapa1abierto.jpg");
			currentMap.setExit(CodigoNES.exitmap1_1, 5, 15);
			currentMap.setExit(CodigoNES.exitmap1_1, 6, 15);
			}
	
			activated = true;
			CodigoNES.view();
		}
	}

}

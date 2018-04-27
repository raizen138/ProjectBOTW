package interactables;

import main.CodigoNES;
import terrain.MapChunk;

public class Button extends Interactable
{

	public Button(String[] newSprites, int[] newRange) {
		super(newSprites, newRange);
		
	}

	@Override
	public void interactWith(int x2, int y2) 
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		if (currentMap.layout()[x2][y2] == range[0]) 
		{
			if (currentMap.name.equals("Camara Resurrección"))
			{	
			currentMap.BgImg = "map/mapa0abierto.jpg";
			}
			if (currentMap.name.equals("Santuario Resurrección"))
			{	
			currentMap.BgImg = "map/mapa1abierto.jpg";
			}
			for(int i = 0; i < CodigoNES.MAP_HEIGHT; i++) {
				for(int j = 0; j<CodigoNES.MAP_WIDTH; j++) {
					if(currentMap.layout()[i][j] == 12) {
						currentMap.layout()[i][j] = 7;
						currentMap.exitLayout[i][j] = 7;
					}
				}
			}
			currentMap.layout()[x2][y2] = range[1];
			CodigoNES.view();
		}
	}

}

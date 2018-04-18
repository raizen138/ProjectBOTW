
public class Enemy extends GameCharacter{
	
	int numero;

	public Enemy(int[] newRange, String[] allSprites, int newHealth, Weapon newWeapon, int charL) {
		super(newRange, allSprites, newHealth, newWeapon);
		place();
		numero = charL;
		
	}

	private void place() {
		// TODO Auto-generated method stub
		MapChunk currentMap = CodigoNES.CurrentMap();
		while(true) {
			x = (int) (Math.random() * 9)+1;
			y = (int) (Math.random() * 14)+1;
			if (currentMap.layout[x][y] == 0) {
				currentMap.layout[x][y] = 8;
				break;
			}
		}
	}

	@Override
	public void attack(GameCharacter target) 
	{		
		target.health -= this.weapon.attack;
	}
		
	public void Update()
	{
		if(linkInRange())
		{
			attack(CodigoNES.link);
		}
		else
		{
			move();
		}
	}
	
	private boolean linkInRange()
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		if(currentMap.charLayout[x+1][y] == 9) {
			return true;
		}
		if(currentMap.charLayout[x-1][y] == 9) {
			return true;
		}
		if(currentMap.charLayout[x][y+1] == 9) {
			return true;
		}
		if(currentMap.charLayout[x][y-1] == 9) {
			return true;
		}
		return false;
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		MapChunk currentMap = CodigoNES.CurrentMap();
				
				int enemigo = numero;
				int opt = (int) (Math.random() * 4);
				switch (opt) {
				case 0:
					if (currentMap.exitLayout[x - 1][y] == 0 && currentMap.layout[x - 1][y] == 0) {
						currentMap.layout[x - 1][y] = 8;
						currentMap.charLayout[x - 1][y] = enemigo;
						currentMap.layout[x][y] = 0;
						currentMap.charLayout[x][y] = 0;
						x--;
						return true;
					}
						return false;
				
				case 1:
					if (currentMap.exitLayout[x][y - 1] == 0 && currentMap.layout[x][y - 1] == 0) {
						currentMap.layout[x][y - 1] = 8;
						currentMap.charLayout[x][y - 1] = enemigo;
						currentMap.layout[x][y] = 0;
						currentMap.charLayout[x][y] = 0;
						y--;
						return true;
					}
					return false;
				case 2:
					if (currentMap.exitLayout[x + 1][y] == 0 && currentMap.layout[x + 1][y] == 0) {
						currentMap.layout[x + 1][y] = 8;
						currentMap.charLayout[x + 1][y] = enemigo;
						currentMap.layout[x][y] = 0;
						currentMap.charLayout[x][y] = 0;
						x++;
						return true;
					}
					return false;
				case 3:
					if (currentMap.exitLayout[x][y + 1] == 0 && currentMap.layout[x][y + 1] == 0) {
						currentMap.layout[x][y + 1] = 8;
						currentMap.charLayout[x][y + 1] = enemigo;
						currentMap.layout[x][y] = 0;
						currentMap.charLayout[x][y] = 0;
						y++;
						return true;
					}
					return false;
				}
			
			return false;
			
		
		
		//CodigoNES.setCurrentMap(currentMap);
	

		
	}
}

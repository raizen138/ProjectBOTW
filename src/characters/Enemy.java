package characters;
import interactables.Drop;
import items.Weapon;
import main.CodigoNES;
import terrain.GameMap;

public class Enemy extends GameCharacter{

	private Drop dropdbass;
	
	public Enemy(int[] newRange, String[] allSprites, int newHealth, Weapon newWeapon, Drop newDrop, int x, int y)
	{
		super(newRange, allSprites, newHealth, newWeapon);
		this.setX(x);
		this.setY(y);		
	}

	public Drop getDrop()
	{
		return dropdbass;
	}
	
	
	@Override
	public int getCurrentSprite() 
	{
		return range[0];
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
		GameMap currentMap = CodigoNES.CurrentMap();
		if(currentMap.getChar(x()+1, y()) instanceof Link)
		{
			return true;
		}
		
		if(currentMap.getChar(x()-1, y()) instanceof Link)
		{
			return true;
		}
		if(currentMap.getChar(x(), y()+1) instanceof Link)
		{
			return true;
		}
		
		if(currentMap.getChar(x(), y()-1) instanceof Link)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean move()
	{
		GameMap currentMap = CodigoNES.CurrentMap();
				
				int opt = (int) (Math.random() * 4);
				
				switch (opt)
				{
					case 0:
						if (currentMap.getTile(x() - 1, y()).isCollider() == false && currentMap.getChar(x() - 1, y()) == null)
						{
							currentMap.setGameCharacter(this, x()-1, y());
							currentMap.setGameCharacter(null, x(), y());
							setX(x()-1);
							return true;
						}
						
						return false;
					
					case 1:
						if (currentMap.getTile(x(), y()-1).isCollider() == false && currentMap.getChar(x(), y()-1) == null)
						{
							currentMap.setGameCharacter(this, x(), y()-1);
							currentMap.setGameCharacter(null, x(), y());
							setY(y()-1);
							return true;
						}
						
						return false;
						
					case 2:
						if (currentMap.getTile(x() + 1, y()).isCollider() == false && currentMap.getChar(x() + 1, y()) == null)
						{
							currentMap.setGameCharacter(this, x()+1, y());
							currentMap.setGameCharacter(null, x(), y());
							setX(x()+1);
							return true;
						}
						
						return false;
						
					case 3:
						if (currentMap.getTile(x(), y()+1).isCollider() == false && currentMap.getChar(x(), y()+1) == null)
						{
							currentMap.setGameCharacter(this, x(), y()+1);
							currentMap.setGameCharacter(null, x(), y());
							setY(y()+1);
							return true;
						}
						
						return false;
				}
			
			return false;
	}
}

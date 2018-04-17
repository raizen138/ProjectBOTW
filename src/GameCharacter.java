
public abstract class GameCharacter 
{
	int[] range;
	String[] sprites;
	int health;
	Weapon weapon;
	int estado;
	int x;
	int y;
	
	public GameCharacter(int[] newRange, String[] allSprites, int newHealth, Weapon newWeapon)
	{
		range = newRange;
		sprites = allSprites;
		health = newHealth;
		weapon = newWeapon;
		estado = 0;
	}
	
	public void writeRange(String[] spriteArray)
	{
		for(int i = 0; i < range.length; i++)
		{
			spriteArray[range[i]] = sprites[i];
		}
	}
	
	
	public boolean die()
	{
		if(health == 0) {
			return true;
		}else {
		return false; 
		}
	}
	
	public abstract boolean attack(GameCharacter target);
	
	public abstract boolean move();

	
	public boolean damage(int amount)
	{
		this.health -= amount;
		
		return true;
	}
	
	public abstract void Update();

}

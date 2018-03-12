
public class GameCharacter 
{
	int[] range;
	String[] sprites;
	int health;
	String name;
	Weapon weapon;
	
	public GameCharacter(int[] newRange, String[] allSprites, int newHealth, Weapon newWeapon, String newName)
	{
		range = newRange;
		sprites = allSprites;
		health = newHealth;
		weapon = newWeapon;
		name = newName;
	}
	
	public void writeRange(String[] spriteArray)
	{
		for(int i = 0; i < range.length; i++)
		{
			spriteArray[range[i]] = sprites[i];
		}
	}
	
	public void giveWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public boolean attack(GameCharacter target)
	{
		target.damage(weapon.attack);
		
		weapon.dura -= 1;
		
		return true;
	}
	
	
	public boolean die()
	{
		if(health == 0) {
			return true;
		}else {
		return false;
		}
	}
	
	
	public boolean damage(int amount)
	{
		this.health -= amount;
		
		return true;
	}
}

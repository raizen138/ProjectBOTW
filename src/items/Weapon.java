package items;

public class Weapon extends Item
{
	
	public int dura;
	public int attack;
	public int duraMax;
	
	public Weapon(int newRange, String allSprites, int newDura, int newAttack) 
	{
		super(newRange, allSprites);
		dura = newDura;
		attack = newAttack;
		duraMax = newDura;
	}
	
	
	public void writeRange(String[] spriteArray)
	{
		spriteArray[range] = sprite;
	}
	
	public void repair()
	{
		dura = duraMax;
	}
	
}
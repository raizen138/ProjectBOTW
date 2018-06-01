package items;

public class Weapon extends Item
{
	
	public int dura;
	public double attack;
	public int duraMax;
	
	public Weapon(int newRange, String allSprites, int newDura, double d) 
	{
		super(newRange, allSprites);
		dura = newDura;
		attack = d;
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
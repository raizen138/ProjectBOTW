
public class Weapon 
{
	int range;
	String sprite;
	int dura;
	int attack;
	int duraMax;
	
	public Weapon(int newRange, String allSprites, int newDura, int newAttack) {
		range = newRange;
		sprite = allSprites;
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
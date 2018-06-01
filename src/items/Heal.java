package items;

public class Heal extends Item
{
	public double cura;

	public Heal(int newRange, String allSprites, double newCura) {
		super(newRange, allSprites);
		cura = newCura;
	}

	public void writeRange(String[] spriteArray)
	{
		spriteArray[range] = sprite;
	}
}

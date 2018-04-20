package interactables;

public abstract class Interactable 
{
	String name = new String();
	int[] range = {5, 17, 18};
	int type;
	
	
	public Interactable(String newName, int[] newRange)
	{
		name = newName;
		type = getType();
	}
	
	
	
	private int getType() {
		if (name.equals("cofre"))
		{
			return 18;
		}
		if(name.equals("npc"))
		{
			return 17;
		}
		if(name.equals("boton"))
		{
			return 5;
		}
		return 0;
	}



	public abstract void interactWith(int x2, int y2);




	
	
	
	
}

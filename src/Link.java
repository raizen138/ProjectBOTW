
public class Link extends GameCharacter{

	public Link(int[] newRange, String[] allSprites, int newHealth, Weapon newWeapon) {
		super(newRange, allSprites, newHealth, newWeapon);
		
	}
	

	public boolean attack(GameCharacter target)
	{
		if(estado == 1) {
			return false;
		}
		target.damage(weapon.attack);
		
		if(weapon.duraMax != 99) {
		weapon.dura -= 1;
		}
		return true;
	}

	public void giveWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public boolean hasWeapon() {
		if(weapon.range == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	
}

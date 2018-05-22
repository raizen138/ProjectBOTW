package characters;

import java.io.Serializable;

import items.Weapon;

public abstract class GameCharacter implements Serializable
{
	int[] range;
	String[] sprites;
	int health;
	public Weapon weapon;
	public int estado;
	private int x;
	private int y;
	
	public GameCharacter
			(
				int[] newRange,
				String[] allSprites,
				int newHealth,
				Weapon newWeapon
			)
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
	
	
	public boolean isDead()
	{
		if(health == 0)
		{
			return true;
		}
		else
		{
			return false; 
		}
	}
	
	public abstract void attack(GameCharacter target);
	
	
	public abstract boolean move();

	
	public boolean damage(int amount)
	{
		this.health -= amount;
		
		return true;
	}
	
	public abstract void Update();
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	public int getCurrentSprite() 
	{
		return 0;
	}
}

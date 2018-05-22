package characters;
import interactables.Interactable;
import items.Item;
import items.Weapon;
import main.CodigoNES;
import terrain.GameMap;

public class Link extends GameCharacter{
	
	int linkS = 1;
	int linkW = 4;
	int linkD = 3;
	int linkA = 2;
	int linkWe = 13;
	int linkAe = 14;
	int linkSe = 15;
	int linkDe = 16;
	public char lastDirChar;
	public int lastDir;
	public char lastAction;
	
	public Link
			(
				int[] newRange,
				String[] allSprites,
				int newHealth,
				Weapon newWeapon
			)
	{
		super(newRange, allSprites, newHealth, newWeapon);
		
		setX(6);
		setY(5);
		
		
	}
	
	public int getCurrentSprite() 
	{
		if(lastDirChar == 'w') 
		{
			return linkW;
		}
		if(lastDirChar == 'a') 
		{
			return linkA;
		}
		if(lastDirChar == 's') 
		{
			return linkS;
		}
		if(lastDirChar == 'd') 
		{
			return linkD;
		}
		return linkS;
	}
	
	public char getCharfromDir(int lastDir2) {
		if(lastDir2 == linkW) {
			return 'w';
		}
		if(lastDir2 == linkA) {
			return 'a';
		}
		if(lastDir2 == linkS) {
			return 's';
		}
		if(lastDir2 == linkD) {
			return 'd';
		}
		
		return 's';
	}
	
	public int getDirection() {
		// Auto-generated method stub
		if (lastDirChar == 'w') {
			return linkW;
		}
		if (lastDirChar == 'a') {
			return linkA;
		}
		if (lastDirChar == 's') {
			return linkS;
		}
		if (lastDirChar == 'd') {
			return linkD;
		}
		return linkS;

	}

	public int getDirfromLastDir() {
		
		if (lastDir == linkW) {
			return linkWe;
		}
		if (lastDir == linkA) {
			return linkAe;
		}
		if (lastDir == linkS) {
			return linkSe;
		}
		if (lastDir == linkD) {
			return linkDe;
		}
		return linkSe;
		
	}

	public void changeSprites() {
		// Auto-generated method stub
		
		if(estado == 1)
		{
			linkS = 26;
			linkW = 24;
			linkA = 25;
			linkD = 27;
		}
		else 
		{
		if (weapon == CodigoNES.fists) 
		{
			if (lastDir == linkS) lastDir=1;
			if (lastDir == linkW) lastDir=4;
			if (lastDir == linkD) lastDir=3;
			if (lastDir == linkA) lastDir=2;
			linkS = 1;
			linkW = 4;
			linkD = 3;
			linkA = 2;
			linkWe = 13;
			linkAe = 14;
			linkSe = 15;
			linkDe = 16;
		} 
		else if (weapon == CodigoNES.sword) 
		{
			if (lastDir == linkS) lastDir=31;
			if (lastDir == linkW) lastDir=29;
			if (lastDir == linkD) lastDir=32;
			if (lastDir == linkA) lastDir=30;
			linkS = 31;
			linkW = 29;
			linkD = 32;
			linkA = 30;
			linkWe = 33;
			linkAe = 34;
			linkSe = 35;
			linkDe = 36;
		} 
		else if (weapon == CodigoNES.lance) 
		{
			if (lastDir == linkS) lastDir=39;
			if (lastDir == linkW) lastDir=37;
			if (lastDir == linkD) lastDir=40;
			if (lastDir == linkA) lastDir=38;
			linkS = 39;
			linkW = 37;
			linkD = 40;
			linkA = 38;
			linkWe = 41;
			linkAe = 42;
			linkSe = 43;
			linkDe = 44;
		}
		}
	}
	
	
	public void attack(int x3, int y3)
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		
		if(estado == 0) {
		CodigoNES.lehud[0][x()][y()] = getDirfromLastDir();
		
		CodigoNES.view();
	
		
		if (currentMap.getChar(x3, y3) instanceof Enemy)
		{
			attack2(currentMap.getChar(x3, y3));
			boolean etamuerto = currentMap.getChar(x3, y3).isDead();

		
		if (this.weapon.dura == 0) 
		{
			this.weapon.repair();
			this.giveWeapon(CodigoNES.fists);
			changeSprites();
			CodigoNES.lehud[0][x()][y()]=lastDir;
		}

		if (etamuerto) 
		{
			Enemy temp = (Enemy) currentMap.getChar(x3, y3);
			currentMap.setInteractable(temp.getDrop(), x3, y3);
			currentMap.setGameCharacter(null, x3, y3);
		}
		}
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		CodigoNES.lehud[0][x()][y()] = lastDir;
		CodigoNES.view();
		}
	}
	
	public void attack2(GameCharacter target)
	{
		target.damage(weapon.attack);
		
		if(weapon.duraMax != 99) {
		weapon.dura -= 1;
		}
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
	
	public int getHealth() {
		return health;
	}

	public boolean move() {
		boolean seMueveSeñores = CodigoNES.input();
		
		if(seMueveSeñores) {
			
			int direccion = getDirection();
			lastDir = direccion;
			boolean doesChangeMap = CodigoNES.changeMap(CodigoNES.mueve[0], CodigoNES.mueve[1]);
			
			if(!doesChangeMap) {
			boolean semueve = CodigoNES.dale(direccion, x(), y(), CodigoNES.mueve[0], CodigoNES.mueve[1]);
				if (semueve == true) {
					setX(x() + CodigoNES.mueve[0]);
					setY(y() + CodigoNES.mueve[1]);
				}
			}else {
				CodigoNES.changeLinkToNextMap(direccion);
			}
			return true;
		}else {
			return false;
		}
	}


	@Override
	public void Update() {
		
		
	}

	@Override
	public void attack(GameCharacter target) {
		
	
	}

	public void interact(int direccion, Interactable inter) {
		
		if (direccion == linkW) {
			CodigoNES.lehud[0][x()][y()] = 13;
			if(inter != null) {
			inter.interactWith(x() - 1, y());
			}
		}
		if (direccion == linkA) {
			CodigoNES.lehud[0][x()][y()] = 14;
			if(inter != null) {
			inter.interactWith(x(), y() - 1);
			}
		}
		if (direccion == linkS) {
			CodigoNES.lehud[0][x()][y()] = 15;
			if(inter != null) {
			inter.interactWith(x() + 1, y());
			}
		}
		if (direccion == linkD) {
			CodigoNES.lehud[0][x()][y()] = 16;
			if(inter != null) {
			inter.interactWith(x(), y() + 1);
		}
		}
	}

	public boolean giveItem(Item drop) 
	{
	Link link = CodigoNES.getLink();
	if(drop instanceof Weapon)
	{
		if(link.weapon == CodigoNES.fists)
		{
			Item(drop);
			return true;	
		}else {
			return false;
		}
	}
		return false;
	}

	public void Item(Item drop)
	{
		GameMap currentMap = CodigoNES.CurrentMap();
		
		//La casilla de encima overdraw TODO
		CodigoNES.lehud[0][x()][y()] = 19;
		CodigoNES.lehud[3][x() - 1][y()] = drop.range;
		CodigoNES.view();
		CodigoNES.item.play();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(drop instanceof Weapon)
		{	
		giveWeapon((Weapon) drop);
		changeSprites();
		}
		CodigoNES.lehud[3][x()-1][y()] = 0;
		CodigoNES.lehud[0][x()][y()] = lastDir;
	}
	
}

package characters;
import interactables.Interactable;
import items.Item;
import items.Weapon;
import main.CodigoNES;
import terrain.MapChunk;

public class Link extends GameCharacter{

	int hearts;
	
	public Link
			(
				int[] newRange,
				String[] allSprites,
				int newHealth,
				Weapon newWeapon
			)
	{
		super(newRange, allSprites, newHealth, newWeapon);
		
		x = 6;
		y = 5;
		
		hearts = newHealth*2;
		
	}
	
	public void attack(int x3, int y3)
	{
		MapChunk currentMap = CodigoNES.CurrentMap();
		
		int enemigo = currentMap.charLayout[x3][y3]-1;
		
		int espadazo = CodigoNES.getDirfromLastDir();
		
		currentMap.layout()[x][y] = espadazo;
		
		CodigoNES.view();
	
		
		if (enemigo != -1)
		{
			attack2(CodigoNES.moblin.get(enemigo));
			boolean etamuerto = CodigoNES.moblin.get(enemigo).die();

		if (this.weapon.dura == 0) {
			this.weapon.repair();
			this.giveWeapon(CodigoNES.fists);
			CodigoNES.changeSprites();
			currentMap.layout()[x][y]=CodigoNES.lastDir;
		}

		if (etamuerto) {
			currentMap.charLayout[x3][y3] = 0;
			currentMap.layout()[x3][y3] = 21;
			CodigoNES.moblin.remove(enemigo);
			currentMap.nEnemy--;
		}
		}
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		currentMap.layout()[x][y] = CodigoNES.lastDir;
		CodigoNES.view();
		
	}
	
	public boolean attack2(GameCharacter target)
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


	public boolean move() {
		boolean seMueveSeñores = CodigoNES.input();
		
		if(seMueveSeñores) {
			
			int direccion = CodigoNES.getDirection();
			CodigoNES.lastDir = direccion;
			boolean doesChangeMap = CodigoNES.changeMap(CodigoNES.mueve[0], CodigoNES.mueve[1]);
			
			if(!doesChangeMap) {
			boolean semueve = CodigoNES.dale(direccion, x, y, CodigoNES.mueve[0], CodigoNES.mueve[1]);
				if (semueve == true) {
					x += CodigoNES.mueve[0];
					y += CodigoNES.mueve[1];
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
		MapChunk currentMap = CodigoNES.CurrentMap();
		
		if (direccion == CodigoNES.linkW) {
			currentMap.layout()[x][y] = 13;
			if(inter != null) {
			inter.interactWith(x - 1, y);
			}
		}
		if (direccion == CodigoNES.linkA) {
			currentMap.layout()[x][y] = 14;
			if(inter != null) {
			inter.interactWith(x, y - 1);
			}
		}
		if (direccion == CodigoNES.linkS) {
			currentMap.layout()[x][y] = 15;
			if(inter != null) {
			inter.interactWith(x + 1, y);
			}
		}
		if (direccion == CodigoNES.linkD) {
			currentMap.layout()[x][y] = 16;
			if(inter != null) {
			inter.interactWith(x, y + 1);
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
		MapChunk currentMap = CodigoNES.CurrentMap();
		
		int anterior = currentMap.layout()[x - 1][y];
		currentMap.layout()[x][y] = 19;
		currentMap.layout()[x - 1][y] = drop.range;
		CodigoNES.view();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		currentMap.layout()[x - 1][y] = anterior;
		
		if(drop instanceof Weapon)
		{	
		giveWeapon((Weapon) drop);
		CodigoNES.changeSprites();
		}
		
		currentMap.layout()[x][y] = CodigoNES.lastDir;
	}
	
}

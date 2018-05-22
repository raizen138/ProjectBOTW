package main;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import characters.Enemy;
import characters.GameCharacter;
import characters.Link;
import graphics.Finestra;
import graphics.Hud;
import graphics.Taulell;
import interactables.Button;
import interactables.Chest;
import interactables.Drop;
import interactables.Interactable;
import interactables.Npc;
import interactables.Overworld;
import items.Weapon;
import terrain.Exit;
import terrain.GameMap;
import terrain.Water;
import utilities.FileManager;
import utilities.MapCreator;
import utilities.Sound;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Legend of Zelda: A Breath of the Past
 * 
 * @author Rubén Hernández
 * @version Alpha 0.6.0 (wip)
 *
 */
public class CodigoNES {

	static Timer timer = new Timer();

	static final int nmaps = 6;
	public static int[] mueve = new int[4];
	
	static Sound shrine = new Sound("music/Shrine.mp3");
	static Sound field = new Sound("music/Field.mp3");
	static Sound battle = new Sound("music/Battle.mp3");
	public static Sound item = new Sound("music/Item.mp3");
	static Sound currentMusic;

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);

	static int timercito = 0;
	
	static Exit exitmap0 = new Exit("Santuario Resurrección");
	static Exit exitmap1_0 = new Exit("Camara Resurrección");
	static Exit exitmap1_1 = new Exit("Great Plateau");
	static Exit exitmap2_0 = new Exit("Santuario Resurrección");
	static Exit exitmap2_1 = new Exit("El mapa del viejo");
	static Exit exitmap3_0 = new Exit("Great Plateau");
	static Exit exitmap3_1 = new Exit("Primeros Moblins");
	static Exit exitmap4_0 = new Exit("El mapa del viejo");
	static Exit exitmap4_1 = new Exit("Segundos Moblins");
	static Exit exitmap5_0 = new Exit("Primeros Moblins");
	static Exit exitmap5_1 = new Exit("Puente");

	
	public static int[][][] lehud = new int[4][][];

	
	public static Weapon sword = new Weapon(20, "spr/espada.png", 2, 3);
	public static Weapon lance = new Weapon(21, "spr/lanza.png", 5, 2);
	public static Weapon fists = new Weapon(0, "", 99, 1);

	static int[] linkRange = { 1, 2, 3, 4, 13, 14, 15, 16, 19, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
			39, 40, 41, 42, 43, 44, 45 };
	static String[] linkSprites = { "spr/linkSP.png", "spr/linkAP.png", "spr/linkDP.png", "spr/linkWP.png",
			"spr/linkWeP.png", "spr/linkAeP.png", "spr/linkSeP.png", "spr/linkDeP.png", "spr/linkTP.png",
			"spr/linkWN.png", "spr/linkAN.png", "spr/linkSN.png", "spr/linkDN.png", "spr/linkWE.png", "spr/linkAE.png",
			"spr/linkSE.png", "spr/linkDE.png", "spr/linkWeE.png", "spr/linkAeE.png", "spr/linkSeE.png",
			"spr/linkDeE.png", "spr/linkWL.png", "spr/linkAL.png", "spr/linkSL.png", "spr/linkDL.png",
			"spr/linkWeL.png", "spr/linkAeL.png", "spr/linkSeL.png", "spr/linkDeL.png", "spr/linkD.png" };
	public static Link link;
	public static ArrayList<GameCharacter> moblin = new ArrayList<GameCharacter>();
	
	static GameMap[][] mundo = FileManager.loadMaps();
	static GameMap currentMap = new GameMap(null);
	
	public static void main(String[] args) {
		//
		/*
		 * Leyenda: 11x16 
		 * 0 = Suelo 1 = Link S 2 = Link A 3 = Link D 4 = Link W 
		 * 5 = Botones (activables) 6 = Obstaculo 7 = Entrada 
		 * 8 = Moblin 9 = Entrada 2 10 = Entrada 3 11 = Entrada 4 
		 * 12 = Entrada cerrada 13 = Link W Espada 14 = Link A
		 * Espada 15 = Link S Espada 16 = Link D Espada 17 = Personajes (hablar) 
		 * 18 = Cofres (interactuar) 19 = Link Tesoro 20 = Espada 21 = Lanza 22 = Agua 23 =
		 * Agua CambioMapa 24 = Link W nadar 25 = Link A nadar 26 = Link S nadar 27 =
		 * Link D nadar 28 = Agua CambioMapa2 29 = EspadaW // 33 = I 30 = EspadaA // 34
		 * = I 31 = EspadaS // 35 = I 32 = EspadaD // 36 = I 37 = LanzaW // 41 = I 38 =
		 * LanzaA // 42 = I 39 = LanzaS // 43 = I 40 = LanzaD // 44 = I 45 = link Death
		 * 46 = Cofre abierto 47 = Boton abiero 48 = Viejo2 49 = Espada OW
		 */
	
		
		currentMap = mundo[0][0];
		currentMusic = shrine;
		
		int[][] chars = currentMap.toOverride();
		int[][] interfaced = { {50}, {0}, {0}, };
		int[][] hearts = new int[24][36];
		int[][] items = new int[11][16];
		
		hearts = Hud.instance().getLayout(link.getHealth()*2, hearts);
		
		lehud[0] = chars;
		lehud[1] = interfaced;
		lehud[2] = hearts;
		lehud[3] = items;
		
		
		t.setActimatges(true);
		t.setActimgbackground(true);
		f.setTitle("TLOZ Breath of the Past");
		t.setPAD(0);
		t.setActfreedraw(true);
		

		String[] allSprites = new String[60];


		for (int i = 0; i < allSprites.length; i++) {
			allSprites[i] = new String();
		}

		link.writeRange(allSprites);
		sword.writeRange(allSprites);
		lance.writeRange(allSprites);
		MapCreator.cofre.writeRange(allSprites);
		MapCreator.boton.writeRange(allSprites);
		MapCreator.viejo.writeRange(allSprites);
		MapCreator.espada.writeRange(allSprites);
		allSprites[50] = "spr/interface.png";
		allSprites[51] = "spr/health.png";
		allSprites[52] = "spr/health2.png";
		allSprites[53] = "spr/health3.png";
		allSprites[8] = "spr/mobSP.png";
		// 5 10 15 20 25 30 35 40 45
		double[] freedrawy = { 1, 1.3125, 1.375, 1.375, 1.25, 1, 1, 1, 1.6875, 1, 1, 1, 1, 1.5, 1.3125, 1.25, 1.3125, 1.1875,
				1, 1.375, 1.5, 1.5, 1, 1, 1.375, 1.125, 1.375, 1.125, 1, 1.25, 1.3125, 1.75, 1.3125, 1.625, 1.3125,
				1.6875, 1.3125, 1.25, 1.3125, 1.75, 1.3125, 1.625, 1.3125, 1.75, 1.3125, 1, 1, 1, 1.375, 1.375, 1, 1, 1, 1 };
		double[] freedrawx = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.1875, 1,
				1.1875, 1, 1, 1.25, 1, 1.25, 1, 1.6875, 1, 1.6875, 1, 1.3125, 1, 1.3125, 1, 1.6875, 1, 1.6875, 1.5, 1, 1, 1, 1.3125, 1, 1 ,1 ,1 };
		/// 5 10 15 20 25 30 35 40 45
		t.setFreedrawx(freedrawx);
		t.setFreedrawy(freedrawy);
		t.setImatges(allSprites);
		

		
		t.dibuixa(currentMap.toIntMap());
		t.setImgbackground(currentMap.getBgImg());
		t.overdibuixa(lehud);

		currentMusic.play();
		System.out.println("Wake up... Link...");
		

			timer.schedule(new TimerTask() {
		
				@Override
				public void run() {
					play();
					view();
					if (link.isDead()) {
						gameover();
					}
					timercito++;
				}
			}, 0, 700);

			

		
	}

	public static void view() {
		// Auto-generated method stub
		t.dibuixa(currentMap.toIntMap());
		t.setImgbackground(currentMap.getBgImg());
		lehud[0] = currentMap.toOverride();
		lehud[2] = Hud.instance().getLayout(link.getHealth()*2, lehud[2]);
		t.overdibuixa(lehud);
	}

	protected static void play() {
		// Auto-generated method stub
		link.move();
		if(link.lastDirChar == 'j') {
			link.attack(link.x()+mueve[2],link.y()+mueve[3]);
			link.lastDirChar = link.getCharfromDir(link.lastDir);
		}
		if(link.lastDirChar == 'k') {
			link.interact(link.lastDir, currentMap.getInter(link.x()+mueve[2],link.y()+mueve[3]));
			link.lastDirChar = link.getCharfromDir(link.lastDir);
		}
		if(link.lastDirChar == 'l') {
			
			
		}
		if(timercito%3==0) {
			EnemyUpdate();
		}
	}

	private static void EnemyUpdate()
	{
		for(GameCharacter e : moblin)
		{
			e.Update();
		}
	}
	

	private static void gameover() {
		// Auto-generated method stub
		lehud[0][link.x()][link.y()] = 45;
		view();
		
		timer.cancel();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		currentMusic.close();
		t.setActimatges(false);
		t.borraOverdraw();
		t.setImgbackground("map/gameover.jpg");
		t.dibuixa(currentMap.toIntMap());
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	

	public static boolean dale(int character, int currentRow, int currentCol, int movx, int movy) {
		
		
		if (!currentMap.getTile(currentRow+movx, currentCol+movy).isCollider()) {
			if(currentMap.getTile(currentRow+movx, currentCol+movy) instanceof Water) {
				link.estado = 1;
			}
			else 
			{
				link.estado = 0;
			}
			link.changeSprites();
			currentMap.setGameCharacter(null, currentRow, currentCol);
			currentMap.setGameCharacter(link, currentRow+movx, currentCol+movy);
			return true;
		} 
		else 
		{
			return false;
		}

	}

	public static boolean input() {
		char in = f.getActualChar();
		switch (in) {
		case 'w':
			mueve[0] = -1;
			mueve[1] = 0;
			link.lastDirChar = 'w';
			link.lastAction = 'w';
			return true;
		case 'a':
			mueve[0] = 0;
			mueve[1] = -1;
			link.lastDirChar = 'a';
			link.lastAction = 'a';
			return true;
		case 's':
			mueve[0] = 1;
			mueve[1] = 0;
			link.lastDirChar = 's';
			link.lastAction = 's';
			return true;
		case 'd':
			mueve[0] = 0;
			mueve[1] = 1;
			link.lastDirChar = 'd';
			link.lastAction = 'd';
			return true;
		case 'j':
			if(link.lastAction != 'j' && link.lastAction != 'k' && link.lastAction != 'l') {
				mueve[2] = mueve[0];
				mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			link.lastDirChar = 'j';
			link.lastAction = 'j';
			return false;	
		case 'k':
			if(link.lastAction != 'j' && link.lastAction != 'k' && link.lastAction != 'l') {
				mueve[2] = mueve[0];
				mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			link.lastDirChar = 'k';
			link.lastAction = 'k';
			return false;
		case 'l':
			if(link.lastAction != 'j' && link.lastAction != 'k' && link.lastAction != 'l') {
			mueve[2] = mueve[0];
			mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			link.lastDirChar = 'l';
			link.lastAction = 'l';
			return false;	
		default:
			return false;
		}

	}

	public static boolean changeMap(int movX, int movY) //
	{
		boolean doesChangeMap = false;

		for (Entry<Integer, String> entry : currentMap.exits.entrySet()) {
			if (currentMap.exitLayout[link.x()][link.y()] == entry.getKey()) {
				doesChangeMap = true;
			}
		}

		try {
			getExitCasilla(link.x() + movX, link.y() + movY);

			return false;
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		if (doesChangeMap) {
			currentMap.layout[link.x()][link.y()] = 0;
			
			currentMap.resetEnemies();

			String next = currentMap.getNextMap(currentMap.exitLayout[link.x()][link.y()]);

			System.out.println(next);

			mapeado[indexOfMap(currentMap.name)].BgImg = currentMap.BgImg;

			currentMap = mapeado[indexOfMap(next)];
			
			moblin.clear();
			
			for (int i = 1; i <= currentMap.nEnemy; i++) {
				moblin.add(new Enemy(moblinRange, moblinSprites, 3, fists, i));
			}
			
			timercito = 0;
		}

		return doesChangeMap;
	}

	private static int getExitCasilla(int fil, int col) throws ArrayIndexOutOfBoundsException {
		return currentMap.exitLayout[fil][col];
	}

	private static int indexOfMap(String name) {
		for (int i = 0; i < mapeado.length; i++) {
			if (mapeado[i].name.equals(name)) {
				return i;
			}
		}

		return -1;
	}

	public static void changeLinkToNextMap(int direction) {

		if (link.x() == 0) {
			link.setX(GameMap.HEIGHT - 1);
		} else if (link.x() == GameMap.HEIGHT - 1) {
			link.setX(0);
		}

		if (link.y() == 0) {
			link.setY(GameMap.WIDTH - 1);
		} else if (link.y() == GameMap.WIDTH - 1) {
			link.setY(0);
		}

		currentMap.layout[link.x()][link.y()] = direction;
		currentMap.charLayout[link.x()][link.y()] = 9;
	}

	
	public static GameMap CurrentMap()
	{
		return currentMap;
	}
	
	public static Link getLink()
	{
		return link;
		
	}
}
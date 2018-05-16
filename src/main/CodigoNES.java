package main;
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
import interactables.Interactable;
import interactables.Npc;
import interactables.Overworld;
import items.Weapon;
import terrain.MapChunk;
import terrain.Water;
import utilities.Sound;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Legend of Zelda: A Breath of the Past
 * 
 * @author Rubén Hernández
 * @version Alpha 0.5.0
 *
 */
public class CodigoNES {

	static Timer timer = new Timer();
	public static final int MAP_HEIGHT = 11;
	public static final int MAP_WIDTH = 16;
	static final int nmaps = 6;
	public static int linkS = 1;
	public static int linkW = 4;
	public static int linkD = 3;
	public static int linkA = 2;
	static int linkWe = 13;
	static int linkAe = 14;
	static int linkSe = 15;
	static int linkDe = 16;
	public static int[] mueve = new int[4];
	static char lastDirChar;
	public static int lastDir;
	static char lastAction;
	
	static Sound shrine = new Sound("music/Shrine.mp3");
	static Sound field = new Sound("music/Field.mp3");
	static Sound battle = new Sound("music/Battle.mp3");
	public static Sound item = new Sound("music/Item.mp3");
	static Sound currentMusic;

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);

	static int timercito = 0;
	
	static int[] moblinRange = { 8 };
	static String[] moblinSprites = { "spr/mobSP.png" };


	static int[][] mapa0 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, 
							 { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
							 { 6, 0, 0, 0, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 12 }, 
							 { 6, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 },
							 { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6 }, 
							 { 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, };
		
	static int[][] mapa1 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
							 { 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 }, 
							 { 9, 0, 0, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 },
							 { 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, };
	
	static int[][] mapa2 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 0, 0, 0, 6, 6, 6, 6, 0, 0, 6, 6, 6, 6 },
							 { 6, 6, 6, 0, 0, 0, 0, 6, 6, 0, 0, 0, 6, 6, 6, 6 }, 
							 { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
							 { 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, 
							 { 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
							 { 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6 }, };
	
	static int[][] mapa3 = { { 6, 6, 6, 6, 6, 6, 9, 9, 9, 9, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6 }, 
							 { 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 17, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, 
							 { 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6 }, };
	
	static int[][] mapa4 = { { 6, 6, 6, 6, 6, 6, 9, 9, 9, 9, 9, 9, 9, 9, 6, 6 },
							 { 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, { 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 23, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
							 { 6, 28, 28, 7, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6 }, };
	
	static int[][] mapa5 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
							 { 6, 6, 6, 6, 6, 22, 22, 22, 22, 22, 22, 6, 6, 6, 6, 6 },
							 { 6, 6, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 22, 6, 6, 6, 6, 6, 22, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 6, 6, 0, 49, 0, 6, 6, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 6, 6, 0, 0, 0, 6, 6, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 6, 6, 6, 0, 6, 6, 6, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 22, 6, 6, 0, 6, 6, 22, 22, 22, 22, 23 },
							 { 6, 22, 22, 22, 22, 22, 22, 6, 0, 6, 22, 22, 22, 22, 22, 23 },
							 { 6, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6 }, };
	
	static HashMap<Integer, String> mapa0Exits = new HashMap<>();
	static HashMap<Integer, String> mapa1Exits = new HashMap<>();
	static HashMap<Integer, String> mapa2Exits = new HashMap<>();
	static HashMap<Integer, String> mapa3Exits = new HashMap<>();
	static HashMap<Integer, String> mapa4Exits = new HashMap<>();
	static HashMap<Integer, String> mapa5Exits = new HashMap<>();

	static int[] colliders = { 5, 6, 8, 12, 17, 18, 46, 47, 48, 49};

	public static MapChunk[] mapeado = new MapChunk[nmaps]; //
	static MapChunk mapacamara;
	static MapChunk mapasantuario;
	static MapChunk mapagreat;
	static MapChunk mapaviejo;
	static MapChunk mapaespada;
	static MapChunk mapaagua;
	
	static int[][][] lehud = new int[2][][];

	static MapChunk currentMap = new MapChunk();

	static String currentMapName = new String();

	public static Weapon sword = new Weapon(20, "spr/espada.png", 2, 3);
	static Weapon lance = new Weapon(21, "spr/lanza.png", 5, 2);
	public static Weapon fists = new Weapon(0, "", 99, 1);
	static int[] linkRange = { 1, 2, 3, 4, 13, 14, 15, 16, 19, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
			39, 40, 41, 42, 43, 44, 45 };
	static String[] linkSprites = { "spr/linkSP.png", "spr/linkAP.png", "spr/linkDP.png", "spr/linkWP.png",
			"spr/linkWeP.png", "spr/linkAeP.png", "spr/linkSeP.png", "spr/linkDeP.png", "spr/linkTP.png",
			"spr/linkWN.png", "spr/linkAN.png", "spr/linkSN.png", "spr/linkDN.png", "spr/linkWE.png", "spr/linkAE.png",
			"spr/linkSE.png", "spr/linkDE.png", "spr/linkWeE.png", "spr/linkAeE.png", "spr/linkSeE.png",
			"spr/linkDeE.png", "spr/linkWL.png", "spr/linkAL.png", "spr/linkSL.png", "spr/linkDL.png",
			"spr/linkWeL.png", "spr/linkAeL.png", "spr/linkSeL.png", "spr/linkDeL.png", "spr/linkD.png" };
	public static Link link = new Link(linkRange, linkSprites, 3, fists);
	public static ArrayList<GameCharacter> moblin = new ArrayList<GameCharacter>();

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

		mapa0Exits.put(7, "Santuario Resurrección");
		mapa1Exits.put(7, "Great Plateau");
		mapa1Exits.put(9, "Camara Resurrección");
		mapa2Exits.put(7, "El mapa del viejo");
		mapa2Exits.put(9, "Santuario Resurrección");
		mapa3Exits.put(7, "Primeros Moblins");
		mapa3Exits.put(9, "Great Plateau");
		mapa4Exits.put(7, "Segundos Moblins");
		mapa4Exits.put(28, "Segundos Moblins");
		mapa4Exits.put(23, "La Espada");
		mapa4Exits.put(9, "El mapa del viejo");
		mapa5Exits.put(28, "Puente");
		mapa5Exits.put(23, "Primeros Moblins");

		int[][] mapa0Char = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		int[][] mapaChar = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		int[][] mapa4Char = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							  { 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
							  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		
		int[] chestrange = {18, 46};
		String[] chestsprites = {"spr/cofreC.png", "spr/cofreA.png"};
		int[] botonrange = {5, 47};
		String[] botonsprites = {"spr/botonD.png", "spr/botonA.png"};
		int[] viejorange = {17, 48};
		String[] viejosprites = {"spr/viejo1.png", "spr/viejo2.png"};
		int[] espadarange = {49};
		String[] espadasprites = {"spr/espadaOW.png"};
		
		
		Chest chest1 = new Chest(chestsprites, chestrange, null);
		Button boton1 = new Button(botonsprites, botonrange);
		Npc viejo1 = new Npc(viejosprites, viejorange, sword, "viejo1");
		Overworld espada1 = new Overworld(espadasprites, espadarange ,sword);
		
		Interactable[][] mapa0I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, boton1, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };
		
		Interactable[][] mapa1I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, chest1, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, chest1, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, boton1, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };
		
		Interactable[][] mapa2I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };
		
		Interactable[][] mapa3I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, viejo1, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };
		
		Interactable[][] mapa4I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };
		
		Interactable[][] mapa5I = { { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, espada1, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
									{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, };

		mapacamara = new MapChunk("Camara Resurrección", mapa0, mapa0Exits, duplicateMatrix(mapa0), mapa0Char,
				"map/mapa0cerrado.jpg", 0, mapa0I);
		mapasantuario = new MapChunk("Santuario Resurrección", mapa1, mapa1Exits, duplicateMatrix(mapa1), mapaChar,
				"map/mapa1cerrado.jpg", 0, mapa1I);
		mapagreat = new MapChunk("Great Plateau", mapa2, mapa2Exits, duplicateMatrix(mapa2), mapaChar, "map/mapa2.jpg", 0, mapa2I);
		mapaviejo = new MapChunk("El mapa del viejo", mapa3, mapa3Exits, duplicateMatrix(mapa3), mapaChar,
				"map/mapa3.jpg", 0, mapa3I);
		mapaespada = new MapChunk("Primeros Moblins", mapa4, mapa4Exits, duplicateMatrix(mapa4), mapa4Char,
				"map/mapa4.jpg", 2, mapa4I);
		mapaagua = new MapChunk("La Espada", mapa5, mapa5Exits, duplicateMatrix(mapa5), mapaChar, "map/mapa5.jpg", 0, mapa5I);

		mapeado[0] = mapacamara;
		mapeado[1] = mapasantuario;
		mapeado[2] = mapagreat;
		mapeado[3] = mapaviejo;
		mapeado[4] = mapaespada;
		mapeado[5] = mapaagua;

		
		int[][] interfaced = { {50}, {0}, {0}, };
		int[][] hearts = new int[24][36];
		
		hearts = Hud.instance().getLayout(link.getHealth()*2, hearts);
		
		
		lehud[0] = interfaced;
		lehud[1] = hearts;
		
		
		t.setActimatges(true);
		t.setActimgbackground(true);
		f.setTitle("TLOZ Breath of the Past");
		t.setPAD(0);
		t.setActfreedraw(true);
		


		for (int i = 1; i < currentMap.nEnemy; i++) {
			moblin.add(new Enemy(moblinRange, moblinSprites, 3, fists, i));
		}

		String[] allSprites = new String[60];


		for (int i = 0; i < allSprites.length; i++) {
			allSprites[i] = new String();
		}

		link.writeRange(allSprites);
		sword.writeRange(allSprites);
		lance.writeRange(allSprites);
		chest1.writeRange(allSprites);
		boton1.writeRange(allSprites);
		viejo1.writeRange(allSprites);
		espada1.writeRange(allSprites);
		allSprites[50] = "spr/interface.png";
		allSprites[51] = "spr/health.png";
		allSprites[52] = "spr/health2.png";
		allSprites[53] = "spr/health3.png";
		allSprites[8] = moblinSprites[0];
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
		
		
		
		currentMap.layout = mapacamara.layout;
		currentMap.name = mapacamara.name;
		currentMap.exits.putAll(mapacamara.exits);
		currentMap.exitLayout = mapacamara.exitLayout;
		currentMap.charLayout = mapacamara.charLayout;
		currentMap.BgImg = mapacamara.BgImg;
		currentMap.interLayout = mapacamara.interLayout;
		currentMusic = shrine;
		
		t.dibuixa(currentMap.layout);
		t.setImgbackground(currentMap.BgImg);
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
		t.dibuixa(currentMap.layout);
		t.setImgbackground(currentMap.BgImg);
		lehud[1] = Hud.instance().getLayout(link.getHealth()*2, lehud[1]);
		t.overdibuixa(lehud);
	}

	protected static void play() {
		// Auto-generated method stub
		link.move();
		if(lastDirChar == 'j') {
			link.attack(link.x()+mueve[2],link.y()+mueve[3]);
			lastDirChar = getCharfromDir(lastDir);
		}
		if(lastDirChar == 'k') {
			link.interact(lastDir, currentMap.interLayout[link.x()+mueve[2]][link.y()+mueve[3]]);
			lastDirChar = getCharfromDir(lastDir);
		}
		if(lastDirChar == 'l') {
			
			
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

	private static char getCharfromDir(int lastDir2) {
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

	private static void gameover() {
		// Auto-generated method stub
		currentMap.layout[link.x()][link.y()] = 45;
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
		t.dibuixa(currentMap.layout);
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public static int getDirection() {
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

	public static int getDirfromLastDir() {
		
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

	public static void changeSprites() {
		// Auto-generated method stub
		
		if(link.estado == 1)
		{
			linkS = 26;
			linkW = 24;
			linkA = 25;
			linkD = 27;
		}else {
		if (link.weapon == fists) {
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
		} else if (link.weapon == sword) {
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
		} else if (link.weapon == lance) {
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

	public static boolean dale(int character, int currentRow, int currentCol, int movx, int movy) {

		if (!isCollision(currentRow + movx, currentCol + movy)) {
			if(Water.getInstance().isWater(currentRow + movx, currentCol + movy)) {
				link.estado = 1;
			}else {
				link.estado = 0;
			}
			changeSprites();
			currentMap.layout[currentRow][currentCol] = 0;
			currentMap.layout[currentRow + movx][currentCol + movy] = getDirection();
			currentMap.charLayout[currentRow][currentCol] = 0;
			currentMap.charLayout[currentRow + movx][currentCol + movy] = 9;
			return true;
		} else {
			currentMap.layout[currentRow][currentCol] = getDirection();
			return false;
		}

	}

	public static boolean input() {
		char in = f.getActualChar();
		switch (in) {
		case 'w':
			mueve[0] = -1;
			mueve[1] = 0;
			lastDirChar = 'w';
			lastAction = 'w';
			return true;
		case 'a':
			mueve[0] = 0;
			mueve[1] = -1;
			lastDirChar = 'a';
			lastAction = 'a';
			return true;
		case 's':
			mueve[0] = 1;
			mueve[1] = 0;
			lastDirChar = 's';
			lastAction = 's';
			return true;
		case 'd':
			mueve[0] = 0;
			mueve[1] = 1;
			lastDirChar = 'd';
			lastAction = 'd';
			return true;
		case 'j':
			if(lastAction != 'j' && lastAction != 'k' && lastAction != 'l') {
				mueve[2] = mueve[0];
				mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			lastDirChar = 'j';
			lastAction = 'j';
			return false;	
		case 'k':
			if(lastAction != 'j' && lastAction != 'k' && lastAction != 'l') {
				mueve[2] = mueve[0];
				mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			lastDirChar = 'k';
			lastAction = 'k';
			return false;
		case 'l':
			if(lastAction != 'j' && lastAction != 'k' && lastAction != 'l') {
			mueve[2] = mueve[0];
			mueve[3] = mueve[1];
			}
			mueve[0] = 0;
			mueve[1] = 0;
			lastDirChar = 'l';
			lastAction = 'l';
			return false;	
		default:
			return false;
		}

	}

	private static boolean isCollision(int row, int col) {
		boolean ret = false;

		for (int i = 0; i < colliders.length; i++) {
			if (currentMap.layout[row][col] == colliders[i]) {
				ret = true;
			}
		}

		return ret;
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
			link.setX(MAP_HEIGHT - 1);
		} else if (link.x() == MAP_HEIGHT - 1) {
			link.setX(0);
		}

		if (link.y() == 0) {
			link.setY(MAP_WIDTH - 1);
		} else if (link.y() == MAP_WIDTH - 1) {
			link.setY(0);
		}

		currentMap.layout[link.x()][link.y()] = direction;
		currentMap.charLayout[link.x()][link.y()] = 9;
	}

	private static int[][] duplicateMatrix(int[][] matrix) {
		int[][] ret = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				ret[i][j] = matrix[i][j];
			}
		}
		return ret;
	}
	
	public static MapChunk CurrentMap()
	{
		return currentMap;
	}
	
	public static Link getLink()
	{
		return link;
		
	}
}
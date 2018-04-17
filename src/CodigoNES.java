import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Legend of Zelda: A Breath of the Past
 * 
 * @author Rubén Hernández
 * @version Alpha 0.2.1
 *
 */
public class CodigoNES {

	static Timer timer = new Timer();
	static final int MAP_HEIGHT = 11;
	static final int MAP_WIDTH = 16;
	static final int nmaps = 6;
	static int linkS = 1;
	static int linkW = 4;
	static int linkD = 3;
	static int linkA = 2;
	static int linkWe = 13;
	static int linkAe = 14;
	static int linkSe = 15;
	static int linkDe = 16;
	static int[] mueve = new int[4];
	static char lastDirChar;
	static int lastDir;
	static char lastAction;

	static Taulell t = new Taulell();
	static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);

	static boolean flagSword = false;
	static int timercito = 0;
	
	static int[] moblinRange = { 8 };
	static String[] moblinSprites = { "spr/mobSP.png" };


	static int[][] mapa0 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 6, 0, 0, 0, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 12 }, { 6, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 },
			{ 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6 }, { 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, };
	static int[][] mapa1 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 }, { 9, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12 },
			{ 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6 }, { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, };
	static int[][] mapa2 = { { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 0, 0, 0, 6, 6, 6, 6, 0, 0, 6, 6, 6, 6 },
			{ 6, 6, 6, 0, 0, 0, 0, 6, 6, 0, 0, 0, 6, 6, 6, 6 }, { 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, { 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 },
			{ 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6 }, };
	static int[][] mapa3 = { { 6, 6, 6, 6, 6, 9, 9, 9, 9, 9, 6, 6, 6, 6, 6, 6 },
			{ 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6 }, { 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, { 6, 6, 6, 17, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, { 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 },
			{ 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6, 6 }, { 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 6 },
			{ 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6 }, { 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 6, 6 }, };
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
			{ 6, 22, 22, 22, 22, 6, 6, 0, 18, 0, 6, 6, 22, 22, 22, 23 },
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

	static int[] colliders = { 5, 6, 8, 12, 17, 18 };

	public static MapChunk[] mapeado = new MapChunk[nmaps]; //
	static MapChunk mapacamara;
	static MapChunk mapasantuario;
	static MapChunk mapagreat;
	static MapChunk mapaviejo;
	static MapChunk mapaespada;
	static MapChunk mapaagua;

	static MapChunk currentMap = new MapChunk();

	static String currentMapName = new String();

	static Weapon sword = new Weapon(20, "spr/espada.png", 2, 3);
	static Weapon lance = new Weapon(21, "spr/lanza.png", 5, 2);
	static Weapon fists = new Weapon(0, "", 99, 1);
	static int[] linkRange = { 1, 2, 3, 4, 13, 14, 15, 16, 19, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
			39, 40, 41, 42, 43, 44, 45 };
	static String[] linkSprites = { "spr/linkSP.png", "spr/linkAP.png", "spr/linkDP.png", "spr/linkWP.png",
			"spr/linkWeP.png", "spr/linkAeP.png", "spr/linkSeP.png", "spr/linkDeP.png", "spr/linkTP.png",
			"spr/linkWN.png", "spr/linkAN.png", "spr/linkSN.png", "spr/linkDN.png", "spr/linkWE.png", "spr/linkAE.png",
			"spr/linkSE.png", "spr/linkDE.png", "spr/linkWeE.png", "spr/linkAeE.png", "spr/linkSeE.png",
			"spr/linkDeE.png", "spr/linkWL.png", "spr/linkAL.png", "spr/linkSL.png", "spr/linkDL.png",
			"spr/linkWeL.png", "spr/linkAeL.png", "spr/linkSeL.png", "spr/linkDeL.png", "spr/linkD.png" };
	static Link link = new Link(linkRange, linkSprites, 3, fists);
	static ArrayList<GameCharacter> moblin = new ArrayList<GameCharacter>();

	public static void main(String[] args) {
		//
		/*
		 * Leyenda: 11x16 0 = Suelo 1 = Link S 2 = Link A 3 = Link D 4 = Link W 5 =
		 * Botones (activables) 6 = Obstaculo 7 = Entrada 8 = Moblin 9 = Entrada 2 10 =
		 * Entrada 3 11 = Entrada 4 12 = Entrada cerrada 13 = Link W Espada 14 = Link A
		 * Espada 15 = Link S Espada 16 = Link D Espada 17 = Personajes (hablar) 18 =
		 * Cofres (interactuar) 19 = Link Tesoro 20 = Espada 21 = Lanza 22 = Agua 23 =
		 * Agua CambioMapa 24 = Link W nadar 25 = Link A nadar 26 = Link S nadar 27 =
		 * Link D nadar 28 = Agua CambioMapa2 29 = EspadaW // 33 = I 30 = EspadaA // 34
		 * = I 31 = EspadaS // 35 = I 32 = EspadaD // 36 = I 37 = LanzaW // 41 = I 38 =
		 * LanzaA // 42 = I 39 = LanzaS // 43 = I 40 = LanzaD // 44 = I 45 = link Death
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
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		int[][] mapaChar = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		int[][] mapa4Char = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

		mapacamara = new MapChunk("Camara Resurrección", mapa0, mapa0Exits, duplicateMatrix(mapa0), mapa0Char,
				"map/mapa0cerrado.jpg", 0);
		mapasantuario = new MapChunk("Santuario Resurrección", mapa1, mapa1Exits, duplicateMatrix(mapa1), mapaChar,
				"map/mapa1cerrado.jpg", 0);
		mapagreat = new MapChunk("Great Plateau", mapa2, mapa2Exits, duplicateMatrix(mapa2), mapaChar, "map/mapa2.jpg", 0);
		mapaviejo = new MapChunk("El mapa del viejo", mapa3, mapa3Exits, duplicateMatrix(mapa3), mapaChar,
				"map/mapa3.jpg", 0);
		mapaespada = new MapChunk("Primeros Moblins", mapa4, mapa4Exits, duplicateMatrix(mapa4), mapa4Char,
				"map/mapa4.jpg", 2);
		mapaagua = new MapChunk("La Espada", mapa5, mapa5Exits, duplicateMatrix(mapa5), mapaChar, "map/mapa5.jpg", 0);

		mapeado[0] = mapacamara;
		mapeado[1] = mapasantuario;
		mapeado[2] = mapagreat;
		mapeado[3] = mapaviejo;
		mapeado[4] = mapaespada;
		mapeado[5] = mapaagua;

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
		allSprites[8] = moblinSprites[0];
		// 5 10 15 20 25 30 35 40 45
		double[] freedrawy = { 1, 1.3125, 1.375, 1.375, 1.25, 1, 1, 1, 1.6875, 1, 1, 1, 1, 1.5, 1.3125, 1.25, 1.3125, 1,
				1, 1.375, 1.5, 1.5, 1, 1, 1.375, 1.125, 1.375, 1.125, 1, 1.25, 1.3125, 1.75, 1.3125, 1.625, 1.3125,
				1.6875, 1.3125, 1.25, 1.3125, 1.75, 1.3125, 1.625, 1.3125, 1.75, 1.3125, 1 };
		double[] freedrawx = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.1875, 1,
				1.1875, 1, 1, 1.25, 1, 1.25, 1, 1.6875, 1, 1.6875, 1, 1.3125, 1, 1.3125, 1, 1.6875, 1, 1.6875, 1.5 };
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

		t.dibuixa(currentMap.layout);
		t.setImgbackground(currentMap.BgImg);

		System.out.println("Wake up... Link...");
		

			timer.schedule(new TimerTask() {
		
				@Override
				public void run() {
					play();
					view();
					if (link.die()) {
						gameover();
					}
					timercito++;
				}
			}, 0, 700);

			

		
	}

	protected static void view() {
		// Auto-generated method stub
		t.dibuixa(currentMap.layout);
		t.setImgbackground(currentMap.BgImg);
	}

	protected static void play() {
		// Auto-generated method stub
		System.out.println(lastDir);
		System.out.println(lastAction);
		System.out.println(lastDirChar);
		moving();
		if(lastDirChar == 'j') {
			attack(link.x+mueve[2],link.y+mueve[3]);
			lastDirChar = getCharfromDir(lastDir);
		}
		if(lastDirChar == 'k') {
			interact(lastDir);
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
		currentMap.layout[link.x][link.y] = 45;
		timer.cancel();
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		t.setActimatges(false);
		t.setImgbackground("map/gameover.jpg");
		t.dibuixa(currentMap.layout);
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	private static void moving() {
		boolean seMueveSeñores = input();
		
		if(seMueveSeñores) {
			
			int direccion = getDirection();
			lastDir = direccion;
			boolean doesChangeMap = changeMap(mueve[0], mueve[1]);
			
			if(!doesChangeMap) {
			boolean semueve = dale(direccion, link.x, link.y, mueve[0], mueve[1]);
				if (semueve == true) {
					link.x += mueve[0];
					link.y += mueve[1];
				}
			}else {
				changeLinkToNextMap(direccion);
			}
		} 	
		
	}

	private static int getDirection() {
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

	private static void interact(int direccion) {
		// Auto-generated method stub

		if (direccion == linkW) {
			currentMap.layout[link.x][link.y] = 13;
			boton(link.x - 1, link.y);
		}
		if (direccion == linkA) {
			currentMap.layout[link.x][link.y] = 14;
			boton(link.x, link.y - 1);
		}
		if (direccion == linkS) {
			currentMap.layout[link.x][link.y] = 15;
			boton(link.x + 1, link.y);
		}
		if (direccion == linkD) {
			currentMap.layout[link.x][link.y] = 16;
			boton(link.x, link.y + 1);
		}
	}

	private static void boton(int x2, int y2) {
		// Auto-generated method stub
		if (currentMap.layout[x2][y2] == 5) {
			for (int i = 0; i < MAP_HEIGHT; i++) {
				for (int j = 0; j < MAP_WIDTH; j++) {
					if (currentMap.exitLayout[i][j] == 12) {
						currentMap.exitLayout[i][j] = 7;
						currentMap.layout[i][j] = 7;
					}
				}
			}
			currentMap.changeBgImg();
		} else if (currentMap.layout[x2][y2] == 17) {
			if (currentMap.name.equals("El mapa del viejo")) {
				if (flagSword == false) {
					if (!link.hasWeapon()) {
						Item(sword);
						System.out.println("It's dangerous to go alone, take this!");
						flagSword = true;
					}
				} else {
					System.out.println("Zelda is waiting for you in the Temple of Time, go save her!");
				}
			}
		} else if (currentMap.layout[x2][y2] == 18) {
			if (currentMap.name.equals("Santuario Resurrección")) {
				System.out.println("This chest was already opened, it has nothing inside...");
			}
			if (currentMap.name.equals("La Espada")) {
				if (!link.hasWeapon()) {
					currentMap.changeBgImg();
					Item(sword);
					currentMap.layout[x2][y2] = 0;
				}
			}
			}
	}

	private static void attack(int x3, int y3) {
		// Auto-generated method stub
		
		int enemigo = currentMap.charLayout[x3][y3]-1;
		System.out.println(enemigo);
		int espadazo = getDirfromLastDir();
		currentMap.layout[link.x][link.y] = espadazo;
		view();
	
		
		if (enemigo != -1) {
		link.attack(moblin.get(enemigo));
		boolean etamuerto = moblin.get(enemigo).die();

		if (link.weapon.dura == 0) {
			link.weapon.repair();
			link.giveWeapon(fists);
			changeSprites();
			currentMap.layout[link.x][link.y]=lastDir;
		}

		if (etamuerto) {
			currentMap.charLayout[x3][y3] = 0;
			currentMap.layout[x3][y3] = 21;
			moblin.remove(enemigo);
			currentMap.nEnemy--;
		}
		}
		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		currentMap.layout[link.x][link.y] = lastDir;
		view();
		
	}

	private static int getDirfromLastDir() {
		
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

	private static void changeSprites() {
		// Auto-generated method stub

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

	private static void Item(Weapon weapon) {
		// Auto-generated method stub
		currentMap.layout[link.x][link.y] = 19;
		currentMap.layout[link.x - 1][link.y] = weapon.range;
		t.dibuixa(currentMap.layout);
		t.setImgbackground(currentMap.BgImg);

		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		currentMap.layout[link.x - 1][link.y] = 0;
		link.giveWeapon(weapon);
		changeSprites();
		currentMap.layout[link.x][link.y] = lastDir;
	}

	private static boolean dale(int character, int currentRow, int currentCol, int movx, int movy) {

		if (!isCollision(currentRow + movx, currentCol + movy)) {
			currentMap.layout[currentRow][currentCol] = 0;
			currentMap.layout[currentRow + movx][currentCol + movy] = character;
			currentMap.charLayout[currentRow][currentCol] = 0;
			currentMap.charLayout[currentRow + movx][currentCol + movy] = 9;
			return true;
		} else {
			currentMap.layout[currentRow][currentCol] = character;
			return false;
		}

	}

	private static boolean input() {
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

	private static boolean changeMap(int movX, int movY) //
	{
		boolean doesChangeMap = false;

		for (Entry<Integer, String> entry : currentMap.exits.entrySet()) {
			if (currentMap.exitLayout[link.x][link.y] == entry.getKey()) {
				doesChangeMap = true;
			}
		}

		try {
			getExitCasilla(link.x + movX, link.y + movY);

			return false;
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		if (doesChangeMap) {
			currentMap.layout[link.x][link.y] = 0;
			
			currentMap.resetEnemies();

			String next = currentMap.getNextMap(currentMap.exitLayout[link.x][link.y]);

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

	private static void changeLinkToNextMap(int direction) {

		if (link.x == 0) {
			link.x = MAP_HEIGHT - 1;
		} else if (link.x == MAP_HEIGHT - 1) {
			link.x = 0;
		}

		if (link.y == 0) {
			link.y = MAP_WIDTH - 1;
		} else if (link.y == MAP_WIDTH - 1) {
			link.y = 0;
		}

		currentMap.layout[link.x][link.y] = direction;
		currentMap.charLayout[link.x][link.y] = 9;
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
	
	public static void setCurrentMap(MapChunk newMap)
	{
		currentMap = newMap;
	}
}
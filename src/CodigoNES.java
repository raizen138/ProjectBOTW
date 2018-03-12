import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CodigoNES {
	
	static final int MAP_HEIGHT = 11;
	static final int MAP_WIDTH = 16;
	static final int nmaps = 5;
	static int linkS = 1;
	static int linkW = 4;
	static int linkD = 3;
	static int linkA = 2;
	static int linkWe = 13;
	static int linkAe = 14;
	static int linkSe = 15;
	static int linkDe = 16;
	
	static Taulell t = new Taulell();
    static Finestra f = new Finestra(t);
	static Scanner sc = new Scanner(System.in);
	
	static boolean flagSword = false;
	
	static int x = 6;
	static int y = 5;
	
	static int [][] mapa0 = {
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,0,0,0,0,0,0,0,0,0,0,0,0,6,6},
  			{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6},
  			{6,0,0,0,6,6,6,0,0,0,0,0,0,0,0,12},
  			{6,0,0,0,0,1,0,0,0,0,0,0,0,0,0,12},
  			{6,0,0,0,0,0,0,0,0,0,0,0,0,0,5,6},
  			{6,6,0,0,0,0,0,0,0,0,0,0,0,0,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  		    {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			};
    static int [][] mapa1 = {
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,0,0,18,0,0,0,0,0,0,0,0,0,0,6},
  			{9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,12},
  			{9,0,0,0,0,18,0,0,0,0,0,0,0,0,0,12},
  			{6,6,0,0,0,0,0,0,0,0,0,0,0,0,5,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  		    {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
  			};
    static int [][] mapa2 = {
    		{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
      		{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
      		{6,6,6,0,0,0,6,6,6,6,0,0,6,6,6,6},
      		{6,6,6,0,0,0,0,6,6,0,0,0,6,6,6,6},
      		{6,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6},
      		{9,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6},
			{9,0,0,0,0,0,0,0,0,0,0,0,0,0,6,6},
			{6,6,6,6,6,0,0,0,0,0,6,6,6,6,6,6},
			{6,6,6,6,6,0,0,0,0,0,6,6,6,6,6,6},
			{6,6,6,6,6,0,0,0,0,0,6,6,6,6,6,6},
			{6,6,6,6,6,7,7,7,7,7,6,6,6,6,6,6},
      		};
    static int [][] mapa3 = {
    		{6,6,6,6,6,9,9,9,9,9,6,6,6,6,6,6},
      		{6,6,0,0,0,0,0,0,0,0,0,0,0,6,6,6},
      		{6,6,6,0,0,0,0,0,0,0,0,0,6,6,6,6},
      		{6,6,6,6,0,0,0,0,0,0,0,0,6,6,6,6},
      		{6,6,6,17,0,0,0,0,0,0,0,0,6,6,6,6},
      		{6,6,6,6,0,0,0,0,0,0,0,0,6,6,6,6},
			{6,6,6,0,0,0,0,0,0,0,0,0,6,6,6,6},
			{6,6,6,6,0,0,0,0,0,0,0,0,6,6,6,6},
			{6,6,6,6,6,0,0,0,0,0,0,0,0,6,6,6},
			{6,6,6,6,6,6,0,0,0,0,0,0,0,0,6,6},
			{6,6,6,6,6,6,7,7,7,7,7,7,7,7,6,6},
      		};
    static int [][] mapa4 = {
       		{6,6,6,6,6,6,9,9,9,9,9,9,9,9,6,6},
       		{6,6,6,6,6,0,0,0,0,0,0,0,0,0,6,6},
       		{6,6,6,6,0,0,0,0,0,0,0,0,0,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
       		{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,8,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,8,0,0,0,6,6,6,6},
 			{23,22,22,0,0,0,0,0,0,0,0,0,6,6,6,6},
 			{6,28,28,7,7,7,7,7,7,7,7,7,6,6,6,6},
       		};

    
	static HashMap<Integer, String> mapa0Exits = new HashMap<>();
	static HashMap<Integer, String> mapa1Exits = new HashMap<>();
	static HashMap<Integer, String> mapa2Exits = new HashMap<>();
	static HashMap<Integer, String> mapa3Exits = new HashMap<>();
	static HashMap<Integer, String> mapa4Exits = new HashMap<>();
	
    
    
    static int[] colliders = {5, 6, 8, 12, 17, 18};
    
    static MapChunk[] mapeado = new MapChunk[nmaps]; //TODO
    static MapChunk mapacamara;
	static MapChunk mapasantuario;
	static MapChunk mapagreat;
	static MapChunk mapaviejo;
	static MapChunk mapaespada;
    
    static MapChunk currentMap = new MapChunk();
     
    static String currentMapName = new String();
    
    static Weapon sword = new Weapon(20, "espada.png", 2, 3);
    static Weapon lance = new Weapon(21, "lanza.png", 5, 2);
    static Weapon fists = new Weapon(0, "", 999, 1);
    static int[] linkRange = {1, 2, 3, 4, 13, 14, 15, 16, 19, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
	static String[] linkSprites = {"linkSP.png","linkAP.png","linkDP.png","linkWP.png", "linkWeP.png", "linkAeP.png", "linkSeP.png", "linkDeP.png", "linkTP.png", "linkWN.png", "linkAN.png", "linkSN.png", "linkDN.png", "linkWE.png", "linkAE.png", "linkSE.png", "linkDE.png", "linkWeE.png", "linkAeE.png", "linkSeE.png", "linkDeE.png", "linkWL.png", "linkAL.png", "linkSL.png", "linkDL.png", "linkWeL.png", "linkAeL.png", "linkSeL.png", "linkDeL.png", "linkD.png"};
	static GameCharacter link = new GameCharacter(linkRange, linkSprites, 3, fists, "Link");
	static GameCharacter[] moblin = new GameCharacter[9];
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Leyenda:
		 * 11x16
		 * 0 = Suelo
		 * 1 = Link S
		 * 2 = Link A
		 * 3 = Link D
		 * 4 = Link W
		 * 5 = Botones (activables)
		 * 6 = Obstaculo
		 * 7 = Entrada
		 * 8 = Moblin
		 * 9 = Entrada 2
		 * 10 = Entrada 3
		 * 11 = Entrada 4
		 * 12 = Entrada cerrada
		 * 13 = Link W Espada
		 * 14 = Link A Espada
		 * 15 = Link S Espada
		 * 16 = Link D Espada
		 * 17 = Personajes (hablar)
		 * 18 = Cofres (interactuar)
		 * 19 = Link Tesoro
		 * 20 = Espada
		 * 21 = Lanza
		 * 22 = Agua
		 * 23 = Agua CambioMapa
		 * 24 = Link W nadar
		 * 25 = Link A nadar
		 * 26 = Link S nadar
		 * 27 = Link D nadar
		 * 28 = Agua CambioMapa2
		 * 29 = EspadaW // 33 = I
		 * 30 = EspadaA // 34 = I
		 * 31 = EspadaS // 35 = I
		 * 32 = EspadaD // 36 = I
		 * 37 = LanzaW // 41 = I
		 * 38 = LanzaA // 42 = I
		 * 39 = LanzaS // 43 = I
		 * 37 = LanzaD // 44 = I
		 * 45 = link Death
		 */

    	
		mapa0Exits.put(7, "Santuario Resurrecci�n");
		mapa1Exits.put(7, "Great Plateau");
		mapa1Exits.put(9, "Camara Resurrecci�n");
		mapa2Exits.put(7, "El mapa del viejo");
		mapa2Exits.put(9, "Santuario Resurrecci�n");
		mapa3Exits.put(7, "Primeros Moblins");
		mapa3Exits.put(9, "Great Plateau");
		mapa4Exits.put(7, "Segundos Moblins");
		mapa4Exits.put(28, "Segundos Moblins");
		mapa4Exits.put(23, "La espada");
		mapa4Exits.put(9, "El mapa del viejo");
		
		int [][] mapa0Char = {
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			};
		
		int [][] mapaChar = {
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			};
		
		int [][] mapa4Char = {
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	  			};
		
		
		
	    mapacamara = new MapChunk("Camara Resurrecci�n", mapa0, mapa0Exits, duplicateMatrix(mapa0), mapa0Char, "mapa0cerrado.jpg");
		mapasantuario = new MapChunk("Santuario Resurrecci�n", mapa1, mapa1Exits, duplicateMatrix(mapa1), mapaChar, "mapa1cerrado.jpg");
		mapagreat = new MapChunk("Great Plateau", mapa2, mapa2Exits, duplicateMatrix(mapa2), mapaChar, "mapa2.jpg");
		mapaviejo = new MapChunk("El mapa del viejo", mapa3, mapa3Exits, duplicateMatrix(mapa3), mapaChar, "mapa3.jpg");
		mapaespada = new MapChunk("Primeros Moblins", mapa4, mapa4Exits, duplicateMatrix(mapa4), mapa4Char, "mapa4.jpg");
		
		mapeado[0] = mapacamara;
		mapeado[1] = mapasantuario;
		mapeado[2] = mapagreat;
		mapeado[3] = mapaviejo;
		mapeado[4] = mapaespada;
		 

		
        t.setActimatges(true);
        t.setActcolors(false);
        t.setActlletres(false);
        t.setActborde(false);
        f.setActetiquetes(false);
        t.setActimgbackground(true);
        t.setImgbackground("mapa0cerrado.jpg");
        f.setTitle("TLOZ Breath of the Past");
        t.setPAD(0);
        
     
		
		int[] moblinRange = {8};
		String[] moblinSprites = {"mobSP.png"};
		
		for(int i = 1; i < moblin.length; i++)
		{
			moblin[i] = new GameCharacter(moblinRange, moblinSprites, 3, fists, "Moblin " + i);
		}
		
		String[] allSprites = new String[60];
		
		for(int i = 0; i < allSprites.length; i++)
		{
			allSprites[i] = new String();
		}
		
		link.writeRange(allSprites);
		sword.writeRange(allSprites);
		lance.writeRange(allSprites);
		moblin[1].writeRange(allSprites);
		t.setImatges(allSprites);
			
		currentMap.layout = mapacamara.layout;
		currentMap.name = mapacamara.name;
		currentMap.exits.putAll(mapacamara.exits);
		currentMap.exitLayout = mapacamara.exitLayout;
		currentMap.charLayout = mapacamara.charLayout;
		currentMap.BgImg = mapacamara.BgImg;
		
		
		
        t.dibuixa(currentMap.layout);
		
		System.out.println("Wake up... Link...");
		
		while(true)
		{
			moving();
			t.dibuixa(currentMap.layout);
			t.setImgbackground(currentMap.BgImg);
			moving();
			t.dibuixa(currentMap.layout);
			t.setImgbackground(currentMap.BgImg);
			moving();
			moverenemigo();
			t.dibuixa(currentMap.layout);
			t.setImgbackground(currentMap.BgImg);
			if (link.die()) {
				gameover();
				break;
			}
			
		}
	}	
	
    private static void moverenemigo() {

		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 16; y++) {
				if (currentMap.layout[x][y] == 8) {
					int enemigo = currentMap.charLayout[x][y];
					int opt = (int) (Math.random() * 4);
					switch (opt) {
					case 0:
						if (currentMap.exitLayout[x - 1][y] == 0 && currentMap.layout[x - 1][y] == 0) {
							currentMap.layout[x - 1][y] = 8;
							currentMap.charLayout[x - 1][y] = enemigo; 
							currentMap.layout[x][y] = 0;
							currentMap.charLayout[x][y] = 0;
							x--;
						}
						break;
					case 1:
						if (currentMap.exitLayout[x][y - 1] == 0 && currentMap.layout[x][y - 1] == 0) {
							currentMap.layout[x][y - 1] = 8;
							currentMap.charLayout[x][y - 1] = enemigo;
							currentMap.layout[x][y] = 0;
							currentMap.charLayout[x][y] = 0;
							y--;
						}
						break;
					case 2:
						if (currentMap.exitLayout[x + 1][y] == 0 && currentMap.layout[x + 1][y] == 0) {
							currentMap.layout[x + 1][y] = 8;
							currentMap.charLayout[x + 1][y] = enemigo;
							currentMap.layout[x][y] = 0;
							currentMap.charLayout[x][y] = 0;
							x++;
						}
						break;
					case 3:
						if (currentMap.exitLayout[x][y + 1] == 0 && currentMap.layout[x][y + 1] == 0) {
							currentMap.layout[x][y + 1] = 8;
							currentMap.charLayout[x][y + 1] = enemigo;
							currentMap.layout[x][y] = 0;
							currentMap.charLayout[x][y] = 0;
							y++;
						}
						break;
					}
					if (currentMap.charLayout[x+1][y] == 9 || currentMap.charLayout[x-1][y] == 9 || currentMap.charLayout[x][y+1] == 9 || currentMap.charLayout[x][y-1] == 9) {
						moblin[enemigo].attack(link);
						
						
					}
				}
			}
		}

	}
    
	private static void gameover() {
		// TODO Auto-generated method stub
		currentMap.layout[x][y]=45;
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.setActimatges(false);
		t.setImgbackground("gameover.jpg");
		t.dibuixa(currentMap.layout);
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void moving() 
	{
		int[] mueve = input();
		
		boolean doesChangeMap = changeMap(mueve[0], mueve[1]);
		
		int direccion = 0;
		
		if(!doesChangeMap) {
		if(mueve[0] == -1) 
		{
			if(currentMap.exitLayout[x-1][y] == 22 || currentMap.exitLayout[x-1][y] == 23 || currentMap.exitLayout[x-1][y] == 28) {
				direccion = 24;
			}else if(currentMap.layout[x-1][y] == 21 && link.weapon == fists) {
				Item(lance);
				
			}
			
			else {
			direccion = linkW;
			}
		}
		
		if(mueve[0] == 1) 
		{
			if(currentMap.exitLayout[x+1][y] == 22 || currentMap.exitLayout[x+1][y] == 23 || currentMap.exitLayout[x+1][y] == 28) {
				direccion = 26;
			}else if(currentMap.layout[x+1][y] == 21 && link.weapon == fists) {
				Item(lance);	
			}else {
			direccion = linkS;
			}
		}
		
		if(mueve[1] == -1) 
		{
			if(currentMap.exitLayout[x][y-1] == 22 || currentMap.exitLayout[x][y-1] == 23 || currentMap.exitLayout[x][y-1] == 28) {
				direccion = 25;
			}else if(currentMap.layout[x][y-1] == 21 && link.weapon == fists) {
				Item(lance);
			}else {
			direccion = linkA;
			}
		}
		
		if(mueve[1] == 1) 
		{
			if(currentMap.exitLayout[x][y+1] == 22 || currentMap.exitLayout[x][y+1] == 23 || currentMap.exitLayout[x][y+1] == 28) {
				direccion = 27;
			}else if(currentMap.layout[x][y+1] == 21 && link.weapon == fists) {
				Item(lance);	
			}else {
			direccion = linkD;
			}
		}
		}else {
			if(mueve[0] == -1) 
			{
				direccion = linkW;
			}
			if(mueve[0] == 1) 
			{
				direccion = linkS;
			}
			if(mueve[1] == -1) 
			{
				direccion = linkA;
			}
			if(mueve[1] == 1) 
			{
				direccion = linkD;
			}
		}
		if(mueve[0] == 0 && mueve[1] == 0) {
			if (currentMap.layout[x][y] == linkS || currentMap.layout[x][y] == linkSe) {
				direccion = linkSe;
			}
			else if (currentMap.layout[x][y] == linkW || currentMap.layout[x][y] == linkWe) {
				direccion = linkWe;
			}
			else if (currentMap.layout[x][y] == linkA || currentMap.layout[x][y] == linkAe) {
				direccion = linkAe;
			}
			else if (currentMap.layout[x][y] == linkD || currentMap.layout[x][y] == linkDe) {
				direccion = linkDe;
			}
			interact(direccion);
		}

		
		if(!doesChangeMap) 
		{	
			boolean semueve = dale(direccion, x, y, mueve[0], mueve[1]);
			
			if (semueve == true) 
			{
				x += mueve[0];
				y += mueve[1];
			}
		}
		else
		{
			changeLinkToNextMap(direccion);
		}
	}
	
	private static void interact(int direccion) {
		// TODO Auto-generated method stub

		if (direccion == linkWe) {
			boton(x-1,y);
		}
		if (direccion == linkAe) {
			boton(x,y-1);
		}
		if (direccion == linkSe) {
			boton(x+1,y);
		}
		if (direccion == linkDe) {
			boton(x,y+1);
		}
	}

	private static void boton(int x2, int y2) {
		// TODO Auto-generated method stub
		if (currentMap.layout[x2][y2] == 5) {
			for(int i = 0; i<MAP_HEIGHT; i++) {
				for (int j = 0; j<MAP_WIDTH; j++) {
					if (currentMap.exitLayout[i][j] == 12) {
						currentMap.exitLayout[i][j] = 7;
						currentMap.layout[i][j] = 7;
					}
				}
			}
			changeBgImg(currentMap.name);
		}
		else if (currentMap.layout[x2][y2] == 17) 
		{
			if (currentMap.name.equals("El mapa del viejo")) 
			{
				if (flagSword == false) 
				{
					System.out.println("It's dangerous to go alone, take this!");
					Item(sword);
					flagSword = true;
				}
				else 
				{
					System.out.println("Zelda is waiting for you in the Temple of Time, go save her!");
				}
			}
		}
		else if (currentMap.layout[x2][y2] == 18) 
		{
			if (currentMap.name.equals("Santuario Resurrecci�n")) 
			{
			System.out.println("This chest was already opened, it has nothing inside...");
			}
		}
		else if (currentMap.layout[x2][y2] == 8)
		{
			System.out.println("KYAAAA");
			attack(x2,y2);
		}
}

	private static void attack(int x3, int y3) {
		// TODO Auto-generated method stub
		
		int enemigo = currentMap.charLayout[x3][y3];
		
		link.attack(moblin[enemigo]);
		boolean etamuerto = moblin[enemigo].die();
		
		System.out.println(link.weapon.dura);
		if(link.weapon.dura == 0) {
			link.weapon.repair();
			link.giveWeapon(fists);
			changeSprites();
		}
		
		if(etamuerto) {
			currentMap.charLayout[x3][y3] = 0;
			currentMap.layout[x3][y3] = 21;
		}
	}

	private static void changeSprites() {
		// TODO Auto-generated method stub
		
		if(link.weapon == fists) {
			linkS = 1;
			linkW = 4;
			linkD = 3;
			linkA = 2;
			linkWe = 13;
			linkAe = 14;
			linkSe = 15;
			linkDe = 16;
		}else if (link.weapon == sword){
			linkS = 31;
			linkW = 29;
			linkD = 32;
			linkA = 30;
			linkWe = 33;
			linkAe = 34;
			linkSe = 35;
			linkDe = 36;
		}else if (link.weapon == lance){
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

	private static void changeBgImg(String name) {
		// TODO Auto-generated method stub
		if (name.equals("Camara Resurrecci�n")) {
			mapeado[0].BgImg = "mapa0abierto.jpg";
			currentMap.BgImg = mapeado[0].BgImg;
		}
		else if (name.equals("Santuario Resurrecci�n")) {
			mapeado[1].BgImg = "mapa1abierto.jpg";
			currentMap.BgImg = mapeado[1].BgImg;
		}
	}


	private static void Item(Weapon weapon) {
		// TODO Auto-generated method stub
		currentMap.layout[x][y]=19;
		currentMap.layout[x-1][y]=weapon.range;
		t.dibuixa(currentMap.layout);
		
		try 
		{
			Thread.sleep(1500);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentMap.layout[x-1][y]=0;
		link.giveWeapon(weapon);
		changeSprites();
	}

	private static boolean dale(int character, int currentRow, int currentCol, int movx, int movy){
		
		if (!isCollision(currentRow + movx, currentCol + movy)) 
		{
			currentMap.layout[currentRow][currentCol] = 0;
			currentMap.layout[currentRow + movx][currentCol + movy] = character;
			currentMap.charLayout[currentRow][currentCol] = 0;
			currentMap.charLayout[currentRow + movx][currentCol + movy] = 9;
			return true;
		}
		else 
		{
			currentMap.layout[currentRow][currentCol] = character;
			return false;	
		}
			
	}
	
	private static int[] input(){
		int[] ret = new int[2];
		char in = sc.next().charAt(0);
		switch (in) 
		{
		case 'w':
			ret[0] = -1;
			ret[1] = 0;
			break;
			
		case 'a':
			ret[0] = 0;
			ret[1] = -1;
			break;
			
		case 's':
			ret[0] = 1;
			ret[1] = 0;
			break;
			
		case 'd':
			ret[0] = 0;
			ret[1] = 1;
			break;
			
		case 'k':
			ret[0] = 0;
			ret[1] = 0;
				}
		return ret;
	}
	
	private static boolean isCollision(int row, int col)
	{
		boolean ret = false;
		
		for(int i = 0; i < colliders.length; i++)
		{
			if(currentMap.layout[row][col] == colliders[i])
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	private static boolean changeMap(int movX, int movY) //TODO
	{
		boolean doesChangeMap = false;
		
		for(Entry<Integer, String> entry : currentMap.exits.entrySet())
		{			
			if(currentMap.exitLayout[x][y] == entry.getKey())
			{
				doesChangeMap = true;
			}
		}
		
		try
		{
			getExitCasilla(x + movX, y + movY);
			
			return false;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{

		}
				
		if(doesChangeMap)
		{
			currentMap.layout[x][y] = 0;
			
			String next = currentMap.getNextMap(currentMap.exitLayout[x][y]);
			
			System.out.println(next);

			
			currentMap = mapeado[indexOfMap(next)];
		}
		
		return doesChangeMap;
	}
	
	private static int getExitCasilla(int fil, int col) throws ArrayIndexOutOfBoundsException
	{
		return currentMap.exitLayout[fil][col];
	}
	
	private static int indexOfMap(String name)
	{
		for(int i = 0; i < mapeado.length; i++)
		{
			if(mapeado[i].name.equals(name))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private static void changeLinkToNextMap(int direction)
	{
		
		if(x == 0)
		{
			x = MAP_HEIGHT - 1;
		}
		else if(x == MAP_HEIGHT - 1)
		{
			x = 0;
		}
		
		if(y == 0)
		{
			y = MAP_WIDTH - 1;
		}
		else if(y == MAP_WIDTH -1)
		{
			y = 0;
		}
		
		currentMap.layout[x][y] = direction;
		currentMap.charLayout[x][y] = 9;
	}
	
	private static int[][] duplicateMatrix(int[][] matrix)
	{
		int[][] ret = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i<matrix.length; i++) {
			for (int j = 0; j<matrix[0].length; j++) {
				ret[i][j] = matrix[i][j];
			}
		}
		return ret;
	}
}	
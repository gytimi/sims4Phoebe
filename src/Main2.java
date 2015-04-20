import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main2 {

	private static boolean stop = false;			//exitProto parancsra valt, megallitja a beolvasociklust
	public static Map map;
	public static Engine engine;
	
	//korlatozott szamú robotok hozhatoak letre a putRobot paranccsal.
	public static Robot robot1;
	public static Robot robot2;
	public static Robot robot3;
	public static Robot robot4;
	public static int robot_szam = 0;			//ebben a valtozoban van nyilvantartva, hogy mennyi robot van mar letrehozva
	
	//a robotokhoz hasonloan a minirobotok is kolatozottak.
	public static Robot miniRobot1;
	public static Robot miniRobot2;
	public static Robot miniRobot3;
	public static Robot miniRobot4;
	public static int mini_robot_szam = 0;
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		/** Ellenorzes az elso argumentum szerint
		 * Az elso argumentum 0 eseten a Realtime tesztelest hivja meg,
		 * 1 eseten a 2. argumentumban megjelolt filet olvassa es annak parancsai szerint vegzi a tesztelest.
		 * ha egyik sem, a program kilep.
		 */
		if(args[0].equals(new String("0"))){							//Real time teszteset		
			System.out.println("Real-time teszt...");
			
			
			Scanner parancsRead = new Scanner(System.in);				//valtozok inicializalasa
			String parancs_arg;											//parancsok argumentumokkal
			do {														//A ciklus addig olvassa a parancsokat, amig az 'exitProto' parancs be nem erkezik
				System.out.println("Adja meg a parancs kodjat:");
				if(parancsRead.hasNext())
		            parancs_arg = parancsRead.next();						//Console olvasasa
				else { parancs_arg = new String("exitProto");}
				String[] parancs = parancs_arg.split(" ");				//A beolvasott parancs tordelese szokozok szerint.
				vegrehajt(parancs);										//a parancs feldolgozasa
				
				
			}while (!stop);
			
			
		}
		else if(args[0].equals(new String("1"))){						//Filebol olvasasos teszteset
			System.out.println("File teszt...");
			
			BufferedReader br = new BufferedReader(new FileReader(args[1]));	//a masodik argumentum, mint faljnev olvasasa
		    try {
		        
		        String line = br.readLine();
		        while(line!= null){										//ciklus, amig van sor a fajlban.
		        	
		        	String[] parancs = line.split(" ");
		        	vegrehajt(parancs);
		        	line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
			
			
		}
		else
			System.out.println("Hibas argumentumok!");					//Hibas elso argumentumnal kilep a program.
	}

	/**A parancsok feldolgozasaert felelos metodus
	 * A parameterkent kapott parancs szerinte meghivja a megfelelo utasitasokat.
	 * @param parancs
	 */
	private static void vegrehajt(String[] parancs) {
		// TODO Auto-generated method stub
		System.out.println("Parancs jott.");
		
		/* Vegtelen if-else kapocs
		 * A kulonbozo parancsok lekezelese
		 */
		if(parancs[0].equals("loadMap")){
			loadMap();
		}else
		if(parancs[0].equals("putRobot")){
			putRobot(parancs[1],parancs[2]);
		}else
		if(parancs[0].equals("putMiniRobot")){
			putMiniRobot(parancs[1],parancs[2]);
		}else
		if(parancs[0].equals("putOil")){
			putOil(parancs[1],parancs[2]);
		}else
		if(parancs[0].equals("putSlime")){
			
		}else
		if(parancs[0].equals("setDirection")){
			
		}else
		if(parancs[0].equals("turnOver")){
			
		}else
		if(parancs[0].equals("roundOver")){
			
		}else
		if(parancs[0].equals("listAliveMinirobot")){
			
		}else
		if(parancs[0].equals("listAliveRobots")){
			
		}else
		if(parancs[0].equals("listTraps")){
			
		}else
		if(parancs[0].equals("exitGame")){
			
		}else
		if(parancs[0].equals("changeActiveRobot")){
			
		}else
		if(parancs[0].equals("getOilNumber")){
			
		}else
		if(parancs[0].equals("getSlimeNumber")){
			
		}else
		if(parancs[0].equals("listTraps")){
			
		}else
		if(parancs[0].equals("killRobot")){
			
		}else
		if(parancs[0].equals("exitProto")){
			stop=true;
		}else
		System.out.println("Hibas bevitel");
	}
	private static void putOil(String arg1, String arg2) {
		
		
	}

	private static void putMiniRobot(String arg1, String arg2) {
		
		switch (mini_robot_szam){
		case 0: 
			miniRobot1=new MiniRobot(engine);			//a minirobot letrehozasa
			mini_robot_szam++;						//minirobotszam novelese
			miniRobot1.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));		//pozicio beallitasa
			break;
		case 1:
			miniRobot2=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot2.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		case 2:
			miniRobot3=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot3.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		case 3:
			miniRobot4=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot4.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		default: System.out.println("Hibas parancs: ennyi miniRobot nem lehet a palyan!");	//ha tobb robotot szeretnenek a palyan mint megengedett, hibauzenet.
		}
		
	}

	/* A putRobot parancs megvalositasa
	 * Letrehoz egy robotot, es a parametert beallitja pozicionak
	 * 
	 * @param arg1
	 * @param arg2
	 */
	private static void putRobot(String arg1, String arg2) {
		
		//Maximum 4 robotot lehet letrehozni, a putRobot meghivasakor mindig a kovetkezo statikus hely toltodik fel.
		switch (robot_szam){
		case 0: 
			robot1=new Robot(engine);			//a robot letrehozasa
			robot_szam++;						//robotszam novelese
			robot1.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));		//pozicio beallitasa
			
			break;
		case 1:
			robot2=new Robot(engine);
			robot_szam++;
			robot2.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		case 2:
			robot3=new Robot(engine);
			robot_szam++;
			robot3.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		case 3:
			robot4=new Robot(engine);
			robot_szam++;
			robot4.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			break;
		default: System.out.println("Hibas parancs: ennyi robot nem lehet a palyan!");	//ha tobb robotot szeretnenek a palyan mint megengedett, hibauzenet.
		}
		
	}
	/* a loadMap parancs megvalositasa
	 * 
	 * letrehoz egy Mapet, egy Enginet, valamint betolti a map.png filet palyanak.
	 */
	private static void loadMap() {
		map=new Map();
		engine=new Engine();
		map.load("map.png");
	}

	
}

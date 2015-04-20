import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class Main2 {

	private static boolean stop = false;			//exitProto parancsra valt, megallitja a beolvasociklust
	public static Map map;
	public static Engine engine;
	
	//korlatozott szamu robotok hozhatoak letre a putRobot paranccsal.
	public static Robot robot1;
	public static Robot robot2;
	public static Robot robot3;
	public static Robot robot4;
	public static int robot_szam = 0;			//ebben a valtozoban van nyilvantartva, hogy mennyi robot van mar letrehozva
	
	//a robotokhoz hasonloan a minirobotok is kolatozottak.
	public static MiniRobot miniRobot1;
	public static MiniRobot miniRobot2;
	public static MiniRobot miniRobot3;
	public static MiniRobot miniRobot4;
	public static int mini_robot_szam = 0;
	
	//Trappek peldanyai
	public static Trap trap1;
	public static Trap trap2;
	public static Trap trap3;
	public static Trap trap4;
	public static int trap_szam = 0;
	
	public static BufferedWriter writer;
	
	
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
				vegrehajt(parancs,args[0],null);										//a parancs feldolgozasa
					
			}while (!stop);
			
		}
		else if(args[0].equals(new String("1"))){						//Filebol olvasasos teszteset
			System.out.println("File teszt...");
			
			BufferedReader br = new BufferedReader(new FileReader(args[1]));	//a masodik argumentum, mint faljnev olvasasa
			writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("args[2]"), "utf-8"));		//kimeneti file megnyitasa
		    try {
		        
		        String line = br.readLine();
		        while(line!= null){										//ciklus, amig van sor a fajlban.
		        	
		        	String[] parancs = line.split(" ");
		        	vegrehajt(parancs,args[0],writer);
		        	line = br.readLine();
		        }
		    } finally {
		        br.close();
		        try {writer.close();} catch (Exception ex) {}
		    }
		}
		else
			System.out.println("Hibas argumentumok!");					//Hibas elso argumentumnal kilep a program.
	}

	/**A parancsok feldolgozasaert felelos metodus
	 * A parameterkent kapott parancs szerinte meghivja a megfelelo utasitasokat.
	 * @param parancs
	 */
	private static void vegrehajt(String[] parancs, String arg, Writer writer) {
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
			if(parancs[1]!=null)
				putOil(parancs[1],parancs[2]);
			else
				putOil();
		}else
		if(parancs[0].equals("putSlime")){
			if(parancs[1]!=null)
				putSlime(parancs[1],parancs[2]);
			else
				putSlime();
		}else
		if(parancs[0].equals("setDirection")){
			setDirection(parancs[1],parancs[2]);
		}else
		if(parancs[0].equals("roundOver")){
			roundOver();
		}else
		if(parancs[0].equals("listAliveMinirobot")){
			String kimenet;
			kimenet = listAliveMinirobots();
			kiiras(kimenet,arg);
		}else
		if(parancs[0].equals("listAliveRobots")){
			String kimenet;
			kimenet = listAliveRobots();
			kiiras(kimenet,arg);
		}else
		if(parancs[0].equals("listTraps")){
			String kimenet;
			kimenet = listTraps();
			kiiras(kimenet,arg);
		}else
		if(parancs[0].equals("exitGame")){
			exitGame();
		}else
		if(parancs[0].equals("changeengine.activePlayer")){
			changeActiveRobot(parancs[1]);
		}else
		if(parancs[0].equals("getOilNumber")){
			String kimenet;
			kimenet = getOilNumber();
			kiiras(kimenet,arg);
		}else
		if(parancs[0].equals("getSlimeNumber")){
			String kimenet;
			kimenet = getSlimeNumber();
			kiiras(kimenet,arg);
		}else
		if(parancs[0].equals("killRobot")){
			engine.dieRobot(engine.activePlayer);	//az engine kitorli az elok kuzul az aktiv robotot.
		}else
		if(parancs[0].equals("exitProto")){
			stop=true;
		}else
		System.out.println("Hibas bevitel");
	}
	
	/* a listAliveMiniRobots parancs megvalositasa
	 * az engine elo minirobot listajat listajat adja vissza
	 */
	private static String listAliveMinirobots() {
		String ki;
		ki = engine.miniRobots.toString();
		return ki;
	}

	/* a listAliveRobots parancs megvalositasa
	 * az engine elo lobot listajat listajat adja vissza
	 */
	private static String listAliveRobots() {
		String ki;
		ki = engine.alivePlayers.toString();
		return ki;
	}

	/* a listTraps parancs megvalositasa
	 * az engine trap listajat adja vissza
	 */
	private static String listTraps() {
		String ki;
		ki = engine.getTraps().toString();
		return ki;
	}

	/* getSlimeNumber parancs megvalositasa
	 * elkeri az aktiv jatekos ragacsszamat, majd stringkent visszaadja azt.
	 */
	private static String getSlimeNumber() {
		Integer oilNum=engine.activePlayer.getSlime_num();
		return oilNum.toString();
	}

	/* getOilNumber parancs megvalositasa
	 * elkeri az aktiv jatekos olajszamat, majd stringkent visszaadja azt.
	 */
	private static String getOilNumber() {
		Integer oilNum=engine.activePlayer.getOil_num();
		return oilNum.toString();
	}

	/* A kimeneti parancsok eredmenyeinek kiirasa
	 * 
	 */
	private static void kiiras(String kimenet, String arg) {
		if(arg.equals(new String("1"))){		//ha fajlbol es fajlba dolgozunk
			try {
				writer.write(kimenet);			//kiiras
				
				writer.newLine();				//ujsor
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else{
			System.out.println(kimenet);		// konzolos kiiras
		}
		
	}

	/* Az exitGame parancs megvalositasa
	 * minden statikus attributum torlese, hogy uj tesztet lehessen kezdeni tiszta lappal.
	 */
	private static void exitGame() {
		engine=null;
		map=null;
		robot_szam = 0;
		mini_robot_szam = 0;
		trap_szam = 0;
		miniRobot1 = null;
		miniRobot2 = null;
		miniRobot3 = null;
		miniRobot4 = null;
		robot1 = null;
		robot2 = null;
		robot3 = null;
		robot4 = null;
		trap1 = null;
		trap2 = null;
		trap3 = null;
		trap4 = null;
	}

	/* A roundOver parancs megvalositasa
	 * Az engine roundOver metodusanak futtatasa
	 */
	private static void roundOver() {
		engine.roundOver();	
	}

	/* A setDirection parancs megvalositasa
	 * Az eppen aktiv robotnak modositja a parameterkeben kapott ertekekre az iranyat.
	 */
	private static void setDirection(String arg1, String arg2) {
		engine.activePlayer.setModifier(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
	}

	/* A putSlime parancs megvalositasa
	 * az eppen aktiv robot Slimerakasat hivja meg.
	 */
	private static void putSlime() {
		engine.activePlayer.placeOil();	
	}
	
	/* A putOil parancs megvalositasa
	 * az eppen aktiv robot Oilrakasat hivja meg.
	 */
	private static void putOil() {
		engine.activePlayer.placeSlime();
	}
	
	/* A changeActiceRobot parancs megvalositasa
	 * beallitja az activePlayer statikus osztaly attributumot
	 * 
	 */
	private static void changeActiveRobot(String string) {
		switch(Integer.parseInt(string)){			//a parancs attributumat integerre parseolva switch elagazas
		case 1:										//a szamoknak megfelelo robot beallitasa aktivnak
			engine.activePlayer=robot1;						
			break;
		case 2:
			engine.activePlayer=robot2;
			break;
		case 3:
			engine.activePlayer=robot3;
			break;
		case 4:
			engine.activePlayer=robot4;
			break;
		default: System.out.println("Hibas parancs: ennyi Robot nem lehet a palyan!");
		}
	}
	
	/* A putSlime parancs megvalositasa
	 * Mikor a putSlime parancsot koordinatak kovetnek, letrehozasra kerul egy uj csapda, es a parametereket kapja a poziciojanak.
	 * @param arg1
	 * @param arg2
	 */
	private static void putSlime(String arg1, String arg2) {
		switch (trap_szam){
		case 0: 
			trap1=new Slime();			// a Slime letrehozasa
			trap_szam++;						// trapszam novelese
			trap1.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Slime poziciojanak beallitasa
			engine.addTrap(trap1);		//Slime hozzaadasa az engine listajahoz.
			break;
		case 1:
			trap2=new Slime();			// a Slime letrehozasa
			trap_szam++;						// trapszam novelese
			trap2.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Slime poziciojanak beallitasa
			engine.addTrap(trap2);		//Slime hozzaadasa az engine listajahoz.
			break;
		case 2:
			trap3=new Slime();			// a Slime letrehozasa
			trap_szam++;						// trapszam novelese
			trap3.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Slime poziciojanak beallitasa
			engine.addTrap(trap3);		//Slime hozzaadasa az engine listajahoz.
			break;
		case 3:
			trap4=new Slime();			// a Slime letrehozasa
			trap_szam++;						// trapszam novelese
			trap4.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Slime poziciojanak beallitasa
			engine.addTrap(trap4);		//Slime hozzaadasa az engine listajahoz.
			break;
		default: System.out.println("Hibas parancs: ennyi miniRobot nem lehet a palyan!");	//ha tobb robotot szeretnenek a palyan mint megengedett, hibauzenet.
		}	
	}

	/* A putOil parancs megvalositasa
	 * Mikor a putOil parancsot koordinatak kovetnek, letrehozasra kerul egy uj csapda, es a parametereket kapja a poziciojanak.
	 * @param arg1
	 * @param arg2
	 */
	private static void putOil(String arg1, String arg2) {
		switch (trap_szam){
		case 0: 
			trap1=new Oil();			// a Oil letrehozasa
			trap_szam++;						// trapszam novelese
			trap1.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Oil poziciojanak beallitasa
			engine.addTrap(trap1);		//Oil hozzaadasa az engine listajahoz.
			break;
		case 1:
			trap2=new Oil();			// a Oil letrehozasa
			trap_szam++;						// trapszam novelese
			trap2.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Oil poziciojanak beallitasa
			engine.addTrap(trap2);		//Oil hozzaadasa az engine listajahoz.
			break;
		case 2:
			trap3=new Oil();			// a Oil letrehozasa
			trap_szam++;						// trapszam novelese
			trap3.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Oil poziciojanak beallitasa
			engine.addTrap(trap3);		//Oil hozzaadasa az engine listajahoz.
			break;
		case 3:
			trap4=new Oil();			// a Oil letrehozasa
			trap_szam++;						// trapszam novelese
			trap4.setPos(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2))); // Oil poziciojanak beallitasa
			engine.addTrap(trap4);		//Oil hozzaadasa az engine listajahoz.
			break;
		default: System.out.println("Hibas parancs: ennyi miniRobot nem lehet a palyan!");	//ha tobb robotot szeretnenek a palyan mint megengedett, hibauzenet.
		}
	}
	
	/* A putMiniRobot parancs megvalositasa
	 * Letrehoz egy minirobotot, es a parametert beallitja pozicionak
	 * 
	 * @param arg1
	 * @param arg2
	 */
	private static void putMiniRobot(String arg1, String arg2) {
		
		switch (mini_robot_szam){
		case 0: 
			miniRobot1=new MiniRobot(engine);			//a minirobot letrehozasa
			mini_robot_szam++;						//minirobotszam novelese
			miniRobot1.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));		//pozicio beallitasa
			engine.miniRobots.add(miniRobot1);		// Az engine listajahoz hozza kell adni az uj minirobotot
			break;
		case 1:
			miniRobot2=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot2.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.miniRobots.add(miniRobot2);
			break;
		case 2:
			miniRobot3=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot3.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.miniRobots.add(miniRobot3);
			break;
		case 3:
			miniRobot4=new MiniRobot(engine);
			mini_robot_szam++;
			miniRobot4.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.miniRobots.add(miniRobot4);
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
			engine.alivePlayers.add(robot1);	// Az engine listajahoz hozza kell adni az uj robotot
			engine.activePlayer=robot1;					//Az ujjonnan letett robot az aktiv robot
			break;
		case 1:
			robot2=new Robot(engine);
			robot_szam++;
			robot2.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.alivePlayers.add(robot2);
			engine.activePlayer=robot2;
			break;
		case 2:
			robot3=new Robot(engine);
			robot_szam++;
			robot3.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.alivePlayers.add(robot3);
			engine.activePlayer=robot3;
			break;
		case 3:
			robot4=new Robot(engine);
			robot_szam++;
			robot4.setPosition(new Coord(Integer.parseInt(arg1),Integer.parseInt(arg2)));
			engine.alivePlayers.add(robot4);
			engine.activePlayer=robot4;
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

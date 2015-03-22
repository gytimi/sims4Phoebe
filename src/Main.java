import java.security.AllPermission;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	/**Menü kiírása
	 * Kiírja a menüpontokat
	 */
	public static void printMenu(){
		System.out.println("Sims4 team - Phoebe szkeleton");
		System.out.println("\nMenu:");
		System.out.println("1. Játék indítása\n" +
				"2. Trap elhelyezese\n" +
				"3. Lépés átadása\n" +
				"4. Kör átadása\n" +
				"5. Kilépés tesztelése\n" +
				"6. Kilépés a Szkeleton tesztbõl");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printMenu();
		Scanner scanchoice = new Scanner(System.in);
		int chosenMenu;

		do {
			System.out.println("Adja meg a parancs kódját:");
			if(scanchoice.hasNextInt())
	            chosenMenu = scanchoice.nextInt();
			else { chosenMenu = 6;}
		    switch (chosenMenu)
		    {
		    	/** Menü 1: Játék indítása
		    	 * A játékoszszám megadása után a játékhoz szükséges objektumok
		    	 * létrehozása és beállításának tesztelése
		    	 */
		        case 1:
		        	System.out.println("- 1. Játék indítása");
		        	System.out.println("? Hány játékos van? (1-4)");
		        	int num;
		        	Scanner num_in = new Scanner(System.in);
		        	if(num_in.hasNextInt())
			            num = num_in.nextInt();
					else { num = 1;}
		            Startup startup = new Startup();
		            startup.setPlayers_num(num);
		            startup.run();
		            break;
		            
		        /** Menü 2: Trap elhelyezése
		         * A kiválasztott csapda elhelyezésének tesztelése
		         */
		        case 2:
		        	System.out.println("- 2. Trap elhelyezése");
		        	System.out.println("? 2.1  [O]lajat vagy [R]agacsot hagyjon a robot? (O/R)");
		        	Scanner in = new Scanner(System.in);
		        	String be = null;
					do{
			        	be=in.nextLine();		        		
			        	}while(!be.equals("O") && !be.equals("R"));
			        if(be.equals("O")){
			        	System.out.println("Szükséges objektumok létrehozása:");
			        	Engine engine_tmp = new Engine();
			        	Coord pos= new Coord(0,0);
			        	Robot robot_tmp = new Robot(engine_tmp);
			        	
			        	System.out.println("\n Tesztelés:");
			        	robot_tmp.placeOil();
			        	
			        	
			        }else if(be.equals("R")){
			        	System.out.println("Szükséges objektumok létrehozása:");
			        	Engine engine_tmp = new Engine();
			        	Coord pos= new Coord(0,0);
			        	Robot robot_tmp = new Robot(engine_tmp);
			        	
			        	System.out.println("\n Tesztelés:");
			        	robot_tmp.placeSlime();
			        }
		            break;
		            
		        /** Menü 3: Lépés átadásának tesztelése
		         * Egy robot befejezi a lépését
		         */
		        case 3:
		        	System.out.println("- 3. Lépés átadása");
		        	/**Szükséges objektumok létrehozása
		        	 * Engine, Robot és Coord ideiglenes objektumok
		        	 * A robot beállítása aktív játékosnak az enginben.
		        	 */
		        	System.out.println("Teszthez szükséges objektumok létrehozása:");
		        	
		        	Engine engine_tmp_3 = new Engine();
		        	Robot robot_tmp_3 = new Robot(engine_tmp_3);
		        	Coord coord_tmp_3 = new Coord(0,0);
		        	engine_tmp_3.setActivePlayer(robot_tmp_3);
		        	
		        	/**Tesztelés
		        	 * az engine turnPassed() metódusának futtatása
		        	 */
		        	System.out.println("\n Tesztelés:");
		        	engine_tmp_3.turnPassed(coord_tmp_3);
		        	
		            break;
		        /** Menü 4: Kör vége
		         * Vizsgálat, hogy a robot hol áll, majd annak megfelelõen a robot léptetése.
		         */
		        case 4:
		        	System.out.println("- 4. Robot mozgatása");
		        	
		        	/** Szükséges objektumok létrehozása
		        	 * Engine, Map, Robot, Oil és Slime osztályok ideiglenes példányosítása,
		        	 * robot hozzáadása az engine alivePlayers listájához,
		        	 * map beállítása az engine.map-nek
		        	 * Olaj az (1,0), ragacs a (2,0) pozícióba kerül, így a tesztelét 
		        	 * a robot helyének állításával lehet szabályozni
		        	 */
		        	System.out.println("Szükséges objektumok létrehozása:");
		        	Engine engine_tmp_4 = new Engine();
		        	Robot robot_tmp_4 = new Robot(engine_tmp_4);
		        	Oil oil_tmp_4 = new Oil();
		        	oil_tmp_4.setPos(new Coord(1,0));
		        	Slime slime_tmp_4 = new Slime();
		        	slime_tmp_4.setPos(new Coord(2,0));
		        	engine_tmp_4.addTrap(oil_tmp_4);
		        	engine_tmp_4.addTrap(slime_tmp_4);
		        	engine_tmp_4.addAlivePlayer(robot_tmp_4);
		        	Map map_tmp_4=new Map();
		        	engine_tmp_4.setMap(map_tmp_4);
		        	
		        	/**A tesztelés esetei
		        	 * A robotok helyének megadásával tesztelhetõek, hogy milyen mezõrõl lépnek el azok.
		        	 */
		        	
		        	System.out.println("\n Tesztelés:");
		        	
		        	System.out.println("? 4.1 A robot [O]lajon, [R]agacson vagy [U]res mezõn áll? (O/R/U)");
		        	Scanner in_4 = new Scanner(System.in);
		        	String be_4 = null;
					do{
			        	be_4=in_4.nextLine();		        		
			        	}while(!be_4.equals("O") && !be_4.equals("R") && !be_4.equals("U"));
			        if(be_4.equals("O")){
			        	robot_tmp_4.setPosition(new Coord(1,0));
			        	engine_tmp_4.roundOver();
			        }else if(be_4.equals("R")){
			        	robot_tmp_4.setPosition(new Coord(2,0));
			        	engine_tmp_4.roundOver();
			        }else if(be_4.equals("U")){
			        	robot_tmp_4.setPosition(new Coord(3,0));
			        	engine_tmp_4.roundOver();
			        }
		        	break;
		        	
		       	/** Menu 5: Kilépés
		       	 * A háromféle kilépési feltétel tesztelése
		         */      	
		        case 5: 
		        	System.out.println("- 5. Kilépés");
		        	/** Szükséges objektumok létrehozása
		        	 * 
		        	 */	        	
		        	System.out.println("Szükséges objektumok létrehozása:");
		        	
		        	Engine engine= new Engine();
		        	
		        	Random rudi=new Random();
		        	
		        	Robot a=new Robot(engine);
		        	a.setRoad(rudi.nextDouble()*100);
		        	Robot b=new Robot(engine);
		        	b.setRoad(rudi.nextDouble()*100);
		        	Robot c=new Robot(engine);
		        	c.setRoad(rudi.nextDouble()*100);
		        	Robot d=new Robot(engine);
		        	d.setRoad(rudi.nextDouble()*100);
		        	
		        	//todo
		        	System.out.println("\n Tesztelés:");		        	
		        	System.out.println("? 5.1  Mindenki [L]eesett, [E]lfogytak a körök, vagy [K]ilépés a programból? (L/E/K)");
		        	Scanner in_5 = new Scanner(System.in);
		        	String be_5 = null;
					do{
			        	be_5=in_5.nextLine();		        		
			        	}while(!be_5.equals("L") && !be_5.equals("E") && !be_5.equals("K"));
		        	if(be_5.equals("L")){
		        		engine.allPlayersDead();
		        	}else if(be_5.equals("E")){
		        		engine.whoWins();
		        		engine.quit();
		        	}else if(be_5.equals("K")){
		        		engine.quit();
		        	}
		            break;
		            
		        /** Menü 6: Kilépés a szkeletonból
		        * Bezárul a program.
		        */
		        case 6: 
		        	System.out.println("Sikeres kilépés.");
		            break;
		        default:
		            System.out.println("Érvénytelen bevitel.");
		    }   
		} while (chosenMenu != 6);
	}

}

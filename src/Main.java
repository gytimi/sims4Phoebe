import java.security.AllPermission;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	/**Menu kiirasa
	 * Kiirja a menupontokat
	 */
	public static void printMenu(){
		System.out.println("Sims4 team - Phoebe szkeleton");
		System.out.println("\nMenu:");
		System.out.println("1. Jatek inditasa\n" +
				"2. Trap elhelyezese\n" +
				"3. Lepes atadasa\n" +
				"4. Kor atadasa\n" +
				"5. Kilepes tesztelese\n" +
				"6. Kilepes a Szkeleton tesztbol");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printMenu();
		Scanner scanchoice = new Scanner(System.in);
		int chosenMenu;

		do {
			System.out.println("Adja meg a parancs kodjat:");
			if(scanchoice.hasNextInt())
	            chosenMenu = scanchoice.nextInt();
			else { chosenMenu = 6;}
		    switch (chosenMenu)
		    {
		    	/** Menu 1: Jatek inditasa
		    	 * A jatekoszszam megadasa utan a jatekhoz szukseges objektumok
		    	 * letrehozasa es beallitasanak tesztelese
		    	 */
		        case 1:
		        	System.out.println("- 1. Jatek inditasa");
		        	System.out.println("? Hany jatekos van? (1-4)");
		        	int num;
		        	Scanner num_in = new Scanner(System.in);
		        	if(num_in.hasNextInt())
			            num = num_in.nextInt();
					else { num = 1;}
		            Startup startup = new Startup();
		            startup.setPlayers_num(num);
		            startup.run();
		            break;
		            
		        /** Menu 2: Trap elhelyezese
		         * A kivalasztott csapda elhelyezesenek tesztelese
		         */
		        case 2:
		        	System.out.println("- 2. Trap elhelyezese");
		        	System.out.println("? 2.1  [O]lajat vagy [R]agacsot hagyjon a robot? (O/R)");
		        	Scanner in = new Scanner(System.in);
		        	String be = null;
					do{
			        	be=in.nextLine();		        		
			        	}while(!be.equals("O") && !be.equals("R"));
			        if(be.equals("O")){
			        	System.out.println("Szukseges objektumok letrehozasa:");
			        	Engine engine_tmp = new Engine();
			        	Coord pos= new Coord(0,0);
			        	Robot robot_tmp = new Robot(engine_tmp);
			        	
			        	System.out.println("\n Teszteles:");
			        	robot_tmp.placeOil();
			        	
			        	
			        }else if(be.equals("R")){
			        	System.out.println("Szukseges objektumok letrehozasa:");
			        	Engine engine_tmp = new Engine();
			        	Coord pos= new Coord(0,0);
			        	Robot robot_tmp = new Robot(engine_tmp);
			        	
			        	System.out.println("\n Teszteles:");
			        	robot_tmp.placeSlime();
			        }
		            break;
		            
		        /** Menu 3: Lepes atadasanak tesztelese
		         * Egy robot befejezi a lepeset
		         */
		        case 3:
		        	System.out.println("- 3. Lepes atadasa");
		        	/**Szukseges objektumok letrehozasa
		        	 * Engine, Robot es Coord ideiglenes objektumok
		        	 * A robot beallitasa aktiv jatekosnak az enginben.
		        	 */
		        	System.out.println("Teszthez szukseges objektumok letrehozasa:");
		        	
		        	Engine engine_tmp_3 = new Engine();
		        	Robot robot_tmp_3 = new Robot(engine_tmp_3);
		        	Coord coord_tmp_3 = new Coord(0,0);
		        	engine_tmp_3.setActivePlayer(robot_tmp_3);
		        	
		        	/**Teszteles
		        	 * az engine turnPassed() metodusanak futtatasa
		        	 */
		        	System.out.println("\n Teszteles:");
		        	engine_tmp_3.turnPassed(coord_tmp_3);
		        	
		            break;
		        /** Menu 4: Kor vege
		         * Vizsgalat, hogy a robot hol all, majd annak megfeleloen a robot leptetese.
		         */
		        case 4:
		        	System.out.println("- 4. Robot mozgatasa");
		        	
		        	/** Szukseges objektumok letrehozasa
		        	 * Engine, Map, Robot, Oil es Slime osztalyok ideiglenes peldanyositasa,
		        	 * robot hozzaadasa az engine alivePlayers listajahoz,
		        	 * map beallitasa az engine.map-nek
		        	 * Olaj az (1,0), ragacs a (2,0) pozicioba kerul, igy a tesztelet 
		        	 * a robot helyenek allitasaval lehet szabalyozni
		        	 */
		        	System.out.println("Szukseges objektumok letrehozasa:");
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
		        	
		        	/**A teszteles esetei
		        	 * A robotok helyenek megadasaval tesztelhetoek, hogy milyen mezorol lepnek el azok.
		        	 */
		        	
		        	System.out.println("\n Teszteles:");
		        	
		        	System.out.println("? 4.1 A robot [O]lajon, [R]agacson vagy [U]res mezon all? (O/R/U)");
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
		        	
		       	/** Menu 5: Kilepes
		       	 * A haromfele kilepesi feltetel tesztelese
		         */      	
		        case 5: 
		        	System.out.println("- 5. Kilepes");
		        	/** Szukseges objektumok letrehozasa
		        	 * 
		        	 */	        	
		        	System.out.println("Szukseges objektumok letrehozasa:");
		        	
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
		        	System.out.println("\n Teszteles:");		        	
		        	System.out.println("? 5.1  Mindenki [L]eesett, [E]lfogytak a korok, vagy [K]ilepes a programbol? (L/E/K)");
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
		            
		        /** Menu 6: Kilepes a szkeletonbol
		        * Bezarul a program.
		        */
		        case 6: 
		        	System.out.println("Sikeres kilepes.");
		            break;
		        default:
		            System.out.println("ervenytelen bevitel.");
		    }   
		} while (chosenMenu != 6);
	}

}

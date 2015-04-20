import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main2 {

	private static boolean stop = false;			//exitProto parancsra vált, megállítja a beolvasóciklust
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		/** Ellenorzes az elso argumentum szerint
		 * Az elso argumentum 0 eseten a Realtime tesztelést hivja meg,
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
				String[] parancs = parancs_arg.split(" ");				//A beolvasott parancs tördelése szóközök szerint.
				vegrehajt(parancs);										//a parancs feldolgozasa
				
				
			}while (!stop);
			
			
		}
		else if(args[0].equals(new String("1"))){						//Filebol olvasasos teszteset
			System.out.println("File teszt...");
			
			BufferedReader br = new BufferedReader(new FileReader(args[1]));	//a második argumentum, mint fáljnév olvasása
		    try {
		        
		        String line = br.readLine();
		        while(line!= null){										//ciklus, amíg van sor a fájlban.
		        	
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
	 */
	private static void vegrehajt(String[] parancs) {
		// TODO Auto-generated method stub
		System.out.println("Parancs jott.");
		
		/* Végtelen if-else kapocs
		 * A különbözõ parancsok lekezelése
		 */
		if(parancs[0].equals("loadMap")){
			
		}else
		if(parancs[0].equals("putRobots")){
			
		}else
		if(parancs[0].equals("putMiniRobots")){
			
		}else
		if(parancs[0].equals("putOil")){
			
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

	
}

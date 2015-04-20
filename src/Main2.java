import java.util.Scanner;


public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args[0].equals(new String("0"))){
			System.out.println("Real-time teszt...");
			
			
			Scanner parancsRead = new Scanner(System.in);
			String parancs;
			do {
				System.out.println("Adja meg a parancs kodjat:");
				if(parancsRead.hasNext())
		            parancs = parancsRead.next();
				else { parancs = new String("exitProto");}
				
				vegrehajt(parancs);
				
				
			}while (!parancs.equals("exitProto"));
			
			
		}
		else if(args[0].equals(new String("1"))){
			System.out.println("File teszt...");
			
		}
		else
			System.out.println("Hibas argumentumok!");
	}

	private static void vegrehajt(String parancs) {
		// TODO Auto-generated method stub
		System.out.println("Parancs jott.");
		System.out.println(parancs);
	}

}

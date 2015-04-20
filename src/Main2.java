
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args[0].equals(new String("0"))){
			System.out.println("Real-time teszt...");
			
		}
		else if(args[0].equals(new String("1"))){
			System.out.println("File teszt...");
			
		}
		else
			System.out.println("Hibás argumentumok!");
	}

}

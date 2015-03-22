public class Coord {

	private int X;
	private int Y;

	public Coord(){									//KÉSZ
		System.out.println("->[:Coord].Coord()");
	}
	
	
	
	public Coord(int x, int y){							//KÉSZ
		
		System.out.println("->[:Coord].Coord(x,y)");
		
		X=x; Y=y;
	}
	
	public int getX() {								//KÉSZ
		System.out.println("->[:Coord].getX");
		
		return X;
	}

	/**
	 * 
	 * @param a
	 */
	public void setX(int a) {						//KÉSZ
		System.out.println("->[:Coord].setX(a)");
		
		X=a;
	}

	public int getY() {								//KÉSZ
		System.out.println("->[:Coord].getY()");
		
		return Y;
	}

	/**
	 * 
	 * @param b
	 */
	public void setY(int b) {						//KÉSZ
		System.out.println("->[:Coord].setY(b)");
		
		Y=b;
	}

	/**\brief Két vektor összeadása
	 * 
	 * Összeadja a két megkapott vektort
	 * és visszatér az új Coord példánnyal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static Coord add(Coord pos1, Coord pos2) {		//KÉSZ
		System.out.println("->[:Coord].add(pos1, pos2)");
		
		Coord tmp=new Coord(pos1.getX()+pos2.getX(), pos1.getY()+pos2.getY());
		
		return tmp;
	}

}
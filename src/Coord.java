public class Coord {

	private int X;
	private int Y;
	
	public Coord(){									//KeSZ
		System.out.println("teszt");
	}
	
	
	
	public Coord(int x, int y){							//KeSZ
		
		System.out.println("->[:Coord].Coord(x,y)");
		
		X=x; Y=y;
	}
	
	public int getX() {								//KeSZ
		System.out.println("->[:Coord].getX");
		
		return X;
	}

	/**
	 * 
	 * @param a
	 */
	public void setX(int a) {						//KeSZ
		System.out.println("->[:Coord].setX(a)");
		
		X=a;
	}

	public int getY() {								//KeSZ
		System.out.println("->[:Coord].getY()");
		
		return Y;
	}

	/**
	 * 
	 * @param b
	 */
	public void setY(int b) {						//KeSZ
		System.out.println("->[:Coord].setY(b)");
		
		Y=b;
	}

	/**\brief Ket vektor osszeadasa
	 * 
	 * osszeadja a ket megkapott vektort
	 * es visszater az uj Coord peldannyal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static Coord add(Coord pos1, Coord pos2) {		//KeSZ
		System.out.println("->[:Coord].add(pos1, pos2)");
		
		Coord tmp=new Coord(pos1.getX()+pos2.getX(), pos1.getY()+pos2.getY());
		
		return tmp;
	}

}
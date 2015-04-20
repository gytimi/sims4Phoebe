public class Coord {

	private int X; // vizszintes tengelyen
	private int Y; // fuggoleges tengelyen
	
	public Coord(){									//KeSZ
		System.out.println("teszt");
	}
	
	public Coord(int x, int y){							//KeSZ
		
		System.out.println("branch");
		
		X=x; Y=y;
	}
	
	/**\brief Getter fgv
	 * 
	 * Visszaadja az Y koordinatat.
	 */
	public int getX() {								//KeSZ
		System.out.println("->[:Coord].getX");
		
		return X;
	}

	/**\brief Setter fgv
	 * 
	 * Beallitja a parameterkent kapott
	 * X koordinatat.
	 * 
	 * @param b
	 */
	public void setX(int a) {						//KeSZ
		System.out.println("->[:Coord].setX(a)");
		
		X=a;
	}
	
	/**\brief Getter fgv
	 * 
	 * Visszaadja az Y koordinatat.
	 */
	public int getY() {								//KeSZ
		System.out.println("->[:Coord].getY()");
		
		return Y;
	}

	/**\brief Setter fgv
	 * 
	 * Beallitja a parameterkent kapott
	 * Y koordinatat.
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
	
	/**\brief Ket vektor tavolsaga
	 * 
	 * kiszamitja a ket megkapott vektor tavolsagat
	 * es visszater azzal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static double distance(Coord pos1, Coord pos2){		//Kesz
		return Math.sqrt((pos2.getX()-pos1.getX())*(pos2.getX()-pos1.getX()) 
			+ (pos2.getY()-pos1.getY())*(pos2.getY()-pos1.getY()));
	}

}

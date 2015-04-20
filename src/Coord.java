public class Coord {

	private int X;
	private int Y;

	public Coord(){									//K�SZ
		//System.out.println("->[:Coord].Coord()");
	}
	
	
	
	public Coord(int x, int y){							//K�SZ
		
		//System.out.println("->[:Coord].Coord(x,y)");
		
		X=x; Y=y;
	}
	
	public int getX() {								//K�SZ
		//System.out.println("->[:Coord].getX");
		
		return X;
	}

	/**
	 * 
	 * @param a
	 */
	public void setX(int a) {						//K�SZ
		//System.out.println("->[:Coord].setX(a)");
		
		X=a;
	}

	public int getY() {								//K�SZ
		//System.out.println("->[:Coord].getY()");
		
		return Y;
	}

	/**
	 * 
	 * @param b
	 */
	public void setY(int b) {						//K�SZ
		//System.out.println("->[:Coord].setY(b)");
		
		Y=b;
	}

	/**\brief K�t vektor �sszead�sa
	 * 
	 * �sszeadja a k�t megkapott vektort
	 * �s visszat�r az �j Coord p�ld�nnyal.
	 * 
	 * @param pos1
	 * @param pos2
	 */
	public static Coord add(Coord pos1, Coord pos2) {		//K�SZ
		//System.out.println("->[:Coord].add(pos1, pos2)");
		
		Coord tmp=new Coord(pos1.getX()+pos2.getX(), pos1.getY()+pos2.getY());
		
		return tmp;
	}
	
	public static double distance(Coord pos1, Coord pos2){
		double x=pos2.getX()-pos1.getX();
		double y=pos2.getY()-pos1.getY();
		double temp=Math.sqrt(x*x+y*y);
		return temp;
	}

}
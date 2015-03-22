public class Oil extends Trap {
	
	public Oil(){								//KÉSZ
		System.out.println("->[:Oil].Oil()");
	}	

	/**\brief Kinullázza a robot modifierét.
	 * 
	 * A kapott robot modifierét nullára állítja.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KÉSZ
		System.out.println("->[:Oil].springOil(r)");
		
		r.setModifier(new Coord(0,0));
	}

}
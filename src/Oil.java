public class Oil extends Trap {
	
	public Oil(){								//KeSZ
		System.out.println("->[:Oil].Oil()");
	}	

	/**\brief Kinullazza a robot modifieret.
	 * 
	 * A kapott robot modifieret nullara allítja.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KeSZ
		System.out.println("->[:Oil].springOil(r)");
		
		r.setModifier(new Coord(0,0));
	}

}
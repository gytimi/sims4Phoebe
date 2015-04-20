public class Oil extends Trap {
	
	public Oil(){								//KeSZ
		System.out.println("->[:Oil].Oil()");
	}	

	/**\brief Kinullazza a robot modifieret.
	 * 
	 * A kapott robot modifieret nullara all�tja.
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KeSZ
		System.out.println("->[:Oil].springOil(r)");
		
		r.setModifier(new Coord(0,0));
	}
	
	public void timePassed(){
		
	}

}
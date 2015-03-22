public class Robot {

	private Coord position;
	private Coord impulse;
	private Coord modifier;
	private int oil_num;
	private int slime_num;
	private double road;
	private Boolean alive;

	private Engine engine;
	
	/**\brief Robot konstruktor
	 * 
	 * Inicializálja a tárolt adatokat és 
	 * eltárolja a paraméterként kapott engine-t.
	 * 
	 * @param engine
	 */
	
	
	public Robot(Engine engine){
		
		System.out.println("->[:Robot].Robot(engine)");
		
		position=new Coord();
		modifier=new Coord();
		impulse=new Coord();
		
		oil_num=0;
		oil_num=0;
		road=0;
		alive=true;
		
		this.engine=engine;
	}
	
	/** \brief Kiszámolja a robot új helyét és vektorait
	 * 
	 * Az impulzus és a modifier vektorok összege
	 * lesz az új impulse vektor, az új hely pedig
	 * a hely és az új impulse összege.
	 * 
	 */
	
	public void calculateCoords() {					//KÉSZ
		
		System.out.println("->[:Robot].calculateCoords()");
		
		impulse=Coord.add(impulse, modifier);
		position=Coord.add(position, impulse);
		modifier.setX(0);
		modifier.setY(0);
		
		System.out.println("<-[:Robot].CalculateCoords()");
	}

	public boolean isAlive() {							//KÉSZ
		
		System.out.println("->[:Robot].isAlive()");
		
		return alive;
	}

	/**\brief Lerak egy olajat
	 * 
	 * Ha van még renkelkezésre álló olaj,
	 * akkor létrehoz egyet a jelenlegi
	 * helyén és berakja az engine-be.
	 */
	public void placeOil() {		//KÉSZ
		
		System.out.println("->[:Robot].placeOil()");
		
		if(oil_num>0){
			oil_num--;
			
			Oil tmp=new Oil();		
			tmp.setPos(position);
			tmp.setOwner(this);
			
			engine.addTrap(tmp);
		}
	}

	/**\brief Lerak egy ragacsot
	 * 
	 * Ha van még renkelkezésre álló ragacs,
	 * akkor létrehoz egyet a jelenlegi
	 * helyén és berakja az engine-be.
	 */
	public void placeSlime() {			//KÉSZ
		
		System.out.println("->[:Robot].placeSlime()");
		
		if(slime_num>0){
			slime_num--;
			
			Slime tmp=new Slime();		
			tmp.setPos(position);
			tmp.setOwner(this);
			
			engine.addTrap(tmp);
		}
	}

	public Coord getPosition() {				//KÉSZ
		System.out.println("Robot.getPosition()");
		
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Coord position) {			//KÉSZ
		System.out.println("->[:Robot].setPosition(position)");
		
		this.position = position;
	}

	public Coord getImpulse() {							//KÉSZ
		System.out.println("->[:Robot].getImpluse()");
		
		return this.impulse;
	}

	/**
	 * 
	 * @param impulse
	 */
	public void setImpulse(Coord impulse) {				//KÉSZ
		System.out.println("->[:Robot].setImpluse(impulse)");
		
		this.impulse = impulse;
	}

	public Coord getModifier() {						//KÉSZ
		System.out.println("->[:Robot].getModifier()");
		
		return this.modifier;
	}

	/**
	 * 
	 * @param modifier
	 */
	public void setModifier(Coord modifier) {			//KÉSZ
		System.out.println("->[:Robot].setModifier(modifier)");
		
		this.modifier = modifier;
	}

	public int getOil_num() {							//KÉSZ
		System.out.println("->[:Robot].getOil_num()");
		
		return this.oil_num;
	}

	/**
	 * 
	 * @param oil_num
	 */
	public void setOil_num(int oil_num) {				//KÉSZ
		System.out.println("->[:Robot].setOil_num(oil_num)");
		
		this.oil_num = oil_num;
	}

	public int getSlime_num() {							//KÉSZ
		System.out.println("->[:Robot].getSlime_num()");
		
		return this.slime_num;
	}

	/**
	 * 
	 * @param slime_num
	 */
	public void setSlime_num(int slime_num) {			//KÉSZ
		System.out.println("->[:Robot].setSlime_num(slime_num)");
		
		this.slime_num = slime_num;
	}

	public double getRoad() {							//KÉSZ
		System.out.println("->[:Robot].getRoad()");
				
		return this.road;
	}

	/**
	 * 
	 * @param road
	 */
	public void setRoad(double road) {					//KÉSZ
		System.out.println("->[:Robot].setRoad(road)");
		
		this.road = road;
	}

	public Boolean getAlive() {							//KÉSZ
		System.out.println("->[:Robot].getAlive()");
		
		return this.alive;
	}

	/**
	 * 
	 * @param alive
	 */
	public void setAlive(Boolean alive) {				//KÉSZ
		System.out.println("->[:Robot].setAlive(alive)");
		
		this.alive = alive;
	}

}
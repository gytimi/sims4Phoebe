public class Trap {

	private Coord pos;
	private int r;
	private Robot owner;
	private int untilCleaned;
	private int untilExpiration;
	private int expired;

	/**
	 * 
	 * @param r
	 */
	public void spring(Robot r) {				//KeSZ
		System.out.println("->[:Trap].springTrap(r)");
	}

	/**\brief utkozik-e a robot a csapdaval
	 * 
	 * Megnezi, hogy a kapott koordinata
	 * beleesik-e a csapda koruli r sugaru
	 * korbe es ennek megfeleloen
	 * visszater egy bool-lal.
	 * 
	 * @param c
	 */
	public Boolean collide(Coord c) {			//KeSZ
		System.out.println("->[:Trap].collide(c)");
		
		if((c.getX()-pos.getX())*(c.getX()-pos.getX())+(c.getY()-pos.getY())*(c.getY()-pos.getY())<=r*r){		//(x-x0)^2+(y-y0)^2<=R^2
			return true;
		}
		
		return false;
	}
	
	public void steppedOnByMiniRobot(MiniRobot x){
		
	}
	
	public void timePassed(){
		
	}

	public Coord getPos() {						//KeSZ
		System.out.println("->[:Trap].getPos()");	
		
		return this.pos;
	}

	/**
	 * 
	 * @param pos
	 */
	public void setPos(Coord pos) {				//KeSZ
		System.out.println("->[:Trap].setPos(pos)");
		
		this.pos = pos;
	}

	public int getR() {							//KeSZ
		System.out.println("->[:Trap].getR()");
		
		return this.r;
	}

	/**
	 * 
	 * @param r
	 */
	public void setR(int r) {					//KeSZ
		System.out.println("->[:Trap].setR(r)");
		
		this.r = r;
	}

	public Robot getOwner() {					//KeSZ
		System.out.println("->[:Trap].getOwner()");
		
		return this.owner;
	}

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Robot owner) {				//KeSZ
		System.out.println("->[:Trap].setOwner(owner)");
		
		this.owner = owner;
	}

	public int getUntilCleaned() {
		return untilCleaned;
	}

	public void setUntilCleaned(int i) {
		this.untilCleaned = i;
	}

	public int getUntilExpiration() {
		return untilExpiration;
	}

	public void setUntilExpiration(int i) {
		this.untilExpiration = i;
	}

	public int getExpired() {
		return expired;
	}

	public void setExpired(int i) {
		this.expired = i;
	}

}
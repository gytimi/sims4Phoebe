
public abstract class Trap {

	private Coord pos;
	private int r;
	private Robot owner;
	private int untilCleaned;
	private int untilExpiration;
	private Boolean expired;

	public abstract void spring(Robot r) ;
	

	public abstract void timePassed() ;
	

	public Boolean collide(Coord c) {			
		if( ( c.getX()-pos.getX()) * (c.getX()-pos.getX() ) +
				( c.getY()-pos.getY()) * (c.getY()-pos.getY() ) <= r*r ){	//(x-x0)^2+(y-y0)^2<=R^2   
			return true;
		}
		return false;
	}
	

	public void steppedOnByMiniRobot(MiniRobot x)
	{
		x.setOnTrap(true);
		this.beingCleaned();
	}
	
	
	private void beingCleaned()
	{
		if (untilCleaned == 0)
			this.expired = true;
		else
			untilCleaned--;
	}

	
	public Coord getPos() {								
		return this.pos;
	}


	public void setPos(Coord pos) {				
		this.pos = pos;
	}

	public int getR() {	
		return this.r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Robot getOwner() {
		return this.owner;
	}


	public void setOwner(Robot owner) {
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

	public boolean getExpired() {
		return expired;
	}

	public void setExpired(boolean b) {
		this.expired = i;
	}

}

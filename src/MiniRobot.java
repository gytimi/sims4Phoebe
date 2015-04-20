
public class MiniRobot extends Robot {

	public MiniRobot(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
	}

	private boolean onTrap;

	public void move(){
		
	}
	
	
	public void steppedOnByRobot(Robot r){
			
	}
	
	public void steppedOnByMinirobot(){
		
	}
	
	public Coord getClosestTrap(Coord position){
		return null;
	}
	
	
	public void setOnTrap(boolean onTrap) {
		this.onTrap = onTrap;
	}
	
	public boolean isOnTrap() {
		return onTrap;
	}

	
}

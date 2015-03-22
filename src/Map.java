import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Map {

	private BufferedImage field;

	/**\brief Betolti a kapott palyat
	 * 
	 * A kapott string alapjan megnyitja
	 * es eltarolja a kepet.
	 * 
	 * @param s
	 */
	public void load(String s) {						//KeSZ sort of (nemtudom jo-e lol)
		System.out.println("->[:Map].load()");
	
		try {
			field=ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No file with that name exists");
		}
	}

	/**\brief Megnezi leesett-e a robot
	 * 
	 * Megnezi a robot jelenlegi helyet,
	 * es ha az a palyan a szakadek szine,
	 * akkor visszater true-val, jelezve,
	 * hogy a robot a melybe zuhant.
	 *
	 * @param c
	 */
	public Boolean fall(Coord c) {						//THIS IS SO BAD BUT I MIGHT WORK FOR TESTS
		System.out.println("->[:Map].fall(c)");
		////////////////////////////////////
		/*if(field.getRGB(c.getX(), c.getY()) == Color.BLACK.getRGB()){
			return true;
		}else
			return false;*/
		////////////////////////////////////
		
		
		System.out.println("? 4.2 Leesett a robot? (I/N)");		//Teszthez ez kell!
		Scanner in = new Scanner(System.in);
		String be = null;
		do{
        	be=in.nextLine();		        		
        	}while(!be.equals("I") && !be.equals("N"));
		if(be.equals("I"))
			return true;
		return false;
	}

	/**\brief Megadja a jatekosok kezdohelyeit
	 * 
	 * Leteszi a megfelelo szamu jatekost,
	 *  es visszaadja a koordinataikat 
	 *  tartalmazo listat.
	 * 
	 * @param numberOfPlayers
	 */
	public ArrayList<Coord> putPlayers(int numberOfPlayers) {			//TO BE FILLED LATER
		System.out.println("->[:Map].putPlayers(numberOfPlayers)");
		ArrayList<Coord> tmp=new ArrayList<Coord>();
		for(int i=0;i<numberOfPlayers;i++){						//igy mar nem dob hibat az engine, nem ures listabol keri majd a jatekosok helyeit
			tmp.add(new Coord(0,0));
		}
		return tmp;
	}

	public BufferedImage getField() {					//KeSZ
		System.out.println("->[:Map].getField()");
		
		return field;
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(BufferedImage field) {			//KeSZ
		System.out.println("->[:Map].setField()");
		
		this.field=field;
	}

}
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

	/**\brief Betölti a kapott pályát
	 * 
	 * A kapott string alapján megnyitja
	 * és eltárolja a képet.
	 * 
	 * @param s
	 */
	public void load(String s) {						//KÉSZ sort of (nemtudom jó-e lol)
		System.out.println("->[:Map].load()");
	
		try {
			field=ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No file with that name exists");
		}
	}

	/**\brief Megnézi leesett-e a robot
	 * 
	 * Megnézi a robot jelenlegi helyét,
	 * és ha az a pályán a szakadék színe,
	 * akkor visszatér true-val, jelezve,
	 * hogy a robot a mélybe zuhant.
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

	/**\brief Megadja a játékosok kezdõhelyeit
	 * 
	 * Leteszi a megfelelõ számú játékost,
	 *  és visszaadja a koordinátáikat 
	 *  tartalmazó listát.
	 * 
	 * @param numberOfPlayers
	 */
	public ArrayList<Coord> putPlayers(int numberOfPlayers) {			//TO BE FILLED LATER
		System.out.println("->[:Map].putPlayers(numberOfPlayers)");
		ArrayList<Coord> tmp=new ArrayList<Coord>();
		for(int i=0;i<numberOfPlayers;i++){						//így már nem dob hibát az engine, nem üres listából kéri majd a játékosok helyeit
			tmp.add(new Coord(0,0));
		}
		return tmp;
	}

	public BufferedImage getField() {					//KÉSZ
		System.out.println("->[:Map].getField()");
		
		return field;
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(BufferedImage field) {			//KÉSZ
		System.out.println("->[:Map].setField()");
		
		this.field=field;
	}

}
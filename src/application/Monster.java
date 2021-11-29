package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster extends ObjetGraphique {

	
	public Monster(Zone zone)   {
		Image img = null;
		try {
			img = new Image(new FileInputStream("Images/Monstre.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		corps=new ImageView(img);
		
		
		double x= zone.getX1()+(zone.getX2()-zone.getX1())*Math.random();
		double y= zone.getY1()+(zone.getY2()-zone.getY1())*Math.random();
		
		corps.setTranslateX(x);
		corps.setTranslateY(y);
		
	}
}

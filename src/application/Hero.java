package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends ObjetGraphique{
	
	public Hero(Zone zone)   {
		Image img = null;
		try {
			img = new Image(new FileInputStream("Images/hero.png"));
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
	public void MoveRight() {
		corps.setTranslateX(corps.getTranslateX()-10);
	}
	public void MoveLeft() {
		corps.setTranslateX(corps.getTranslateX()+10);

	}
	public void MoveDown() {
		corps.setTranslateY(corps.getTranslateY()-10);

		
	}
	public void MoveUp() {
		corps.setTranslateY(corps.getTranslateY()+10);

		
	}
}

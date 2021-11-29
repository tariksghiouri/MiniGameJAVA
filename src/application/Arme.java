package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arme extends ObjetGraphique {

	public Arme(ObjetGraphique hero)   {
		Image img = null;
		try {
			img = new Image(new FileInputStream("Images/arme.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		corps=new ImageView(img);
		
		corps.setTranslateX(hero.getCorps().getTranslateX());
		corps.setTranslateY(hero.getCorps().getTranslateY());
		
	}
	public double getRotate() {
		return corps.getRotate()-90;
	}
	public void rotateLeft() {
		corps.setRotate(getRotate()+95);
	}
	public void rotateRight() {
		corps.setRotate(getRotate()+85);

		
	}
	public void updateState(Hero hero) {
		corps.setTranslateX(hero.getCorps().getTranslateX());
		corps.setTranslateY(hero.getCorps().getTranslateY());
	}
	
}

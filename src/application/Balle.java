package application;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Balle  extends ObjetGraphique{
	private	Point2D direction= new Point2D(0, 0);

	public Balle(Arme arme) {
		corps=new Circle(0,0,5,Color.RED);
		corps.setTranslateX(arme.corps.getTranslateX()+8);
		corps.setTranslateY(arme.corps.getTranslateY()-12);
		updateDirecion(arme.getRotate());

	}
	
	private void updateDirecion(double rot) {
		
		direction=new Point2D(Math.cos(Math.toRadians(rot)),Math.sin(Math.toRadians(rot)));
		direction=direction.normalize().multiply(3);
		
	}

	public void update() {
		corps.setTranslateX(corps.getTranslateX()+direction.getX());
		corps.setTranslateY(corps.getTranslateY()+direction.getY());
	}

}

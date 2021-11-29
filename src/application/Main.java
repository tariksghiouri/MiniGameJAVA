package application;
	
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	private List<Monster> mesMonsters= new ArrayList<>();
	private List<Balle> mesBalles= new ArrayList<>();
	private int w_height=600;
	private int w_width=800;
	private BorderPane root=new BorderPane();
	private Scene scene = new Scene(root,w_width,w_height);			
	private Line line = new Line(0,200,w_width,200);
	private Zone zone1= new Zone(0,0,line.getEndX()-50,line.getEndY()-50);
	private Zone zone2= new Zone(line.getStartX(), line.getStartY(), line.getEndX()-50,w_height-50);
	private Hero hero= new Hero(zone2);
	private Arme arme= new Arme(hero);
	EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			// TODO Auto-generated method stub

			  switch(event.getCode())
			  {
			  case RIGHT: arme.rotateLeft(); break;
			  case LEFT:arme.rotateRight(); break;
			  case A:hero.MoveRight();arme.updateState(hero);break;
			  case D:hero.MoveLeft();arme.updateState(hero); break;
			  case W:hero.MoveDown();arme.updateState(hero);break;
			  case S:hero.MoveUp();arme.updateState(hero); break;
			  case SPACE:
				  Balle balle=new Balle(arme);
				  mesBalles.add(balle);
				  root.getChildren().add(balle.getCorps());
				  break;
		
			  default:break;
			  }
		}
	};
	
	AnimationTimer animationTime=new AnimationTimer() {
		
		@Override
		public void handle(long arg0) {
			// TODO Auto-generated method stub
			Updatecontent();
			
		}

		
	};
	private void Updatecontent() {
		for (Balle balle:mesBalles) {
			balle.update();
		}
		
		if (Math.random()<0.01)
		{
		Monster monster= new Monster(zone1);
		root.getChildren().add(monster.getCorps());
		mesMonsters.add(monster);
		}
		for(Balle balle:mesBalles) {
			for(Monster monster: mesMonsters) {
				if(balle.touch(monster)) {
					root.getChildren().removeAll(balle.getCorps(), monster.getCorps());
					balle.setIsAlive(false);
					monster.setIsAlive(false);
				}
			}
		}
		mesMonsters.removeIf(ObjetGraphique::isDead);
		mesBalles.removeIf(ObjetGraphique::isDead);
	}
	private void CreateContent() {
		
		root.getChildren().add(line);
		root.getChildren().add(hero.getCorps());
		root.getChildren().add(arme.getCorps());
	}
//		@Override
	public void start(Stage primaryStage) {
		try {
			
			CreateContent();
			primaryStage.setScene(scene);
			animationTime.start();
			
			scene.setOnKeyPressed(event);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

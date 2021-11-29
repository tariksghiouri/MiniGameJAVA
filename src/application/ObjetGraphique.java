package application;
import javafx.scene.Node;

public class ObjetGraphique {
	
	
	protected Node corps;
	private Boolean isAlive=true ;
	public Boolean getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}
	public Boolean isDead () {
		return !isAlive;
	}
	public Node getCorps() {
		return corps;
	}
	public void setCorps(Node corps) {
		this.corps = corps;
	}
	
	public boolean touch(ObjetGraphique obj){
		return corps.getBoundsInParent().intersects(obj.getCorps().getBoundsInParent());
		
	}
	
	
}

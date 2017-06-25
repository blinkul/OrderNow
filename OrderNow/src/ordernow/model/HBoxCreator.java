package ordernow.model;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HBoxCreator {
	HBox hb = null;
	private Comanda comanda;
	public static int nrHb;
	
	public HBoxCreator(Comanda comanda){
		this.comanda = comanda;
		hb = new HBox();
		hb.getChildren().add(new Label("TEST"));
	}
	
	public HBox getHbox(){
		return hb;
	}
}

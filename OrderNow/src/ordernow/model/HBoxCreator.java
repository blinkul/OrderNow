package ordernow.model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/** 
 * Trebuie sa primeasca ca parametru un obiect de tip comanda
 * Pe baza lui se construieste un HBox
 * HBox componenta:
 * -Label Comanda.cantitate
 * -Label Comanda.numeMeniu
 * -Label totalComanda;
 * -ChoiceBox Comanda.persoane (ArrayList)
 * -Button Add Persoane
 * -Button Remove Persoane
 * 
 * @author ciprian.anghel
 *
 */

//TODO Cele de mai sus

public class HBoxCreator {
	HBox hb = null;	
	//Will pop up a dialog pane unde:
	//-poti vedea cine a cumparat asta
	//-poti sterge/adauga persoane
	//-poti adauga pentru fiecare persoana cat au platit
	Button persons = null;
	private Comanda comanda;
	public static int nrHb;
	
	String cantitate; 
	String numeMeniu;
	String pretTotal;
	
	public HBoxCreator(Comanda comanda){
		cantitate = String.valueOf(comanda.getCantitate()) + " x ";
		numeMeniu = comanda.getNumeMeniu();
		pretTotal = " : TOTAL " +comanda.getPret()+" RON   ";
		
		this.comanda = comanda;
		hb = new HBox();
//		hb.setStyle("-fx-background-color: WHITE");
//		HBox.setHgrow(hb, Priority.ALWAYS);
//		hb.setPrefWidth(10000);
		hb.getChildren().add(new Label(cantitate));
		hb.getChildren().add(new Label(numeMeniu));
		hb.getChildren().add(new Label(pretTotal));	

		
		
	}
	
	public HBox getHbox(){
		return hb;
	}
}

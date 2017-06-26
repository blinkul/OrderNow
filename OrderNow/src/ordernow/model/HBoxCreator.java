package ordernow.model;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
	private Comanda comanda;
	public static int nrHb;
	
	String cantitate; 
	String numeMeniu;
	
	
	public HBoxCreator(Comanda comanda){
		cantitate = "Cantitate: " + String.valueOf(comanda.getCantitate()) + "   ";
		numeMeniu = "Comanda: " + comanda.getNumeMeniu() + "   ";
		
		this.comanda = comanda;
		hb = new HBox();
		hb.getChildren().add(new Label(cantitate));
		hb.getChildren().add(new Label(numeMeniu));
		
	}
	
	public HBox getHbox(){
		return hb;
	}
}

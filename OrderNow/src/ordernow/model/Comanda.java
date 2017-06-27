package ordernow.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Comanda implements Comparable<Comanda>{
	
	private StringProperty numeMeniu;
	//probabil bazat pe numarul de persoane
	private IntegerProperty cantitate;
	private DoubleProperty pret;
	private DoubleProperty totalComanda; // = pret * persoane.size()
//	private ArrayList<Persons> persoaneList;
	private ObservableList<Persons> persoane;
	
	public Comanda(String numeMeniu, Double pret, Persons persoane){		
		this.persoane = FXCollections.observableArrayList(persoane);
		setNumeMeniu(numeMeniu);
		setPret(pret);
		setTotalComanda(getPret() * getCantitate());
	}
	
	private String simplifyString(String string){
		//TODO simplifyString
		//Pentru comparatie, trebuiesc eliminate toate caracterele speciale si spatiile libere + to uppercase
		return string;
	}	
	
	public String getNumeMeniu() {
		return numeMeniuProperty().get();
	}

	public void setNumeMeniu(String numeMeniu) {
		numeMeniuProperty().set(numeMeniu);
	}

	public int getCantitate() {
		if (persoane == null || persoane.get(0) == null) {
			return 0;
		} else {
			testShowLista(persoane);
			return persoane.size();
		}
	}

	public void setCantitate(int cantitate) {
		cantitateProperty().set(cantitate);
	}

	public double getPret() {
		return pretProperty().get();
	}

	public void setPret(double pret) {
		pretProperty().set(pret);;
	}

	public double getTotalComanda() {
		return totalComandaProperty().get();
	}

	public void setTotalComanda(double totalComanda) {
		totalComandaProperty().set(totalComanda);
	}

	//Compara numele meniurilor DUPA simplificarea stringului
	@Override
	public int compareTo(Comanda comanda) {
		if (simplifyString(getNumeMeniu()).equals(simplifyString(comanda.getNumeMeniu()))) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public StringProperty numeMeniuProperty(){
		if(numeMeniu == null){
			numeMeniu = new SimpleStringProperty(this, "numeMeniu");
		}
		return numeMeniu;
	}
	
	public IntegerProperty cantitateProperty(){
		if(cantitate == null){
			cantitate = new SimpleIntegerProperty(this, "cantitate");
		}
		return cantitate;
	}
	
	public DoubleProperty pretProperty(){
		if(pret == null){
			pret = new SimpleDoubleProperty(this, "pret");
		}
		return pret;
	}
	
	public DoubleProperty totalComandaProperty(){
		if(totalComanda == null){
			totalComanda = new SimpleDoubleProperty(this, "totalComanda");
		}
		return totalComanda;
	}

	@Override
	public String toString() {
		return getNumeMeniu();
	}	
	
	private void testShowLista(ObservableList<Persons> lista){
		for(Persons p : lista){
			System.out.println("Lista:");
			System.out.println(p);
			System.out.println("-----------------");
		}
	}
}

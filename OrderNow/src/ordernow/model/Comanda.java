package ordernow.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Comanda implements Comparable<Comanda>{
	
	private String numeMeniu;
	//probabil bazat pe numarul de persoane
	private int cantitate;
	private double pret;
	private double totalComanda; // = pret * persoane.size()
//	private ArrayList<Persons> persoaneList;
	private ObservableList<Persons> persoane;
	
	public Comanda(String numeMeniu, Double pret, Persons persoane){		
		this.persoane = FXCollections.observableArrayList(persoane);
		setNumeMeniu(numeMeniu);
		setPret(pret);
	}
	
	private String simplifyString(String string){
		//TODO simplifyString
		//Pentru comparatie, trebuiesc eliminate toate caracterele speciale si spatiile libere + to uppercase
		return string;
	}	
	
	public String getNumeMeniu() {
		return numeMeniu;
	}

	public void setNumeMeniu(String numeMeniu) {
		this.numeMeniu = numeMeniu;
	}

	//TODO Not working
	public int getCantitate() {
		if (persoane == null || persoane.get(0) == null) {
			return 0;
		} else {
			testShowLista(persoane);
			return persoane.size();
		}
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public double getTotalComanda() {
		return totalComanda;
	}

	public void setTotalComanda(double totalComanda) {
		this.totalComanda = totalComanda;
	}

	//Compara numele meniurilor DUPA simplificarea stringului
	@Override
	public int compareTo(Comanda comanda) {
		if (simplifyString(numeMeniu).equals(simplifyString(comanda.toString()))) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return numeMeniu;
	}	
	
	private void testShowLista(ObservableList<Persons> lista){
		for(Persons p : lista){
			System.out.println("Lista:");
			System.out.println(p);
			System.out.println("-----------------");
		}
	}
}

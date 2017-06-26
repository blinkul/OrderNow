package ordernow.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Comanda implements Comparable<Comanda>{
	
	private String numeMeniu;
	//probabil bazat pe numarul de persoane
	private int cantitate;
	private double pret;
	private double totalComanda; // = pret * persoane.size()
	private ObservableList<Persons> persoane;	
	
	public Comanda(String numeMeniu, Double pret, ObservableList<Persons> persoane){
		persoane = FXCollections.observableArrayList();
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

	public int getCantitate() {
		if (persoane.isEmpty()) {
			return 0;
		} else {
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
}

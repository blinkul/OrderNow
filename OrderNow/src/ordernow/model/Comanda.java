package ordernow.model;

import java.util.ArrayList;

public class Comanda implements Comparable<Comanda>{
	private String orderName;
	private int quantity;
//	private ArrayList<Persons> doritori;	
	private Persons persoana;
	private Double price;
	
	public Comanda(String orderName, Double price, Persons persoana){
//		setOrderName(orderName);
//		doritori.add(persoana);
//		setPrice(price);		
		
		this.orderName = orderName;
		this.price = price;
		//Problema la arrayList
		this.persoana = persoana;
		
		System.out.println("Comanda "+orderName+"; "+price+"; "+persoana.getName());
		
	}	
	
	public Comanda(){
		
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName.trim();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public void add(Persons person){
//		doritori.add(person);
//		quantity = doritori.size();
//	}	
//	public ArrayList<Persons> getDoritori() {
//		return new ArrayList<Persons>(doritori);
//	}

	@Override
	public int compareTo(Comanda order) {
		if (orderName.equals(order)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	
}

package ordernow.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persons implements Comparable<Persons>{
	
	private StringProperty name;
	private DoubleProperty amount;
		
	public Persons(String name, double amount) {
		setName(name);
		setAmount(amount);
	}	
	
	public void setName(String name) {
		nameProperty().set(name);
	}
	
	public String getName(){
		return nameProperty().get();
	}
	
	public void setAmount(Double amount){
		amountProperty().set(amount);
	}
	
	public Double getAmount(){
		return amountProperty().get();
	}
	
	public StringProperty nameProperty(){
		if(name == null){
			name = new SimpleStringProperty(this, "name");
		}
		return name;
	}
	
	public DoubleProperty amountProperty(){
		if(amount == null){
			amount = new SimpleDoubleProperty(this, "amount");
		}
		return amount;
	}
//		amount = (double)Math.round((amount + addAmount) * 100d) / 100d;

//		amount = (double)Math.round((amount - substractAmount) * 100d) / 100d;

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(Persons o) {
		if (name.equals(((Persons) o).name)) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

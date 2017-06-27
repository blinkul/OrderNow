package ordernow.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ordernow.model.Comanda;
import ordernow.model.HBoxCreator;
import ordernow.model.Persons;

public class MainPane implements Initializable {

	//Menu
	@FXML
	TextField tfAddPerson;
	@FXML
	Button btnAddPersons;	
	@FXML
	GridPane gridPaneMenuID, gridPaneTableID;
	@FXML
	VBox vboxPersonsID;
	
	//Main Pane
	@FXML
	Button btnMenuID, btnTableID, btnAddOrderID;
	@FXML
	GridPane gridPaneMainID;	
	@FXML
	TextField tfMenuID, tfPretID;
	@FXML
	TableView<Persons> testTableID;
	@FXML
	TableColumn<Persons, String> columnNameID;
	@FXML
	TableColumn<Persons, Double> columnAmountID;
	@FXML
//	ChoiceBox<Persons> cbChooseID;
	ComboBox<Persons> cbChooseID;
	@FXML
	VBox vbOrdersID;
	@FXML
	Label InformatiiID;
		
	boolean isMenuOpen = true;
	boolean isTableOpen = false;
		
	ObservableList<Persons> listOfPersons;	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showHideContactCreator();
		showHideContactTable();
		
		//Detecting changes			
		listOfPersons = FXCollections.observableArrayList();
		listOfPersons.addListener((ListChangeListener<Persons>) c -> System.out.println("Detect change in listOfPersons"));
		
		//Adding information to testTableID
		testTableID.setItems(listOfPersons);
		columnNameID.setCellValueFactory(new PropertyValueFactory("name"));
		columnAmountID.setCellValueFactory(new PropertyValueFactory("amount"));
		testTableID.getColumns().setAll(columnNameID, columnAmountID);
		cbChooseID.getItems().addAll(listOfPersons);
	}
	
	public void showHideContactCreator() {
		
		if (isMenuOpen == true) {
			//close it
			gridPaneMenuID.setVisible(false);
			gridPaneMainID.getColumnConstraints().get(1).setMinWidth(0);
			gridPaneMainID.getColumnConstraints().get(1).setMaxWidth(0);
			isMenuOpen = false;
			
			System.out.println("Menu closed");
		} else {
			//open Menu, close Table if open
			if(isTableOpen == true){
				showHideContactTable();
			}
			gridPaneMenuID.setVisible(true);
			gridPaneMainID.getColumnConstraints().get(1).setMinWidth(150);
			gridPaneMainID.getColumnConstraints().get(1).setMaxWidth(150);
			isMenuOpen = true;
			
			System.out.println("Menu opened");
		}
	}
	
	public void showHideContactTable() {
		
		if (isTableOpen == true) {
			//close it
			gridPaneTableID.setVisible(false);
			gridPaneMainID.getColumnConstraints().get(1).setMinWidth(0);
			gridPaneMainID.getColumnConstraints().get(1).setMaxWidth(0);
			isTableOpen = false;
			
			System.out.println("Table closed");
		} else {
			//open Table, close Menu if open
			if(isMenuOpen == true){
				showHideContactCreator();
			}
			gridPaneTableID.setVisible(true);
			gridPaneMainID.getColumnConstraints().get(1).setMinWidth(250);
			gridPaneMainID.getColumnConstraints().get(1).setMaxWidth(250);
			isTableOpen = true;
			
			System.out.println("Table opened");
		}
	}
	
	//TODO Trebuie Lucrata

	//Adds persons to list
	/**
	 * Sa nu adaugi acelasi nume de doua ori
	 * Posibilitate de:
	 * -stergere
	 * -editare
	 */
	
	public void addPersons() {

		Persons person;
		String name = tfAddPerson.getText();
		Double amount = 0d;

		if (isContactEligible(name)) {
			name = parseName(name);
			person = new Persons(name, amount);
			listOfPersons.add(person);
			System.out.println("Contact added: " + name);
			InformatiiID.setText("Contact added: " + name);
			cbChooseID.getItems().add(person);
		} else {
			System.out.println("Contact was not added.");
		}
	}	
	
	/**
	 * This will:
	 * -check if tf is empty
	 * -check if tf contains numbers
	 * -check if tf contains anything than letters
	 * -check if name was already added to the list
	 * @return
	 */
	private boolean isContactEligible(String name) {
		if (name.trim().isEmpty()) {
			System.out.println("Text field is empty");
			InformatiiID.setText("Nu ati introdus nimic in campul <Nume>!");
			return false;
		} else if (isContainingNumbers(name)) {
			System.out.println("Text contains numbers");
			InformatiiID.setText("Campul <Nume> nu trebuie sa contina cifre!");
			return false;
		} else if(isOnlyLetters(name) == false){
			System.out.println("Text contains special characters");
			InformatiiID.setText("Campul <Nume> nu trebuie sa contina caractere speciale!");
			return false;
		} else if (isAdded(name)) {
			System.out.println("Name already exists in the database");
			InformatiiID.setText("\"" +name+"\" exista deja in baza de date.");
			return false;
		} else {
			return true;
		}
	}

	private boolean isContainingNumbers(String string) {
		char[] charArr = string.toCharArray();
		for (char a : charArr) {
			if (Character.isDigit(a)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isOnlyLetters(String string) {
		char[] charArr = string.toCharArray();
		for (char a : charArr) {
			if (Character.isLetter(a) == false) {
				if(a==' '){
					continue;
				}
				return false;
			}
		}
		return true;
	}

	//check if person was added before
	private boolean isAdded(String person) {
		person = parseName(person);
		for (Persons p : listOfPersons) {
			if (p.getName().equals(person)) {
				return true;
			}
		}
		return false;
	}
	
	private String parseName(String name) {
		String[] strArr = name.split(" ");
		StringBuilder sb = null;

		if (name.trim().equals("") == false) {
			sb = new StringBuilder();
			for (String string : strArr) {
				if (string.trim().isEmpty()) {
					continue;
				} else {
					sb.append(string.substring(0, 1).toUpperCase());
					sb.append(string.substring(1).toLowerCase());
					sb.append(" ");
				}
			}
			return sb.toString().trim();
		} else {
			return null;
		}
	}
	
	
	private String numeComanda;
	private Double pret;
	private Comanda comanda;
	private Persons persoana;
	
	public void addOrder(){	

		cbChooseID.setStyle(null);
		tfMenuID.setStyle(null);
		tfPretID.setStyle(null);
		
		try{
			numeComanda = tfMenuID.getText().trim();
			pret = Double.valueOf(tfPretID.getText().trim());
			persoana = cbChooseID.getSelectionModel().getSelectedItem();
			
			if(cbChooseID.getSelectionModel().isEmpty()){
				InformatiiID.setText("Alegeti persoana care doreste meniul");
				cbChooseID.setStyle("-fx-border-radius: 2px; -fx-border-color: RED");
				return;
			}
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CONFIRMA MENIUL...");
			alert.setHeaderText(persoana.getName() + " a comandat:\n " + numeComanda + "\nPret meniu: "+pret+" RON");
			alert.setContentText("Esti ok cu asta?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				comanda = new Comanda(numeComanda, pret, persoana);
				//Creeaza campul comanda in tabel
				HBoxCreator hb = new HBoxCreator(comanda);		
				vbOrdersID.getChildren().addAll(hb.getHbox());
			} 		
			
		}catch(NumberFormatException nfe){
			InformatiiID.setText("Introduceti contravaloarea meniului");
			tfPretID.setStyle("-fx-border-radius: 2px; -fx-border-color: RED");			
		}	
	}	
}

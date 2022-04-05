package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model = new Model();
	
    public void setModel(Model model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	String parola = txtParola.getText();
    	model.anagramma(parola);
    	Set<String> corretti = model.getCorretti();
    	Set<String> errati = model.getErrati();
    	
    	for(String s: corretti)
    		txtAnagrammiCorretti.appendText(s+"\n");
    	
    	for(String s: errati)
    		txtAnagrammiErrati.appendText(s+"\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}


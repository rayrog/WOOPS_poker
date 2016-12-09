package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.*;

public class Cinscription extends JFrame {
	private Vinscription vins;
	private JFrame frameins;
	private Cconnexion ccon;
	public Cinscription(Cconnexion c) {
		this.vins = new Vinscription(this, c.getFenetreco().getFrame());
		this.ccon = c;
	}
	
	public Cconnexion getCcon() {
		return ccon;
	}

	public void setCcon(Cconnexion ccon) {
		this.ccon = ccon;
	}

	public void displayInscription(){
		vins.getFrame().setVisible(true);
	}
	
	public void closeInscription(){
		vins.getFrame().dispose();
	}
	
	public void deleteTxtInField(JTextField txtField) {
		txtField.setText("");
	}
	
	public void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}
	
	public void runInscription(){
		displayInscription();
	}
	
	public void verifyFields(ArrayList<JTextField> fiels){
		
	}
}

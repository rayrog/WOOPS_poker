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
	public Cinscription(JFrame feneco) {
		vins = new Vinscription(this);

	}
	
	public void displayInscription(){
		vins.getFrame().setVisible(true);
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

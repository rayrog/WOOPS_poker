package fr.poker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.poker.view.*;

public class Cinscription extends JFrame {
	
	public static void displayInscription(){
		
		Vinscription v = new Vinscription();
		v.getFrame().setVisible(true);
	}
	
	public static void deleteTxtInField(JTextField txtField) {
		txtField.setText("");
	}
	
	public static void fillField(JTextField txtField, String txt) {
		txtField.setText(txt);
	}
	
	public static void runInscription(){
		displayInscription();
	}
}

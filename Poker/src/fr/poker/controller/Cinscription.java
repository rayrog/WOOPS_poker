package fr.poker.controller;

import fr.poker.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;

public class Cinscription extends JFrame {
	
	public static void displayInscription(){
		
		Vinscription v = new Vinscription();
		v.getFrame().setVisible(true);
	}
	
	public static void runInscription(){
		displayInscription();
	}
}

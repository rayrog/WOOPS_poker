package fr.poker.controller;

import javax.swing.UIManager;
//import fr.poker.vue;
import fr.poker.controller.Partie;

public class Lanceur {
	public static void main(String[] args){
		try{
			//Essayer d'ouvrir l'ihm de la partie
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		FenetrePrincipale.getInstance();
		Partie.getInstance().start();
	}
}
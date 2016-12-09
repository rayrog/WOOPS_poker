package fr.poker.controller;

import javax.swing.JFrame;


import fr.poker.controller.bdd.CBconnect;
import fr.poker.view.Vconnexion;

public class Cconnexion extends JFrame {
	static Vconnexion fenetreCo = new Vconnexion();
	
	/** Serial UID */
	private static final long serialVersionUID = 8934682278090456214L;


	public static void displayConnexion() {
		//Vconnexion fenetreCo = new Vconnexion();
		fenetreCo.getFrame().setVisible(true);
	}
	
	public static void closeConnexion() {
		//Vconnexion fenetreCo = new Vconnexion();
		//fenetreCo.removeAll();
		fenetreCo.getFrame().dispose();
	}

	public static void runCconnexion() {
		displayConnexion();
	}

	public static void login() {
		boolean loginOK=false;
		System.out.println(fenetreCo.getTxtEmail().getText());
		System.out.println(fenetreCo.getPwdMotDePasse().getText()); // temp for debug 
		//CBconnect.connexion();
		//CBconnect.lire();
		// comparer couple login mdp avec la bdd >>>> si Ok : LoginOK a true 
		if (loginOK==true){
			System.out.println("Login OK, ouverture de la page de connexion");
			// lancer page de connexion 
		}
		else {
			//JOptionPane.showMessageDialog(null, "Erreur de connexion : ", "InfoBox: " + "Error Login", JOptionPane.INFORMATION_MESSAGE);	
		}
	}
}


package fr.poker.controller;

public class Clanceur {
	
	public Clanceur() {
		Cconnexion ccon = new Cconnexion();
		try {
			System.out.println("Ouverture page connexion");
			ccon.displayConnexion();;

		} catch (Exception e) {
			e.printStackTrace();

		}
		// FenetrePrincipale.getInstance();
		// Partie.getInstance().start();
	}
}
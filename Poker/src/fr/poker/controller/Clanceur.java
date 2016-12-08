package fr.poker.controller;

public class Clanceur {

//	
//	 * Lance la fenetre de connexion
//	 * 

	public static void main(String[] args) {
		try {
			Cinscription.displayInscription();

		} catch (Exception e) {
			e.printStackTrace();

		}
		// FenetrePrincipale.getInstance();
		// Partie.getInstance().start();
	}

}
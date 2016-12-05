package fr.poker.controller;

public class Clanceur {

	/*
	 * Lance la fenetre de connexion
	 * 
	 * Voir pour rajouter des test : a internet ? a bien les fichiers requis pour se connecter au serveur
	 */
	public static void main(String[] args) {
		try {
			Cconnexion.runCconnexion();

		} catch (Exception e) {
			e.printStackTrace();

		}
		// FenetrePrincipale.getInstance();
		// Partie.getInstance().start();
	}

}

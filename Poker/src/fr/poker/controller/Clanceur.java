package fr.poker.controller;

public class Clanceur {
	public Clanceur() {
		// TODO Auto-generated constructor stub
	}
//	
//	 * Lance la fenetre de connexion
//	 * 
	
	public static void main(String[] args) {
		Cconnexion ccon =new Cconnexion();
		try {
			ccon.displayConnexion();;

		} catch (Exception e) {
			e.printStackTrace();

		}
		// FenetrePrincipale.getInstance();
		// Partie.getInstance().start();
	}

}
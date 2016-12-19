package fr.poker.controller;

public class CdebugLuka {
	public CdebugLuka(){}
	
	public static void main(String[] args) {
		Cconnexion ccon = new Cconnexion();
		try {
			System.out.println("Ouverture page Accueil ID Joueur 1");
			ccon.runAccueil(1);

		} catch (Exception e) {
			e.printStackTrace();

		}
		// FenetrePrincipale.getInstance();
		// Partie.getInstance().start();
	}

}



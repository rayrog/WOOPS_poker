package fr.poker;

import fr.poker.controller.Cconnexion;

public class debugLuka {
	public debugLuka(){}
	
	public static void main(String[] args) {
		Cconnexion ccon = new Cconnexion();
		try {
			System.out.println("Ouverture page Accueil ID Joueur 1");
			ccon.runAccueil(1);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}


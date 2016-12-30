package fr.poker;

import fr.poker.controller.Caccueil;
import fr.poker.controller.Cconnexion;
import fr.poker.controller.Cparametre;

public class debugLuka {
	public debugLuka(){}
	
	public static void main(String[] args) {
		Cconnexion ccon = new Cconnexion();
	
		try {
			//System.out.println("Ouverture page Accueil ID Joueur 1");
			ccon.runAccueil(1);


		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}



package fr.poker.controller;

import static java.lang.System.out;
import java.util.EventListener;
import fr.poker.view.*;

public class Cconnexion{

	public static void DisplayConnexion() {
		out.println("Lancement Ecran de connexion");
		Vconnexion EcranConnexion = new Vconnexion();
		
		EcranConnexion.main();
		

		
		//Vconnexion test = new Vconnexion();

	
		//objetTest.getFrame();

		//objetTest.getFrame().setVisible(false);;

		//objetTest.getBtnInscription().;
		
		
		
	}
	
	

	/*Display view.accueil 
	Boutton Connexion disable 
	boutton inscription enable 
	*/


	
	/*
	 * while click on inscription/connexion pas NOK : 
	 

		{
		verifier que compte et password remplis  
		
			si oui : 
				display click connexion en non gris� 
				( faire avec des gets)
		
				si non :
					do nothing
		}
	
			
			/* Une fois un bouton cliqu� :  
	
	listener click connexion
	{
		demander � la BDD si login/pwd OK
		Si ok : 
			Afficher connexion reussie et ouvrir controller
			Accueil 
			
	}
	
	listener click Inscription 
	{
		lance controller.inscription 
		
	}



*/
}
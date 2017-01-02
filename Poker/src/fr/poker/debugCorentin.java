package fr.poker;

import fr.poker.controller.Cconnexion;
import fr.poker.view.Vjeu;
import fr.poker.model.*;
import fr.poker.model.chat.client.ClientChat;
import fr.poker.model.chat.client.Emission;

public class debugCorentin {
	public debugCorentin(){}
	
	public static void main(String[] args) {
		try {
			System.out.println("Je lance VJeu");
			
			ClientChat.runClient();
			System.out.println("Connexion OK");
			Vjeu window = new Vjeu(null);

			System.out.println("Affichage OK");
			
			
			System.out.println("Fini");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
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
<<<<<<< HEAD
			System.out.println("Je lance VJeu");
			
			ClientChat.runClient();
			System.out.println("Connexion OK");
=======
			//System.out.println("Je lance VJeu");
			int portChat=5009;
			Client.runClient(portChat);
			//System.out.println("Connexion OK");
>>>>>>> master
			Vjeu window = new Vjeu(null);

			//System.out.println("Affichage OK");
			
			
			//System.out.println("Fini");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
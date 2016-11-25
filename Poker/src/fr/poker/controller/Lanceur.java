package fr.poker.controller;

import fr.poker.controller.*;
//import view; To do 

public class Lanceur {
	
	/*Lance la fenetre de connexion
	 * 
	 * Voir pour rajouter des test : 
	 * 	a internet ? 
	 * 	a bien les fichiers requis pour se connecter au serveur 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args){
		try{
		Connexion.DisplayConnexion();
		}
		catch(Exception e){}
		//FenetrePrincipale.getInstance();
		//Partie.getInstance().start();
	}
	
}
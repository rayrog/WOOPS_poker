package fr.poker;
import fr.poker.model.*;
public class Poker {

	public static void main(String[] args) {
		
		Paquet paq = new Paquet("Jeu de 52 cartes");
		Joueur j = new Joueur(1, null, 5, true); //Compte à null car pas encore implémenter
		Joueur dealer = new Joueur(2,null,0,true,"Dealer");
		
		/* Test pour Paquet, carte, couleur, Valeur */
		//System.out.println(paq);
		//System.out.println(paq.piocher());
		//System.out.println(paq);
		
		/* Test Joueur */
		//System.out.println(j);
		//System.out.println(dealer);
		
		//j.miser(3);
		//System.out.println(j);
		//j.relancer(3);
		//System.out.println(j);
		
		/*Test Compte */
		//A FAIRE MADAFACKA
	}

}

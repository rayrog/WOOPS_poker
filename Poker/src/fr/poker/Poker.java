package fr.poker;

import fr.poker.controller.Cdistribuer2cartes;
import fr.poker.model.*;
import java.util.*;

public class Poker {

	public static void main(String[] args) {

		Compte c = new Compte(1, "Dididoo", "Dujardin", "Luka", "worldofkalu@gmail.com", "0667929511",
				"15#61ds064ez6!65$64", 5, "Cherche pas t'es mort");
		Compte c2 = new Compte(2, "Dadidoo", "Miky", "Bob", "toz@gmail.com", "0667929511", "15#61ds064ez6!65$64", 5,
				"Cherche pas t'es mort");
		Joueur j = new Joueur(1, c, 5, true);

		Salle s = new Salle();
		Table t = new Table(1, 7);
		
		Paquet paq = new Paquet("Jeu de 52 cartes");
		MainJoueur m = new MainJoueur(j, t);
		

		
		
		ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();	
		mesJoueurs.add(j);
		new Cdistribuer2cartes(mesJoueurs,paq);
		System.out.println(mesJoueurs);
		/* Test pour Paquet, carte, couleur, Valeur */
//		 System.out.println(paq);
//		 System.out.println(paq.piocher());
//		 System.out.println(paq);

		/* Test Joueur */
		// System.out.println(j);
		// j.miser(3);
		// System.out.println(j);
		// j.relancer(3);
		// System.out.println(j);

		/* Test Compte */
////		System.out.println(c.getJoueur());
////		System.out.println(j);
//
//		Scanner sc = new Scanner(System.in);
//		float potDepart = 0;
//
//		do {
//			System.out.println("Choissisez votre pot de départ pour la partie :");
//
//			try {
//				potDepart = sc.nextFloat(); //TODO: fix me (reset the scanner if catch the exception)
//				if (potDepart > 0) {
//					c.createJoueur(potDepart);
//					System.out.println("Joueur créé avec un pot de départ de " + c.joueur.getCreditPartie());
//				}
//			} catch (Exception e) {
//				System.out.println("Il faut entrer un chiffre \n");
//				
//			}
//		} while (c.getJoueur() == null );
//
//		if (c.joueur != null)
//			c.joueur.miser(3);
		
		/* Test MainJoueur*/
		t.addCarte(paq.piocher());
		j.addCarte(paq.piocher());
		m.setCartes();
		System.out.println(m);
	}
	

}

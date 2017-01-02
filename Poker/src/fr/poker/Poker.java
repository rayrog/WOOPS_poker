package fr.poker;

import fr.poker.controller.*;
import fr.poker.model.*;

public class Poker {

	public static void main(String[] args) {
		/* LANCEMENT DE L'INTERFACE GRAPHIQUE (VIEW) */
		//Clanceur init = new Clanceur();
		
		/* SIMULATON DE CREATION DE COMPTE --> TODO: Use BDD fields*/
		Compte c1 = new Compte(1, "Dididoo", "Dujardin", "Luka", "worldofkalu@gmail.com", "0667929511", "15#61ds064ez6!65$64", 5);
		Compte c2 = new Compte(2, "Dadidoo", "Flory", "Mike", "toz@gmail.com", "0667929511", "15#61ds064ez6!65$64", 5);
		Compte c3 = new Compte(3, "Dododu", "Prima", "Corentin", "test@hotmail.fr", "0667951232", "hash", 0);
		
		/* SIMULATION REJOINDRE SALLE--> TODO: Cr�er un joueur lorsqu'on click sur rejoindre/creer partie */
//		c1.createJoueur(0);
//		c2.createJoueur(5);
//		c3.createJoueur(120);
		
		/* SIMULATION DE CREATION PARTIE --> TODO: A faire lors de la cr�ation d'une partie*/
		//Salle s1 = new Salle("Salle 1", false, "inutile"); //salle publique
		//Salle s2 = new Salle("Salle 2", true, "F4uxH@shM@g€ul€"); //salle privee
		
		/* AJOUT DE SPECTATEUR */
		//s1.rejoindre(c1.getJoueur());
		
		/*AJOUT DE JOUEUR A LA TABLE*/
		
		//Quand c2 clique sur la chaise
//		c2.getJoueur().setEtat(true);		
//		s1.rejoindre(c2.getJoueur());
//		
//		//Quand c3 clique sur la chaise
//		c3.getJoueur().setEtat(true);
//		s1.rejoindre(c3.getJoueur());
//		
//		/*LANCEMENT DE LA PARTIE (CONTROLLER)*/
//		Cpartie partie = new Cpartie(s1.getTable()); 
//		partie.run();
//		
//		Paquet paq = new Paquet("Jeu de 52 cartes");
//		MainJoueur m = new MainJoueur(j1, t);
		

//		ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
//		mesJoueurs.add(j1);
//		mesJoueurs.add(j2);
//		System.out.println(mesJoueurs);
		
		/* Test pour Paquet, carte, couleur, Valeur */
		// System.out.println(paq);
		// System.out.println(paq.piocher());
		// System.out.println(paq);

		/* Test Joueur */
		// System.out.println(j);
		// j.miser(3);
		// System.out.println(j);
		// j.relancer(3);
		// System.out.println(j);

		/* Test Compte */
		//// System.out.println(c.getJoueur());
		//// System.out.println(j);
		//
		// Scanner sc = new Scanner(System.in);
		// float potDepart = 0;
		//
		// do {
		// System.out.println("Choissisez votre pot de d�part pour la partie :");
		//
		// try {
		// potDepart = sc.nextFloat(); //TODO: fix me (reset the scanner if catch the exception)
		// if (potDepart > 0) {
		// c.createJoueur(potDepart);
		// System.out.println("Joueur cr�� avec un pot de d�part de " + c.joueur.getCreditPartie());
		// }
		// } catch (Exception e) {
		// System.out.println("Il faut entrer un chiffre \n");
		//
		// }
		// } while (c.getJoueur() == null );
		//
		// if (c.joueur != null)
		// c.joueur.miser(3);

		/* Test MainJoueur */
//		t.addCarte(paq.piocher());
//		j1.addCarte(paq.piocher());
//		m.setCartes();
//		System.out.println(m);
	}


}

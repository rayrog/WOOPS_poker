package fr.poker;

import java.util.ArrayList;
import java.util.List;

import fr.poker.model.Carte;
import fr.poker.model.Compte;
import fr.poker.model.Joueur;
import fr.poker.model.MainJoueur;
import fr.poker.model.Paquet;
import fr.poker.model.Salle;
import fr.poker.model.Table;

public class Poker {

	public static void main(String[] args) {
		Compte c = new Compte(1, "Dididoo", "Dujardin", "Luka", "worldofkalu@gmail.com", "0667929511", "15#61ds064ez6!65$64", 5, "Cherche pas t'es mort");
		Compte c2 = new Compte(2, "Dadidoo", "Miky", "Bob", "toz@gmail.com", "0667929511", "15#61ds064ez6!65$64", 5, "Cherche pas t'es mort");
		Joueur j1 = new Joueur(1, c, 5, true);
		Joueur j2 = new Joueur(2, c2, 5, true);
		
		Salle s = new Salle();
		Table t = new Table(1, 7);

		Paquet paq = new Paquet("Jeu de 52 cartes");
		MainJoueur m = new MainJoueur(j1, t);

		ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
		mesJoueurs.add(j1);
		mesJoueurs.add(j2);
		initJoueurs(mesJoueurs, paq);
		System.out.println(mesJoueurs);
		
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
		// System.out.println("Choissisez votre pot de départ pour la partie :");
		//
		// try {
		// potDepart = sc.nextFloat(); //TODO: fix me (reset the scanner if catch the exception)
		// if (potDepart > 0) {
		// c.createJoueur(potDepart);
		// System.out.println("Joueur créé avec un pot de départ de " + c.joueur.getCreditPartie());
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
		t.addCarte(paq.piocher());
		j1.addCarte(paq.piocher());
		m.setCartes();
		System.out.println(m);
	}

	/**
	 * Génére un couple de cartes par joueur
	 * 
	 * @param joueurs La liste de joueurs à initialiser
	 * @param paq Le paquet à utiliser
	 */
	private static void initJoueurs(ArrayList<Joueur> joueurs, Paquet paq) {
		List<Carte> listeCartes;

		for (Joueur joueur : joueurs) {
			listeCartes = new ArrayList<Carte>();

			listeCartes.add(paq.piocher());
			listeCartes.add(paq.piocher());

			joueur.setCartes(listeCartes);
		}
	}

}

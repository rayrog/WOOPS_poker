package fr.poker.controller;

import fr.poker.model.*;

public class Cpartie {

	private Table maTable;

	public Cpartie(Table maTable, int nbJoueurs) {
		this.maTable = new Table(nbJoueurs);
	}

	public void run() { //Pour lancer la premiere partie
		
	}

	public void distribuerRole(Table table) {
		for (int i = 0; i < maTable.getJoueurs().size(); i++) {

			Joueur currentJ = maTable.getJoueurs().get(i);
			System.out.println("Je suis actuellement sur ce joueur: " + currentJ);

			switch (i) {
			case 1:
				currentJ.setRole("Dealer");
				break;
			case 2:
				currentJ.setRole("Petite blinde");
				break;
			case 3:
				currentJ.setRole("Grosse blinde");
				break;
			default:
				currentJ.setRole("Neutre");
			}
		}
	}

	public void distribuerCartes() {
		if (maTable.getTour() == 0) { // Distribution initiale de 2 cartes a
										// chaque joueur
			for (Joueur j : maTable.getJoueurs()) {
				j.addCarte(maTable.getPaq().piocher());
				j.addCarte(maTable.getPaq().piocher());
			}
		}
		if (maTable.getTour() == 1) { // FLOP --> 3 Cartes
			for (int i = 1; i < 4; i++) {
				maTable.addCarte(maTable.getPaq().piocher());
			}
		}
		if (maTable.getTour() == 2) // TURN --> 1 Carte
			maTable.addCarte(maTable.getPaq().piocher());

		if (maTable.getTour() == 3) // RIVER --> 1 Carte
			maTable.addCarte(maTable.getPaq().piocher());
	}

	public Joueur verifierGagnant() {
		Joueur gagnant = null;
		AbstractCombinaison c = new MainHaute();// Main la plus pourrie

		if (maTable.getNbJoueurs() == 1) // Si le joueur est assis tout seul a
											// la table (si tous les autres se
											// déco)
			gagnant = maTable.getJoueurs().get(0); // le gagnant est le restant

		if (maTable.getNbJoueursEnJeu() == 1) { // ou tous les autres sont
												// couchés
			for (Joueur j : maTable.getJoueurs()) {
				if (!j.isDown())
					gagnant = j;
			}
		}
		if (maTable.getTour() == 4) { // Fin de la manche (toutes les cartes ont
										// ete distribuees)
			for (Joueur j : maTable.getJoueurs()) {
				if (j.getBestCombinaison().compareTo(c) > 0) // combinaison du
																// joueur
																// meilleure que
																// combinaison a
																// comparer
					c = j.getBestCombinaison(); // Nouvelle combinaison a
												// comparer
				gagnant = j; // Gagnant provisoire
			}
		}

		return gagnant;
	}

	public void tourSuivant() { // Pas une méthode de Table car on part du
								// principe que c'est le controller qui cadence
								// la partie
		if (verifierGagnant() == null) {
			switch (maTable.getTour()) {
			case 0:
				maTable.setTour(1);
				break;
			case 1:
				maTable.setTour(2);
				break;
			case 2:
				maTable.setTour(3);
				break;
			case 3:
				maTable.setTour(4);
				break;
			case 4:
				relancerManche();
				break;
			}
		}
		maTable.tour = 1;
	}

	public void relancerManche() {
		distribuerGains();
		maTable.resetCartes(); //Débarasse la table
		maTable.setTour(0);
		for(Joueur j : maTable.getJoueurs()){ //On vire tous ceux qui ont plus de sous ou sont passer spec ou on déco
			if(!j.getEtat() || j.getCreditPartie() <= 0)
				maTable.delJoueur(j);
		}
		maTable.setPaq(new Paquet("Jeu de 52 cartes de la table " + maTable.getId()));
	}

	public void distribuerGains() {
		Joueur gagnant = verifierGagnant();
		gagnant.setCreditPartie(gagnant.getCreditPartie() + maTable.getPot());
		maTable.setPot(0);
	}

}

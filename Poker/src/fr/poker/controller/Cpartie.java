package fr.poker.controller;

import fr.poker.model.*;

public class Cpartie {

	public Table maTable;

	public Cpartie(Table t) {

		if (t.getJoueurs().size() > 1) // On cr�e une partie que s'il y a
										// d�ja deux joueurs assis � la
										// table
			this.maTable = t;
	}

	public void run() {

		System.out.println("Début de la nouvelle partie");
		maTable.setTour(0);
		maTable.setPot(0);

		Joueur winner = new Joueur();

		if (maTable.getJoueurs().size() > 1) {
			distribuerRole(maTable);
			distribuerCartes();
			do {
				winner = verifierGagnant();

				/* DEBUG */
				for (Joueur j : maTable.getJoueurs())
					j.getInfos();
				System.out.println(maTable);
				/***/

				while (miseEnAttente() == -1) {
					joueurSuivant();
					break; // to remove--> just for debug waiting parler() implementation
				}
				tourSuivant();
				distribuerCartes();
			} while (winner == null);

		} else
			System.out.println("C'est dommage tu es tout seul");
	}

	public void distribuerRole(Table table) {
		for (int i = 0; i < maTable.getJoueurs().size(); i++) {

			Joueur j = maTable.getJoueurs().get(i);

			if (maTable.getJoueurs().size() < 3) {
				switch (i) {
				case 0:
					j.setRole("Petite blinde");
					j.miser(maTable.getSmallBlind());
					parler(j);
					break;
				case 1:
					j.setRole("Grosse blinde");
					j.miser(maTable.getBigBlind());
					parler(j);
					break;
				default:
					System.out.println("Erreur de role");
				}
			} else {
				switch (i) {
				case 0:
					j.setRole("Dealer");
					break;
				case 1:
					j.setRole("Petite blinde");
					j.miser(maTable.getSmallBlind());
					break;
				case 2:
					j.setRole("Grosse blinde");
					j.miser(maTable.getBigBlind());
					break;
				default:
					j.setRole("Neutre");
				}
			}
		}
	}

	public void distribuerCartes() {
		if (maTable.getTour() == 0) {
			/* Ajout des joueurs en attente */
			if (!maTable.getJoueursAttente().isEmpty()) {
				for (Joueur j : maTable.getJoueursAttente()) {
					maTable.rejoindre(j);
					maTable.getJoueursAttente().remove(j);
				}
			}
			/* Distribution initiale de 2 cartes a chaque joueur */
			for (Joueur j : maTable.getJoueurs()) {
				j.addCarte(maTable.getPaq().piocher());
				j.addCarte(maTable.getPaq().piocher());
				j.setM();
			}
		}
		if (maTable.getTour() == 1) { // FLOP --> 3 Cartes
			for (int i = 1; i < 4; i++)
				maTable.addCarte(maTable.getPaq().piocher());
			for (Joueur j : maTable.getJoueursEnJeu())
				j.setM();
		}
		if (maTable.getTour() == 2) { // TURN --> 1 Carte
			maTable.addCarte(maTable.getPaq().piocher());
			for (Joueur j : maTable.getJoueursEnJeu())
				j.setM();
		}

		if (maTable.getTour() == 3) {// RIVER --> 1 Carte
			maTable.addCarte(maTable.getPaq().piocher());
			for (Joueur j : maTable.getJoueursEnJeu())
				j.setM();
		}

	}

	public Joueur verifierGagnant() {
		Joueur gagnant = null;
		AbstractCombinaison c = new MainHaute();// Main la plus pourrie

		if (maTable.getJoueurs().size() == 1) // Si le joueur est assis tout
												// seul a
												// la table (si tous les autres
												// se
												// d�co)
			gagnant = maTable.getJoueurs().get(0); // le gagnant est le restant

		if (maTable.getJoueursEnJeu().size() == 1) { // ou tous les autres sont
			// couch�s
			for (Joueur j : maTable.getJoueurs()) {
				if (!j.isDown())
					gagnant = j;
			}
		}
		if (maTable.getTour() == 4) { // Fin de la manche (toutes les cartes ont
										// ete distribuees)
			for (Joueur j : maTable.getJoueurs()) {
				if (j.getM().compareTo(c) > 0) // combinaison du
												// joueur
												// meilleure que
												// combinaison a
												// comparer
					c = j.getM(); // Nouvelle combinaison a
									// comparer
				gagnant = j; // Gagnant provisoire
			}
		}

		return gagnant;
	}

	public void tourSuivant() { // Pas une m�thode de Table car on part du
								// principe que c'est le controller qui cadence
								// la partie
		if (verifierGagnant() == null && miseEnAttente() == -1) {
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
	}

	public void relancerManche() {
		distribuerGains();
		maTable.resetCartes(); // D�barasse la table
		maTable.setTour(0);
		for (Joueur j : maTable.getJoueurs()) { // On vire tous ceux qui ont
												// plus de sous ou sont passer
												// spec ou on d�co
			if (!j.getEtat() || j.getCreditPartie() <= maTable.getBigBlind())
				maTable.quitter(j);
		}
		maTable.setPaq(new Paquet("Jeu de 52 cartes de la table " + maTable.getId()));
	}

	public void distribuerGains() {
		Joueur gagnant = verifierGagnant();
		gagnant.setCreditPartie(gagnant.getCreditPartie() + maTable.getPot());
		maTable.setPot(0);
	}

	public Joueur joueurSuivant() {

		Joueur next = new Joueur();
		int nextIdx;

		for (Joueur j : maTable.getJoueursEnJeu()) {
			if (maTable.getTour() != 4 && j.getRole() == "Petite blinde" && !j.getaSuivi()) {
				nextIdx = maTable.getJoueursEnJeu().indexOf(j);
				// enablebouton(Joueur j)
				parler(j);
				// disableBouton(Joueur j)
				next = maTable.getJoueursEnJeu().get(nextIdx);
			}
		}

		return next;
	}

	public void parler(Joueur j) {
		// TODO: enableBuutton + action listener + action + disablebutton
	}

	/* Retourne -1 si tous les joueurs en jeu n'ont pas encore suivi */
	public int miseEnAttente() {
		for (Joueur j : maTable.getJoueursEnJeu()) {
			if (!j.getaSuivi())
				return -1;
		}
		return 1;
	}
}

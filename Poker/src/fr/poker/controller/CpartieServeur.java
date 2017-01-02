package fr.poker.controller;

import fr.poker.model.*;

public class CpartieServeur implements Runnable {
	public Salle maSalle;
	public Table maTable;
	private JoueurServeur joueurCourant;
	private boolean joueurCourantParle;

	public CpartieServeur(Table t, Salle salle) {
		super();
		maTable = t;
		maSalle = salle;
		(new Thread(this)).start();
		joueurCourantParle = false;
	}

	public void distribuerRole(Table table) {
		for (int i = 0; i < maTable.getJoueurs().size(); i++) {

			JoueurServeur j = maTable.getJoueurs().get(i);

			if (maTable.getJoueurs().size() < 3) {
				switch (i) {
				case 0:
					j.setRole("Petite blinde");
					System.out.println(j.getPseudo() + " est petite blinde");
					j.miser(maTable.getSmallBlind());
					parler(j);
					break;
				case 1:
					j.setRole("Grosse blinde");
					System.out.println(j.getPseudo() + " est grosse blinde");
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
					System.out.println(j.getPseudo() + " est dealer");
					break;
				case 1:
					j.setRole("Petite blinde");
					System.out.println(j.getPseudo() + " est petite blinde");
					j.miser(maTable.getSmallBlind());
					break;
				case 2:
					j.setRole("Grosse blinde");
					System.out.println(j.getPseudo() + " est grosse blinde");
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
				for (JoueurServeur j : maTable.getJoueursAttente()) {
					maTable.rejoindre(j);
					maTable.getJoueursAttente().remove(j);
				}
			}
			/* Distribution initiale de 2 cartes a chaque joueur */
			maSalle.notifierLesJoueurs(ConstantesClient.NOTIFICATIONSPARTIE + " " + "Distribution%des%cartes");
			for (JoueurServeur j : maTable.getJoueurs()) {
				j.addCarte(maTable.getPaq().piocher());
				j.getOut().println(ConstantesClient.MESCARTES+" "+j.getCartes().get(0).toString());
				j.addCarte(maTable.getPaq().piocher());
				j.getOut().println(ConstantesClient.MESCARTES+" "+j.getCartes().get(1).toString());
				maSalle.notifierLesJoueurs(ConstantesClient.CARTESJOUEURS+" "+j.getCartes().get(0).toString());
				attendre(1000);				
				maSalle.notifierLesJoueurs(ConstantesClient.CARTESJOUEURS+" "+j.getCartes().get(1).toString());
				System.out.println(j.getPseudo()+" pioche le "+j.getCartes().get(0).toString()+" et le "+j.getCartes().get(1).toString());

			}
			maSalle.notifierLesJoueurs(ConstantesClient.DISTRIBUTION + " ");
		}
		if (maTable.getTour() == 1) { // FLOP --> 3 Cartes
			for (JoueurServeur j : maTable.getJoueurs()) {
				System.out.println("FLOP!!!!!!!!!!!!!!!!!!!!!!");
				j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE + " " + "FLOP");
			}
			for (int i = 1; i < 4; i++) {
				maTable.addCarte(maTable.getPaq().piocher());
			}
			maSalle.notifierLesJoueurs(ConstantesClient.CARTETABLE + " " + maTable.getCartes().get(0).toString());
			attendre(1000);
			maSalle.notifierLesJoueurs(ConstantesClient.CARTETABLE + " " + maTable.getCartes().get(1).toString());
			attendre(1000);
			maSalle.notifierLesJoueurs(ConstantesClient.CARTETABLE + " " + maTable.getCartes().get(2).toString());
		}
		if (maTable.getTour() == 2) {// TURN --> 1 Carte
			for (JoueurServeur j : maTable.getJoueurs()) {
				System.out.println("TURN!!!!!!!!!!!!!!!!!!!!!!");
				j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE + " " + "TURN");
			}
			maTable.addCarte(maTable.getPaq().piocher());
			maSalle.notifierLesJoueurs(ConstantesClient.CARTETABLE + " " + maTable.getCartes().get(3).toString());
		}
		if (maTable.getTour() == 3) {// RIVER --> 1 Carte
			for (JoueurServeur j : maTable.getJoueurs()) {
				System.out.println("RIVER!!!!!!!!!!!!!!!!!!!!!!");
				j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE + " " + "RIVER");
			}
			maTable.addCarte(maTable.getPaq().piocher());
			maSalle.notifierLesJoueurs(ConstantesClient.CARTETABLE + " " + maTable.getCartes().get(4).toString());
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
				// if (j.getBestCombinaison().compareTo(c) > 0) // combinaison
				// du
				// joueur
				// meilleure que
				// combinaison a
				// comparer
				// c = j.getBestCombinaison(); // Nouvelle combinaison a
				// comparer
				gagnant = j; // Gagnant provisoire
				// }
			}

			return gagnant;
		}
		return gagnant;
	}

	public void tourSuivant() { // Pas une m�thode de Table car on part du
								// principe que c'est le controller qui cadence
								// la partie
		if (verifierGagnant() == null && miseEnAttente() == 1) {
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
		maTable.setPot(0.0);
	}

	public Joueur joueurSuivant() {

		Joueur next = new Joueur();
		int nextIdx;
		for (JoueurServeur j : maTable.getJoueursEnJeu()) {
			if (maTable.getTour() != 4) {
				if (j.getRole() == "Petite blinde")
					parler(j);
				nextIdx = maTable.getJoueursEnJeu().indexOf(j);
				joueurCourantParle = true;
				System.out.println(j.getPseudo() + " parle...");
				maSalle.notifierLesJoueurs(ConstantesClient.NOTIFICATIONSPARTIE + " " + j.getPseudo() + "%parle...");
				while (isJoueurCourantParle() != false) {
					parler(j);
				} // En attente de la décision du joueur
				j.getOut().println(ConstantesClient.SILENCE + " ");
				attendre(3000);
				if (maTable.getJoueursEnJeu().size() != 0 && nextIdx != maTable.getJoueursEnJeu().size())
					next = maTable.getJoueursEnJeu().get(nextIdx);
			}
		}
		return next;
	}

	public JoueurServeur getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(JoueurServeur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

	public boolean isJoueurCourantParle() {
		return joueurCourantParle;
	}

	public void setJoueurCourantParle(boolean joueurCourantParle) {
		this.joueurCourantParle = joueurCourantParle;
	}

	public void parler(JoueurServeur j) {
		j.getOut().println(ConstantesClient.JOUE);
	}

	/*Retourne -1 si un joueur n'a pas encore suivi*/
	public int miseEnAttente() {
		for (JoueurServeur j : maTable.getJoueursEnJeu()) {
			if (j.getMise() < maTable.getBestMise())
				return -1;
		}
		return 1;
	}

	public void attendre(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void run() {

		maTable.setTour(0);
		maTable.setPot(0.0);

		Joueur winner = new Joueur();

		/* On attend les joueurs */
		/* TODO : changer le nombre de joueurs mini dans la boucle */
		/* On commence la partie dès qu'il y a trois joueurs */
		do {
			System.out.println("En attente");
			System.out.println("Il n'y a que " + maTable.getJoueurs().size() + " joueurs à la table");
			attendre(3000);
		} while (maTable.getJoueurs().size() < 3);

		System.out.println("Début de la nouvelle partie");
		for (JoueurServeur j : maTable.getJoueurs()) {
			j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE + " Début%de%la%nouvelle%partie");
		}

		if (maTable.getJoueurs().size() > 1) {
			distribuerRole(maTable);
			do {
				maSalle.notifierLesJoueurs(ConstantesClient.POT + " " + Double.toString(maTable.getPot()));
				distribuerCartes();
				

				while (miseEnAttente() == -1) {
					joueurSuivant();
					try {
						Thread.sleep(1000);
					} catch (Exception exc) {
						exc.printStackTrace();
					}
				}
				winner = verifierGagnant();
				tourSuivant();
			} while (winner == null);
			System.out.println("GAGNANT : " + winner.getPseudo());
			maSalle.setFinPartie(true);
		} else
			System.out.println("C'est dommage tu es tout seul");

	}

}

package fr.poker.model;

import java.util.*;

public class Table {
	private int id;
	private int placeMax;
	private List<Carte> cartes;
	private ArrayList<Joueur> joueurs;
	private ArrayList<Joueur> joueursAttente;
	private float smallBlind;
	private float bigBlind;
	private Paquet paq;
	private float pot;
	private int tour; // tour 0: Mise initiale; tour 1: flop(3 cartes); tour 2:
						// Turn(1carte); tour 3: River(1 Carte); tour 4: Pour
						// check le gagnant

	public Table() {
		super();
		this.id = 1; // A g�rer avec la base de donn�es
		this.placeMax = 7;
		this.paq = new Paquet("Jeu de 52 cartes de la table " + id);
		this.joueurs = new ArrayList<Joueur>();
		this.pot = 0;
		this.tour = 0;
		this.smallBlind = (float) 0.5;
		this.bigBlind = 1;
		this.joueursAttente = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paquet getPaq() {
		return paq;
	}

	public void setPaq(Paquet paq) {
		this.paq = paq;
	}

	public int getPlaceMax() {
		return placeMax;
	}

	public void setPlaceMax(int placeMax) {
		this.placeMax = placeMax;
	}

	public ArrayList<Joueur> getJoueursEnJeu() {
		ArrayList<Joueur> list = new ArrayList<Joueur>();
		for (Joueur j : getJoueurs()) {
			if (!j.isDown())
				list.add(j);
		}
		return list;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}

	public void resetCartes() {
		cartes.clear();
	}

	public ArrayList<Joueur> getJoueurs() {
		ArrayList<Joueur> liste = new ArrayList<Joueur>();

		for (Joueur j : this.joueurs) {
			if (j.etat) // en jeu
				liste.add(j);
		}
		return liste;
	}

	public ArrayList<Joueur> getSpectateurs() {
		ArrayList<Joueur> liste = new ArrayList<Joueur>();

		for (Joueur j : this.joueurs) {
			if (!j.etat) // en jeu
				liste.add(j);
		}
		return liste;
	}

	public float getPot() {
		return pot;
	}

	public void setPot(float pot) {
		this.pot = pot;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public float getSmallBlind() {
		return smallBlind;
	}

	public float getBigBlind() {
		return bigBlind;
	}

	public ArrayList<Joueur> getJoueursAttente() {
		return joueursAttente;
	}

	public void setJoueursAttente(ArrayList<Joueur> joueursAttente) {
		this.joueursAttente = joueursAttente;
	}

	public void rejoindre(Joueur j) {
		if (getJoueurs().size() <= placeMax) {
			if (j.getEtat()!= true) { // Si un spectateur veut rejoindre la partie
				joueurs.add(j);
				j.setEtat(false);// Au cas ou etat=null
				System.out.println(j.getPseudo() + " a rejoint la salle en spectateur");
			} else {
				if (j.getCreditPartie()> getBigBlind()) {
					if (tour == 0) {
						joueurs.add(j);
						j.setEtat(true);
						j.setTable(this);
						System.out.println(j.getPseudo() + " a rejoint la table");
					} else {
						if (!joueursAttente.contains(j))
							joueursAttente.add(j);
						System.out.println("Attente du début de la prochaine manche");
					}
				}else
				System.out.println("Vous n'avez pas suffisament de credit pour cette partie");
			}
		} else
			System.out.println("Il n'y a pas suffisament de place à cette table");
	}

	public void quitter(Joueur j) {
		j.etat = false;
		joueurs.remove(j);
	}

	@Override
	public String toString() {
		return "Table [placeMax=" + placeMax + ", cartes=" + cartes + ", joueurs=" + joueurs + ", joueursAttente="
				+ joueursAttente + ", smallBlind=" + smallBlind + ", bigBlind=" + bigBlind + ", pot=" + pot + ", tour="
				+ tour + "]";
	}
	
	

}
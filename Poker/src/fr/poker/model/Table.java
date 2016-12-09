package fr.poker.model;

import java.util.*;

public class Table {
	private int id;
	private int placeMax;
	private List<Carte> cartes;
	private ArrayList<Joueur> joueurs;
	private Paquet paq;
	private float pot;
	public int tour;		// tour 0: Mise initiale; tour 1: flop(3 cartes); tour 2: Turn(1carte); tour 3: River(1 Carte); tour 4: Pour check le gagnant

	public Table(int placeMax) {
		this.id = 1;	// A gérer avec la base de données
		this.placeMax = placeMax;
		this.paq = new Paquet("Jeu de 52 cartes de la table " + id);
		this.pot = 0;
		this.tour = 0;
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

	public int getNbJoueurs() {
		return joueurs.size();
	}
	
	public int getNbJoueursEnJeu(){
		int i = 0;
		for(Joueur j : getJoueurs()){
			if(!j.isDown())
				i++;
		}
		return i;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}
	
	public void resetCartes(){
		cartes.clear();
	}

	public ArrayList<Joueur> getJoueurs() {
		ArrayList<Joueur> liste = new ArrayList<Joueur>();
		
		for(Joueur j : this.joueurs){
			if(j.etat)	//en jeu
				liste.add(j);
		}
		return liste;
	}

	public ArrayList<Joueur> getSpectateurs() {
		ArrayList<Joueur> liste = new ArrayList<Joueur>();
		
		for(Joueur j : this.joueurs){
			if(!j.etat)	//en jeu
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



	public void addJoueur( Joueur joueur) {
		this.joueurs.add(joueur);
	}
	
	public void delJoueur(Joueur joueur){
		this.joueurs.remove(joueur);
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public void rejoindreTable(Joueur j) {
		if (getNbJoueurs() <= placeMax && j.creditPartie > 0 && j.etat && tour==0)
			joueurs.add(j);
		else
			System.out.println("Vous n'avez pas encore votre place a cette table");
	}

	public void quitterTable(Joueur j) {
		j.etat = false;
		joueurs.remove(j);
	}
	
	
}
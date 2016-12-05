package fr.poker.model;

import java.util.*;

public class Table {
	private int id;
	private int placeMax;
	private int nbJoueurs;
	private List<Carte> cartes;
	private List<Joueur> joueurs;
	public int tour;

	public Table(int id, int placeMax) {
		this.id = id;
		this.placeMax = placeMax;
		this.nbJoueurs = 0;
		this.tour = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlaceMax() {
		return placeMax;
	}

	public void setPlaceMax(int placeMax) {
		this.placeMax = placeMax;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void addJoueur( Joueur joueur) {
		this.joueurs.add(joueur);
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public void rejoindreTable(Joueur j) {
		if (nbJoueurs <= placeMax && j.creditPartie > 0) {

			j.etat = true;
			nbJoueurs++;
			joueurs.add(j);
		} else
			System.out.println("Vous n'avez pas votre place a cette table");
	}

	public void quitterTable(Joueur j) {
		j.etat = false;
		nbJoueurs--;
		joueurs.remove(j);
	}
	
	
}
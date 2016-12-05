package fr.poker.model;

import java.util.*;

public class MainJoueur {

	private Joueur joueur;
	private Table table;
	private List<Carte> cartes;
	private AbstractCombinaison bestCombinaison;
	private int nbCartes;
	private int nbCartesMax;

	public MainJoueur(Joueur joueur, Table table) {
		super();
		this.joueur = joueur;
		this.table = table;
		nbCartesMax = 5;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte carte) {
		cartes.add(carte);
	}

	public AbstractCombinaison getBestCombinaison() {
		return bestCombinaison;
	}

	public void setBestCombinaison(AbstractCombinaison bestCombinaison) {
		//TODO: implement
		this.bestCombinaison = bestCombinaison;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public int getNbCartesMax() {
		return nbCartesMax;
	}
	
	
}
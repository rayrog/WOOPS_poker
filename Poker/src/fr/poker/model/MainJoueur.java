package fr.poker.model;

import java.util.*;

public class MainJoueur {

	private Joueur joueur;
	private Table table;
	private List<Carte> cartes; //TODO: transform to a Set
	private AbstractCombinaison bestCombinaison;
	private int nbCartes;
	private int nbCartesMax;

	public MainJoueur(Joueur joueur, Table table) {
		super();
		this.joueur = joueur;
		this.table = table;
		nbCartesMax = 5;
		cartes = joueur.getCartes(); //Ajout des cartes du joueur
		cartes.addAll(2, table.getCartes());	//Ajout des cartes de la table
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void refresh() {
		cartes.addAll(table.getCartes());	//Ajout des cartes de la table
	}

	public void addCarte(Carte carte) {
		cartes.add(carte);
	}

	public AbstractCombinaison getBestCombinaison() {
		return bestCombinaison;
	}

	public void setBestCombinaison() {
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

	public Table getTable() {
		return table;
	}

	@Override
	public String toString() {
		return "MainJoueur [joueur=" + joueur + ", table=" + table + ", cartes=" + cartes + ", bestCombinaison="
				+ bestCombinaison + ", nbCartes=" + nbCartes + ", nbCartesMax=" + nbCartesMax + "]";
	}	
	
}
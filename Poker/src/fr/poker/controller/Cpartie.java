package fr.poker.controller;

import java.util.ArrayList;

import fr.poker.model.Joueur;

public class Cpartie {

	private ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();

	public Cpartie(ArrayList<Joueur> Joueurs) {
		this.mesJoueurs = Joueurs;
	}

	public void run() {

		for (int i = 0; i < mesJoueurs.size(); i++) {

			Joueur currentJ = mesJoueurs.get(i);
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

}

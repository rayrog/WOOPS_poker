package fr.poker.controller;

import java.util.ArrayList;
import java.util.List;

import fr.poker.model.*;


public class Cdistribuer2cartes {

	private List<Carte> listCartes;
	private ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
	Paquet CurrentPaq;
	private Carte carte1;
	private Carte carte2;
//	
	public Cdistribuer2cartes(ArrayList<Joueur> Joueurs,Paquet paq) {
		mesJoueurs = Joueurs;
		CurrentPaq=paq;
	}
	
	public ArrayList<Joueur> run(){
		// Je pioche 2 cartes et je crée une liste avec.
		System.out.println(CurrentPaq);
		carte1=CurrentPaq.piocher();
		listCartes.add(carte1);
		carte2=CurrentPaq.piocher();
		listCartes.add(carte2);
		System.out.println(listCartes);
		
		
		for (int i = 0; i < mesJoueurs.size(); i++) {
			Joueur currentJ = mesJoueurs.get(i);
			
			//currentJ.setCartes(carteTemp);
			
		}
		return mesJoueurs;
	}
}

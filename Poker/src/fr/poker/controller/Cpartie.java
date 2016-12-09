package fr.poker.controller;

import fr.poker.model.*;

public class Cpartie {

	private Table maTable;
	Paquet paq = new Paquet("Jeu de 52 cartes");

	public Cpartie(Table maTable, int nbJoueurs) {
		this.maTable = new Table(nbJoueurs);
	}

	public void run() {

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
		if(maTable.getTour() == 0){ // Distribution initiale de 2 cartes a chaque joueur 
			for (Joueur j : maTable.getJoueurs()) {
				j.addCarte(paq.piocher());
				j.addCarte(paq.piocher());
			}
		}
		if (maTable.getTour() == 1) { // FLOP --> 3 Cartes
			for (int i = 1; i < 4; i++) {
				maTable.addCarte(paq.piocher());
			}
		}
		if (maTable.getTour() == 2) // TURN --> 1 Carte
			maTable.addCarte(paq.piocher());

		if (maTable.getTour() == 3) // RIVER --> 1 Carte
			maTable.addCarte(paq.piocher());
	}
	
	public Joueur verifierGagnant(){
		Joueur gagnant = new Joueur();
		AbstractCombinaison c = new MainHaute();//Main la plus pourrie
		
		if(maTable.getNbJoueurs() == 1)		//Si le joueur est assis tout seul a la table (si tous les autres se déco)
			gagnant = maTable.getJoueurs().get(0);	//le gagnant est le restant
		
		if(maTable.getNbJoueursEnJeu() == 1){		//ou tous les autres sont couchés
			for(Joueur j : maTable.getJoueurs()){
				if(!j.isDown())
					gagnant = j;
			}
		}
		if(maTable.getTour() == 4){		//Fin de la manche (toutes les cartes ont ete distribuees)
			for(Joueur j : maTable.getJoueurs()){
				if(j.getBestCombinaison().compareTo(c) > 0) //combinaison du joueur meilleure que combinaison a comparer
					c = j.getBestCombinaison(); //Nouvelle combinaison a comparer
					gagnant = j;				//Gagnant provisoire
			}
		}
		
		 return gagnant;
	}
	
	public void relancerManche(){
		//TODO: implement
	}
	
	

}

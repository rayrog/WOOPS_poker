package fr.poker.model;

import java.util.*;

public class Joueur {

	private int id; // Pour identifier un joueur dans une partie
	private Compte compte; // Pour définir sur quel compte le joueur joue
	private int creditPartie; // Cagnotte avec laquelle le joueur décide de
								// commencer la partie
	private boolean etat; // True = en jeu ; False = Spectateur
	private String role; // Dealer, petite blinde, grosse blinde, neutre
	private boolean isDown; // True = couché; false = en jeu
	private int aSuivi; // Index pour savoir si le joueur a jouer depuis une ou
						// plusieurs relances
	private List<Carte> cartes; // Cartes distribuées au joueur au début de la
								// partie

	private AbstractCombinaison bestCombinaison; // Meilleure combinaison de 5 cartes de la table(3) et du joueur(2)

	float mise; // A voir si la liste est la meilleure solution 

	/* Joueur de base*/
	public Joueur(int id, Compte compte, int creditPartie, boolean etat) { 
		this.id = id;
		this.compte = compte;
		this.creditPartie = creditPartie;		
		if(creditPartie == 0) // si crédit nul le joueur est d'office spectateur
			this.etat = false;
		else
			this.etat = etat;
	}
	
	/* Joueur avec un role affecté (Ex: Création d'un dealer) */

	public Joueur(int id, Compte compte, int creditPartie, boolean etat, String role) {
		this.id = id;
		this.compte = compte;
		this.creditPartie = creditPartie;
		if(creditPartie == 0) // si crédit nul le joueur est d'office spectateur
			this.etat = false;
		else{
			this.etat = etat;
			this.role = role;
		}
	}


	public float miser(float montant) { // Float pour pouvoir miser des petites somme (Ex: 0.5€)
		if(creditPartie - montant >= 0){
			creditPartie -= montant;
			mise = montant;	
			return mise;
		} else{ 
			System.out.println("Credit insuffisant");
			return -1;
		}
	}

	public float relancer(float montant) {
		if(creditPartie - montant >= 0){
			creditPartie -= montant;
			mise += montant;	
			return mise;
		} else{ 
			System.out.println("Credit insuffisant");
			return -1;
		}
	}

	public void coucher() {
		isDown = true;
	}

	public void quitterTable() {
		etat = false;
	}

	public void quitterSalle() {
		//TODO : a gérer avec la base de données pour éviter de supprimer toutes les infos du joueurs (stats)
	}
	
	public void getInfos(){
		System.out.println("Compte : "+ compte );
		System.out.println("Credit restants : " + creditPartie);
		if(etat == true){
			System.out.println("En jeu");
			System.out.println("Role : " + role);
		}
		else
			System.out.println("Spectateur");
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", compte=" + compte + ", creditPartie=" + creditPartie + ", etat=" + etat
				+ ", role=" + role + ", isDown=" + isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes
				+ ", bestCombinaison=" + bestCombinaison + ", mise=" + mise + "]";
	}

	/*
	@Override
	public String toString() {
		String joueur ="Joueur [id=" + id + ", compte=" + compte + ", creditPartie=" + creditPartie;
		
		if(etat = true){
			joueur += ". ,En jeu en tant que " + role +",";
		}
		else
			joueur += " ,Spectateur,";
		joueur += " role=" + role + ", isDown=" + isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes + ", bestCombinaison=" + bestCombinaison + ", mise=" + mise + "]";
		
		return joueur;
	}*/
}
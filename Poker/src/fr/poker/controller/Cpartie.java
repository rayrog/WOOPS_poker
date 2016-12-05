package fr.poker.controller;
import java.awt.List;
// cette class va nous permettre de repartir les roles
import java.io.BufferedReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
//import fr.poker.vue; // mettre l'import du bon IHM
import fr.poker.controller.Clanceur;

import fr.poker.model.Carte;
import fr.poker.model.Paquet;
import fr.poker.model.Joueur;

public class Cpartie extends Thread {

	ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
	
	public Cpartie(ArrayList<Joueur> Joueurs) {
		this.mesJoueurs = Joueurs;
	}
	public void run() {
	
		for (int i=0; i < mesJoueurs.size(); i++){	// Je parcours ma liste de joueur
			System.out.println("Je suis actuellement sur ce joueur: "+Joueur.get(compte));
			if(i==0){
				mesJoueurs.setAttribute(role,"dealeur");
			}
			else{
				if(i==1){
					mesJoueurs.setAttribute(role,"petite blind");
				}
				else{
					if(i==2){
						mesJoueurs.setAttribute(role,"grosse blind");
					}
					else{		// Sinon ils n'ont pas de roles les gens
						mesJoueurs.setAttribute(role,"pas de role");
					}
				}
			}
			
			
		}
		// Il faut des getters et setters
	}
	
}

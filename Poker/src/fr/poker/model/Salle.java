package fr.poker.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import fr.poker.controller.CpartieServeur;

public class Salle{
	private int id;
	private String nom;
	private int privat; // 1: salle privee ; 0: salle publique
	private String hash;
	public Table table;
	private int numSuivantJoueur = 0;
	private boolean ajoutSuccess;
	private CpartieServeur maPartie;
	private int monPort;
	private boolean finPartie;
	private ArrayList<JoueurServeur> joueurs;

	public Salle(String nom, int privat, String hash, int port) {
		super();
		this.nom = nom;
		this.privat = privat;
		if (privat==1)
			this.hash = hash;
		this.table = new Table(this);
		this.monPort = port;
		this.joueurs = new ArrayList<JoueurServeur>();
		this.maPartie = new CpartieServeur(this);
		this.finPartie = false;
		this.ajoutSuccess = false;
	}
	
	//TODO : POUR TESTS A SUPPRIMER
	public static void main(String[] args) throws Exception {
		int port = 4555;
		Salle newSalle = new Salle("salleTest", 0, "", port);
		ServerSocket  receptionniste =  new ServerSocket(port);
		//Maximum 10 joueurs dans la salle
		JoueurServeur[] lesJoueurs = new JoueurServeur[10];
		System.out.println(newSalle.finPartie);
		while(!newSalle.finPartie ) newSalle.ajouterJoueur(receptionniste.accept());
	}
	
	public void ajouterJoueur (Socket socket) throws Exception {
		//Process ajout nouveau joueur à la salle
		numSuivantJoueur++;
		JoueurServeur newJoueur = new JoueurServeur(socket, this);
		while(!ajoutSuccess){
			//attendre(1000);
			System.out.println("On attend la réponse du joueur pour sa création");
			System.out.println(ajoutSuccess);
			//attendre(1000);
		}
		joueurs.add(newJoueur);
		//Envois des adversaires au nouvel arrivant
		for(Joueur jenjeu : table.getJoueurs()){
			newJoueur.getOut().println(ConstantesClient.NOUVEL_ADVERSAIRE+" "+jenjeu.getNumeroJoueurTable()+" "+jenjeu.getPseudo()+" "+jenjeu.creditPartie);
		}
		ajoutSuccess = false;
		//System.out.println("Nouveau joueur ajouter avec succès!!!");
		notifierLesJoueurs(ConstantesClient.NOTIFICATIONSSALLE+" "+newJoueur.getPseudo()+"%a%rejoint%la%salle");
	}

	public boolean isAjoutSuccess() {
		return ajoutSuccess;
	}


	public void rejoindre(JoueurServeur j) {
		if (this.privat == 1) {
			System.out.println("Cette partie est priv�e. Veuillez entrer le mot de passe : ");
			Scanner sc = new Scanner(System.in);
			String h = sc.nextLine();
			if (h == this.getHash()) { // Si c'est le bon mdp il entre en
										// spectateur
				j.setEtat(false);
				this.getTable().rejoindre(j);
			}
		} else {
			this.getTable().rejoindre(j);
		}
	}

	public void quitter(JoueurServeur j) throws Exception {
		j.out.close();
		j.in.close();
		notifierLesJoueurs(ConstantesClient.NOTIFICATIONSSALLE+" "+j.getPseudo()+"%a%quitter%la%salle");
		joueurs.remove(j);
	}

	public void inviter() {
		// TODO: implement
	}
	
	public void lancement() throws Exception{
		int port = 4555;
		ServerSocket  receptionniste =  new ServerSocket(port);
		System.out.println(receptionniste);
		//Maximum 10 joueurs dans la salle
		while(!this.finPartie ) ajouterJoueur(receptionniste.accept());
	}
	
	public void notifierLesJoueurs(String message){
		for(JoueurServeur j : joueurs){
			j.getOut().println(message);
			
		}
	}
	
	public void attendre(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public CpartieServeur getMaPartie() {
		return maPartie;
	}

	public void setMaPartie(CpartieServeur maPartie) {
		this.maPartie = maPartie;
	}

	public int getMonPort() {
		return monPort;
	}

	public void setMonPort(int monPort) {
		this.monPort = monPort;
	}

	public boolean isFinPartie() {
		return finPartie;
	}

	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int isPrivat() {
		return privat;
	}

	public void setPrivat(int privat) {
		this.privat = privat;
	}

	public String getHash() {
		return hash;
	}

	public Table getTable() {
		return table;
	}

	public void setAjoutSuccess(boolean ajoutSuccess) {
		this.ajoutSuccess = ajoutSuccess;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	public int getNumSuivantJoueur() {
		return numSuivantJoueur;
	}

	public void setNumSuivantJoueur(int numSuivantJoueur) {
		this.numSuivantJoueur = numSuivantJoueur;
	}
	
	public ArrayList<JoueurServeur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<JoueurServeur> joueurs) {
		this.joueurs = joueurs;
	}
}
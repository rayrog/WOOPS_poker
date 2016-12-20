package fr.poker.model;

import java.util.*;

public class Salle {
	private int id;
	private String nom;
	private boolean privat; // 1: salle privee ; 0: salle publique
	private String hash;
	public Table table;

	public Salle(String nom, boolean privat, String hash) {
		this.nom = nom;
		this.privat = privat;
		if (privat)
			this.hash = hash;
		this.table = new Table();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isPrivat() {
		return privat;
	}

	public void setPrivat(boolean privat) {
		this.privat = privat;
	}

	public String getHash() {
		return hash;
	}

	public Table getTable() {
		return table;
	}

	public void rejoindre(Joueur j) {
		if (this.isPrivat()) {
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

	public void quitter(Joueur j) {
		this.getTable().quitter(j);
	}

	public void inviter() {
		// TODO: implement
	}

}
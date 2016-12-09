package fr.poker.model;

import java.util.*;

public class Joueur {

	private int id; // Pour identifier un joueur dans une partie
	protected Compte compte; // Pour d�finir sur quel compte le joueur joue
	protected float creditPartie; // Cagnotte avec laquelle le joueur d�cide de commencer la partie
	protected boolean etat; // True = en jeu ; False = Spectateur
	private String role; // Dealer, Petite blinde, Grosse blinde, Neutre
	private boolean isDown; // True = couch�; false = en jeu
	private int aSuivi; // Index pour savoir si le joueur a jouer depuis une ou plusieurs relances
	private List<Carte> cartes; // Cartes distribu�es au joueur au d�but de la partie

	private MainJoueur m; // Meilleure combinaison de 5 cartes de la table(3) et du joueur(2)

	float mise;
	
	public Joueur(){
		super();
	}

	public Joueur(int id, Compte compte, float creditPartie, boolean etat) {
		super();
		this.id = id;
		this.compte = compte;
		this.creditPartie = creditPartie;
		if (creditPartie == 0) // si cr�dit nul le joueur est d'office spectateur
			this.etat = false;
		else
			this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getCompte() {
		return compte;
	}

	public float getCreditPartie() {
		return creditPartie;
	}

	public void setCreditPartie(float creditPartie) {
		this.creditPartie = creditPartie;
	}

	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public int getaSuivi() {
		return aSuivi;
	}

	public void setaSuivi(int aSuivi) {
		this.aSuivi = aSuivi;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte cartes) {
		this.cartes.add(cartes);
	}

	public AbstractCombinaison getBestCombinaison() {
		return m.getBestCombinaison();
	}

	public float getMise() {
		return mise;
	}

	public float miser(float montant) { // Float pour pouvoir miser des petites somme (Ex: 0.5�)
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise = montant;
			return mise;
		} else {
			System.out.println("Credit insuffisant pour miser " + montant);
			return -1;
		}
	}

	public float relancer(float montant) {
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise += montant;
			return mise;
		} else {
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
		// TODO : a g�rer avec la base de donn�es pour �viter de supprimer toutes les infos du joueurs (stats)
	}

	public void getInfos() {
		System.out.println("Compte : " + compte);
		System.out.println("Credit restants : " + creditPartie);
		if (etat == true) {
			System.out.println("En jeu");
			System.out.println("Role : " + role);
		} else
			System.out.println("Spectateur");
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", compte=" + compte.getPseudo() + ", creditPartie=" + creditPartie + ", etat=" + etat + ", role=" + role + ", isDown=" + isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes + ", bestCombinaison=" + m.getBestCombinaison() + ", mise=" + mise + "]";
	}

	public void setCartes(List<Carte> listeCartes) {
		this.cartes = listeCartes;
	}

	// @Override
	// public String toString() {
	// String joueur = "Joueur [id=" + id + ", compte=" + compte + ", creditPartie=" + creditPartie;
	//
	// if (etat = true) {
	// joueur += ". ,En jeu en tant que " + role + ",";
	// } else
	// joueur += " ,Spectateur,";
	// joueur += " role=" + role + ", isDown=" + isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes + ", bestCombinaison=" + bestCombinaison + ", mise=" + mise + "]";
	//
	// return joueur;
	// }
}
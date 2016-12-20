package fr.poker.model;

import java.util.*;

public class Joueur {

	private int id; // Pour identifier un joueur dans une partie
	protected Compte compte; // Pour d�finir sur quel compte le joueur joue
	protected float creditPartie; // Cagnotte avec laquelle le joueur d�cide de
									// commencer la partie
	protected boolean etat; // True = en jeu ; False = Spectateur
	private String role; // Dealer, Petite blinde, Grosse blinde, Neutre
	private boolean isDown; // True = couch�; false = en jeu
	private boolean aSuivi; // Index pour savoir si le joueur a jouer depuis une ou
						// plusieurs relances
	private List<Carte> cartes; // Cartes distribu�es au joueur au d�but de la
								// partie
	private String pseudo;
	private Table table; // Table sur laquelle le joueur joue

	private MainJoueur m; // Meilleure combinaison de 5 cartes de la table(3) et
							// du joueur(2)

	public float mise;

	public Joueur() {
		super();
	}

	public Joueur(Compte compte, float creditPartie, String pseudo) {
		super();
		this.pseudo = pseudo;
		this.compte = compte;
		this.creditPartie = creditPartie;
		etat = false;
		cartes = new ArrayList<>();
		aSuivi = false;
	}

	public void parler(){
		
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

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public boolean getaSuivi() {
		return aSuivi;
	}

	public void setaSuivi(boolean aSuivi) {
		this.aSuivi = aSuivi;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte c) {
		cartes.add(c);
	}

	public AbstractCombinaison getBestCombinaison() {
		return m.getBestCombinaison();
	}

	public float getMise() {
		return mise;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void miser(float montant) { // Float pour pouvoir miser des petites
										// somme (Ex: 0.5euro)
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise = montant;
			setaSuivi(true);
		} else {
			System.out.println("Credit insuffisant pour miser " + montant);
		}
	}

	public void relancer(float montant) {
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise += montant;
			for(Joueur j : table.getJoueursEnJeu()){ //On réinitialise le flag aSuivi en cas de relance
				j.setaSuivi(false);
			}
			setaSuivi(true);
		} else {
			System.out.println("Credit insuffisant");
		}
	}
	
	public float suivre(float montantPrecedent){  // Pour utiliser cette fonction il faut faire un getMise() 
		if (creditPartie - montantPrecedent >= 0) {  // sur le joueur précedent et le proposer en parametre.
			mise += montantPrecedent;
			setaSuivi(true);
			return 1;
		}
		else{
		System.out.println("Credit insuffisant");
		setaSuivi(false);
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
		// TODO : a g�rer avec la base de donn�es pour �viter de supprimer
		// toutes les infos du joueurs (stats)
	}
	
	public void getInfos() {
		System.out.println("Compte : " + compte.getNom());
		System.out.println("Credit restants : " + creditPartie);
		if (etat == true) {
			System.out.println("En jeu");
			System.out.println("Role : " + role);
			System.out.println("Cartes : " + cartes);
			System.out.println();
		} else
			System.out.println("Spectateur");
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", creditPartie=" + creditPartie + ", etat=" + etat
				+ ", role=" + role + ", isDown=" + isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes + ", pseudo="
				+ pseudo + ", table=" + table + ", m=" + m + ", mise=" + mise + "]";
	}

	public void setCartes(List<Carte> listeCartes) {
		this.cartes = listeCartes;
	}
	
	
}
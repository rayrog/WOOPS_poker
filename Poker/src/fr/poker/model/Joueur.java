package fr.poker.model;

import java.util.*;

public class Joueur {

	protected int id; // Pour identifier un joueur dans une partie
	protected Compte compte; // Pour d�finir sur quel compte le joueur joue
	protected Double creditPartie; // Cagnotte avec laquelle le joueur d�cide de
									// commencer la partie
	private int numeroJoueurTable;
	private boolean jouer;  //a la fonction de token
	private boolean tourGagne;
	private boolean tourFini;
	private boolean partieGagne;
	protected boolean partieFinie;
	protected boolean etat; // True = en jeu ; False = Spectateur
	private String role; // Dealer, Petite blinde, Grosse blinde, Neutre
	private boolean isDown; // True = couch�; false = en jeu
	private boolean aSuivi; // Index pour savoir si le joueur a jouer depuis une
							// ou
	// plusieurs relances
	private List<Carte> cartes; // Cartes distribu�es au joueur au d�but de la
								// partie
	private String pseudo;
	private Table table; // Table sur laquelle le joueur joue
	public ArrayList<Joueur> adversaires;
	private AbstractCombinaison m; // Meilleure combinaison de 5 cartes de la
									// table(3) et
	// du joueur(2)

	public Double mise;

	public Joueur() {
		super();
		this.partieFinie = false;
		adversaires = new ArrayList<Joueur>();
		this.cartes = new ArrayList<Carte>();
		etat = false;
		jouer = false; // CE flag permet de débloquer les boutons de la vue du joueur
		cartes = new ArrayList<>();
		aSuivi = false;
	}

	public Joueur(Compte compte, Double creditPartie, String pseudo) {
		super();
		this.pseudo = pseudo;
		this.compte = compte;
		this.creditPartie = creditPartie;
		this.partieFinie = false;
		this.adversaires = new ArrayList<Joueur>();
		this.cartes = new ArrayList<Carte>();
		etat = false;
		jouer = false; // CE flag permet de débloquer les boutons de la vue du joueur
		cartes = new ArrayList<>();
		aSuivi = false;
	}

	public int getId() {
		return id;
	}

	public Compte getCompte() {
		return compte;
	}

	public Double getCreditPartie() {
		return creditPartie;
	}

	public boolean getEtat() {
		return etat;
	}

	public Table getTable() {
		return table;
	}

	public AbstractCombinaison getM() {
		return m;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public String getRole() {
		return role;
	}

	public boolean getaSuivi() {
		return aSuivi;
	}

	public Double getMise() {
		return mise;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreditPartie(Double creditPartie) {
		this.creditPartie = creditPartie;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void setCartes(List<Carte> listeCartes) {
		this.cartes = listeCartes;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setaSuivi(boolean aSuivi) {
		this.aSuivi = aSuivi;
	}

	public void setM() {

		List<Carte> allCartes = new ArrayList<Carte>();
		System.out.println("---------------------" + allCartes);
		for (Carte c : cartes) { // Cartes du joueur
			if (c != null && !allCartes.contains(c)) {
				allCartes.add(c);
			}
		}
		for (Carte c : table.getCartes()) { // Cartes de la table
			if (c != null && !allCartes.contains(c)) {
				allCartes.add(c);
			}
		}
		System.out.println("---------------------" + allCartes);

		QuinteFlush qfJoueur = new QuinteFlush();
		if (qfJoueur.verifier(allCartes)) {
			m = qfJoueur;
		} else {
			Carre carreJoueur = new Carre();
			if (carreJoueur.verifier(allCartes)) {
				m = carreJoueur;
			} else {
				Full fullJoueur = new Full();
				if (fullJoueur.verifier(allCartes)) {
					m = fullJoueur;
				} else {
					Flush couleurJoueur = new Flush();
					if (couleurJoueur.verifier(allCartes)) {
						m = couleurJoueur;
					} else {
						Quinte suiteJoueur = new Quinte();
						if (suiteJoueur.verifier(allCartes)) {
							m = suiteJoueur;
						} else {
							Brelan brelanJoueur = new Brelan();
							if (brelanJoueur.verifier(allCartes)) {
								m = brelanJoueur;
							} else {
								DoublePaire dpJoueur = new DoublePaire();
								if (dpJoueur.verifier(allCartes)) {
									m = dpJoueur;
								} else {
									Paire paireJoueur = new Paire();
									if (paireJoueur.verifier(allCartes)) {
										m = paireJoueur;
									} else {
										MainHaute rienJoueur = new MainHaute();
										rienJoueur.verifier(allCartes);
										m = rienJoueur;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean isDown() {
		return isDown;
	}

	public void addCarte(Carte c) {
		System.out.println(c.toString());
		cartes.add(c);
	}

	public boolean miser(Double montant) { // Double pour pouvoir miser des petites
										// somme (Ex: 0.5euro)
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise = montant;
			table.setPot(table.getPot() + mise);
			return true;
		}
		System.out.println("Credit insuffisant pour miser " + montant);
		return false;
	}

	public void relancer(Double montant) {
		if (creditPartie - montant >= 0) {
			creditPartie -= montant;
			mise += montant;
			table.setPot(table.getPot() + mise);
			for (Joueur j : table.getJoueursEnJeu()) { // On réinitialise le
														// flag aSuivi en cas de
														// relance
				j.setaSuivi(false);
			}
			setaSuivi(true);
		} else {
			System.out.println("Credit insuffisant");
		}
	}

	public boolean suivre(Double montantPrecedent) { // Pour utiliser cette
													// fonction il faut faire un
													// getMise()
		if (creditPartie - montantPrecedent >= 0) { // sur le joueur précedent
													// et le proposer en
													// parametre.
			mise += montantPrecedent;
			table.setPot(table.getPot() + mise);
			setaSuivi(true);
			return true;
		} else {
			setaSuivi(false);
			return false;
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
			System.out.println("Main : " + m);
			System.out.println();
		} else
			System.out.println("Spectateur");
	}
	
	public int getNumeroJoueurTable() {
		return numeroJoueurTable;
	}

	public void setNumeroJoueurTable(int numeroJoueurTable) {
		this.numeroJoueurTable = numeroJoueurTable;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", creditPartie=" + creditPartie + ", etat=" + etat + ", role=" + role + ", isDown="
				+ isDown + ", aSuivi=" + aSuivi + ", cartes=" + cartes + ", pseudo=" + pseudo + " m=" + m + ", mise="
				+ mise + "]";
	}


}
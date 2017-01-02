package fr.poker.model;

import java.util.*;

public class Table {
	private int id;
	private int placeMax;
	private int gestionPlaces [];
	private List<Carte> cartes;
	private int numSuivantJoueur;
	private ArrayList<JoueurServeur> joueurs;
	private ArrayList<JoueurServeur> joueursAttente;
	private Double smallBlind;
	private Double bigBlind;
	private Paquet paq;
	private Double pot;
	private Salle maSalle;
	private double bestMise;
	private int tour; // tour 0: Mise initiale; tour 1: flop(3 cartes); tour 2:
						// Turn(1carte); tour 3: River(1 Carte); tour 4: Pour
						// check le gagnant

	public Table(Salle salle) {
		super();
		id = 1; // A g�rer avec la base de donn�es
		//TODO : à changer mettre 6 car c'est un tableau (commence par 0)
		placeMax = 2;
		//On tinitialise le tableau de gestion des places
		gestionPlaces = new int[placeMax+1];
		for(int i=0;i<gestionPlaces.length;i++) gestionPlaces[i]=-1;
		paq = new Paquet("Jeu de 52 cartes de la table " + id);
		joueurs = new ArrayList<JoueurServeur>();
		pot = 0.0;
		tour = 0;
		smallBlind = 0.5;
		bigBlind = 1.0;
		joueursAttente = new ArrayList<>();
		cartes = new ArrayList<>();
		this.maSalle = salle;
		bestMise = bigBlind;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paquet getPaq() {
		return paq;
	}

	public void setPaq(Paquet paq) {
		this.paq = paq;
	}

	public int getPlaceMax() {
		return placeMax;
	}

	public void setPlaceMax(int placeMax) {
		this.placeMax = placeMax;
	}

	public ArrayList<JoueurServeur> getJoueursEnJeu() {
		ArrayList<JoueurServeur> list = new ArrayList<JoueurServeur>();
		for (JoueurServeur j : getJoueurs()) {
			if (!j.isDown())
				list.add(j);
		}
		return list;
	}
	
	

	public double getBestMise() {
		return bestMise;
	}

	public void setBestMise(double bestMise) {
		this.bestMise = bestMise;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}

	public void resetCartes() {
		cartes.clear();
	}

/*	public ArrayList<JoueurServeur> getJoueurs() {
		ArrayList<JoueurServeur> liste = new ArrayList<JoueurServeur>();

		for (JoueurServeur j : joueurs) {
			if (j.etat) // en jeu
				liste.add(j);
		}
		return liste;
	}*/
	
	public ArrayList<JoueurServeur> getJoueurs() {
		return joueurs;
	}
	
	public ArrayList<Joueur> getSpectateurs() {
		ArrayList<Joueur> liste = new ArrayList<Joueur>();

		for (Joueur j : this.joueurs) {
			if (!j.etat) // en jeu
				liste.add(j);
		}
		return liste;
	}

	public Double getPot() {
		return pot;
	}

	public void setPot(Double pot) {
		this.pot = pot;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public Double getSmallBlind() {
		return smallBlind;
	}

	public Double getBigBlind() {
		return bigBlind;
	}

	public ArrayList<JoueurServeur> getJoueursAttente() {
		return joueursAttente;
	}

	public void setJoueursAttente(ArrayList<JoueurServeur> joueursAttente) {
		this.joueursAttente = joueursAttente;
	}

	public void rejoindre(JoueurServeur j) {
		System.out.println(getJoueurs().size());
		if (getJoueurs().size() <= placeMax) {
				if (j.getCreditPartie()> getBigBlind()) {
					if (tour == 0) {
						joueurs.add(j);
						//Pour donner un Idtable au joueur
						numSuivantJoueur = findPlace();
						//On réserve la place sur la table
						gestionPlaces[numSuivantJoueur] = 1;
						j.setEtat(true);
						j.setTable(this);
						maSalle.notifierLesJoueurs(ConstantesClient.NOTIFICATIONSSALLE+" "+ j.getPseudo()+"%a%rejoint%la%table");
						j.setNumeroJoueurTable(numSuivantJoueur);
						j.getOut().println(ConstantesClient.MONIDTABLE+" "+numSuivantJoueur);
						//Envois du infos du nouvel arrivant aux joueurs
						maSalle.notifierLesJoueurs(ConstantesClient.NOUVEL_ADVERSAIRE+" "+j.getNumeroJoueurTable()+" "+j.getPseudo()+" "+Double.toString(j.getCreditPartie()));
					} else {
						if (!joueursAttente.contains(j))
							joueursAttente.add(j);
						System.out.println("Attente du début de la prochaine manche");
						j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE+" "+ j.getPseudo()+"Attente%du%début%de%la%prochaine%manche");
					}
				}else{
					System.out.println("Vous n'avez pas suffisament de credit pour cette partie");
					j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE+" "+ j.getPseudo()+"Vous%n'avez%pas%suffisament%de%credit%pour%cette%partie");
				}

		} else {
			System.out.println("Il n'y a pas suffisament de place à cette table");
			j.getOut().println(ConstantesClient.NOTIFICATIONSPARTIE+" "+"Il%n'y%a%pas%suffisament%de%place%à%cette%table");
		}
	}

	public void quitter(Joueur j) {
		j.etat = false;
		//On libére la place sur la table
		gestionPlaces[j.getNumeroJoueurTable()] = -1;
		maSalle.notifierLesJoueurs(ConstantesClient.ADVERSAIRE_OUT+" "+j.getNumeroJoueurTable()+" "+j.getPseudo()+" "+Double.toString(j.getCreditPartie()));
		joueurs.remove(j);
	}
	
	public int findPlace() {
		int i;
		for(i=0 ; i<gestionPlaces.length ; i++){
			if(gestionPlaces[i] == -1)
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Table [placeMax=" + placeMax + ", cartes=" + cartes + ", joueurs=" + joueurs + ", joueursAttente="
				+ joueursAttente + ", smallBlind=" + smallBlind + ", bigBlind=" + bigBlind + ", pot=" + pot + ", tour="
				+ tour + "]";
	}
	
	

}
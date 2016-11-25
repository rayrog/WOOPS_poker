package fr.poker.model;

public enum Couleur {
	COEUR("Coeur",1),
	PIQUE("Pique",2),
	TREFLE("Trefle",3),
	CARREAU("Carreau",4);
	
	private int id;
	private String nom;
	
	Couleur(String nom, int id) {
		this.nom = nom;
		this.id = id;
		
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

}

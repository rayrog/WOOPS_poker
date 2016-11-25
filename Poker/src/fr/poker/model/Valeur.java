package fr.poker.model;

public enum Valeur {
	DEUX("Deux",2),
	TROIS("Trois",3),
	QUATRE("Quatre",4),
	CINQ("Cinq",5),
	SIX("Six",6),
	SEPT("Sept",7),
	HUIT("Huit",8),
	NEUF("Neuf",9),
	DIX("Dix",10),
	VALET("Valet",11),
	DAME("Dame",12),
	ROI("Roi",13),
	AS("As",14)	;
	
	private int valeur;
	private String nom;
	
	Valeur(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public String getNom() {
		return nom;
	}
	
}





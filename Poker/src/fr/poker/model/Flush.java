package fr.poker.model;

import java.util.*;

public class Flush extends AbstractCombinaison {
	private String couleur;

	public Flush() {
		super("Couleur");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res=false;
		if(cartes.size()>4){
			int coeur=0;
			int pique=0;
			int carreau=0;
			int treffle=0;
			for(Carte c : cartes){
				if(c.getCouleur().equals(Couleur.COEUR)){
					coeur++;
				}
				else if(c.getCouleur().equals(Couleur.PIQUE)){
					pique++;
				}
				else if(c.getCouleur().equals(Couleur.TREFLE)){
					treffle++;	
				}
				else {
					carreau++;				
				}
			}
			Collections.sort((ArrayList) cartes);
			res=carreau>4 || coeur > 4 || pique > 4 || treffle > 4;
			if(res){
				List<Carte> cartesCouleur;
				if(carreau>4){
					couleur="Carreau";
					cartesCouleur=conserverCouleur(cartes, Couleur.CARREAU);
				}
				else if(coeur>4){
					couleur="Coeur";
					cartesCouleur=conserverCouleur(cartes, Couleur.COEUR);
				}
				else if(pique>4){
					couleur="Pique";
					cartesCouleur=conserverCouleur(cartes, Couleur.PIQUE);
				}
				else {
					cartesCouleur=conserverCouleur(cartes, Couleur.TREFLE);
					couleur="Trefle";
				}
				Collections.sort(cartesCouleur, new Comparateur());
				List<Valeur> kikers = new ArrayList<Valeur>();
				for(int i=1; i<=5; i++){
					kikers.add(cartesCouleur.get(cartesCouleur.size()-i).getValeur());
				}
				setKikers(kikers);
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "Couleur  "+couleur;
	}

	private List<Carte> conserverCouleur(List<Carte> cartes, Couleur couleur){
		List<Carte> res = new ArrayList<Carte>();
		for(Carte c : cartes){
			if(c.getCouleur().equals(couleur)){
				res.add(c);
			}
		}
		return res;
	}

	@Override
	public int getValeur() {
		return 5;
	}

}

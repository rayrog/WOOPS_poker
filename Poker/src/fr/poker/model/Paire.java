package fr.poker.model;

import java.util.*;

public class Paire extends AbstractCombinaison {
	public Paire() {
		super("Paire");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res=false;
		if(cartes.size()>1){
			for(Valeur v : Valeur.values()){
				if(compterValeur(v, cartes)==2){ //on cherche la valeur de la paire
					setValeurHaute(v); 
					List<Valeur> kikers = new ArrayList<Valeur>();
					Collections.sort(cartes, new Comparateur());
					int size=cartes.size();
					int i=1;
					while(kikers.size()<3 && i<=size){ //Une paire a 3 kikers
						if(size-i>=0 && !cartes.get(size-i).getValeur().equals(v)){ //Si la valeur de la carte est differente de la valeur de la paire
							kikers.add(cartes.get(size-i).getValeur());//on lajoute
						}
						i++;
					}
					setKikers(kikers);
					res=true;
				}
			}
		}
		return res;
	}

	@Override
	public int getValeur() {
		return 1;
	}

	@Override
	public String toString() {
		return "Paire de "+getValeurHaute().getNom().toLowerCase();
	}

}

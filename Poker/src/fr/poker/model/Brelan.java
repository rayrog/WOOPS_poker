package fr.poker.model;

import java.util.*;

public class Brelan extends AbstractCombinaison {
	public Brelan() {
		super("Brelan");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res=false;
		setCombinaisonProche(false);
		if(cartes.size()>2){
			for(Valeur v : Valeur.values()){
				if(compterValeur(v, cartes)==3){
					setValeurHaute(v);
					List<Valeur> kikers = new ArrayList<Valeur>();
					Collections.sort(cartes, new Comparateur());
					int size=cartes.size();
					int i=1;
					while(kikers.size()<2 && i<=size){
						if(!cartes.get(size-i).getValeur().equals(v)){
							kikers.add(cartes.get(size-i).getValeur());
						}
						i++;
					}
					setKikers(kikers);
					res=true;
				}
				if(compterValeur(v, cartes)==2){
					setCombinaisonProche(true);
				}
			}
		}
		return res;
	}

	@Override
	public int getValeur() {
		return 3;
	}

	@Override
	public String getDescription() {
		return "Brelan de "+getValeurHaute().getNom().toLowerCase();
	}

}

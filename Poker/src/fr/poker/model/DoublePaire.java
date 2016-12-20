package fr.poker.model;

import java.util.*;

public class DoublePaire extends AbstractCombinaison {
	public DoublePaire() {
		super("Double paire");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res=false;
		if(cartes.size()>3){
			for(Valeur valeur1 : Valeur.values()){
				for(Valeur valeur2 : Valeur.values()){
					if(valeur1.compareTo(valeur2)>0){
						int cpt1=compterValeur(valeur1, cartes);
						int cpt2=compterValeur(valeur2, cartes);;
						if(cpt1==2 && cpt2==2){
							setValeurHaute(valeur1);
							setValeurBasse(valeur2);
							List<Valeur> kikers = new ArrayList<Valeur>();
							Collections.sort(cartes, new Comparateur());
							int size=cartes.size();
							int i=1;
							while(kikers.size()<1 && i<=size){
								if(!cartes.get(size-i).getValeur().equals(valeur1) && !cartes.get(size-i).getValeur().equals(valeur2)){
									kikers.add(cartes.get(size-i).getValeur());
								}
								i++;
							}
							setKikers(kikers);
							res=true;
						}
					}
				}
			}
		}
		return res;
	}

	@Override
	public String getDescription() {
		return "Double paire : "+getValeurHaute().getNom().toLowerCase()+" et "+getValeurBasse().getNom().toLowerCase();
	}

	@Override
	public int getValeur() {
		return 2;
	}

}

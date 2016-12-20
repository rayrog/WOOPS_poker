package fr.poker.model;

import java.util.*;

public class QuinteFlush extends AbstractCombinaison {
	public QuinteFlush() {
		super("Quinte flush");
	}
	@Override
	public boolean verifier(List<Carte> cartes) {
		int cpt=0;
		if(cartes.size()>4){
			Collections.sort((ArrayList) cartes);
			List<Integer> differences = new ArrayList<Integer>();
			for (int i=1; i<cartes.size(); i++){
				differences.add(cartes.get(i).compareTo(cartes.get(i-1)));
			}
			cpt=0;
			for(int i : differences){
				if(i==1){
					cpt++;
					setValeurHaute(cartes.get(i).getValeur());
				}
				else {
					if(cpt==4){
						return true;
					}
					cpt=0;
				}
			}
		}
		return cpt==4;
	}
	@Override
	public int getValeur() {
		return 8;
	}

	@Override
	public String toString() {
		return "Quinte Flush";
	}


}
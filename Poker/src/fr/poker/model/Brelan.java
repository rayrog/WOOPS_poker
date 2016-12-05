package fr.poker.model;

import java.util.*;

public class Brelan extends AbstractCombinaison {
	public Brelan() {
		super("Brelan");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res = false;
		setCombinaisonProche(false);
		if (cartes.size() > 2) {
			for (Valeur v : Valeur.values()) {
				if (compterValeur(v, cartes) == 3) { // On cherche la valeur du
														// brelan
					setValeurHaute(v);
					List<Valeur> kikers = new ArrayList<Valeur>();
					Collections.sort(cartes, new Comparateur());// trier dans l'ordre
																// croissant
					int size = cartes.size();
					int i;
					for (i = 1; i <= size &&  kikers.size() < 2 ; i++) { //un brelan ne peut pas avoir plus de 2 kikers
						if (!cartes.get(size - i).getValeur().equals(v)) { //si la valeur de la carte n'est pas egale a la valeur du brelan
							kikers.add(cartes.get(size - i).getValeur()); //C'est un kiker
						}
						setKikers(kikers);
						res = true;
					}
					if (compterValeur(v, cartes) == 2) {
						setCombinaisonProche(true);
					}
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
		return "Brelan de " + getValeurHaute().getNom().toLowerCase();
	}

}

package fr.poker.model;

import java.util.*;

public class Carre extends AbstractCombinaison {
	public Carre() {
		super("Carre");
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		boolean res = false;
		setCombinaisonProche(false);
		if (cartes.size() > 3) {
			for (Valeur v : Valeur.values()) {
				if (compterValeur(v, cartes) == 4) { // On cherche la valeur du carre
					setValeurHaute(v);
					List<Valeur> kikers = new ArrayList<Valeur>();
					Collections.sort(cartes, new Comparateur());
					int size = cartes.size();
					int i = 1;
					while (kikers.size() < 1 && i <= size) { // un seul kiker possible
						if (!cartes.get(size - i).getValeur().equals(v)) {
							kikers.add(cartes.get(size - i).getValeur());
						}
						i++;
					}
					setKikers(kikers);
					res = true;
				}
				if (compterValeur(v, cartes) == 3) {
					setCombinaisonProche(true);
				}
			}
		}
		return res;
	}

	@Override
	public String getDescription() {
		return "Carré de " + getValeurHaute().getNom().toLowerCase();
	}

	@Override
	public int getValeur() {
		return 7;
	}

}

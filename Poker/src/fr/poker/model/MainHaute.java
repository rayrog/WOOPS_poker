package fr.poker.model;

import java.util.*;

public class MainHaute extends AbstractCombinaison {
	public MainHaute() {
	super("Carte haute");
}

	@Override
	public int getValeur() {
		return 0;
	}

	@Override
	public boolean verifier(List<Carte> cartes) {
		if (cartes.size() > 0) {
			Collections.sort(cartes, new Comparateur());
			List<Valeur> kikers = new ArrayList<Valeur>();
			int size = cartes.size();
			int i = 1;
			while (size - i >= 0 && kikers.size() < 5) {
				kikers.add(cartes.get(size - i).getValeur());
				i++;
			}
			setKikers(kikers);
		}
		return true;
	}

	@Override
	public String getDescription() {
		return "Aucune combinaison";
	}

}

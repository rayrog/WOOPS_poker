package fr.poker.model;

import java.util.*;

public abstract class AbstractCombinaison implements Comparable<AbstractCombinaison> {

	private String nom;
	private Valeur valeurHaute;
	private Valeur valeurBasse;
	private List<Valeur> kikers;
	private boolean combinaisonProche;

	protected AbstractCombinaison(String nom) {
		this.nom = nom;
	}

	/* Spécifique à chaque combinaison */
	public abstract boolean verifier(List<Carte> cartes);
	public abstract String getDescription();
	public abstract int getValeur();

	/* Compte le nombre de fois qu'une valeur est présente dans une list de cartes*/
	public int compterValeur(Valeur v, List<Carte> cartes) {
		int cpt = 0;
		for (Carte c : cartes) {
			if (c.getValeur().equals(v)) {
				cpt++;
			}
		}
		return cpt;
	}

	/* Compare les kikers de deux combinaisons; retourne 0 si kikers égaux; retourne un negatif si les kikers sont inférieurs aux kikers de l'objet c */
	public int comparerKikers(AbstractCombinaison c) {
		int res = 0;
		if (getKikers() != null) {
			Collections.sort(getKikers()); //On utise Collections et pas List ne peut pas etre sort et pas ArrayList pour eviter les problemes de type
			Collections.sort(c.getKikers());
			int i = 1;
			while (i <= getKikers().size() && res == 0) {
				res = getKikers().get(getKikers().size() - i).compareTo(c.getKikers().get(getKikers().size() - i)); //On compare le plus haut kiker de chaque combinaison jusqu'à trouver
				i++;
			}
		}
		return res;
	}

	@Override
	public int compareTo(AbstractCombinaison c) {
		int res = getValeur() - c.getValeur();
		if (res == 0) {
			if (this instanceof Paire || this instanceof Brelan || this instanceof Carre || this instanceof Quinte
					|| this instanceof QuinteFlush) {
				res = getValeurHaute().compareTo(c.getValeurHaute());
			} else if (this instanceof Full || this instanceof DoublePaire) {
				res = 10 * (getValeurHaute().compareTo(c.getValeurHaute()))
						+ getValeurBasse().compareTo(c.getValeurBasse());
			}
			if (res == 0) {
				res = comparerKikers(c);
			}
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractCombinaison)) {
			return false;
		}
		AbstractCombinaison other = (AbstractCombinaison) obj;
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the kikers
	 */
	public List<Valeur> getKikers() {
		return kikers;
	}

	/**
	 * @param kikers
	 *            the kikers to set
	 */
	public void setKikers(List<Valeur> kikers) {
		this.kikers = kikers;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the valeurHaute
	 */
	public Valeur getValeurHaute() {
		return valeurHaute;
	}

	/**
	 * @param valeurHaute
	 *            the valeurHaute to set
	 */
	public void setValeurHaute(Valeur valeurHaute) {
		this.valeurHaute = valeurHaute;
	}

	/**
	 * @return the valeurBasse
	 */
	public Valeur getValeurBasse() {
		return valeurBasse;
	}

	/**
	 * @param valeurBasse
	 *            the valeurBasse to set
	 */
	public void setValeurBasse(Valeur valeurBasse) {
		this.valeurBasse = valeurBasse;
	}

	public boolean isCombinaisonProche() {
		return combinaisonProche;
	}

	public void setCombinaisonProche(boolean combinaisonProche) {
		this.combinaisonProche = combinaisonProche;
	}
	

}
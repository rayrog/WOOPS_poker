package fr.poker.model;

import java.util.*;

public abstract class AbstractCombinaison implements Comparable<AbstractCombinaison> {

	/* Défini dans les classes filles */
	private String nom;
	private Valeur valeurHaute;
	private Valeur valeurBasse;
	private List<Valeur> kikers;
	private boolean combinaisonProche; // Permet de savoir si on doit vérifier
										// qu'il y a pas une combinaison avec
										// des carte similaires (ex: brelan de 3
										// et carre de 3)

	protected AbstractCombinaison(String nom) {
		this.nom = nom;
	}

	/* Spécifique à chaque combinaison */
	public abstract boolean verifier(List<Carte> cartes);

	public abstract String getDescription();

	/*
	 * rien = 0 ; paire=1; double paire=2 ; brelan=3 ; quinte=4 ; flush=5 ;
	 * full=6 ; carre=7 ; quinte flush=8 ; quinte flush royale=9
	 */
	public abstract int getValeur();

	/*
	 * Compte le nombre de fois qu'une valeur est présente dans une list de
	 * cartes
	 */
	public int compterValeur(Valeur v, List<Carte> cartes) {
		int cpt = 0;
		for (Carte c : cartes) {
			if (c.getValeur().equals(v)) {
				cpt++;
			}
		}
		return cpt;
	}

	/*
	 * Compare les kikers de deux combinaisons; retourne 0 si kikers égaux;
	 * retourne un negatif si les kikers sont inférieurs aux kikers de l'objet c
	 */
	public int comparerKikers(AbstractCombinaison c) {
		int res = 0;
		if (getKikers() != null) {
			Collections.sort(getKikers()); // On utise Collections et pas List
											// ne peut pas etre sort et pas
											// ArrayList pour eviter les
											// problemes de type
			Collections.sort(c.getKikers());
			int i = 1;
			while (i <= getKikers().size() && res == 0) {
				res = getKikers().get(getKikers().size() - i).compareTo(c.getKikers().get(getKikers().size() - i)); // On
																													// compare
																													// le
																													// plus
																													// haut
																													// kiker
																													// de
																													// chaque
																													// combinaison
																													// jusqu'à
																													// trouver
				i++;
			}
		}
		return res;
	}

	/* retourne un negatif si plus petit que la combinaison en parametre, etc */
	@Override
	public int compareTo(AbstractCombinaison c) {
		int res = getValeur() - c.getValeur(); // Compare le poids des
												// combinaisons
		if (res == 0) { // poids égaux
			if (this instanceof Paire || this instanceof Brelan || this instanceof Carre || this instanceof Quinte
					|| this instanceof QuinteFlush) {
				res = getValeurHaute().compareTo(c.getValeurHaute());
			} else if (this instanceof Full || this instanceof DoublePaire) {
				/*
				 * pour plus de granularite on ajoute du poids a la valeur haute
				 */
				res = 10 * (getValeurHaute().compareTo(c.getValeurHaute()))
						+ getValeurBasse().compareTo(c.getValeurBasse());
			}
			if (res == 0) {
				res = comparerKikers(c); // en dernier recours on compare les
											// cartes qui restent
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

	public List<Valeur> getKikers() {
		return kikers;
	}

	public void setKikers(List<Valeur> kikers) {
		this.kikers = kikers;
	}

	public String getNom() {
		return nom;
	}

	public Valeur getValeurHaute() {
		return valeurHaute;
	}

	public void setValeurHaute(Valeur valeurHaute) {
		this.valeurHaute = valeurHaute;
	}

	public Valeur getValeurBasse() {
		return valeurBasse;
	}

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
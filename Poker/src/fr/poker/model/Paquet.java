package fr.poker.model;

import java.util.*;

public class Paquet {


	private String nom;

	private Set<Carte> p = new HashSet<Carte>();


	public Paquet(String nom) {
		super();
		this.nom = nom;
		
		for (Valeur v : Valeur.values()) {
			for (Couleur c : Couleur.values()) {
				p.add(new Carte(c,v));
				//System.out.println("Carte ajout�e : " + v + " de " + c);
			}
		}				
	}

	public Set<Carte> getInstance() {
		return p;
	}

	public Carte piocher() {
		int size = p.size();
		int item = new Random().nextInt(size);
		Carte c = new Carte();
		int i = 0;
		for(Carte o : p)
		{
		    if (i == item && !p.isEmpty()){
		        c = o;
		    	p.remove(o);
		    	return c;
		    }
		    if (p.isEmpty()){
		    	System.out.println("Paquet vide impossible de piocher");
		    	return null;
		    }
		    i = i + 1;
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Paquet [nom=" + nom + ", p=" + p + "]";
	}
}
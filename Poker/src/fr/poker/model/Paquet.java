package fr.poker.model;

import java.util.*;

public class Paquet {


	private String nom;

	private Set<Carte> p = new HashSet<Carte>();


	public Paquet(String nom) {
		this.nom = nom;
		
		for (Valeur v : Valeur.values()) {
			for (Couleur c : Couleur.values()) {
				p.add(new Carte(c,v));
				//System.out.println("Carte ajoutée : " + v + " de " + c);
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
		    if (i == item){
		        c = o;
		    	p.remove(o);
		    	return c;
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
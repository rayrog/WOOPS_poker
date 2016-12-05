package fr.poker.model;
import java.lang.annotation.*;


public class Carte {
   private Couleur couleur;
   private Valeur valeur;
   private boolean active;
   

   @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
	result = prime * result + ((main == null) ? 0 : main.hashCode());
	result = prime * result + ((table == null) ? 0 : table.hashCode());
	result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Carte other = (Carte) obj;
	if (active != other.active)
		return false;
	if (couleur == null) {
		if (other.couleur != null)
			return false;
	} else if (!couleur.equals(other.couleur))
		return false;
	if (main == null) {
		if (other.main != null)
			return false;
	} else if (!main.equals(other.main))
		return false;
	if (table == null) {
		if (other.table != null)
			return false;
	} else if (!table.equals(other.table))
		return false;
	if (valeur == null) {
		if (other.valeur != null)
			return false;
	} else if (!valeur.equals(other.valeur))
		return false;
	return true;
}


   public java.util.Collection<Main> main;
   public java.util.Collection<Table> table;
   
   public Carte(){
	   
   }
   public Carte(Couleur couleur, Valeur valeur) {
      this.couleur = couleur;
      this.valeur = valeur;
   }
   

   public Couleur getCouleur() {
   	return couleur;
   }
   
   public void setCouleur(Couleur couleur) {
      this.couleur = couleur;
   }
   
   public Valeur getValeur() {
   	return valeur;
   }
   
   public void setValeur(Valeur valeur) {
      this.valeur = valeur;
   }
   public boolean readStatus() {
      return active;
   }
   
   public void on() {
      this.active = true; 
   }
   
   public void off() {
      this.active = false; 
   }
   
   public int compareColor(Couleur couleur) {
      this.couleur.compareTo(couleur);
      return 0;
   }
   
   public int compareValue(Valeur valeur) {
      return 0; //to fix
   }
   
   public int compareTo(Carte carte) {
      return valeur.compareTo(carte.getValeur());
   }
   
   @Override
   public String toString() {
   	return valeur.toString()+" de "+couleur.toString();
   }
   
}
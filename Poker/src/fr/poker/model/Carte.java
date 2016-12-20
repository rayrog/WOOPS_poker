package fr.poker.model;


public class Carte {
   private Couleur couleur;
   private Valeur valeur;
   private boolean active;
   
   public Carte(){
	   super();
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
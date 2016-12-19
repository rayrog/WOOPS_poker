package fr.poker.model;

import java.util.*;

public class Salle {
   private int id;
   private String nom;
   private boolean privat;
   private String hash;
   public Table table;
   
   public Salle(String nom, boolean privat, String hash,  Table table) {
      this.nom = nom;
      this.privat = privat;
      if(privat)
    	  this.hash = hash;
      this.table = table;
   }
   	
   
   public void rejoindre(Joueur j) {
	   if(!privat)
		   System.out.println("Attennnnnnd");
   }
   
   public void quitter() {
      // TODO: implement
   }
   
   public void inviter() {
      // TODO: implement
   }

}
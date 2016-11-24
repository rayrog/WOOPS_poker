package fr.poker.model;
/***********************************************************************
 * Module:  Paquet.java
 * Author:  Rayan
 * Purpose: Defines the Class Paquet
 ***********************************************************************/

import java.util.*;

/** @pdOid 2487b722-c118-422b-9dcc-6daf025e2269 */
public class Paquet {
   /** @pdOid 892e1f83-b29a-4817-9281-3057bb58eea5 */
   private int id;
   /** @pdOid 6b58c1a3-7597-4cb0-8e34-050c5a8b59d9 */
   private String nom;
   /** @pdOid e7fdbaf4-8a6a-47ca-9e81-331f453799a1 */
   private Paquet instance;
   
   /** @pdRoleInfo migr=no name=Carte assc=association86 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Carte> carte;
   
   /** @pdOid e0d4bf30-a502-43e4-9c59-eb19f9b03b31 */
   public Paquet() {
      // TODO: implement
   }
   
   /** @pdOid a4e45e78-393c-4491-b089-2201eed8d25b */
   public Paquet creer() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 09a0a13c-d4fa-4c37-baa9-94be59a335d7 */
   public Paquet getInstance() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 69ea103e-318d-43e8-8ee9-374ab4130556 */
   public void melanger() {
      // TODO: implement
   }
   
   /** @pdOid 6b51692a-0786-4c72-a479-19f48ba1cc4c */
   public void trier() {
      // TODO: implement
   }
   
   /** @pdOid 3235c16e-959d-4bdc-b507-b9da62003389 */
   public Carte piocher() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 05e01555-e25c-4c5e-a51b-aae2350b5e45 */
   public String toString() {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Carte> getCarte() {
      if (carte == null)
         carte = new java.util.HashSet<Carte>();
      return carte;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCarte() {
      if (carte == null)
         carte = new java.util.HashSet<Carte>();
      return carte.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCarte */
   public void setCarte(java.util.Collection<Carte> newCarte) {
      removeAllCarte();
      for (java.util.Iterator iter = newCarte.iterator(); iter.hasNext();)
         addCarte((Carte)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCarte */
   public void addCarte(Carte newCarte) {
      if (newCarte == null)
         return;
      if (this.carte == null)
         this.carte = new java.util.HashSet<Carte>();
      if (!this.carte.contains(newCarte))
         this.carte.add(newCarte);
   }
   
   /** @pdGenerated default remove
     * @param oldCarte */
   public void removeCarte(Carte oldCarte) {
      if (oldCarte == null)
         return;
      if (this.carte != null)
         if (this.carte.contains(oldCarte))
            this.carte.remove(oldCarte);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCarte() {
      if (carte != null)
         carte.clear();
   }

}
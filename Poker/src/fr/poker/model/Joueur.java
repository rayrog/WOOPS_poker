package fr.poker.model;
/***********************************************************************
 * Module:  Joueur.java
 * Author:  Rayan
 * Purpose: Defines the Class Joueur
 ***********************************************************************/

import java.util.*;

/** @pdOid fcbf3f3f-553d-4ea7-af34-4c9d1312da0b */
public class Joueur {
   /** @pdOid 02c5da90-19c6-47aa-8911-2417e8ef9421 */
   private int id;
   /** @pdOid 7656f825-f972-4bf7-9d1f-a8ac08055cb1
       @pdRoleInfo migr=yes name=Compte assc=association88 */
   private Compte compte;
   /** @pdOid 9276eb21-41b3-4533-a7e7-6379535feacd */
   private int creditPartie;
   /** @pdOid d6fb2d3a-039a-41d9-94fa-d1d86b1f517c */
   private boolean etat;
   /** @pdOid 15d6b86a-6ee4-4ffe-817b-be99f4312480 */
   private String role;
   /** @pdOid fdca4fbf-54e7-4cd0-8662-7288d6bbaa8a */
   private List<Carte> cartes;
   /** @pdOid 1ad2fcda-6d18-4cc0-a6b9-6b12de4794d5 */
   private boolean isDown;
   /** @pdOid 76a80342-afd2-4c8f-9b3b-73f8b07680a8 */
   private int aSuivi;
   
   /** @pdRoleInfo migr=no name=Main assc=association4 mult=1..* */
   public Main[] main;
   /** @pdRoleInfo migr=no name=Mise assc=miser coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Mise> mise;
   
   /** @param compte
    * @pdOid 63bc88be-38fb-4109-aaa4-38856ccbb39e */
   public Joueur(Compte compte) {
      this.compte = compte;
   }
   
   /** @pdOid 7531516c-de2d-498f-8b3e-ec2935f68af8 */
   public int miser() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 94f35270-088d-4e18-b512-e88a05d26718 */
   public int relancer() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 93c643c2-8bda-45be-a028-4419c81cf480 */
   public void suivre() {
      // TODO: implement
   }
   
   /** @pdOid dffdf20e-e691-4d46-833a-56ea682b5a60 */
   public void coucher() {
      // TODO: implement
   }
   
   /** @pdOid d266064d-d430-4f7b-9cec-05bcedfcb41b */
   public void quitterTable() {
      // TODO: implement
   }
   
   /** @pdOid 88e7e878-54e5-4e20-b0a1-87492370a847 */
   public void quitterSalle() {
      // TODO: implement
   }
   
   /** @pdOid ef96843b-38ff-47bf-9037-1b4400f6a3b4 */
   public int getId() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid b1dcb58d-8adf-43bb-97ad-167f1fe260f8 */
   public boolean getStatus() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 10d8f5eb-b5f0-4780-99e6-b2815d739535 */
   public void setStatus() {
      // TODO: implement
   }
   
   /** @pdOid 48a6e365-a572-4131-98a0-c9af02b18fc7 */
   public String getRole() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid be52fb71-a744-4f6c-8fd8-d9d853e44725 */
   public void setRole() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Mise> getMise() {
      if (mise == null)
         mise = new java.util.HashSet<Mise>();
      return mise;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMise() {
      if (mise == null)
         mise = new java.util.HashSet<Mise>();
      return mise.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMise */
   public void setMise(java.util.Collection<Mise> newMise) {
      removeAllMise();
      for (java.util.Iterator iter = newMise.iterator(); iter.hasNext();)
         addMise((Mise)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMise */
   public void addMise(Mise newMise) {
      if (newMise == null)
         return;
      if (this.mise == null)
         this.mise = new java.util.HashSet<Mise>();
      if (!this.mise.contains(newMise))
         this.mise.add(newMise);
   }
   
   /** @pdGenerated default remove
     * @param oldMise */
   public void removeMise(Mise oldMise) {
      if (oldMise == null)
         return;
      if (this.mise != null)
         if (this.mise.contains(oldMise))
            this.mise.remove(oldMise);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMise() {
      if (mise != null)
         mise.clear();
   }

}
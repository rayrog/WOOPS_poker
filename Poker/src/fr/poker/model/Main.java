package fr.poker.model;
/***********************************************************************
 * Module:  Main.java
 * Author:  Rayan
 * Purpose: Defines the Class Main
 ***********************************************************************/

import java.util.*;

/** @pdOid 5297f71e-4058-45c5-8737-2961cce95442 */
public class Main {
   /** @pdOid 717673b2-dd8e-47f3-8821-10adcd55ae5b */
   private Joueur joueur;
   /** @pdOid 89e5f7ce-0209-4cbc-b462-219945383d02 */
   private List<Carte> cartes;
   /** @pdOid 487b56f0-ce5f-4a9a-9dc4-cd3777fef0e8 */
   private Combinaison bestCombinaison;
   /** @pdOid fc483325-1ca8-4c8e-a9f8-95b230c6cbe4 */
   private int nbCartes;
   /** @pdOid a1d025c9-6c0e-4078-bad5-a4e430a74269 */
   private int nbCartesMax;
   
   /** @pdRoleInfo migr=no name=Tour assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Tour> tour;
   
   /** @pdOid 77c13941-80fd-4886-b5e0-3e84bc528225 */
   public Combinaison getBestCombinaison() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid aa4d0125-40fc-4156-807e-529017e3704a */
   public Combinaison setBestCombinaison() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 5e01baab-0f39-49b7-a53e-8990563c86cf */
   public Carte ajouterCarte() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid aa6a3964-96a5-47f1-93ee-c92d29996194 */
   public Joueur getJoueur() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid f78d86cd-d5e2-474b-a400-31d3f3d87824 */
   public void setJoueur() {
      // TODO: implement
   }
   
   /** @pdOid ff74d0cb-0d49-48f8-96a0-486faad3b4ba */
   public String toString() {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Tour> getTour() {
      if (tour == null)
         tour = new java.util.HashSet<Tour>();
      return tour;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTour() {
      if (tour == null)
         tour = new java.util.HashSet<Tour>();
      return tour.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTour */
   public void setTour(java.util.Collection<Tour> newTour) {
      removeAllTour();
      for (java.util.Iterator iter = newTour.iterator(); iter.hasNext();)
         addTour((Tour)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTour */
   public void addTour(Tour newTour) {
      if (newTour == null)
         return;
      if (this.tour == null)
         this.tour = new java.util.HashSet<Tour>();
      if (!this.tour.contains(newTour))
         this.tour.add(newTour);
   }
   
   /** @pdGenerated default remove
     * @param oldTour */
   public void removeTour(Tour oldTour) {
      if (oldTour == null)
         return;
      if (this.tour != null)
         if (this.tour.contains(oldTour))
            this.tour.remove(oldTour);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTour() {
      if (tour != null)
         tour.clear();
   }

}
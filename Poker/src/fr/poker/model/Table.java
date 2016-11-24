package fr.poker.model;
/***********************************************************************
 * Module:  Table.java
 * Author:  Rayan
 * Purpose: Defines the Class Table
 ***********************************************************************/

import java.util.*;

/** @pdOid 520bf573-e57e-48d8-8447-32e070ce14ec */
public class Table {
   /** @pdOid 3d6e4312-a14a-46c0-8cd7-9ba0658f55a9 */
   private int id;
   /** @pdOid eb89162a-0d1a-4b43-82ab-cdff54983ca8 */
   private String nom;
   /** @pdOid 0c4e6c3c-d864-4114-ab5b-b118b0ff3a18 */
   private int placeMax;
   /** @pdOid 81dd31d3-5637-47f3-801f-878ffc4c4965 */
   private int nbJoueurs;
   /** @pdOid e33934b6-e4c2-4772-8d54-3bc791ec96bb */
   private List<Carte> cartes;
   
   /** @pdRoleInfo migr=no name=Tour assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Tour> tour;
   
   /** @pdOid 96880ee9-c90b-4d99-8084-e614f13b868b */
   public Table() {
      // TODO: implement
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
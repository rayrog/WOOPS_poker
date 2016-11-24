package fr.poker.model;
/***********************************************************************
 * Module:  Pot.java
 * Author:  Rayan
 * Purpose: Defines the Class Pot
 ***********************************************************************/

import java.util.*;

/** @pdOid 13c47b08-d980-4958-ba3e-9d20770bc6a1 */
public class Pot {
   /** @pdOid 2ea8e12a-3479-43a1-8e1a-e5e851bb8d89 */
   private int montant;
   /** @pdOid b19f821f-823a-4b31-9680-f63e9f9a9cb5 */
   private int montantMax;
   
   /** @pdRoleInfo migr=no name=Tour assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Tour> tour;
   
   /** @pdOid 000fb8b3-6345-4b12-b325-0eeacb20c309 */
   public Pot() {
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
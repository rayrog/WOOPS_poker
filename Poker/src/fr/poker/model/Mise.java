package fr.poker.model;
/***********************************************************************
 * Module:  Mise.java
 * Author:  Rayan
 * Purpose: Defines the Class Mise
 ***********************************************************************/

import java.util.*;

/** @pdOid 723cc03b-7917-4aa1-8c78-b95d2a524f87 */
public class Mise {
   /** @pdOid 13f6850d-b2a6-412f-a6f3-2f1566e7c56d */
   private int montant;
   /** @pdOid 9337149a-69df-4603-a199-fc87bf91eee3 */
   private boolean relance;
   
   /** @pdRoleInfo migr=no name=Pot assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   public java.util.Collection<Pot> pot;
   
   /** @pdOid e6497ba1-b4f5-4cad-8e9c-8fdc922b27dc */
   public Mise() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pot> getPot() {
      if (pot == null)
         pot = new java.util.HashSet<Pot>();
      return pot;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPot() {
      if (pot == null)
         pot = new java.util.HashSet<Pot>();
      return pot.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPot */
   public void setPot(java.util.Collection<Pot> newPot) {
      removeAllPot();
      for (java.util.Iterator iter = newPot.iterator(); iter.hasNext();)
         addPot((Pot)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPot */
   public void addPot(Pot newPot) {
      if (newPot == null)
         return;
      if (this.pot == null)
         this.pot = new java.util.HashSet<Pot>();
      if (!this.pot.contains(newPot))
         this.pot.add(newPot);
   }
   
   /** @pdGenerated default remove
     * @param oldPot */
   public void removePot(Pot oldPot) {
      if (oldPot == null)
         return;
      if (this.pot != null)
         if (this.pot.contains(oldPot))
            this.pot.remove(oldPot);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPot() {
      if (pot != null)
         pot.clear();
   }

}
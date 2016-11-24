package fr.poker.model;
/***********************************************************************
 * Module:  Jeton.java
 * Author:  Rayan
 * Purpose: Defines the Class Jeton
 ***********************************************************************/

import java.util.*;

/** @pdOid ee6448e6-8770-4cf2-9219-57cb7a05e634 */
public class Jeton {
   /** @pdOid 9d8e323c-890e-4400-8811-a85106aeac99 */
   private int valeur;
   
   /** @pdRoleInfo migr=no name=Mise assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Mise> mise;
   
   
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
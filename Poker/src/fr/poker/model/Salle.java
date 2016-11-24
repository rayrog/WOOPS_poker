package fr.poker.model;
/***********************************************************************
 * Module:  Salle.java
 * Author:  Rayan
 * Purpose: Defines the Class Salle
 ***********************************************************************/

import java.util.*;

/** @pdOid ffc015c5-a6c1-4d27-80f0-0595862cab1e */
public class Salle {
   /** @pdOid d4883325-80bf-4f68-b978-1001608db312 */
   private int id;
   /** @pdOid 6623902f-5d73-4495-a4a3-3914e1f9b393 */
   private String nom;
   /** @pdOid b06b46f1-afb5-405f-95a9-9080d81e351e */
   private boolean private;
   /** @pdOid d3156aac-5a7a-4a71-bd2e-6e38951a3415 */
   private int hash;
   /** @pdOid eba3bbc9-4ad4-4dc6-be9c-cded7bbe8f11 */
   private boolean mode;
   
   /** @pdRoleInfo migr=no name=Table assc=association7 mult=1..1 type=Aggregation */
   public Table table;
   
   /** @pdOid 294b6f85-68ea-4032-99c7-e89ea3b3798c */
   public Salle() {
      // TODO: implement
   }
   
   /** @pdOid 39eefffb-3618-48ac-9f25-174a61aaf085 */
   public void rejoindre() {
      // TODO: implement
   }
   
   /** @pdOid a09feea6-d17f-46da-a8c5-680b466acabf */
   public void quitter() {
      // TODO: implement
   }
   
   /** @pdOid f888e6d5-6d7a-46b1-9277-3b0d9326881e */
   public void inviter() {
      // TODO: implement
   }

}
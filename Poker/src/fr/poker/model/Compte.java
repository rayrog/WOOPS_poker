package fr.poker.model;
/***********************************************************************
 * Module:  Compte.java
 * Author:  Rayan
 * Purpose: Defines the Class Compte
 ***********************************************************************/

import java.util.*;

/** @pdOid 8902f8c9-f17e-4df7-8098-2aec67d74285 */
public class Compte {
   /** @pdOid 5ec4455c-bc6d-476e-8bee-4c53f9b49756 */
   private int id;
   /** @pdOid 28e6ef37-bcc7-4348-aa48-1016312a1c47 */
   private String pseudo;
   /** @pdOid 89dc4d5f-925f-4aa5-b995-df070b561fac */
   private String nom;
   /** @pdOid 82001975-bef7-4e0b-b4a6-b519361d5a16 */
   private String prenom;
   /** @pdOid 564c8461-4f5b-4167-96f4-52cd4ebc17ac */
   private String mail;
   /** @pdOid 8ef7913c-320e-48e9-9031-463eb921cbfa */
   private int tel;
   /** @pdOid 2872dcf1-66d0-4492-a534-71628307821a */
   private int hash;
   /** @pdOid 1358fb7a-9b9c-4fe4-bb00-d42824686eb7 */
   private int credit;
   /** @pdOid 34249d47-6e4d-4fbd-8b36-269f80caa2a5 */
   private String bio;
   
   /** @pdRoleInfo migr=no name=Joueur assc=association87 mult=0..1 */
   public Joueur joueur;
   
   /** @pdOid f6845131-ad43-49c6-8c01-4b1ab89234a0 */
   public int getId() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 5afbfefb-1e7e-41de-a7bc-413d352f9e9d */
   public int getPseudo() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid c420992b-3dbe-400e-b28c-b1e218857c00 */
   public int setPseudo() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 8dc5015b-6156-4756-bf59-009a9512caa6 */
   public String getNom() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid ab669a86-74c3-49cd-8bfa-e14e989a995e */
   public void setNom() {
      // TODO: implement
   }
   
   /** @pdOid 596f7157-b7de-433c-910a-25415822b112 */
   public String getPrenom() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 990818c3-8883-41e8-ac29-d907ad6eb534 */
   public void setPrenom() {
      // TODO: implement
   }
   
   /** @pdOid c54a5154-96e9-4a39-9974-ed3e409e64e5 */
   public String getMail() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 2580f6ec-2ab8-4164-b447-ad8d53583e12 */
   public void setMail() {
      // TODO: implement
   }
   
   /** @pdOid 8794e7ee-cf18-4a4f-bef3-85632ce9190f */
   public int getTel() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid eb225060-0b93-4341-855b-7e577611d510 */
   public void setTel() {
      // TODO: implement
   }
   
   /** @pdOid 59a520c7-9bf4-4088-a33a-a09b8eb4597d */
   public int getPasswd() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 10508e73-48ec-47b6-8a51-97b250939415 */
   public void setPasswd() {
      // TODO: implement
   }
   
   /** @pdOid c924afd3-5a01-41fd-bbea-d2fb117c8194 */
   public int getCredit() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 6548cd32-6775-497e-b179-e088c5065533 */
   public void setCredit() {
      // TODO: implement
   }
   
   /** @pdOid 24c6a9aa-3eb6-4d7f-9431-c91e12347ef1 */
   public String getBio() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid cfe13f1a-3a00-4702-b1a7-27ba3c4e93d7 */
   public void setBio() {
      // TODO: implement
   }

}
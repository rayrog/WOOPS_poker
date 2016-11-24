package fr.poker.model;
import java.lang.annotation.*;

/** @pdOid 22b229ea-097f-4b98-afff-54343b340760 */
public class Carte {
   /** @pdOid a0aae867-b7ca-44f0-a814-0c52b0348ac8
       @pdRoleInfo migr=yes name=Couleur assc=association13 */
   private Couleur couleur;
   /** @pdOid 8adb50a8-8106-48f4-8de0-166b5e59f26e
       @pdRoleInfo migr=yes name=Valeur assc=association14 */
   private Valeur valeur;
   /** @pdOid f6e4ac22-01d3-4859-99b2-298abec106cb */
   private boolean active;
   
   /** @pdOid 367e7b74-891e-4fc8-af54-e6b5d5daaa1a
       @pdRoleInfo migr=yes name=Carte assc=association32 */
   public static Carte AS_COEUR;
   /** @pdOid 16d7d060-1e27-4206-9d66-90b1c8c51881
       @pdRoleInfo migr=yes name=Carte assc=association33 */
   public static Carte AS_PIQUE;
   /** @pdOid bb71fdd1-ed15-442e-974b-3d4e5218bbda
       @pdRoleInfo migr=yes name=Carte assc=association34 */
   public static Carte AS_TREFLE;
   /** @pdOid d81c80f1-a0f2-4be8-8a37-1e2ec36fa8c1
       @pdRoleInfo migr=yes name=Carte assc=association35 */
   public static Carte AS_CARREAU;
   /** @pdOid a7709f1c-2898-4d87-a8fd-18a198781ae2
       @pdRoleInfo migr=yes name=Carte assc=association36 */
   public static Carte ROI_COEUR;
   /** @pdOid e0f698d9-3baa-462c-90b6-e48a6592854b
       @pdRoleInfo migr=yes name=Carte assc=association37 */
   public static Carte ROI_PIQUE;
   @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
	result = prime * result + ((main == null) ? 0 : main.hashCode());
	result = prime * result + ((table == null) ? 0 : table.hashCode());
	result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Carte other = (Carte) obj;
	if (active != other.active)
		return false;
	if (couleur == null) {
		if (other.couleur != null)
			return false;
	} else if (!couleur.equals(other.couleur))
		return false;
	if (main == null) {
		if (other.main != null)
			return false;
	} else if (!main.equals(other.main))
		return false;
	if (table == null) {
		if (other.table != null)
			return false;
	} else if (!table.equals(other.table))
		return false;
	if (valeur == null) {
		if (other.valeur != null)
			return false;
	} else if (!valeur.equals(other.valeur))
		return false;
	return true;
}

/** @pdOid e6e19525-0886-450f-8cc6-7fc91c8330b9
       @pdRoleInfo migr=yes name=Carte assc=association38 */
   public static Carte ROI_TREFLE;
   /** @pdOid 1b656e09-4a97-46aa-be40-32eb22fff707
       @pdRoleInfo migr=yes name=Carte assc=association39 */
   public static Carte ROI_CARREAU;
   /** @pdOid 84422221-c83a-426f-ad73-0222ec81be68
       @pdRoleInfo migr=yes name=Carte assc=association40 */
   public static Carte DAME_COEUR;
   /** @pdOid b6db5ce6-dc69-4cd1-81aa-159e3f194a9f
       @pdRoleInfo migr=yes name=Carte assc=association41 */
   public static Carte DAME_PIQUE;
   /** @pdOid cb4011d5-ec40-4491-bb0c-d328316a628d
       @pdRoleInfo migr=yes name=Carte assc=association42 */
   public static Carte DAME_TREFLE;
   /** @pdOid 422c93d8-7fba-48f2-a489-b1de207d8547
       @pdRoleInfo migr=yes name=Carte assc=association43 */
   public static Carte DAME_CARREAU;
   /** @pdOid d002169f-99e8-4f15-b786-52b2ae7517d0
       @pdRoleInfo migr=yes name=Carte assc=association44 */
   public static Carte VALET_COEUR;
   /** @pdOid a680a1c7-0598-497f-8730-927e88983aed
       @pdRoleInfo migr=yes name=Carte assc=association45 */
   public static Carte VALET_PIQUE;
   /** @pdOid aef6b7bd-1dfb-439d-8ed7-693719b17208
       @pdRoleInfo migr=yes name=Carte assc=association46 */
   public static Carte VALET_TREFLE;
   /** @pdOid e6546912-ecfc-48d7-877c-f6e09618b9da
       @pdRoleInfo migr=yes name=Carte assc=association47 */
   public static Carte VALET_CARREAU;
   /** @pdOid 957eb583-339a-4690-90a9-006a1868d552
       @pdRoleInfo migr=yes name=Carte assc=association48 */
   public static Carte DIX_COEUR;
   /** @pdOid b0cceb06-e1de-4c09-acaa-9cb7ef4cbec1
       @pdRoleInfo migr=yes name=Carte assc=association49 */
   public static Carte DIX_PIQUE;
   /** @pdOid c5365d8c-5f20-47a0-b3d2-8eb26c760474
       @pdRoleInfo migr=yes name=Carte assc=association50 */
   public static Carte DIX_TREFLE;
   /** @pdOid cc085830-03b9-4e65-9f01-2dd5201eb883
       @pdRoleInfo migr=yes name=Carte assc=association51 */
   public static Carte DIX_CARREAU;
   /** @pdOid bb2cc32e-5f9c-4002-86b3-8e6f7189faa4
       @pdRoleInfo migr=yes name=Carte assc=association52 */
   public static Carte NEUF_COEUR;
   /** @pdOid 13678369-6c3f-4c76-ac37-dffdda2744e7
       @pdRoleInfo migr=yes name=Carte assc=association53 */
   public static Carte NEUF_PIQUE;
   /** @pdOid 112483d0-36ba-480d-8183-c51f0451f7d0
       @pdRoleInfo migr=yes name=Carte assc=association54 */
   public static Carte NEUF_TREFLE;
   /** @pdOid fe97accb-7861-4fa9-8806-d453a12dcd5e
       @pdRoleInfo migr=yes name=Carte assc=association55 */
   public static Carte NEUF_CARREAU;
   /** @pdOid 792010fe-b738-4896-a18c-26256823205c
       @pdRoleInfo migr=yes name=Carte assc=association56 */
   public static Carte HUIT_COEUR;
   /** @pdOid ddb86530-017e-4df4-b775-287b577c5a00
       @pdRoleInfo migr=yes name=Carte assc=association57 */
   public static Carte HUIT_PIQUE;
   /** @pdOid 6beceab0-fb81-4845-8490-5f394af9cb39
       @pdRoleInfo migr=yes name=Carte assc=association58 */
   public static Carte HUIT_TREFLE;
   /** @pdOid 280d7585-ac1e-4fde-a0c9-6024b7f804b6
       @pdRoleInfo migr=yes name=Carte assc=association59 */
   public static Carte HUIT_CARREAU;
   /** @pdOid 4e13aa75-b825-402f-953e-dee5afa1bccb
       @pdRoleInfo migr=yes name=Carte assc=association60 */
   public static Carte SEPT_COEUR;
   /** @pdOid d7c08460-db60-435a-8234-88fc3e4ff271
       @pdRoleInfo migr=yes name=Carte assc=association61 */
   public static Carte SEPT_PIQUE;
   /** @pdOid 1dd7db50-cfd2-4075-95f1-07d9df7e2330
       @pdRoleInfo migr=yes name=Carte assc=association62 */
   public static Carte SEPT_TREFLE;
   /** @pdOid 72b34f3f-f288-40a3-8a69-b39d184c326a
       @pdRoleInfo migr=yes name=Carte assc=association63 */
   public static Carte SEPT_CARREAU;
   /** @pdOid 072cba79-244a-4140-b312-77ffad85da85
       @pdRoleInfo migr=yes name=Carte assc=association64 */
   public static Carte SIX_COEUR;
   /** @pdOid 385cce5b-896b-4e81-b3ad-e4b82ca2b962
       @pdRoleInfo migr=yes name=Carte assc=association65 */
   public static Carte SIX_PIQUE;
   /** @pdOid e613a2d4-cb28-4191-b20f-12e4295a95c6
       @pdRoleInfo migr=yes name=Carte assc=association66 */
   public static Carte SIX_TREFLE;
   /** @pdOid 4a2594ea-9805-45a6-a0f3-c6442bd23bde
       @pdRoleInfo migr=yes name=Carte assc=association67 */
   public static Carte SIX_CARREAU;
   /** @pdOid 6cc1d412-8cd0-4172-8a16-c59ecb3495c0
       @pdRoleInfo migr=yes name=Carte assc=association68 */
   public static Carte CINQ_COEUR;
   /** @pdOid 11019468-8dca-41d3-b9d8-9c1163aa4803
       @pdRoleInfo migr=yes name=Carte assc=association69 */
   public static Carte CINQ_PIQUE;
   /** @pdOid 2bb2e9fa-80f0-48bf-ac12-aed83d115768
       @pdRoleInfo migr=yes name=Carte assc=association70 */
   public static Carte CINQ_TREFLE;
   /** @pdOid 139e0240-7016-4010-afa9-695065b44555
       @pdRoleInfo migr=yes name=Carte assc=association71 */
   public static Carte CINQ_CARREAU;
   /** @pdOid 6077c452-40c8-4293-aaa6-1f220c8d6aed
       @pdRoleInfo migr=yes name=Carte assc=association72 */
   public static Carte QUATRE_COEUR;
   /** @pdOid 19562780-260d-449b-bc5b-66d2a4de3959
       @pdRoleInfo migr=yes name=Carte assc=association73 */
   public static Carte QUATRE_PIQUE;
   /** @pdOid 1b1f6ea0-e824-48f6-9440-0433cd57fda8
       @pdRoleInfo migr=yes name=Carte assc=association74 */
   public static Carte QUATRE_TREFLE;
   /** @pdOid 777f0583-d86b-4a04-84ab-55a51c86c244
       @pdRoleInfo migr=yes name=Carte assc=association75 */
   public static Carte QUATRE_CARREAU;
   /** @pdOid 3599dadd-c036-4f41-b5fc-79d8dfe5b94b
       @pdRoleInfo migr=yes name=Carte assc=association76 */
   public static Carte TROIS_COEUR;
   /** @pdOid 4d708eca-911d-41ad-8954-c6256d083be3
       @pdRoleInfo migr=yes name=Carte assc=association77 */
   public static Carte TROIS_PIQUE;
   /** @pdOid 79c5e17f-601b-49ee-93b5-19c4a34657c0
       @pdRoleInfo migr=yes name=Carte assc=association78 */
   public static Carte TROIS_TREFLE;
   /** @pdOid cb6e9dc3-342b-4bce-8595-c577a193d96f
       @pdRoleInfo migr=yes name=Carte assc=association79 */
   public static Carte TROIS_CARREAU;
   /** @pdOid 793759f4-4a33-4f69-9f2a-4c4be4de9ef3
       @pdRoleInfo migr=yes name=Carte assc=association80 */
   public static Carte DEUX_COEUR;
   /** @pdOid e1eadc7c-fc9f-4ae0-8f24-85638f0e6c34
       @pdRoleInfo migr=yes name=Carte assc=association81 */
   public static Carte DEUX_PIQUE;
   /** @pdOid d214f9ca-b12b-456d-924a-588d3f287624
       @pdRoleInfo migr=yes name=Carte assc=association82 */
   public static Carte DEUX_TREFLE;
   /** @pdOid 19f56a6e-b3dd-45f2-8575-14a75ad1ed4f
       @pdRoleInfo migr=yes name=Carte assc=association83 */
   public static Carte DEUX_CARREAU;
   
   /** @pdRoleInfo migr=no name=Main assc=association84 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Main> main;
   /** @pdRoleInfo migr=no name=Table assc=association85 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Table> table;
   
   /** @param couleur 
    * @param valeur
    * @pdOid c2fb753c-4faa-4519-8e3f-ba52bd990f6f */
   public Carte(Couleur couleur, Valeur valeur) {
      this.couleur = couleur;
      this.valeur = valeur;
   }
   
   /** @pdOid d7fd7a24-80af-46a0-a83b-48cdbef84958 */
   public Couleur getCouleur() {
   	return couleur;
   }
   
   /** @param couleur
    * @pdOid 9430ee14-68af-415e-8e7e-78fca23760c1 */
   public void setCouleur(Couleur couleur) {
      this.couleur = couleur;
   }
   
   /** @pdOid 07d465ac-b0ad-4b5d-9c9a-319cc2897a62 */
   public Valeur getValeur() {
   	return valeur;
   }
   
   /** @param valeur
    * @pdOid c1aca6e9-c956-4639-afbe-d90c6d2b0fa6 */
   public void setValeur(Valeur valeur) {
      this.valeur = valeur;
   }
   
   /** @pdOid ca971b56-d571-4d30-8c15-31019d1fcac5 */
   public boolean readStatus() {
      return active;
   }
   
   /** @pdOid d8386816-fdac-40b7-8651-44087120a115 */
   public void on() {
      this.active = true; 
   }
   
   /** @pdOid 490907e6-1fb2-4da3-b16b-6d6ef0974156 */
   public void off() {
      this.active = false; 
   }
   
   /** @param couleur
    * @pdOid d5b8090e-8011-4498-98ed-80080e2c6dd9 */
   public int compareColor(Couleur couleur) {
      this.couleur.compareTo(couleur);
      return 0;
   }
   
   /** @param valeur
    * @pdOid 262a0bb0-b0a9-4249-be91-546c94fa787a */
   public int compareValue(Valeur valeur) {
      return 0; //to fix
   }
   
   /** @param carte
    * @pdOid 42cfe7da-1d44-4a31-896a-a846a741e2f8 */
   public int compareTo(Carte carte) {
      return valeur.compareTo(carte.getValeur());
   }
   
   /** @pdOid 3a22a015-5fbc-442b-9026-714608ac88f5 */
   public Carte getAllCards() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 2a310077-646c-49be-9e97-2b7582be79ea */
   @Override
   public String toString() {
   	return valeur.toString()+" de "+couleur.toString();
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Main> getMain() {
      if (main == null)
         main = new java.util.HashSet<Main>();
      return main;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMain() {
      if (main == null)
         main = new java.util.HashSet<Main>();
      return main.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMain */
   public void setMain(java.util.Collection<Main> newMain) {
      removeAllMain();
      for (java.util.Iterator iter = newMain.iterator(); iter.hasNext();)
         addMain((Main)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMain */
   public void addMain(Main newMain) {
      if (newMain == null)
         return;
      if (this.main == null)
         this.main = new java.util.HashSet<Main>();
      if (!this.main.contains(newMain))
         this.main.add(newMain);
   }
   
   /** @pdGenerated default remove
     * @param oldMain */
   public void removeMain(Main oldMain) {
      if (oldMain == null)
         return;
      if (this.main != null)
         if (this.main.contains(oldMain))
            this.main.remove(oldMain);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMain() {
      if (main != null)
         main.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Table> getTable() {
      if (table == null)
         table = new java.util.HashSet<Table>();
      return table;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTable() {
      if (table == null)
         table = new java.util.HashSet<Table>();
      return table.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTable */
   public void setTable(java.util.Collection<Table> newTable) {
      removeAllTable();
      for (java.util.Iterator iter = newTable.iterator(); iter.hasNext();)
         addTable((Table)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTable */
   public void addTable(Table newTable) {
      if (newTable == null)
         return;
      if (this.table == null)
         this.table = new java.util.HashSet<Table>();
      if (!this.table.contains(newTable))
         this.table.add(newTable);
   }
   
   /** @pdGenerated default remove
     * @param oldTable */
   public void removeTable(Table oldTable) {
      if (oldTable == null)
         return;
      if (this.table != null)
         if (this.table.contains(oldTable))
            this.table.remove(oldTable);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTable() {
      if (table != null)
         table.clear();
   }

}
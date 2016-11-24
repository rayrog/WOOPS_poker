package fr.poker.model;
import java.lang.annotation.*;

/** @pdOid 3e349e3f-d4e4-4a55-962c-f501145c0979 */
public class Valeur {
   /** @pdOid a521a1f2-fbc9-4e7c-a06f-b0a3e5bc7f3a */
   private String nom;
   /** @pdOid ffea8023-c3ba-47b9-961d-9f5d5ac21b4b */
   private int valeur;
   
   /** @pdOid 8e865eee-7618-4007-bf9a-8c7e928431a3
       @pdRoleInfo migr=yes name=Valeur assc=association19 */
   public static Valeur DEUX;
   /** @pdOid c335d63e-6dbf-48d9-af19-06e1604a0f33
       @pdRoleInfo migr=yes name=Valeur assc=association20 */
   public static Valeur TROIS;
   /** @pdOid d26b2477-02f9-4d87-81cb-f3ac8e14a8fd
       @pdRoleInfo migr=yes name=Valeur assc=association21 */
   public static Valeur QUATRE;
   /** @pdOid d9bd0e59-59c0-4a49-b0c6-0671bc5a1541
       @pdRoleInfo migr=yes name=Valeur assc=association22 */
   public static Valeur CINQ;
   /** @pdOid 8f862121-139c-469a-8f29-994516900897
       @pdRoleInfo migr=yes name=Valeur assc=association23 */
   public static Valeur SIX;
   /** @pdOid aee0e468-1406-4ad7-a059-ca10e99da2e8
       @pdRoleInfo migr=yes name=Valeur assc=association24 */
   public static Valeur SEPT;
   /** @pdOid 1bf2f01e-ac7d-4275-b59b-ed1f412aca4e
       @pdRoleInfo migr=yes name=Valeur assc=association25 */
   public static Valeur HUIT;
   /** @pdOid c668fd4d-1291-4f21-b564-fea5281d0415
       @pdRoleInfo migr=yes name=Valeur assc=association26 */
   public static Valeur NEUF;
   /** @pdOid 5b9d0c7e-7ff5-4b17-bddc-b661560e46b9
       @pdRoleInfo migr=yes name=Valeur assc=association27 */
   public static Valeur DIX;
   /** @pdOid 2dd3c154-9119-49d7-9161-00a4d2b5fbcb
       @pdRoleInfo migr=yes name=Valeur assc=association28 */
   public static Valeur VALET;
   /** @pdOid 114eac25-8fe2-49e3-a5a1-cd6216d30a8b
       @pdRoleInfo migr=yes name=Valeur assc=association29 */
   public static Valeur DAME;
   /** @pdOid 76422494-0f12-490d-95ef-8cc585501359
       @pdRoleInfo migr=yes name=Valeur assc=association30 */
   public static Valeur ROI;
   /** @pdOid f8009dd4-70ec-423d-bb28-68bffbef34ea
       @pdRoleInfo migr=yes name=Valeur assc=association31 */
   public static Valeur AS;
   
   /** @param valeur
    * @pdOid 48b9470e-1eb3-4238-8582-428287ea29c7 */
   public Valeur(int valeur) {
      this.valeur = valeur;
      
        switch (valeur) {
            case 2:  this.nom = "2";break;
            case 3:  this.nom = "3";break;
            case 4:  this.nom = "4";break;
            case 5:  this.nom = "5";break;
            case 6:  this.nom = "6";break;
            case 7:  this.nom = "7";break;
            case 8:  this.nom = "8";break;
            case 9:  this.nom = "9";break;
            case 10: this.nom = "10";break;
            case 11: this.nom = "Valet";break;
            case 12: this.nom = "Dame";break;
            case 13: this.nom = "Roi";break;
            case 14: this.nom = "As";break;
            default: this.nom = "CARTE A VALEUR INCONNUE";break;
        }
   }
   
   /** @pdOid c4d6e1c8-754f-4f2d-817d-f000a62e4afb */
   public int getValeur() {
   	return valeur;
   }
   
   /** @param valeur
    * @pdOid 6fefed8e-e22e-4b7a-9ac4-1dc8df2c6094 */
   public void setValeur(int valeur) {
      this.valeur = valeur;
   }
   
   /** @pdOid 523de563-de5f-4148-abfd-755c3bd90978 */
   public String getNom() {
   	return nom;
   }
   
   /** @param nom
    * @pdOid 82e92cb1-4b25-4d93-a96a-db176de6d696 */
   public void setNom(String nom) {
      this.nom = nom;
   }
   
   /** @param valeur
    * @pdOid e48afae2-fe23-46dc-8f6b-f6a611158956 */
   public int compareTo(Valeur valeur) {
   	return 0; //to fix
   }
   
   /** @pdOid a1abeef5-0416-47c4-99cc-bddcde453478 */
   public static Valeur[] getAllValeurs() {
   	return new Valeur[]{DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS};
   }
   
   /** @pdOid a2b4b124-1931-4d6e-ad3d-d332a8950714 */
   @Override
   public String toString() {
   	return getNom();
   }

}
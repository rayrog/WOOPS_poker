package fr.poker.model;

/** @pdOid 23fd333e-c170-4134-8155-89089b644e95 */
public class Couleur {
   /** @pdOid d4560ebc-0e6a-4e80-a402-a1213cdf8f6e */
   private int id;
   /** @pdOid ba1d6a03-6e80-4798-b7d6-495fa2b41ce9 */
   private String nom;
   
   /** @pdOid 30684fd6-1288-4acc-8c0d-ed593085f004
       @pdRoleInfo migr=yes name=Couleur assc=association15 */
   public static Couleur PIQUE = new Couleur("Pique");
   /** @pdOid 5f03df0d-f1bb-4e0b-86de-4c5e9c71c307
       @pdRoleInfo migr=yes name=Couleur assc=association16 */
   public static Couleur TREFLE = new Couleur("Trefle");
   /** @pdOid a12467dd-660b-48bb-a8cd-cc2d9e7b972a
       @pdRoleInfo migr=yes name=Couleur assc=association17 */
   public static Couleur COEUR = new Couleur("Coeur");
   /** @pdOid 63584a9d-a297-4a0e-a89c-4d1739d8758b
       @pdRoleInfo migr=yes name=Couleur assc=association18 */
   public static Couleur CARREAU = new Couleur("Carreau");
   
   /** @param nom
    * @pdOid 47fd47a5-6bc9-41ad-851d-160467f0e352 */
   public Couleur(String nom) {
      this.nom = nom;
      switch (nom) {
         case "Coeur":  this.id = 1;break;
         case "Pique":  this.id = 2;break;
         case "Trefle":  this.id = 3;break;
         case "Carreau":  this.id = 4;break;
         default: this.id = 99;break;
      }
   }
   
   /** @pdOid 41f348c0-e20b-4f71-b8d2-19b4cbf89b30 */
   public int getId() {
      // TODO: implement
      return this.id;
   }
   
   /** @param id
    * @pdOid 40bb0ad8-304b-48e7-b9c9-98789527c605 */
   public void setId(int id) {
      this.id = id;
   }
   
   /** @pdOid 759723ee-faff-4b49-8c24-4540268ba113 */
   public String getNom() {
   	return nom;
   }
   
   /** @param nom
    * @pdOid 6c29b706-88d6-47f9-8228-ff911abe1fd9 */
   public void setNom(String nom) {
      this.nom = nom;
   }
   
   /** @param o
    * @pdOid 5cd5be9f-b7bf-4546-9c24-709c3c448941 */
   public int compareTo(Couleur o) {
   	if(nom.compareTo(o.getNom())==0 && id == o.getId()){
   		return 0; //égal
   	}
   	else {
   		return 1; //différents
   	}
   }
   
   /** @pdOid 79a15477-1899-4064-8152-4a674f92b830 */
   public static Couleur[] getAllCouleurs() {
   	return new Couleur[]{PIQUE, COEUR, TREFLE, CARREAU};
   }
   
   /** @pdOid dcc42fa2-9e9a-4d23-bad4-0b6df928f063 */
   public int hashCode() {
      // TODO: implement
      return 0;
   }
   
   /** @pdOid 8f7e933f-ea93-4afb-8fe3-3f1291bf8ab0 */
   @Override
   public String toString() {
   	return getNom();
   }

}
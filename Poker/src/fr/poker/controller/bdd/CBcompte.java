package fr.poker.controller.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.poker.controller.Cinscription;


public class CBcompte {
	
	private CBconnect cbCo;
	private Statement st;
	private Cinscription cIns;
	public CBcompte(CBconnect c) {
		this.cbCo = c;
	}	
	
/*PARTIE FONCTIONS Connexions/ Inscriptions*/	
	


	public int checkMail(String mail){
		
		/*
		 * Cette fct sert � tester si le mail en param�tre existe.
		 * Renvois ID Joueur si mail existe dans bdd sinon renvois -1
		 * 
		 */
		int resultat=-1;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();	
			
			String sql = "SELECT ID FROM `Compte` WHERE `mail` LIKE '";
			sql = new StringBuilder(sql).insert(sql.length(),mail).toString();
			sql = new StringBuilder(sql).insert(sql.length(),"'").toString();
			
			// debug : affichage requete :
				//System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			//test si le mail existe, si oui, change la valeur de resultat par -1
			if (rs.next())
			{	
				String name = rs.getString(1);
				//debug : Affichage Mail + ID
				//	System.out.println("Mail Found. ID player is " + name);
				resultat=Integer.parseInt(name);
			}
			else {
				System.out.println("Mail not Found in bdd");
			}
			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	public int checkPasswd(String pwd){
		
		/*
		 * Cette fct sert � tester si le pwd en param�tre existe.
		 * Renvois ID Joueur si pwd existe dans bdd sinon renvois -1
		 * 
		 */
		int resultat=-1;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();
			
			String sql = "SELECT ID FROM `Compte` WHERE `hash` LIKE '";
			sql = new StringBuilder(sql).insert(sql.length(),pwd).toString();
			sql = new StringBuilder(sql).insert(sql.length(),"'").toString();
			
			// debug : affichage requete 
			//	System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			//test si le mail existe, si oui, change la valeur de resultat par -1
			if (rs.next())
			{	
				String name = rs.getString(1);
				//debug : 
			//	System.out.println("pwd Found. ID player is " + name);
				resultat=Integer.parseInt(name);
			}
			else {
				System.out.println("pwd not Found in bdd");
			}
			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	public int checkPseudo(String pseudo){
		
		/*
		 * Cette fct sert � tester si le pwd en param�tre existe.
		 * Renvois ID Joueur si le pseudo existe dans bdd sinon renvois -1
		 * 
		 */
		int resultat=-1;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();
			
			String sql = "SELECT ID FROM `Compte` WHERE `pseudo` LIKE '";
			sql = new StringBuilder(sql).insert(sql.length(),pseudo).toString();
			sql = new StringBuilder(sql).insert(sql.length(),"'").toString();
			
			// debug : affichage requete 
			//	System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			//test si le mail existe, si oui, change la valeur de resultat par -1
			if (rs.next())
			{	
				String name = rs.getString(1);
				//debug : 
			//	System.out.println("pwd Found. ID player is " + name);
				resultat=Integer.parseInt(name);
			}
			else {
				System.out.println("pseudo not Found in bdd");
			}
			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	public int lastInsertId (String table) {
		
		/*
		 * Cette fct permet de récupérer l' id du dernier compte inséré dans 
		 * la BDD
		 * 
		 */
		int resultat = -1;
		try{
			
			cbCo.connexion();
			this.st=cbCo.getSt();
			String sql = "SELECT max(id) FROM `Poker`."+table;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
			{	
				String id = rs.getString(1);
				resultat=Integer.parseInt(id);
			}			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		
		return resultat;
		
	}
	
	
/* PARTIE INSCRIPTION */

	
	//Ecriture des données du nouvel utilisateur dans la BDD
	public void inscription(Cinscription c){
		
		try{
			cIns = c;
			cbCo.connexion();
			this.st=cbCo.getSt();
			//Requête sql
			System.out.println(lastInsertId("Compte"));
			int lastId = lastInsertId("Compte");
			lastId = lastId + 1;
			String pwdHashed = cbCo.hashage(cIns.getVins().getPwdAccount().getText());
			String sql = "INSERT INTO `Poker`.`Compte` (`id`, `nom`, `prenom`, `mail`, `tel`, `hash`, `credit`, `bio`, `pseudo`) VALUES ('"+lastId+"', '"+cIns.getVins().getTxtLastName().getText()+"', '"+cIns.getVins().getTxtFirstName().getText()+"', '"+cIns.getVins().getTxtEmail().getText()+"', '"+cIns.getVins().getTxtPhoneNumber().getText()+"', '"+pwdHashed+"', '50', 'Ceci est votre bio', '"+cIns.getVins().getTxtPseudo().getText()+"')";
			int rs = st.executeUpdate(sql);

			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public String getCredit(int iDplayer){
		/*
			 * Cette fct sert a recuperer le credit d'un joueur passé en parametre.
			 */
			String resultat="Erreur credit";
			try{
				//Connexion � la BDD 
				cbCo.connexion();
				this.st=cbCo.getSt();
				
				String sql = "SELECT credit FROM `Compte` WHERE `id` LIKE '";
				sql = new StringBuilder(sql).insert(sql.length(),iDplayer).toString();
				sql = new StringBuilder(sql).insert(sql.length(),"'").toString();
				
				// debug : affichage requete 
				//	System.out.println(sql);
	
				ResultSet rs = st.executeQuery(sql);
				ResultSetMetaData resultMeta = rs.getMetaData();
				//test si le mail existe, si oui, change la valeur de resultat par -1
				if (rs.next())
				{	
					resultat = rs.getString(1);
					//debug : 
					//System.out.println("Credit for " + iDplayer + " is " + resultat);
					
				}
				else {
					System.out.println("Erreur dans fct get credit");
				}
		
				cbCo.fermerConnexion();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return resultat;
	}

	
	
	public String getPseudo(int iDplayer){
		/*
			 * Cette fct sert a recuperer le credit d'un joueur passé en parametre.
			 */
			String resultat="Erreur Pseudo";
			try{
				//Connexion � la BDD 
				cbCo.connexion();
				this.st=cbCo.getSt();
				
				String sql = "SELECT pseudo FROM `Compte` WHERE `id` LIKE '";
				sql = new StringBuilder(sql).insert(sql.length(),iDplayer).toString();
				sql = new StringBuilder(sql).insert(sql.length(),"'").toString();
				
				// debug : affichage requete 
				//	System.out.println(sql);
	
				ResultSet rs = st.executeQuery(sql);
				ResultSetMetaData resultMeta = rs.getMetaData();
				//test si le mail existe, si oui, change la valeur de resultat par -1
				if (rs.next())
				{	
					resultat = rs.getString(1);
					//debug : 
					//System.out.println("Credit for " + iDplayer + " is " + resultat);
					
				}
				else {
					System.out.println("Erreur dans fct get pseudo");
				}
		
				cbCo.fermerConnexion();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return resultat;
	}
/**/

	

}










/* Sources : 




public class CBLireEcrire{
	public static void main(String[] args) {
		//Petit Test
		
	}
	try{
		CBconnexion c = new CBconnexion();
		String sql = "INSERT INTO javadb (`personne`) VALUE('"+personne+"')";
		//Etape 1 : exécution requête
		c.getSt().executeUpdate(sql);
		c.getCn().close();
		c.getSt().close();

	} catch(SQLException e1) {
		e1.printStackTrace();
	} catch(ClassNotFoundException e) {
		e1.printStackTrace();
	}finally {
		try{
			//Etape 5 : libérer ressources de la mémoire
			c.setCn.close();
			c.setSt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}


}









public class CBlire {
	try{
		CBconnexion();
		String sql = "SELECT * FROM `javadb`";
		//Etape 4 : exécution requête
		rs = st.executeQuery(sql);
		//Etape 5: (parcours de Resultset)
		while (rs.next()){
			System.out.println(rs.getString("personne"));
		}

	} catch(SQLException e) {
		e.printStackTrace();
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		try{
			//Etape 6 : libérer ressources de la mémoire
			cn.close();
			st.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}










*/
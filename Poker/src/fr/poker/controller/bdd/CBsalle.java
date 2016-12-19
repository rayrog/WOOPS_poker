package fr.poker.controller.bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CBsalle {
	
	
	

	
	

	/*Partie traitement des salles*/
	
	
	
	

	public void listeSalles(String pseudo){
		
		/*
		 * Cette fct sert a lister les salles existantes 
		 * 
		 
	
		try{
			//Connexion � la BDD 
			connexion();
			
			String sql = "SELECT ID FROM `Compte` WHERE `pseudo` LIKE '";
			sql = new StringBuilder(sql).insert(sql.length(),pseudo).toString();
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
				//resultat=Integer.parseInt(name);
			}
			else {
				System.out.println("pwd not Found in bdd");
			}
			fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void createSalle(int ID){
		
		
		
	}
*/
	}
}

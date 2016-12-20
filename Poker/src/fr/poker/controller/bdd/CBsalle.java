package fr.poker.controller.bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Spring;

public class CBsalle {
	
	
	
	private CBconnect cbCo;
	private Statement st;
	
	public CBsalle(CBconnect c) {
		this.cbCo = c;
	}	
	
	
	/*Partie traitement des salles*/

	public int listeSalles(){
		
		/*
		 * Cette fct sert a lister les salles existantes 
		 * et return leur nombre (-1 si aucune)
		 */
		int resultat = -1;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();
			String sql = "SELECT * FROM `Salle`";
			
			// debug : affichage requete 
			//	System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			//test si le mail existe, si oui, change la valeur de resultat par -1
			resultat=0;
			while(rs.next())
			{	
				String name = rs.getString(2); // recupere champ correspondant a 2 valeur dans bdd
				System.out.println("Nom : " + name + " Nombre de joueur (to finish)" );
				resultat++;
			}

			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	
	
	
public String[] listeSalles1(){
		
		/*
		 * Cette fct sert a lister les salles existantes 
		 * et return leur nombre (-1 si aucune)
		 */
		String[] resultat;
		int i=0;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();
			String sql = "SELECT * FROM `Salle`";
			
			// debug : affichage requete 
			//	System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			//test si le mail existe, si oui, change la valeur de resultat par -1
		
			while(rs.next())
			{	
				String name = rs.getString(2); // recupere champ correspondant a 2 valeur dans bdd
				resultat[i]=name;
				System.out.println("Ajouté a la liste : "+ name);
				i++;
			}

			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	
	
	
	

}
	
	
	
	


package fr.poker.controller.bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

public class CBsalle {
	private CBconnect cbCo;
	private Statement st;
	private Vector<String> listId= new Vector();// liste contenant les ID des parties existantes. elle permet de faire la liaison de 
	
	public CBsalle(CBconnect c) {
		this.cbCo = c;
	}	
	
	/*Partie traitement des salles*/

	@SuppressWarnings("null")
	public Vector<String> listeSalles(){
		
		/*
		 * Cette fct sert a lister les salles existantes 
		 * et return leur nombre (-1 si aucune)
		 */
		int resultat = -1;
		Vector<String> listSalles = new Vector();
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

			resultat=0;
			this.listId.clear(); // C
			
			while(rs.next())
			{	
				String name = rs.getString(2); // recupere champ correspondant a 2 valeur dans bdd = nom de la salle
				String Id = rs.getString(1);
				String nbJoueurs=nbJoueurSalle(Id);
				String lineToDisplay="Salle ID : " + Id + " // nom : " + name + " // " + nbJoueurs + " Joueurs";
				System.out.println(lineToDisplay);
				listSalles.addElement(lineToDisplay);
				resultat++;			
				this.listId.addElement(Id);
			}
			System.out.println("Nombre de salles : " + resultat);
			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listSalles;
	}

	
	public String nbJoueurSalle(String IDSalle){
		
		/*
		 * Sert a retourner le nombre de joueurs dans une salle placée en paramètre
		 * 
		 */
		int i=0;
		try{
			//Connexion � la BDD 
			cbCo.connexion();
			this.st=cbCo.getSt();
			String sql = "SELECT * FROM `LinkCompteSalle` WHERE `idPartie` = ";
			sql = new StringBuilder(sql).insert(sql.length(),IDSalle).toString();
			// debug System.out.println(sql);
			
			//exécution requête
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			while(rs.next())
			{	
				i=i+1;
				//System.out.println("i: " + i);
			}
			//System.out.println(i + " Joueurs dans la salle d'ID :"+ IDSalle);
			cbCo.fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return Integer.toString(i);
	}

	public Vector<String> getListId() {
		return listId;
	}

	public void setListId(Vector<String> listId) {
		this.listId = listId;
	}

	public boolean verifDataSalle(String string) {
		
		return false;
		// TODO Auto-generated method stub
		
	}

	public String creeSalle(boolean isPrivate, String string, String string2) {
		
		
		
		return string2;
		// creer une salle et retourne son ID 
		
		// TODO Auto-generated method stub
		
	}
	
}
	
	
	
	


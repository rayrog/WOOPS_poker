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
	private Vector<String> listId= new Vector();// liste contenant les ID des parties existantes. 
	
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


	public int getPortSalle() {
		// TODO Auto-generated method stub
		return -1;
	}

	public int getPortChat() {
		// TODO Auto-generated method stub
		return -1;
	}

	public void creeSalle(boolean isPrivate, String password, String nomSalle, int portSalle, int portChat) {
		try{
			System.out.println("Creation de la salle : Privée= "+ isPrivate + " nomSalle :" + nomSalle + " portSalle : " + portSalle + " portChat " + portChat);
			String sql = "";
			cbCo.connexion();
			this.st=cbCo.getSt();
			// Recupération d'un Id de Salle :
			int lastId = 0;
			lastId=lastInsertId("Salle");
			lastId = lastId + 1;
			//Requête sql
			if (isPrivate==true){
				String pwdHashed = cbCo.hashage(password);
				sql = "INSERT INTO `Poker`.`Salle` (`id`, `nom`, `privat`, `hash`, `portSalle`, `portChat`) VALUES ('"+lastId+"', '"+nomSalle+"', '1', '"+pwdHashed+"', '"+portSalle+"', '"+portChat+"')";
	
			}
			else {
				
				sql = "INSERT INTO `Poker`.`Salle` (`id`, `nom`, `privat`, `hash`, `portSalle`, `portChat`) VALUES ('"+lastId+"', '"+nomSalle+"', '0', '', '"+portSalle+"', '"+portChat+"')";	
			}
			System.out.println("requete : "+ sql);
			int rs = st.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		
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
	
}
	
	
	
	


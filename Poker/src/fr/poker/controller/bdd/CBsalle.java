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

	public void creeSalle(boolean isPrivate, String password, String nomSalle, int portSalle, int portChat) {
		
		//Envois une requete de création de salle à la Bdd , avec un mot de passe haché si isPrivate a true.
		try{
			System.out.println("Creation de la salle : Privée="+ isPrivate + " nomSalle=" + nomSalle + " portSalle=" + portSalle + " portChat=" + portChat);
			String sql = "";
			cbCo.connexion();
			this.st=cbCo.getSt();
			// Recupération d'un Id de Salle :
			int lastId = 0;
			lastId=lastInsertId("Salle");
			lastId = lastId + 1;
			System.out.println("lastid"+ lastId);
			//Requête sql
			if (isPrivate==true){
				String pwdHashed = cbCo.hashage(password);
				sql = "INSERT INTO `Poker`.`Salle` (`id`, `nom`, `privat`, `hash`, `portSalle`, `portChat`) VALUES ('"+lastId+"', '"+nomSalle+"', '1', '"+pwdHashed+"', '"+portSalle+"', '"+portChat+"')";
			}
			else {
				sql = "INSERT INTO `Poker`.`Salle` (`id`, `nom`, `privat`, `hash`, `portSalle`, `portChat`) VALUES ('"+lastId+"', '"+nomSalle+"', '0', '', '"+portSalle+"', '"+portChat+"')";	
			}
			//System.out.println("requete : "+ sql);
			int rs = st.executeUpdate(sql);
			System.out.println("Salle "+ nomSalle+ " crée");
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
				if (rs!=null){
					resultat=0;
				}
				else if (rs.next())
				{	
						String id = rs.getString(1);
						resultat=Integer.parseInt(id);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}	
			
			return resultat+1;
			
		}
	
	public int getAvailablePort(String string) {
		/*
		 * REcupère une liste des ports déjà utilisés et prend le premier libre, tant que celui ci est inclus 4555-4565 
		//4570-458
		 */
		int port=-1;
		int i=0;
		int min=0;
		int max=0;
		int count;
		String sql="";
		
		if (string=="salle"){
			// Met les parametre min et max au bon format 
			min=4555;
			max=4565;
			sql="SELECT `portSalle` FROM `Salle`";
			
		}else if(string=="chat"){
			min =4570;
			max=4580;
			sql="SELECT `portChat` FROM `Salle`";
			
		}else{
			System.out.println("Erreure fonction GetAvailable Port");
		}
		try{
			cbCo.connexion();
			this.st=cbCo.getSt();
			ResultSet rs = st.executeQuery(sql);
			Vector<Integer> listPort = new Vector();
			count =0;
			while(rs.next()){
				String portUsed = rs.getString(1);
				listPort.addElement(Integer.parseInt(portUsed));
				//System.out.println("portUsed "+ portUsed);
				count++;
				}		
			//System.out.println(count);
			System.out.println("Port utilisiés : " + count +"/10 : " + string + listPort.toString());
			// Verifie si la limite de Salle n'est pas atteinte
			
			if (count==10){
				System.out.println("10 ports utilisé!, limite atteinte : Changer le nombre de port disponnible dans CB Salle ");
				return port;
			}
			else {
				
				//min prend la valeur minimum exi
				for (int p : listPort) {
					if(p>min){
						min=p+1;
					}
				}
				//System.out.println("min" + min);
				if(min<=max){
					port=min+1;
					System.out.println(port);
				}
				else
					System.out.println("Port Maximal deja utilisé supprimer des parties");
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}	
		return port;
	}



}
	
	
	
	


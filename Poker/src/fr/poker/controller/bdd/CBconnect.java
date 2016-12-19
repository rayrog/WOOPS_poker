package fr.poker.controller.bdd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CBconnect {
	private String url;
	private String login;
	private String passwd;
	private Connection cn;
	private Statement st;
	private String encryptedString;
	
	
	public CBconnect() {
		//Information d'accès à la base de données
		this.url="jdbc:mysql://172.23.2.15:3306/Poker";
		this.login = "woopsirc4";
		this.passwd = "woopsirc4";
		this.cn = null;
		this.st = null;
	}

	public static void main(String[] args){
		CBconnect connect = new CBconnect();
		connect.connexion();
		connect.lire("Compte");
		
	}
	

//maybe static
	public void connexion(){
		try{
			//Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			//Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void fermerConnexion(){
		try{
			//Etape 1 : libérer ressources de la mémoire
			cn.close();
			st.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void lire(String base){
		try{
			String sql = "SELECT * FROM "+base;
			//Etape 4 : exécution requête
			ResultSet rs = st.executeQuery(sql);
			//Etape 5 : récupérer les metadata (informations globales)
			ResultSetMetaData resultMeta = rs.getMetaData();
			//Etape 5: (parcours de Resultset)
			System.out.println("\n*********************************************************************************************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			System.out.println("\n*********************************************************************************************************");

			while(rs.next()){         
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + rs.getObject(i).toString() + "\t |");

				System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Statement getSt() {
		return st;
	}
	
	public String hashage(String pwd) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(pwd.getBytes());
			encryptedString = new String(messageDigest.digest());
			return encryptedString;
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getEncryptedString() {
		return encryptedString;
	}

	public void setEncryptedString(String encryptedString) {
		this.encryptedString = encryptedString;
	}
	
// Fonctions génériques 
	
	/*
public ResultSet executeRequete(String requete){
		// Executte la requete entrée en paramètre
		
		// debug : affichage requete 
		//	System.out.println(sql);
		ResultSet rs = null;
		ResultSetMetaData resultMeta = null;
		try{
			//Connexion � la BDD 
			connexion();
			String sql = requete;
			//Requete
			rs = st.executeQuery(sql);
			resultMeta = rs.getMetaData();
			fermerConnexion();
		}
		catch(SQLException e) {
			e.printStackTrace();
	}
	return rs;
}
*/
	
/*
public void supprimerTouT(){
	// ATTENTION SUPPRIME toute la Bdd
	try{
		String sql = "DELETE * FROM `javadb`";
		//Etape 4 : exécution requête
		ResultSet rs = st.executeQuery(sql);
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
}

*/
	

	
}

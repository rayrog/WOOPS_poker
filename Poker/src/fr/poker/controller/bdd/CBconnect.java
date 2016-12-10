package fr.poker.controller.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CBconnect {
	private String url;
	private String login;
	private String passwd;
	private Connection cn;
	private Statement st;
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
		connect.lire();
		
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

	private void fermerConnexion(){
		try{
			//Etape 1 : libérer ressources de la mémoire
			cn.close();
			st.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void lire(){
		try{
			String sql = "SELECT * FROM `Compte`";
			//Etape 4 : exécution requête
			ResultSet rs = st.executeQuery(sql);
			//Etape 5 : récupérer les metadata (informations globales)
			ResultSetMetaData resultMeta = rs.getMetaData();
			//Etape 5: (parcours de Resultset)
			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			System.out.println("\n**********************************");

			while(rs.next()){         
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + rs.getObject(i).toString() + "\t |");

				System.out.println("\n---------------------------------");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int checkMail(String mail){
		
		/*
		 * Cette fct sert � tester si le mail en param�tre existe.
		 * Renvois ID Joueur si mail existe dans bdd sinon renvois -1
		 * 
		 */
		int resultat=-1;
		try{
			//Connexion � la BDD 
			connexion();
			
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
			fermerConnexion();
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
			connexion();
			
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
			fermerConnexion();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	
	public void ecrire(String donne){
		try{
			String sql = "INSERT INTO javadb (`personne`) VALUE('"+donne+"')";
			//Etape 4 : exécution requête
			ResultSet rs = st.executeQuery(sql);

			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void supprimer(){
		try{
			String sql = "DELETE * FROM `javadb`";
			//Etape 4 : exécution requête
			ResultSet rs = st.executeQuery(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

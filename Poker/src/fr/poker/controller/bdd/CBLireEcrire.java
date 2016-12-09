package fr.poker.controller.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	}/*finally {
		try{
			//Etape 5 : libérer ressources de la mémoire
			c.setCn.close();
			c.setSt.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}*/


}

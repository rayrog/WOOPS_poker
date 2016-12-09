package fr.poker.controller.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

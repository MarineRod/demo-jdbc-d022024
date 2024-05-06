package fr.digi.c022024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class App {

	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	
	
	static {
		
		ResourceBundle dbConfig = ResourceBundle.getBundle("db");
		DB_URL = dbConfig.getString("db.url");
		DB_USER = dbConfig.getString("db.user");
		DB_PWD = dbConfig.getString("db.pwd");
	}

	public static void main(String[] args) {

		Connection connection = null;
		Statement st = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);			
			st = connection.createStatement();
			//C -> Insertion
			int nb = st.executeUpdate("INSERT INTO FOURNISSEUR(NOM) VALUES('DIGI')");
			System.out.println("Nombre d'éléments créés : " + nb);
			//R -> 
			
			//U -> Mise à jour
			int nbModifies = st.executeUpdate("UPDATE FOURNISSEUR SET NOM = 'ETS DUBOIS' WHERE ID = 3");
			System.out.println("Nombre d'éléments modifiés : " + nbModifies);
			
			//D -> Suppression
			int nbSupp = st.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM = 'DIGI'");
			System.out.println("Nombre d'éléments supprimés : "+ nbSupp);

			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (null != st) {
					st.close();
				}
				if (null != connection) {
					connection.close();
				}
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}				
		System.out.println("Fin du programme");
	}
}

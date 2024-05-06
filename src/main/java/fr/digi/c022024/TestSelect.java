package fr.digi.c022024;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.digi.c022024.entites.Fournisseur;

public class TestSelect {
	
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
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);			
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {
			
			List<Fournisseur> fournisseurs = new ArrayList<>();
			
			while(rs.next()) {

				int id = rs.getInt("ID");//getInt(1);
				String nom = rs.getString("NOM");//getInt(2);
				fournisseurs.add(new Fournisseur(id, nom));
			}
			
			fournisseurs.forEach(System.out::println);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}		
	}
}

package fr.digi.c022024.dao.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import fr.digi.c022024.dao.FournisseurDAO;
import fr.digi.c022024.entites.Fournisseur;

public class FournisseurJDBCDAO implements FournisseurDAO {

	private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR(NOM) VALUES('%s')";
	
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	
	
	static {
		
		ResourceBundle dbConfig = ResourceBundle.getBundle("db");
		DB_URL = dbConfig.getString("db.url");
		DB_USER = dbConfig.getString("db.user");
		DB_PWD = dbConfig.getString("db.pwd");
	}
	
	@Override
	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);			
				Statement st = connection.createStatement();) {
			
			//C -> Insertion
			String query = String.format(INSERT_QUERY, fournisseur.getRaisonSociale());
			st.executeUpdate(query);
		}
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return false;
	}

}

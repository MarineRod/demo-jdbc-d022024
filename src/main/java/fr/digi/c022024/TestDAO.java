package fr.digi.c022024;

import fr.digi.c022024.dao.FournisseurDAO;
import fr.digi.c022024.dao.jbdc.FournisseurJDBCDAO;
import fr.digi.c022024.entites.Fournisseur;

public class TestDAO {

	public static void main(String[] args) {
		FournisseurDAO dao = new FournisseurJDBCDAO();
		try {
			dao.insert(new Fournisseur("SEBSY CORP"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

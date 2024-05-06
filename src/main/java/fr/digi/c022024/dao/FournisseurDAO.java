package fr.digi.c022024.dao;

import java.util.List;

import fr.digi.c022024.entites.Fournisseur;

public interface FournisseurDAO {
	
	List<Fournisseur> extraire();
	void insert(Fournisseur fournisseur) throws Exception;
	int update(String ancienNom, String nouveauNom);
	boolean delete(Fournisseur fournisseur);	
}

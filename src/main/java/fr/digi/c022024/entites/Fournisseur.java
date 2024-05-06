package fr.digi.c022024.entites;

public class Fournisseur {
	
	private int id;
	private String raisonSociale;
	
	
	public Fournisseur() {
	}
	
	public Fournisseur(String raisonSociale) {
		super();
		this.raisonSociale = raisonSociale;
	}

	public Fournisseur(int id, String raisonSociale) {
		this.id = id;
		this.raisonSociale = raisonSociale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", raisonSociale=" + raisonSociale + "]";
	}	
}

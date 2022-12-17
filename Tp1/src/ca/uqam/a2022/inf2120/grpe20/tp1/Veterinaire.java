package ca.uqam.a2022.inf2120.grpe20.tp1;

/*
 *  Cette classe représente les données de la personne (médecin) qui traite les animaux.
 */
public class Veterinaire extends Employe {
	private String profil;
	// Constructor
	public Veterinaire(String nom, String prenom, String matricule, String titre, String profil) {
		super(nom, prenom,  matricule, titre);
		this.profil =  profil;
	}

	public String getProfil() {
		return this.profil;
	}
	public String toString() {
		return getPrenom() + " " + getNom()  + " | "+  getMatricule() + " | " + getTitre() + " | "+ 
	getAnimaux() + " | "+ getProfil();
	}
}

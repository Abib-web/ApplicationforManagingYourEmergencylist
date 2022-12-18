package ca.uqam.a2022.inf2120.grpe20.tp1;

/*
 *  Cette classe repr�sente les donn�es de la personne qui aide le v�t�rinaire dans le traitement des
animaux.
 */
public class Technicien extends Employe {
	private String statut;
	// Constructor
	public Technicien(String nom, String prenom, String matricule, String titre, String statut) {
		super(nom, prenom,  matricule, titre);
		this.statut =  statut;
	}

	public String getStatut() {
		return this.statut;
	}
	public String toString() {
		return getPrenom() + " " + getNom()  +  " | "+  getMatricule() +" | "+  getTitre() + " | "+ 
	getAnimaux() + " | "+ getStatut();
	}
}

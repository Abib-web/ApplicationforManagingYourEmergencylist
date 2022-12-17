package ca.uqam.a2022.inf2120.grpe20.tp1;

/*
 *  Cette classe représente les données du propriétaire de l’animal qui a une assurance maladie pour
son animal.
 * */
public class ProprietaireAssure extends
									Proprietaire{
	private String numAssurance ;
	// Constructor
	public ProprietaireAssure(String nom, String prenom, String numTelephone, String numAssurance) {
		super(nom, prenom, numTelephone);
		this.numAssurance = numAssurance;
	}
		
	//getters
	public String getNumAssurance(){
		return this.numAssurance;
	}
	
	public String toString() {
		return getPrenom() + " " + getNom()  + " | "+ getTelephone() + " | "+ getNumAssurance();
	}
}

package ca.uqam.a2022.inf2120.grpe20.tp1;

/*
 * Cette classe représente les données du propriétaire de l’animal.
 * */
public class Proprietaire extends Personne {
	private String numTelephone; 
	// Constructor
	public Proprietaire(String nom, String prenom, String numTelephone) {
		super(nom, prenom);
		this.numTelephone = numTelephone;
		
	}

	//getters
	public String getTelephone(){
		return this.numTelephone;
	}
	public String toString() {
		return getPrenom() + " " + getNom()  + " | "+ getTelephone();
	}
}

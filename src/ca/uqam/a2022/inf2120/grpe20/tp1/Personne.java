package ca.uqam.a2022.inf2120.grpe20.tp1;

/*
 * Cette class a toute les informations basic qu'une personne est cense avoir
 */
public abstract class Personne {
	// Les variables d'instances
		private String nom;
		private String prenom;
		
		// Constructor
		public Personne(String nom, String prenom) {
			this.nom = nom;
			this.prenom = prenom;
		}
		
		//setters
		public void setNom(String nom) {
			this.nom = nom;
		}
		public void setPrenom(String prenom){
			this.prenom = prenom;
		}
		//getters
		public String getNom(){
			return this.nom;
		}
		public String getPrenom(){
			return this.prenom;
		}
		
}

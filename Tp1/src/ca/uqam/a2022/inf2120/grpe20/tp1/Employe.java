package ca.uqam.a2022.inf2120.grpe20.tp1;

public abstract class Employe extends Personne {
	//les variables d'instacnces
	private String matricule;
	private String titre;
	private int nbrsAnimaux = 0;
	// Constructor
	public Employe(String nom, String prenom, String matricule, String titre) {
		super(nom, prenom);
		this.matricule =  matricule;
		this.titre =  titre;
	}
	
	public void setMatricule(String matricule){
		this.matricule = matricule;
	}
	//getters
	public String getMatricule(){
		return this.matricule;
	}
	public void setTitre(String titre){
		this.titre = titre;
	}
	//getters
	public String getTitre(){
		return this.titre;
	}
	
	// methode d'increment d'animaux
	public void incAnimaux() {
		nbrsAnimaux = nbrsAnimaux + 1;
	}
	
	// methode donne le nombres d'animaux
		public int getAnimaux() {
			return this.nbrsAnimaux;
		}
}

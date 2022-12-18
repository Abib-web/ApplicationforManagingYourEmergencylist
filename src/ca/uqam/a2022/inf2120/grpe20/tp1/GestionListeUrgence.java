package ca.uqam.a2022.inf2120.grpe20.tp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UQAM - Automne 2022 - INF2120 - Groupe 20 - TP1
 * 
 * Classe GestionListeUrgence : cette classe définit les services d'une file d'attente 
 * dans laquelle les animaux sont organisés en ordre décroissant selon leurs priorités 
 * et leurs dates / heures d'arrivée. Les priorités commencent de 1 à 5, où 1 est la plus
 * grande priorité, tandis que 5 est la plus petite. Les animaux de la plus grande priorité
 * sont ajoutés au début de la liste. Les éléments de la même priorité sont ordonnés selon 
 * la date et l'heure d'arrivée. 
 * 
 * VOUS DEVEZ COMPLÉTER LES MÉTHODES SUIVANTES :
 *   - public boolean ajouter(Animal aml)
 *   - public boolean assignerTechnicienEtVeterinaire (Technicien tech, Veterinaire vet)
 *   - public Animal rechercherParIdentifiantDansFileAttente(int identifiant)
 *   - public Animal rechercherParIdentifiant(int identifiant)
 *   - public List<Animal> rechercherParPrenomEspece(String prenom, String espece)
 *   - public boolean remplacer(Animal amlARemplacer, Animal nouvelAml)
 *   - public Animal retirerAnimal(int identifiant)
 * 
 * VOIR LA JAVADOC DE CES MÉTHODES POUR PLUS DE DÉTAILS SUR LEURS IMPLÉMENTATIONS.
 * 
 * INFORMATIONS IMPORTANTES :
 * Ajoutez toute autre méthode privée que vous jugez nécessaire pour accomplir
 * ce travail.
 * 
 * @author VOTRE NOM VOTRE PRÉNOM - VOTRE CODE PERMANENT
 * 
 * @version 4 octobre 2022
 */

public class GestionListeUrgence {

   // Déclaration des constantes
   static final int PRIORITE_UN = 1;
   static final int PRIORITE_CINQ = 5;
   
   // Déclaration des attributs d'instance
   
	// Liste des animaux dans la file d'attente sans technicien 
   // et vétérinaire assignés
	private List<Animal> fileAttenteDesAnimaux;
	
   // Liste des animaux avec technicien et vétérinaire assignés
	// Autrement dit des animaux qui recoivent maintenant des soins 
   private List<Animal> listeDesAnimauxAvecTechEtVetAssignes;

	/**
	 * Constructeur sans argument pour la création des listes vides
	 *  - fileAttenteDesAnimaux 
	 *  - listeDesAnimauxAvecTechEtVetAssignes
	 */
	public GestionListeUrgence() {
		fileAttenteDesAnimaux    = new ArrayList<>();
		listeDesAnimauxAvecTechEtVetAssignes  = new ArrayList<>();
	}
	
	/**
	 * Retourne tous les animaux qui sont dans la file d'attente.
	 * 
    * @return la file d'attente des animaux
    */
   public List<Animal> getListeUrgenteDesAnimaux() {
      return Collections.unmodifiableList(fileAttenteDesAnimaux);
   }

   /**
    * Retourne tous les animaux qui ont déjà un technicien et
    * un vétérinaire assignés.
    * 
    * @return la liste des animaux qui ont un technicien et un vétérinaire
    */
   public List<Animal> getListeDesAnimauxSousSoins() {
      return Collections.unmodifiableList(listeDesAnimauxAvecTechEtVetAssignes);
   }



   /**
    * Cette méthode ajoute l'animal 'aml' passé en paramètre dans la file d'attente (fileAttenteDesAnimaux)
    * selon sa priorité, sa date et heure d'arrivée. Ainsi les animaux de la plus grande priorité sont placés
    * au début de la file. 
    * 
    * Les priorités commencent de 1 à 5, où 1 est la plus grande priorité, tandis que 5 est la plus petite.
    * 
    * Si 'aml' a la même priorité qu'un autre qui existe déjà dans la file d'attente, et sa date et heure 
    * d'arrivée est plus grande que celle de ce dernier, il doit être placé après cet animal. 
    * 
    * Exemple 1 : supposons que a1, a2, et a3 sont les animaux avec les priorités et les dates / heures d'arrivée
    *   a1 (la priorité = 2, la date et heure d'arrive = 04/10/2022 08:45)
    *   a2 (la priorité = 1, la date et heure d'arrive = 04/10/2022 09:45)
    *   a3 (la priorité = 3, la date et heure d'arrive = 04/10/2022 10:45)
    *   
    *   La file d'attente se présente comme suit après l'ajout des trois animaux :
    *   [a2, a1, a3] où a1 est à la 1ere position, a2 est à la 2e position, et a3 est à la 3e position.
    *  
    * Exemple 2 : supposons que a1, a2, et a3 sont les animaux avec les priorités et les dates / heures d'arrivée
    *   a1 (la priorité = 1, la date et heure d'arrive = 04/10/2022 07:10)
    *   a2 (la priorité = 2, la date et heure d'arrive = 04/10/2022 08:20)
    *   a3 (la priorité = 1, la date et heure d'arrive = 04/10/2022 09:55)
    *   
    *   La file d'attente se présente comme suit après l'ajout des trois animaux :
    *   [a1, a3, a2] où a1 est à la 1ere position, a3 est à la 2e position, et a2 est à la 3e position.
    *   
    * L'animal 'aml' ne doit pas être ajouté dans la file d'attente (fileAttenteDesAnimaux) si l'une des conditions 
    * suivantes est vraie :
    *   - 'aml' est null.
    *   - 'aml' a une priorité qui est inférieure à 1 ou supérieure à 5.
    *
    * @param aml l'animal à ajouter dans la file d'attente
    * @return vrai si 'aml' est ajouté dans la file d'attente, sinon faux
    * 
    * Implementation
    * 
    * Si la liste d'attente est vide, on ajoute un element sinon nous ajoutons l'element 
    * puis parcourons la liste pour un trie en fonction de la priorite. En ce qui concerne les heures
    * d'arrives,un autre trie est fais pour chaque element du tableau par rqpport a l'heure d'arrives
    * 
    */
   public boolean ajouter(Animal aml) {
	   
      // À COMPLÉTER
	   if(fileAttenteDesAnimaux.size() == 0 ) {
		   fileAttenteDesAnimaux.add(aml);
		   return true;
	   }else if(fileAttenteDesAnimaux.size() > 0) {
		   	   fileAttenteDesAnimaux.add(aml);
			   int taille = fileAttenteDesAnimaux.size();
			   
			// Trie par insertion par rapport aux animaux qui ont la meme priorite
			   for(int i = 0; i< taille; i++){
					   Animal index = fileAttenteDesAnimaux.get(i);
					   int j = i -1;
		
					   while(j>=0 && fileAttenteDesAnimaux.get(j).getPriorite()> index.getPriorite() ) {
						   fileAttenteDesAnimaux.set(fileAttenteDesAnimaux.indexOf(fileAttenteDesAnimaux.get(j+1)),fileAttenteDesAnimaux.get(j));
						   j--; 
					   }
					   
					   fileAttenteDesAnimaux.set(fileAttenteDesAnimaux.indexOf(fileAttenteDesAnimaux.get(j +1)), index);
					   
			   }
			   // Trie par insertion par rapport aux heures d'arrives pour les animaux qui ont la meme priorite
			 for(int i = 0; i< taille; i++){
				   Animal index = fileAttenteDesAnimaux.get(i);
				   int jd = i -1;
				   while(jd>=0 && fileAttenteDesAnimaux.get(jd).getPriorite() == index.getPriorite() && fileAttenteDesAnimaux.get(jd).getDateHeureArrivee().isAfter(index.getDateHeureArrivee()) ) {
						fileAttenteDesAnimaux.set(fileAttenteDesAnimaux.indexOf(fileAttenteDesAnimaux.get(jd+1)),fileAttenteDesAnimaux.get(jd));
						jd--; 
					   }
				   fileAttenteDesAnimaux.set(fileAttenteDesAnimaux.indexOf(fileAttenteDesAnimaux.get(jd +1)), index);		   
		   }
			   
				 return true;
			   }
			  
return false;
   }

	/**
	 * Cette méthode remplace l'animal 'amlARemplacer' par 'nouvelAml' dans la file d'attente 
	 * (fileAttenteDesAnimaux). 
	 * 
	 * Si 'amlARemplacer' et 'nouvelAml' ont la même priorité, la même date et heure d'arrivée, 
	 * le paramètre 'nouvelAml' est placé exactement à la même position que 'amlARemplacer'.
	 * 
	 * Si 'amlARemplacer' et 'nouvelAml' n'ont pas la même priorité, ou ils n'ont pas les mêmes
	 * dates et heures d'arrivée, le paramètre 'amlARemplacer' est supprimé de la file d'attente, 
	 * et 'nouvelAml' est ajouté selon sa priorité, sa date et heure d'arrivée.
	 * 
	 * Le remplacement ne doit pas être fait si l'une des conditions suivantes est vraie :
     *   - 'amlARemplacer' est null.
     *   - 'amlARemplacer' n'existe pas dans la file d'attente
     *   - 'nouvelAml' est null
	 * 
	 * @param amlARemplacer l'animal à remplacer
	 * @param nouvelAml le nouvel animal à placer dans la file d'attente
	 * @return vrai si le remplacement est fait, sinon faux
	 * 
	 * Implementation
	 * 
	 * suivis les intructions d'en haut
	 */
   public boolean remplacer(Animal amlARemplacer, Animal nouvelAml) {

      // À COMPLÉTER
	  if(amlARemplacer == null || (!fileAttenteDesAnimaux.contains(amlARemplacer))|| nouvelAml ==null) {
		  return false;
	  } else {
		  if(nouvelAml.getPriorite() == amlARemplacer.getPriorite() && 
				  					nouvelAml.getDateHeureArrivee().isEqual(amlARemplacer.getDateHeureArrivee())) {
			  	
			  fileAttenteDesAnimaux.set(fileAttenteDesAnimaux.indexOf(amlARemplacer), nouvelAml);
			  return true;
		  }
		  if(nouvelAml.getPriorite() != amlARemplacer.getPriorite() || 
					!nouvelAml.getDateHeureArrivee().isEqual(amlARemplacer.getDateHeureArrivee())) {

			  fileAttenteDesAnimaux.remove(fileAttenteDesAnimaux.indexOf(amlARemplacer));
			  ajouter(nouvelAml);
			  return true;
		  }
	  }
      return false;

   }

   /**
    * Cette méthode assigne le technicien 'tech' et le vétérinaire 'vet' à l'animal qui est à la
    * première position dans la file d'attente (fileAttenteDesAnimaux). Une fois qu'un 'tech' et un 'vet' 
    * sont assignés à un animal, ce dernier est retiré de la file d'attente et ajouté dans la liste des 
    * animaux qui ont un technicien et un vétérinaire (listeDesAnimauxAvecTechEtVetAssignes).
    * 
    * 
    * L'assignation ne doit pas être faite si l'une des conditions suivantes est vraie :
    *   - 'tech' est null.
    *   - 'vet' est null
    *   - la file d'attente (fileAttenteDesAnimaux) est vide
    * 
    * @param tech le technicien à assigner
    * @param vet le vétérinaire à assigner
    * @return vrai si l'assignation est faite, sinon faux
    */
	public boolean assignerTechnicienEtVeterinaire (Technicien tech, Veterinaire vet) {
	   
	   // À COMPLÉTER
		if(tech == null || vet == null || fileAttenteDesAnimaux.isEmpty() ) {
			return false;
		}else {
			//Affectons le medcin et technicien aux premier animal dans la liste d'attente 
			fileAttenteDesAnimaux.get(0).setTechnicien(tech);
			fileAttenteDesAnimaux.get(0).setVeterinaire(vet);
			// incrementons d'un pour le veterinaire et les techniciens
			tech.incAnimaux(); 
			vet.incAnimaux();
			//ajout dans les animaux ayant un veterinaire et technicien puis on les retire de liste d;attentes
			listeDesAnimauxAvecTechEtVetAssignes.add(fileAttenteDesAnimaux.get(0));
			retirerAnimal(fileAttenteDesAnimaux.get(0).getIdentifiant());
			
			
			return true;
		}
	   
	}
	
	/**
    * Cette méthode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) à partir
    * de son identifiant.
    * 
    * La méthode retourne l'animal qui a un identifiant égal à l'identifiant passé en paramètre, 
    * sinon null si aucun animal trouvé avec cet identifiant.
    * 
    * @param identifiant l'identifiant de l'animal à rechercher
    * @return l'animal ou null si aucun animal trouvé
    */
   public Animal rechercherParIdentifiantDansFileAttente(int identifiant) {

      // À COMPLÉTER
	   for(Animal unAnimal: fileAttenteDesAnimaux) {
	    	  if(unAnimal.getIdentifiant()== identifiant) {
	    		  return unAnimal;
	    	  }
	      }
      return null;

   }
   
	
   /**
    * Cette méthode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) et dans la liste
    * des animaux qui ont un technicien et un vétérinaire (listeDesAnimauxAvecTechEtVetAssignes) à partir
    * de son identifiant.
    * 
    * La méthode retourne l'animal qui a un identifiant égal à l'identifiant passé en paramètre, sinon null 
    * si aucun animal trouvé avec cet identifiant.
    * 
    * @param identifiant l'identifiant de l'animal à rechercher
    * @return l'animal ou null si aucun animal trouvé
    * 
    */
	public Animal rechercherParIdentifiant(int identifiant) {

		// À COMPLÉTER
		 for(Animal unAnimal: fileAttenteDesAnimaux) {
	    	  if(unAnimal.getIdentifiant()== identifiant) {
	    		  return unAnimal;
	    	  }
	      }
		 for(Animal unAnimal: listeDesAnimauxAvecTechEtVetAssignes) {
	    	  if(unAnimal.getIdentifiant()== identifiant) {
	    		  return unAnimal;
	    	  }
	      }
		return null;

	}
	
   /**
    * Cette méthode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) et dans la liste
    * des animaux qui ont un technicien et un vétérinaire (listeDesAnimauxAvecTechEtVetAssignes) à partir
    * de son prénom et de son espèce (chien ou chat).
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "CHIQUITA" est égal à "chiquita"
    * ou "CHIEN" est égal à "Chien".
    * 
    * La méthode retourne la liste des animaux qui ont le même prénom que le prénom passé en paramètre
    * et la même espéce que l'espèce passée en paramètre, sinon null si aucun animal trouvé avec ce 
    * prénom et cette espèce.
    * 
    * @param prenom le prénom de l'aminal
    * @param espece l'espéce de l'animal
    * @return la liste des animaux (ArrayList) ou null si aucun animal trouvé
    */
   public List<Animal> rechercherParPrenomEspece(String prenom, String espece) {
	   // Conversion des parametres en minuscule pour eviter les erreur case
	   prenom = prenom.toLowerCase();
	   espece = espece.toLowerCase();
      // À COMPLÉTER
	   List<Animal> listRechercher = new ArrayList<>();
	   for(Animal unAnimal: fileAttenteDesAnimaux) {
		   String tmpPrenom = unAnimal.getPrenom().toLowerCase();
		   String tmpEspece = unAnimal.getEspece().toLowerCase();
	    	  if( tmpPrenom.equals(prenom)  && tmpEspece.equals(espece)) {
	    		  listRechercher.add(unAnimal);
	    	  }
	      }
	   for(Animal unAnimal: listeDesAnimauxAvecTechEtVetAssignes) {
		   String tmpPrenom = unAnimal.getPrenom().toLowerCase();
		   String tmpEspece = unAnimal.getEspece().toLowerCase();
	    	  if(tmpPrenom.equals(prenom) && tmpEspece.equals(espece)) {
	    		  listRechercher.add(unAnimal);
	    	  }
	      }
	   if(listRechercher.isEmpty()) {
		   return null;
	   }else {
		   return listRechercher;
	   }
   }

	/**
	 * Cette méthode retire un animal de la file d'attente (fileAttenteDesAnimaux) à partir
	 * de son identifiant.
	 * 
     * La méthode retourne l'animal retiré qui a un identifiant égal à l'identifiant passé 
     * en paramètre, sinon null si aucun animal trouvé avec cet identifiant.
	 * 
	 * @param identifiant l'identifiant de l'animal à retirer.
	 * @return l'animal retiré ou null si aucun animal trouvé.
	 */
	public Animal retirerAnimal(int identifiant) {

		// À COMPLÉTER
      for(Animal unAnimal: fileAttenteDesAnimaux) {
    	  if(unAnimal.getIdentifiant() == identifiant) {
    		  fileAttenteDesAnimaux.remove(fileAttenteDesAnimaux.indexOf(unAnimal));
    		  return unAnimal;
    	  }
      }
      return null;

	}



}

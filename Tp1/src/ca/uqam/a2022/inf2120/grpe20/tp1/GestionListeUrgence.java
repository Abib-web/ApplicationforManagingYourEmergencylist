package ca.uqam.a2022.inf2120.grpe20.tp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UQAM - Automne 2022 - INF2120 - Groupe 20 - TP1
 * 
 * Classe GestionListeUrgence : cette classe d�finit les services d'une file d'attente 
 * dans laquelle les animaux sont organis�s en ordre d�croissant selon leurs priorit�s 
 * et leurs dates / heures d'arriv�e. Les priorit�s commencent de 1 � 5, o� 1 est la plus
 * grande priorit�, tandis que 5 est la plus petite. Les animaux de la plus grande priorit�
 * sont ajout�s au d�but de la liste. Les �l�ments de la m�me priorit� sont ordonn�s selon 
 * la date et l'heure d'arriv�e. 
 * 
 * VOUS DEVEZ COMPL�TER LES M�THODES SUIVANTES :
 *   - public boolean ajouter(Animal aml)
 *   - public boolean assignerTechnicienEtVeterinaire (Technicien tech, Veterinaire vet)
 *   - public Animal rechercherParIdentifiantDansFileAttente(int identifiant)
 *   - public Animal rechercherParIdentifiant(int identifiant)
 *   - public List<Animal> rechercherParPrenomEspece(String prenom, String espece)
 *   - public boolean remplacer(Animal amlARemplacer, Animal nouvelAml)
 *   - public Animal retirerAnimal(int identifiant)
 * 
 * VOIR LA JAVADOC DE CES M�THODES POUR PLUS DE D�TAILS SUR LEURS IMPL�MENTATIONS.
 * 
 * INFORMATIONS IMPORTANTES :
 * Ajoutez toute autre m�thode priv�e que vous jugez n�cessaire pour accomplir
 * ce travail.
 * 
 * @author VOTRE NOM VOTRE PR�NOM - VOTRE CODE PERMANENT
 * 
 * @version 4 octobre 2022
 */

public class GestionListeUrgence {

   // D�claration des constantes
   static final int PRIORITE_UN = 1;
   static final int PRIORITE_CINQ = 5;
   
   // D�claration des attributs d'instance
   
	// Liste des animaux dans la file d'attente sans technicien 
   // et v�t�rinaire assign�s
	private List<Animal> fileAttenteDesAnimaux;
	
   // Liste des animaux avec technicien et v�t�rinaire assign�s
	// Autrement dit des animaux qui recoivent maintenant des soins 
   private List<Animal> listeDesAnimauxAvecTechEtVetAssignes;

	/**
	 * Constructeur sans argument pour la cr�ation des listes vides
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
    * Retourne tous les animaux qui ont d�j� un technicien et
    * un v�t�rinaire assign�s.
    * 
    * @return la liste des animaux qui ont un technicien et un v�t�rinaire
    */
   public List<Animal> getListeDesAnimauxSousSoins() {
      return Collections.unmodifiableList(listeDesAnimauxAvecTechEtVetAssignes);
   }



   /**
    * Cette m�thode ajoute l'animal 'aml' pass� en param�tre dans la file d'attente (fileAttenteDesAnimaux)
    * selon sa priorit�, sa date et heure d'arriv�e. Ainsi les animaux de la plus grande priorit� sont plac�s
    * au d�but de la file. 
    * 
    * Les priorit�s commencent de 1 � 5, o� 1 est la plus grande priorit�, tandis que 5 est la plus petite.
    * 
    * Si 'aml' a la m�me priorit� qu'un autre qui existe d�j� dans la file d'attente, et sa date et heure 
    * d'arriv�e est plus grande que celle de ce dernier, il doit �tre plac� apr�s cet animal. 
    * 
    * Exemple 1 : supposons que a1, a2, et a3 sont les animaux avec les priorit�s et les dates / heures d'arriv�e
    *   a1 (la priorit� = 2, la date et heure d'arrive = 04/10/2022 08:45)
    *   a2 (la priorit� = 1, la date et heure d'arrive = 04/10/2022 09:45)
    *   a3 (la priorit� = 3, la date et heure d'arrive = 04/10/2022 10:45)
    *   
    *   La file d'attente se pr�sente comme suit apr�s l'ajout des trois animaux :
    *   [a2, a1, a3] o� a1 est � la 1ere position, a2 est � la 2e position, et a3 est � la 3e position.
    *  
    * Exemple 2 : supposons que a1, a2, et a3 sont les animaux avec les priorit�s et les dates / heures d'arriv�e
    *   a1 (la priorit� = 1, la date et heure d'arrive = 04/10/2022 07:10)
    *   a2 (la priorit� = 2, la date et heure d'arrive = 04/10/2022 08:20)
    *   a3 (la priorit� = 1, la date et heure d'arrive = 04/10/2022 09:55)
    *   
    *   La file d'attente se pr�sente comme suit apr�s l'ajout des trois animaux :
    *   [a1, a3, a2] o� a1 est � la 1ere position, a3 est � la 2e position, et a2 est � la 3e position.
    *   
    * L'animal 'aml' ne doit pas �tre ajout� dans la file d'attente (fileAttenteDesAnimaux) si l'une des conditions 
    * suivantes est vraie :
    *   - 'aml' est null.
    *   - 'aml' a une priorit� qui est inf�rieure � 1 ou sup�rieure � 5.
    *
    * @param aml l'animal � ajouter dans la file d'attente
    * @return vrai si 'aml' est ajout� dans la file d'attente, sinon faux
    * 
    * Implementation
    * 
    * Si la liste d'attente est vide, on ajoute un element sinon nous ajoutons l'element 
    * puis parcourons la liste pour un trie en fonction de la priorite. En ce qui concerne les heures
    * d'arrives,un autre trie est fais pour chaque element du tableau par rqpport a l'heure d'arrives
    * 
    */
   public boolean ajouter(Animal aml) {
	   
      // � COMPL�TER
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
	 * Cette m�thode remplace l'animal 'amlARemplacer' par 'nouvelAml' dans la file d'attente 
	 * (fileAttenteDesAnimaux). 
	 * 
	 * Si 'amlARemplacer' et 'nouvelAml' ont la m�me priorit�, la m�me date et heure d'arriv�e, 
	 * le param�tre 'nouvelAml' est plac� exactement � la m�me position que 'amlARemplacer'.
	 * 
	 * Si 'amlARemplacer' et 'nouvelAml' n'ont pas la m�me priorit�, ou ils n'ont pas les m�mes
	 * dates et heures d'arriv�e, le param�tre 'amlARemplacer' est supprim� de la file d'attente, 
	 * et 'nouvelAml' est ajout� selon sa priorit�, sa date et heure d'arriv�e.
	 * 
	 * Le remplacement ne doit pas �tre fait si l'une des conditions suivantes est vraie :
     *   - 'amlARemplacer' est null.
     *   - 'amlARemplacer' n'existe pas dans la file d'attente
     *   - 'nouvelAml' est null
	 * 
	 * @param amlARemplacer l'animal � remplacer
	 * @param nouvelAml le nouvel animal � placer dans la file d'attente
	 * @return vrai si le remplacement est fait, sinon faux
	 * 
	 * Implementation
	 * 
	 * suivis les intructions d'en haut
	 */
   public boolean remplacer(Animal amlARemplacer, Animal nouvelAml) {

      // � COMPL�TER
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
    * Cette m�thode assigne le technicien 'tech' et le v�t�rinaire 'vet' � l'animal qui est � la
    * premi�re position dans la file d'attente (fileAttenteDesAnimaux). Une fois qu'un 'tech' et un 'vet' 
    * sont assign�s � un animal, ce dernier est retir� de la file d'attente et ajout� dans la liste des 
    * animaux qui ont un technicien et un v�t�rinaire (listeDesAnimauxAvecTechEtVetAssignes).
    * 
    * 
    * L'assignation ne doit pas �tre faite si l'une des conditions suivantes est vraie :
    *   - 'tech' est null.
    *   - 'vet' est null
    *   - la file d'attente (fileAttenteDesAnimaux) est vide
    * 
    * @param tech le technicien � assigner
    * @param vet le v�t�rinaire � assigner
    * @return vrai si l'assignation est faite, sinon faux
    */
	public boolean assignerTechnicienEtVeterinaire (Technicien tech, Veterinaire vet) {
	   
	   // � COMPL�TER
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
    * Cette m�thode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) � partir
    * de son identifiant.
    * 
    * La m�thode retourne l'animal qui a un identifiant �gal � l'identifiant pass� en param�tre, 
    * sinon null si aucun animal trouv� avec cet identifiant.
    * 
    * @param identifiant l'identifiant de l'animal � rechercher
    * @return l'animal ou null si aucun animal trouv�
    */
   public Animal rechercherParIdentifiantDansFileAttente(int identifiant) {

      // � COMPL�TER
	   for(Animal unAnimal: fileAttenteDesAnimaux) {
	    	  if(unAnimal.getIdentifiant()== identifiant) {
	    		  return unAnimal;
	    	  }
	      }
      return null;

   }
   
	
   /**
    * Cette m�thode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) et dans la liste
    * des animaux qui ont un technicien et un v�t�rinaire (listeDesAnimauxAvecTechEtVetAssignes) � partir
    * de son identifiant.
    * 
    * La m�thode retourne l'animal qui a un identifiant �gal � l'identifiant pass� en param�tre, sinon null 
    * si aucun animal trouv� avec cet identifiant.
    * 
    * @param identifiant l'identifiant de l'animal � rechercher
    * @return l'animal ou null si aucun animal trouv�
    * 
    */
	public Animal rechercherParIdentifiant(int identifiant) {

		// � COMPL�TER
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
    * Cette m�thode recherche un animal dans la file d'attente (fileAttenteDesAnimaux) et dans la liste
    * des animaux qui ont un technicien et un v�t�rinaire (listeDesAnimauxAvecTechEtVetAssignes) � partir
    * de son pr�nom et de son esp�ce (chien ou chat).
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "CHIQUITA" est �gal � "chiquita"
    * ou "CHIEN" est �gal � "Chien".
    * 
    * La m�thode retourne la liste des animaux qui ont le m�me pr�nom que le pr�nom pass� en param�tre
    * et la m�me esp�ce que l'esp�ce pass�e en param�tre, sinon null si aucun animal trouv� avec ce 
    * pr�nom et cette esp�ce.
    * 
    * @param prenom le pr�nom de l'aminal
    * @param espece l'esp�ce de l'animal
    * @return la liste des animaux (ArrayList) ou null si aucun animal trouv�
    */
   public List<Animal> rechercherParPrenomEspece(String prenom, String espece) {
	   // Conversion des parametres en minuscule pour eviter les erreur case
	   prenom = prenom.toLowerCase();
	   espece = espece.toLowerCase();
      // � COMPL�TER
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
	 * Cette m�thode retire un animal de la file d'attente (fileAttenteDesAnimaux) � partir
	 * de son identifiant.
	 * 
     * La m�thode retourne l'animal retir� qui a un identifiant �gal � l'identifiant pass� 
     * en param�tre, sinon null si aucun animal trouv� avec cet identifiant.
	 * 
	 * @param identifiant l'identifiant de l'animal � retirer.
	 * @return l'animal retir� ou null si aucun animal trouv�.
	 */
	public Animal retirerAnimal(int identifiant) {

		// � COMPL�TER
      for(Animal unAnimal: fileAttenteDesAnimaux) {
    	  if(unAnimal.getIdentifiant() == identifiant) {
    		  fileAttenteDesAnimaux.remove(fileAttenteDesAnimaux.indexOf(unAnimal));
    		  return unAnimal;
    	  }
      }
      return null;

	}



}

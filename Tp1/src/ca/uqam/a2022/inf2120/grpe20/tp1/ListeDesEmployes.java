package ca.uqam.a2022.inf2120.grpe20.tp1;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.File;  // Import the File class
import java.util.Scanner;

/**
 * UQAM - Automne 2022 - INF2120 - Groupe 20 - TP1
 * 
 * Classe ListeDesEmployes : contient tous les employés (techniciens et vétérinaires) 
 * de la clinique vétérinaire Urgence Animale qui sont dans le fichier "Employes.csv".
 * 
 * VOUS DEVEZ COMPLÉTER LES MÉTHODES SUIVANTES : 
 *   - public static void lireFichierEmployes()
 *   - public static Technicien rechercherTechnicienParMatricule(String matricule)
 *   - public static Veterinaire rechercherVeterinaireParMatricule(String matricule)
 * 
 * VOIR LA JAVADOC DE CES MÉTHODES POUR PLUS DE DÉTAILS SUR LEURS IMPLÉMENTATIONS.
 * 
 * @author VOTRE NOM VOTRE PRÉNOM - VOTRE CODE PERMANENT
 * 
 * @version 4 octobre 2022
 */

public class ListeDesEmployes {

   // Déclaration des constantes
   private static final String EMPLOYES = "src/ca/uqam/a2022/inf2120/grpe20/tp1/Employes.csv";
   private static final String TSA      = "TSA";
   private static final String DMV      = "DMV";

   // La liste des employés (techniciens et vétérinaires)
   private static List<Employe> listeDesEmployes = new ArrayList<Employe>();
   

   /**
    * Retourne la liste des employés.
    * 
    * @return the listeDesEmployes
    */
   public static List<Employe> obtenirListeDesEmployes() {
      return Collections.unmodifiableList(listeDesEmployes);
   }

   

   /**
    * Cette méthode doit lire le fichier "Employes.csv", créer les techniciens
    * et les vétérinaires, ensuite les ajouter dans la liste des employés (listeDesEmployes).
    * 
    * Chaque ligne du fichier est composée des données d'un technicien ou d'un
    * vétérinaire. Si la ligne commence par : 
    *   a) TSA, c'est un technicien 
    *   b) DMV, c'est un vétérinaire
    * 
    */
   public static void lireFichierEmployes() {

     
	   try{
		      File myObj = new File(EMPLOYES); 
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		    	  String[] arrOfStr = data.split(";"); // A chaque line nous creons un tableaux grace aux separateur ;
		    	  if(i == 0) {
		    		  i++;
		    		  continue;
		    	  }else {
		    		  if(arrOfStr[0].equals(DMV)) {
		    			  Employe tmpDMV = new Veterinaire(arrOfStr[2],arrOfStr[1],arrOfStr[3],arrOfStr[0],arrOfStr[5]); // creation d'un veterinaire avec touts les elements du tableau  cree precedemments
				    	  listeDesEmployes.add(tmpDMV);
		    		  } else if(arrOfStr[0].equals(TSA)) {
		    			  Employe tmpTSA = new Technicien(arrOfStr[2],arrOfStr[1],arrOfStr[3],arrOfStr[0],arrOfStr[6]); // Creation d'un technicien
				    	  listeDesEmployes.add(tmpTSA);
		    		  }
			    	  
		    	  }
		    	  
		       i++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

   }

   /**
    * Cette méthode recherche un technicien dans la liste des employés (listeDesEmployes) à partir
    * de son matricule.
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "SCO54122" est égal à "sco54122".
    * 
    * La méthode retourne le technicien dont le matricule est égal au matricule passé en paramètre, 
    * sinon null si aucun technicien trouvé avec ce paramètre.
    * 
    * @param matricule le matricule du technicien recherché
    * @return le technicien ou null si aucun technicien trouvé
    * 
    * Implementation
    * Noous parcourons la boucle, puis verifions les matricules  de chaque Technicien  dans la liste avec celui du Technicien entre en argument 
    */
   public static Technicien rechercherTechnicienParMatricule(String matricule) {
	   
      // À COMPLÉTER
	   Technicien valeur = null;
	   int i = 0;
	   int taille = listeDesEmployes.size();
	   while( taille != 0 ) {
		   String tmpMatricule = listeDesEmployes.get(i).getMatricule();
		   if(matricule.toLowerCase().equals(tmpMatricule.toLowerCase())) {
			   valeur = (Technicien)listeDesEmployes.get(i);
			   break;
		   }else {
			   valeur=  null;
		   }
		   taille--;
		   i++;
	   }
	   return valeur;
   }
   
   /**
    * Cette méthode recherche un vétérinaire dans la liste des employés (listeDesEmployes) à partir
    * de son matricule.
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "DAN12345" est égal à "dan12345".
    * 
    * La méthode retourne le vétérinaire dont le matricule est égal au matricule passé en paramètre, 
    * sinon null si aucun vétérinaire trouvé avec ce paramètre.
    * 
    * @param matricule le matricule du vétérinaire recherché
    * @return le vétérinaire ou null si aucun vétérinaire trouvé
    * 
    * Implementation
    * Noous parcourons la boucle, puis verifions le matricules de chaque veterinaie dans la liste avec le matricule du veterinaie entre en argument 
    * 
    */
   public static Veterinaire rechercherVeterinaireParMatricule(String matricule) {

      // À COMPLÉTER
	   Veterinaire valeur = null;
	   int i = 0;
	   int taille = listeDesEmployes.size();
	   while( taille != 0 ) {
		   String tmpMatricule = listeDesEmployes.get(i).getMatricule();
		   if(matricule.toLowerCase().equals(tmpMatricule.toLowerCase())) {
			   valeur = (Veterinaire)listeDesEmployes.get(i);
			   break;
		   }else {
			   valeur=  null;
		   }
		   taille--;
		   i++;
	   }
	   return valeur;

   }
   


}

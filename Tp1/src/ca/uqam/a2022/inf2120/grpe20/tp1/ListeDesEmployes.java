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
 * Classe ListeDesEmployes : contient tous les employ�s (techniciens et v�t�rinaires) 
 * de la clinique v�t�rinaire Urgence Animale qui sont dans le fichier "Employes.csv".
 * 
 * VOUS DEVEZ COMPL�TER LES M�THODES SUIVANTES : 
 *   - public static void lireFichierEmployes()
 *   - public static Technicien rechercherTechnicienParMatricule(String matricule)
 *   - public static Veterinaire rechercherVeterinaireParMatricule(String matricule)
 * 
 * VOIR LA JAVADOC DE CES M�THODES POUR PLUS DE D�TAILS SUR LEURS IMPL�MENTATIONS.
 * 
 * @author VOTRE NOM VOTRE PR�NOM - VOTRE CODE PERMANENT
 * 
 * @version 4 octobre 2022
 */

public class ListeDesEmployes {

   // D�claration des constantes
   private static final String EMPLOYES = "src/ca/uqam/a2022/inf2120/grpe20/tp1/Employes.csv";
   private static final String TSA      = "TSA";
   private static final String DMV      = "DMV";

   // La liste des employ�s (techniciens et v�t�rinaires)
   private static List<Employe> listeDesEmployes = new ArrayList<Employe>();
   

   /**
    * Retourne la liste des employ�s.
    * 
    * @return the listeDesEmployes
    */
   public static List<Employe> obtenirListeDesEmployes() {
      return Collections.unmodifiableList(listeDesEmployes);
   }

   

   /**
    * Cette m�thode doit lire le fichier "Employes.csv", cr�er les techniciens
    * et les v�t�rinaires, ensuite les ajouter dans la liste des employ�s (listeDesEmployes).
    * 
    * Chaque ligne du fichier est compos�e des donn�es d'un technicien ou d'un
    * v�t�rinaire. Si la ligne commence par : 
    *   a) TSA, c'est un technicien 
    *   b) DMV, c'est un v�t�rinaire
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
    * Cette m�thode recherche un technicien dans la liste des employ�s (listeDesEmployes) � partir
    * de son matricule.
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "SCO54122" est �gal � "sco54122".
    * 
    * La m�thode retourne le technicien dont le matricule est �gal au matricule pass� en param�tre, 
    * sinon null si aucun technicien trouv� avec ce param�tre.
    * 
    * @param matricule le matricule du technicien recherch�
    * @return le technicien ou null si aucun technicien trouv�
    * 
    * Implementation
    * Noous parcourons la boucle, puis verifions les matricules  de chaque Technicien  dans la liste avec celui du Technicien entre en argument 
    */
   public static Technicien rechercherTechnicienParMatricule(String matricule) {
	   
      // � COMPL�TER
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
    * Cette m�thode recherche un v�t�rinaire dans la liste des employ�s (listeDesEmployes) � partir
    * de son matricule.
    * 
    * La recherche ne doit pas tenir compte de la casse. Par exemple : "DAN12345" est �gal � "dan12345".
    * 
    * La m�thode retourne le v�t�rinaire dont le matricule est �gal au matricule pass� en param�tre, 
    * sinon null si aucun v�t�rinaire trouv� avec ce param�tre.
    * 
    * @param matricule le matricule du v�t�rinaire recherch�
    * @return le v�t�rinaire ou null si aucun v�t�rinaire trouv�
    * 
    * Implementation
    * Noous parcourons la boucle, puis verifions le matricules de chaque veterinaie dans la liste avec le matricule du veterinaie entre en argument 
    * 
    */
   public static Veterinaire rechercherVeterinaireParMatricule(String matricule) {

      // � COMPL�TER
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

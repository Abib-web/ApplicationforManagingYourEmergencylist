package ca.uqam.a2022.inf2120.grpe20.tp1.tests;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import ca.uqam.a2022.inf2120.grpe20.tp1.*;
import ca.uqam.a2022.inf2120.grpe20.tp1.utiles.Clavier;

/**
 * UQAM - Automne 2022 - INF2120 - Groupe 20 - TP1
 * 
 * Classe TestGestionListeUrgence : Cette classe permet de tester les fonctions
 * du système de gestion de la liste d'urgence des animaux de la clinique
 * Urgence Animale (UA). Elle contient les méthodes de saisie, de validation, et
 * d'affichage. Elle fait appel aux services des classes Animal,
 * ListeDesEmployes,et GestionListeUrgence pour ajouter, modifier, enlever,
 * rechercher et afficher les animnaux, les techniciens, et les vétérnaires.
 * 
 * 
 * @author Ismael Doukoure
 * 
 * @version 4 octobre 2022
 */
public class TestGestionListeUrgence {

   // Déclaration des constantes
   static final char   OUI          = 'O';
   static final char   NON          = 'N';
   static final String MENU_GESTION = "\n\n  *** Gestion de la liste d'urgence de la clinique UA ***\n"
                                                   + "      1. Ajouter un animal dans la file d'attente\n"
                                                   + "      2. Assigner un technicien et un vétérinaire au premier animal "
                                                                  + "\n         dans la file d'attente\n"
                                                   + "      3. Modifier la priorité d'un animal dans la file d'attente\n" 
                                                   + "      4. Retirer un animal de la file d'attente\n"
                                                   + "      5. Rechercher un animal à partir de son identifiant\n" 
                                                   + "      6. Rechercher un animal à partir de son prénom et de son espèce\n" 
                                                   + "      7. Afficher tous les animaux dans la file d'attente\n"
                                                   + "      8. Afficher tous les animaux qui ont un technicien et un vétérinaire assignés\n"
                                                   + "      9. Afficher les techniciens et les vétérinaires\n"
                                                   + "      0. Quitter le programme\n\n";

   static final String MSG_INVITE                   = "  Entrez votre choix : ";

   static final String MSG_ERREUR                     = "\n  L’option choisie est invalide!";
   static final String MSG_ERREUR_VET_INEXISTANT      = " Erreur - Aucun vétérinaire avec le matricule ";
   static final String MSG_ERREUR_TECH_INEXISTANT     = " Erreur - Aucun technicien avec le matricule ";
   static final String MSG_ERREUR_ANIMAL_INEXISTANT_1 = " Erreur - Aucun animal dans la file d'attente avec l'identifiant ";
   static final String MSG_ERREUR_ANIMAL_INEXISTANT_2 = " Erreur - Aucun animal avec l'identifiant ";


   static final String MSG_INFO_ANIMAL_AJOUTER_SUCCES     = "Voici l'identifiant de l'animal ajouté dans la file d'attente : ";
   static final String MSG_INFO_ANIMAL_AJOUTER_ECHEC      = "L'ajout de l'animal dans la file d'attente a échoué ";
   static final String MSG_INFO_ASSIGNATION_SUCCES        = "Les assignations de technicien et de vétérinaire sont faites avec succès";
   static final String MSG_INFO_ASSIGNATION_ECHEC         = "Les assignations de technicien et de vétérinaire ont échoué";
   static final String MSG_INFO_CHANGER_PRIORITE_SUCCES   = "La priorité a été modifié avec succès, et l'animal est placé "
                                                             + "dans \n    la file d'attente selon sa nouvelle priorité";
   static final String MSG_INFO_CHANGER_PRIORITE_ECHEC    = "La modification de la priorité a échoué";
   static final String MSG_INFO_ENLEVE_SUCCES      = "L'animal a été retiré de la file d'attente avec succés";
   static final String MSG_INFO_ENLEVE_ECHEC       = "Aucun animal dans la file d'attente avec l'identifiant ";

   // Définition des méthodes

   /**
    * Afficher un message de remerciement
    */
   private static void afficherMsgRemerciement() {

      System.out.println("\n\n  Merci et à la prochaine ! ");
   }

   /**
    * Afficher un message
    */
   private static void afficherMsg(String msg) {

      System.out.println("\n\n   --------------------------------------------------------------------------");
      System.out.println("    " + msg);
      System.out.println("   --------------------------------------------------------------------------");
   }

   /**
    * Afficher les informations de l'animal passé en paramètre.
    * 
    * @param unAnimal l'animal à afficher
    */
   public static void afficherUnAnimal(Animal unAnimal) {

      System.out.println(" \n\n-----------------------------------------------------------------------------");
      System.out.println("  Voici les informations de l'animal ");
      System.out.println(" -----------------------------------------------------------------------------");
      System.out.println("    " + unAnimal);
      System.out.println(" \n\n");
      System.out.println("   --------------------------------------------------------------------------");
      
   }

   /**
    * Afficher les animaux de la liste passée en paramètre.
    * 
    * @param lesAnimaux la liste des animaux
    */
   public static void afficherLesAnimaux(List<Animal> lesAnimaux) {

      if (lesAnimaux == null || lesAnimaux.isEmpty()) {
         System.out.println("\n\n   --------------------------------------------------------------------------");
         System.out.println("    Aucun animal trouvé !");
         System.out.println("   --------------------------------------------------------------------------");

      } else {

         System.out.println("\n\n   -----------------------------------------------------------------------------");
         System.out.println("    Voici les informations demandées ");
         System.out.println("   -----------------------------------------------------------------------------");
         for (int i = 0; i < lesAnimaux.size(); i++) {
            System.out.println("    " + lesAnimaux.get(i) + "\n");
         }

         System.out.println("   --------------------------------------------------------------------------");
      }

   }
   
   /**
    * Afficher les techniciens et les vétérinaires.
    * 
    * @param listeDesEmployes liste des techniciens et des vétérinaires
    */
   public static void afficherLesEmployes(List<Employe> listeDesEmployes) {

      if (listeDesEmployes == null || listeDesEmployes.isEmpty()) {
         System.out.println("\n\n   --------------------------------------------------------------------------");
         System.out.println("    Aucun technicien ou vétérinaire trouvé !");
         System.out.println("   --------------------------------------------------------------------------");

      } else {
         System.out.println("\n\n   -----------------------------------------------------------------------------");
         System.out.println("    Voici les techniciens et les vétérinaires de la clinique Urgence Animale ");
         System.out.println("   -----------------------------------------------------------------------------");
         for (int i = 0; i < listeDesEmployes.size(); i++) {
            System.out.println("    " + listeDesEmployes.get(i));
         }
         System.out.println("   -----------------------------------------------------------------------------");
      }

   }

   /**
    * Afficher le message de bienvenue.
    */
   public static void afficherMessageBienvenue() {

      // Message de bienvenue et le resumé de ce que le programme fait.
      System.out.println("\n  -------------------------------------------------------------------------------------------");
      System.out.println("  Bienvenue dans le système de gestion de liste d'urgence de la clinique Urgence Animale.");
      System.out.println("  ---------------------------------------------------------------------------------------------");
   }

   /**
    * Saisir et valider le choix de menu de l'utilisateur.
    * 
    * @return l'option du menu choisi par l'utilisateur
    */
   public static int saisirValiderChoixMenuGestion() {

      int choixMenu = -1;

      do {

         try {

            System.out.println(MENU_GESTION);
            System.out.print(MSG_INVITE);
            choixMenu = Clavier.lireInt();

            if (choixMenu < 0 || choixMenu > 9) {
               System.out.println(MSG_ERREUR);
            }

         } catch (NumberFormatException e) {
            System.out.println(MSG_ERREUR);
         }

      } while (choixMenu < 0 || choixMenu > 9);

      return choixMenu;

   }

   /**
    * Saisir et valider la raison de l'urgence.
    * 
    * @return la raison de l'urgence
    */
   public static String saisirValiderRaisonUrgence() {

      String matricule;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez la raison de l'urgence : ");
         matricule = Clavier.lireString();
         matricule = matricule.trim();

         if (matricule.isEmpty()) {
            System.out.println("\n  La raison ne peut pas être vide!");
            estValide = false;
         }

      } while (!estValide);

      return matricule;

   }

   /**
    * Saisir et valider le matricule du technicien.
    * 
    * @return le matricule du technicien
    */
   public static String saisirValiderMatriculeTechnicien() {

      String matricule;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le matricule du technicien (format = DAN12345 ou dan12345): ");
         matricule = Clavier.lireString();
         matricule = matricule.trim();

         if (matricule.isEmpty()) {
            System.out.println("\n  Le matricule du technicien ne peut pas être vide!");
            estValide = false;
         }

      } while (!estValide);

      return matricule;

   }

   /**
    * Saisir et valider le matricule du vétérinaire.
    * 
    * @return le matricule du vétérinaire
    */
   public static String saisirValiderMatriculeVeterinaire() {

      String matricule;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le matricule du vétérinaire (format = DAN12345 ou dan12345): ");
         matricule = Clavier.lireString();
         matricule = matricule.trim();

         if (matricule.isEmpty()) {
            System.out.println("\n  Le matricule du vétérinaire ne peut pas être vide!");
            estValide = false;
         }

      } while (!estValide);

      return matricule;

   }

   /**
    * Saisir et valider l'âge de l'animal.
    * 
    * @return l'âge de l'animal
    */
   public static String saisirValiderAge() {

      String age;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez l'âge de l'animal (exemple : 8 mois ou 2 ans): ");
         age = Clavier.lireString();
         age = age.trim();

         if (age.isEmpty()) {
            System.out.println("\n  L'âge entrée est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return age;

   }

   /**
    * Saisir et valider la priorité.
    * 
    * @return la priorité à assigner à l'animal
    */
   public static int saisirValiderPriorite() {

      int priorite = -1;

      do {

         try {

            System.out.print("\n  Entrez la priorité (1 à 5 inclusivement): ");
            priorite = Clavier.lireInt();

            if (priorite < 1 || priorite > 5) {
               System.out.println("\n  La priorité saisie est invalide!");
            }

         } catch (NumberFormatException e) {
            System.out.println("\n  La priorité saisie est invalide!");
         }

      } while (priorite < 1 || priorite > 5);

      return priorite;

   }

   /**
    * Saisir et valider le prénom de l'animal.
    * 
    * @return le prénom de l'animal
    */
   public static String saisirValiderPrenomAnimal() {

      String nomAnimal;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le prénom de l'animal (le prénom ne doit pas être vide): ");
         nomAnimal = Clavier.lireString();
         nomAnimal = nomAnimal.trim();

         if (nomAnimal.isEmpty()) {
            System.out.println("\n  Le prénom saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return nomAnimal;

   }

   /**
    * Saisir et valider l'espèce de l'animal.
    * 
    * @return l'espèce de l'animal
    */
   public static String saisirValiderEspece() {

      String espece;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez l'espèce de l'animal (exemple : chien ou chat): ");
         espece = Clavier.lireString();
         espece = espece.trim();

         if (espece.isEmpty()) {
            System.out.println("\n  L'espèce n'est pas vide!");
            estValide = false;
         }

      } while (!estValide);

      return espece;

   }

   /**
    * Saisir et valider le nom du propriétaire.
    * 
    * @return le nom du propriétaire de l'animal
    */
   public static String saisirValiderNomProprietaire() {

      String nomProprietaire;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le nom du propriétaire (le nom ne doit pas être vide): ");
         nomProprietaire = Clavier.lireString();
         nomProprietaire = nomProprietaire.trim();

         if (nomProprietaire.isEmpty()) {
            System.out.println("\n  Le nom saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return nomProprietaire;

   }

   /**
    * Saisir et valider le prénom du propriétaire.
    * 
    * @return le prénom du propriétaire de l'animal
    */
   public static String saisirValiderPrenomProprietaire() {

      String nomProprietaire;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le prénom du propriétaire (le prénom ne doit pas être vide): ");
         nomProprietaire = Clavier.lireString();
         nomProprietaire = nomProprietaire.trim();

         if (nomProprietaire.isEmpty()) {
            System.out.println("\n  Le prénom saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return nomProprietaire;

   }

   /**
    * Saisir et valider le numéro d'assurance.
    * 
    * @return le numéro d'assurance
    */
   public static String saisirValiderNumeroAssurance() {

      String numeroAssurance;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le numéro d'assurance (le numéro d'assurance ne doit pas être vide): ");
         numeroAssurance = Clavier.lireString();
         numeroAssurance = numeroAssurance.trim();

         if (numeroAssurance.isEmpty()) {
            System.out.println("\n  Le numéro d'assurance saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return numeroAssurance;

   }

   /**
    * Saisit et valide le numéro de téléphone du propriétaire.
    * 
    * @return le numéro de téléphone du propriétaire
    */
   public static String saisirValiderNumeroTelephone() {

      String telephone;
      boolean estValide;

      Pattern pattern = Pattern.compile("\\d{3} \\d{3}-\\d{4}");

      do {

         estValide = true;

         System.out.print("\n  Entrez le numéro de téléphone du propriétaire (format : NNN NNN-NNNN): ");
         telephone = Clavier.lireString();
         telephone = telephone.trim();

         Matcher matcher = pattern.matcher(telephone);
         if (!matcher.matches()) {
            System.out.println("\n  Le numéro de téléphone est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return telephone;

   }

   /**
    * Saisir et valider l'identifiant de l'animal.
    * 
    * @return l'identifiant de l'animal
    */
   public static int saisirValiderIdentifiant() {

      int identifiant = -1;
      boolean estValide;

      do {

         estValide = true;

         try {

            System.out.print("\n  Entrez l'identifiant : ");
            identifiant = Clavier.lireInt();

         } catch (NumberFormatException e) {
            System.out.println("\n  L'identifiant est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return identifiant;

   }

   /**
    * Saisir et valider la réponse de la question à savoir si l'animal est
    * assuré ou non.
    * 
    * @return la réponse de la question d'assurance
    */
   public static char SaisirValiderReponseQuestionAssurance() {

      boolean estValide;
      char reponse;

      do {

         estValide = true;

         System.out.print("\n  L'animal est-il assuré (O ou o = Oui, N ou n = Non) : ");
         reponse = Clavier.lireCharLn();
         reponse = Character.toUpperCase(reponse);

         if (reponse != OUI && reponse != NON) {
            System.out.println("\n  La réponse saisie est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return reponse;
   }

   /**
    * Saisir les attributs d'un animal, créer et retourner l'animal
    * 
    * @return animal l'animal créé à partir des données saisies
    */
   public static Animal SaisirAttributsAnimal() {

      Animal animal = null;
      Proprietaire propriet;

      // Saisir le prénom de l'animal
      String nom = saisirValiderPrenomAnimal();

      // Saisir l'espèce de l'animal
      String espece = saisirValiderEspece();
      
      // Saisir l'âge de l'animal
      String age = saisirValiderAge();

      // Saisir la raison de l'urgence
      String raisonUrgence = saisirValiderRaisonUrgence();

      // Saisir la priorité
      int priorite = saisirValiderPriorite();

      // Saisir le prénom du propriétaire
      String prenomProprietaire = saisirValiderPrenomProprietaire();

      // Saisir le nom du propriétaire
      String nomProprietaire = saisirValiderNomProprietaire();

      // Saisir le téléphone du propriétaire
      String telephone = saisirValiderNumeroTelephone();

      // Saisir la réponse de la question
      char reponse = SaisirValiderReponseQuestionAssurance();

      if (reponse == OUI) {
         // Saisir le numéro d'assurance du propriétaire
         String numeroAssurance = saisirValiderNumeroAssurance();

         // Créer le propriétaire assuré
         propriet = new ProprietaireAssure(prenomProprietaire, nomProprietaire, telephone, numeroAssurance);

      } else {
         // Créer le propriétaire non assuré
         propriet = new Proprietaire(prenomProprietaire, nomProprietaire, telephone);
      }

      animal = new Animal(espece, nom, age, raisonUrgence, priorite, propriet);

      return animal;

   }

   // La méthode "main" est la porte d'entrée pour l'exécution (JVM)
   public static void main(String[] args) {

      // Déclarations des varibales locales
      boolean sortiePrincipale;
      boolean estValide;

      int choixMenu;
      int identifiant;

      String matricule;
      String nom;
      String espece;

      Animal animal;
      Animal animalCopie;
      Technicien tech;
      Veterinaire vete;
      GestionListeUrgence gestionListeUrgence;

      // Le message de bienvenue et le résumé de ce que le système fait
      afficherMessageBienvenue();

      // Appel de la méthode de lecture du fichier "Employes.csv" pour créer la liste
      // des techniciens et des vétérinaires
      ListeDesEmployes.lireFichierEmployes();

      // Création d'un objet de la classe GestionListeUrgence
      gestionListeUrgence = new GestionListeUrgence();

      do {

         // Initialisation des variables
         choixMenu = 0;
         sortiePrincipale = false;
         estValide = false;

         // Afficher le menu des options et saisir l'option choisie
         // par l'utilisateur
         choixMenu = saisirValiderChoixMenuGestion();

         switch (choixMenu) {

         case 1: // Ajout d'un animal dans la liste d'attente

            animal = SaisirAttributsAnimal();
            estValide = gestionListeUrgence.ajouter(animal);

            if (estValide) {
               // Afficher l'identifiant de l'animal
               afficherMsg(MSG_INFO_ANIMAL_AJOUTER_SUCCES + animal.getIdentifiant());
            } else {
               afficherMsg(MSG_INFO_ANIMAL_AJOUTER_ECHEC);
            }
 
            break;

         case 2: // Assignation d'un technicien et d'un vétérinaire 
                 // au premier animal dans la file d'attente

            // Saisir le matricule du technicien à assigner
            matricule = saisirValiderMatriculeTechnicien();
            tech = ListeDesEmployes.rechercherTechnicienParMatricule(matricule);
            if (tech == null) {
               afficherMsg(MSG_ERREUR_TECH_INEXISTANT + matricule);
            } else {
            
               // Saisir le matricule du vétérinaire à assigner
               matricule = saisirValiderMatriculeVeterinaire();
               vete = ListeDesEmployes.rechercherVeterinaireParMatricule(matricule);
               if (vete == null) {
                  afficherMsg(MSG_ERREUR_VET_INEXISTANT + matricule);
               }
               
               if (tech != null && vete != null) { 
                  estValide = gestionListeUrgence.assignerTechnicienEtVeterinaire(tech, vete);
                  if (estValide) {
                     afficherMsg(MSG_INFO_ASSIGNATION_SUCCES);
                  } else {
                     afficherMsg(MSG_INFO_ASSIGNATION_ECHEC);
                  }
               }
            }
            break;

         case 3: // Modification de la priorité d'un animal dans la file d'attente

            // Saisir l'identifiant de l'animal à modifier
            identifiant = saisirValiderIdentifiant();
            animal = gestionListeUrgence.rechercherParIdentifiantDansFileAttente(identifiant);
            if (animal == null) {
               afficherMsg(MSG_ERREUR_ANIMAL_INEXISTANT_1 + identifiant);
            } else {
               
               animalCopie = new Animal(animal);

               int nouvellePriorite = saisirValiderPriorite();
               animalCopie.setPriorite(nouvellePriorite);
               estValide = gestionListeUrgence.remplacer(animal, animalCopie);

               if (estValide) {
                  afficherMsg(MSG_INFO_CHANGER_PRIORITE_SUCCES);
               } else {
                  afficherMsg(MSG_INFO_CHANGER_PRIORITE_ECHEC);
               }
            }
            break;

         case 4: // Retirer un animal de la liste d'attente

            // Saisir l'identifiant de l'animal à enlever
            identifiant = saisirValiderIdentifiant();
            animal = gestionListeUrgence.retirerAnimal(identifiant);

            if (animal != null) {
               afficherMsg(MSG_INFO_ENLEVE_SUCCES);
            } else {
               afficherMsg(MSG_INFO_ENLEVE_ECHEC + identifiant);
            }

            break;

         case 5: // La recherche d'un animal à partir de son identifiant

            // Saisir l'identifiant de l'animal à rechercher
            identifiant = saisirValiderIdentifiant();
            animal = gestionListeUrgence.rechercherParIdentifiant(identifiant);
            
            if (animal != null) {
               afficherUnAnimal(animal);;
            } else {
               afficherMsg(MSG_ERREUR_ANIMAL_INEXISTANT_2 + identifiant);
            }

            break;
            
         case 6: // La recherche d'un animal à partir de son prénom et de son espèce

            // Saisir le prénom de l'animal
            nom = saisirValiderPrenomAnimal();
            // Saisir l'espèce de l'animal
            espece = saisirValiderEspece();
            
            afficherLesAnimaux(gestionListeUrgence.rechercherParPrenomEspece(nom, espece));
            
            break;

         case 7: // Afficher les animaux dans la file d'attente

            afficherLesAnimaux(gestionListeUrgence.getListeUrgenteDesAnimaux());

            break;

         case 8: // Afficher les animaux qui ont déjà un technicien et un vétérinaire

            afficherLesAnimaux(gestionListeUrgence.getListeDesAnimauxSousSoins());

            break;
            
         case 9: // Afficher les techniciens et les vétérinaires

            afficherLesEmployes(ListeDesEmployes.obtenirListeDesEmployes());

            break;


         case 0:

            afficherMsgRemerciement();
            sortiePrincipale = true;

         }

      } while (!sortiePrincipale);

   }

}

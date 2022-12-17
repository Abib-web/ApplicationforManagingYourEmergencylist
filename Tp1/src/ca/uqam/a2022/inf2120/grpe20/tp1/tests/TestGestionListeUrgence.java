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
 * du syst�me de gestion de la liste d'urgence des animaux de la clinique
 * Urgence Animale (UA). Elle contient les m�thodes de saisie, de validation, et
 * d'affichage. Elle fait appel aux services des classes Animal,
 * ListeDesEmployes,et GestionListeUrgence pour ajouter, modifier, enlever,
 * rechercher et afficher les animnaux, les techniciens, et les v�t�rnaires.
 * 
 * 
 * @author Ismael Doukoure
 * 
 * @version 4 octobre 2022
 */
public class TestGestionListeUrgence {

   // D�claration des constantes
   static final char   OUI          = 'O';
   static final char   NON          = 'N';
   static final String MENU_GESTION = "\n\n  *** Gestion de la liste d'urgence de la clinique UA ***\n"
                                                   + "      1. Ajouter un animal dans la file d'attente\n"
                                                   + "      2. Assigner un technicien et un v�t�rinaire au premier animal "
                                                                  + "\n         dans la file d'attente\n"
                                                   + "      3. Modifier la priorit� d'un animal dans la file d'attente\n" 
                                                   + "      4. Retirer un animal de la file d'attente\n"
                                                   + "      5. Rechercher un animal � partir de son identifiant\n" 
                                                   + "      6. Rechercher un animal � partir de son pr�nom et de son esp�ce\n" 
                                                   + "      7. Afficher tous les animaux dans la file d'attente\n"
                                                   + "      8. Afficher tous les animaux qui ont un technicien et un v�t�rinaire assign�s\n"
                                                   + "      9. Afficher les techniciens et les v�t�rinaires\n"
                                                   + "      0. Quitter le programme\n\n";

   static final String MSG_INVITE                   = "  Entrez votre choix : ";

   static final String MSG_ERREUR                     = "\n  L�option choisie est invalide!";
   static final String MSG_ERREUR_VET_INEXISTANT      = " Erreur - Aucun v�t�rinaire avec le matricule ";
   static final String MSG_ERREUR_TECH_INEXISTANT     = " Erreur - Aucun technicien avec le matricule ";
   static final String MSG_ERREUR_ANIMAL_INEXISTANT_1 = " Erreur - Aucun animal dans la file d'attente avec l'identifiant ";
   static final String MSG_ERREUR_ANIMAL_INEXISTANT_2 = " Erreur - Aucun animal avec l'identifiant ";


   static final String MSG_INFO_ANIMAL_AJOUTER_SUCCES     = "Voici l'identifiant de l'animal ajout� dans la file d'attente : ";
   static final String MSG_INFO_ANIMAL_AJOUTER_ECHEC      = "L'ajout de l'animal dans la file d'attente a �chou� ";
   static final String MSG_INFO_ASSIGNATION_SUCCES        = "Les assignations de technicien et de v�t�rinaire sont faites avec succ�s";
   static final String MSG_INFO_ASSIGNATION_ECHEC         = "Les assignations de technicien et de v�t�rinaire ont �chou�";
   static final String MSG_INFO_CHANGER_PRIORITE_SUCCES   = "La priorit� a �t� modifi� avec succ�s, et l'animal est plac� "
                                                             + "dans \n    la file d'attente selon sa nouvelle priorit�";
   static final String MSG_INFO_CHANGER_PRIORITE_ECHEC    = "La modification de la priorit� a �chou�";
   static final String MSG_INFO_ENLEVE_SUCCES      = "L'animal a �t� retir� de la file d'attente avec succ�s";
   static final String MSG_INFO_ENLEVE_ECHEC       = "Aucun animal dans la file d'attente avec l'identifiant ";

   // D�finition des m�thodes

   /**
    * Afficher un message de remerciement
    */
   private static void afficherMsgRemerciement() {

      System.out.println("\n\n  Merci et � la prochaine ! ");
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
    * Afficher les informations de l'animal pass� en param�tre.
    * 
    * @param unAnimal l'animal � afficher
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
    * Afficher les animaux de la liste pass�e en param�tre.
    * 
    * @param lesAnimaux la liste des animaux
    */
   public static void afficherLesAnimaux(List<Animal> lesAnimaux) {

      if (lesAnimaux == null || lesAnimaux.isEmpty()) {
         System.out.println("\n\n   --------------------------------------------------------------------------");
         System.out.println("    Aucun animal trouv� !");
         System.out.println("   --------------------------------------------------------------------------");

      } else {

         System.out.println("\n\n   -----------------------------------------------------------------------------");
         System.out.println("    Voici les informations demand�es ");
         System.out.println("   -----------------------------------------------------------------------------");
         for (int i = 0; i < lesAnimaux.size(); i++) {
            System.out.println("    " + lesAnimaux.get(i) + "\n");
         }

         System.out.println("   --------------------------------------------------------------------------");
      }

   }
   
   /**
    * Afficher les techniciens et les v�t�rinaires.
    * 
    * @param listeDesEmployes liste des techniciens et des v�t�rinaires
    */
   public static void afficherLesEmployes(List<Employe> listeDesEmployes) {

      if (listeDesEmployes == null || listeDesEmployes.isEmpty()) {
         System.out.println("\n\n   --------------------------------------------------------------------------");
         System.out.println("    Aucun technicien ou v�t�rinaire trouv� !");
         System.out.println("   --------------------------------------------------------------------------");

      } else {
         System.out.println("\n\n   -----------------------------------------------------------------------------");
         System.out.println("    Voici les techniciens et les v�t�rinaires de la clinique Urgence Animale ");
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

      // Message de bienvenue et le resum� de ce que le programme fait.
      System.out.println("\n  -------------------------------------------------------------------------------------------");
      System.out.println("  Bienvenue dans le syst�me de gestion de liste d'urgence de la clinique Urgence Animale.");
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
            System.out.println("\n  La raison ne peut pas �tre vide!");
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
            System.out.println("\n  Le matricule du technicien ne peut pas �tre vide!");
            estValide = false;
         }

      } while (!estValide);

      return matricule;

   }

   /**
    * Saisir et valider le matricule du v�t�rinaire.
    * 
    * @return le matricule du v�t�rinaire
    */
   public static String saisirValiderMatriculeVeterinaire() {

      String matricule;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le matricule du v�t�rinaire (format = DAN12345 ou dan12345): ");
         matricule = Clavier.lireString();
         matricule = matricule.trim();

         if (matricule.isEmpty()) {
            System.out.println("\n  Le matricule du v�t�rinaire ne peut pas �tre vide!");
            estValide = false;
         }

      } while (!estValide);

      return matricule;

   }

   /**
    * Saisir et valider l'�ge de l'animal.
    * 
    * @return l'�ge de l'animal
    */
   public static String saisirValiderAge() {

      String age;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez l'�ge de l'animal (exemple : 8 mois ou 2 ans): ");
         age = Clavier.lireString();
         age = age.trim();

         if (age.isEmpty()) {
            System.out.println("\n  L'�ge entr�e est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return age;

   }

   /**
    * Saisir et valider la priorit�.
    * 
    * @return la priorit� � assigner � l'animal
    */
   public static int saisirValiderPriorite() {

      int priorite = -1;

      do {

         try {

            System.out.print("\n  Entrez la priorit� (1 � 5 inclusivement): ");
            priorite = Clavier.lireInt();

            if (priorite < 1 || priorite > 5) {
               System.out.println("\n  La priorit� saisie est invalide!");
            }

         } catch (NumberFormatException e) {
            System.out.println("\n  La priorit� saisie est invalide!");
         }

      } while (priorite < 1 || priorite > 5);

      return priorite;

   }

   /**
    * Saisir et valider le pr�nom de l'animal.
    * 
    * @return le pr�nom de l'animal
    */
   public static String saisirValiderPrenomAnimal() {

      String nomAnimal;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le pr�nom de l'animal (le pr�nom ne doit pas �tre vide): ");
         nomAnimal = Clavier.lireString();
         nomAnimal = nomAnimal.trim();

         if (nomAnimal.isEmpty()) {
            System.out.println("\n  Le pr�nom saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return nomAnimal;

   }

   /**
    * Saisir et valider l'esp�ce de l'animal.
    * 
    * @return l'esp�ce de l'animal
    */
   public static String saisirValiderEspece() {

      String espece;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez l'esp�ce de l'animal (exemple : chien ou chat): ");
         espece = Clavier.lireString();
         espece = espece.trim();

         if (espece.isEmpty()) {
            System.out.println("\n  L'esp�ce n'est pas vide!");
            estValide = false;
         }

      } while (!estValide);

      return espece;

   }

   /**
    * Saisir et valider le nom du propri�taire.
    * 
    * @return le nom du propri�taire de l'animal
    */
   public static String saisirValiderNomProprietaire() {

      String nomProprietaire;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le nom du propri�taire (le nom ne doit pas �tre vide): ");
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
    * Saisir et valider le pr�nom du propri�taire.
    * 
    * @return le pr�nom du propri�taire de l'animal
    */
   public static String saisirValiderPrenomProprietaire() {

      String nomProprietaire;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le pr�nom du propri�taire (le pr�nom ne doit pas �tre vide): ");
         nomProprietaire = Clavier.lireString();
         nomProprietaire = nomProprietaire.trim();

         if (nomProprietaire.isEmpty()) {
            System.out.println("\n  Le pr�nom saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return nomProprietaire;

   }

   /**
    * Saisir et valider le num�ro d'assurance.
    * 
    * @return le num�ro d'assurance
    */
   public static String saisirValiderNumeroAssurance() {

      String numeroAssurance;
      boolean estValide;

      do {

         estValide = true;

         System.out.print("\n  Entrez le num�ro d'assurance (le num�ro d'assurance ne doit pas �tre vide): ");
         numeroAssurance = Clavier.lireString();
         numeroAssurance = numeroAssurance.trim();

         if (numeroAssurance.isEmpty()) {
            System.out.println("\n  Le num�ro d'assurance saisi est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return numeroAssurance;

   }

   /**
    * Saisit et valide le num�ro de t�l�phone du propri�taire.
    * 
    * @return le num�ro de t�l�phone du propri�taire
    */
   public static String saisirValiderNumeroTelephone() {

      String telephone;
      boolean estValide;

      Pattern pattern = Pattern.compile("\\d{3} \\d{3}-\\d{4}");

      do {

         estValide = true;

         System.out.print("\n  Entrez le num�ro de t�l�phone du propri�taire (format : NNN NNN-NNNN): ");
         telephone = Clavier.lireString();
         telephone = telephone.trim();

         Matcher matcher = pattern.matcher(telephone);
         if (!matcher.matches()) {
            System.out.println("\n  Le num�ro de t�l�phone est invalide!");
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
    * Saisir et valider la r�ponse de la question � savoir si l'animal est
    * assur� ou non.
    * 
    * @return la r�ponse de la question d'assurance
    */
   public static char SaisirValiderReponseQuestionAssurance() {

      boolean estValide;
      char reponse;

      do {

         estValide = true;

         System.out.print("\n  L'animal est-il assur� (O ou o = Oui, N ou n = Non) : ");
         reponse = Clavier.lireCharLn();
         reponse = Character.toUpperCase(reponse);

         if (reponse != OUI && reponse != NON) {
            System.out.println("\n  La r�ponse saisie est invalide!");
            estValide = false;
         }

      } while (!estValide);

      return reponse;
   }

   /**
    * Saisir les attributs d'un animal, cr�er et retourner l'animal
    * 
    * @return animal l'animal cr�� � partir des donn�es saisies
    */
   public static Animal SaisirAttributsAnimal() {

      Animal animal = null;
      Proprietaire propriet;

      // Saisir le pr�nom de l'animal
      String nom = saisirValiderPrenomAnimal();

      // Saisir l'esp�ce de l'animal
      String espece = saisirValiderEspece();
      
      // Saisir l'�ge de l'animal
      String age = saisirValiderAge();

      // Saisir la raison de l'urgence
      String raisonUrgence = saisirValiderRaisonUrgence();

      // Saisir la priorit�
      int priorite = saisirValiderPriorite();

      // Saisir le pr�nom du propri�taire
      String prenomProprietaire = saisirValiderPrenomProprietaire();

      // Saisir le nom du propri�taire
      String nomProprietaire = saisirValiderNomProprietaire();

      // Saisir le t�l�phone du propri�taire
      String telephone = saisirValiderNumeroTelephone();

      // Saisir la r�ponse de la question
      char reponse = SaisirValiderReponseQuestionAssurance();

      if (reponse == OUI) {
         // Saisir le num�ro d'assurance du propri�taire
         String numeroAssurance = saisirValiderNumeroAssurance();

         // Cr�er le propri�taire assur�
         propriet = new ProprietaireAssure(prenomProprietaire, nomProprietaire, telephone, numeroAssurance);

      } else {
         // Cr�er le propri�taire non assur�
         propriet = new Proprietaire(prenomProprietaire, nomProprietaire, telephone);
      }

      animal = new Animal(espece, nom, age, raisonUrgence, priorite, propriet);

      return animal;

   }

   // La m�thode "main" est la porte d'entr�e pour l'ex�cution (JVM)
   public static void main(String[] args) {

      // D�clarations des varibales locales
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

      // Le message de bienvenue et le r�sum� de ce que le syst�me fait
      afficherMessageBienvenue();

      // Appel de la m�thode de lecture du fichier "Employes.csv" pour cr�er la liste
      // des techniciens et des v�t�rinaires
      ListeDesEmployes.lireFichierEmployes();

      // Cr�ation d'un objet de la classe GestionListeUrgence
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

         case 2: // Assignation d'un technicien et d'un v�t�rinaire 
                 // au premier animal dans la file d'attente

            // Saisir le matricule du technicien � assigner
            matricule = saisirValiderMatriculeTechnicien();
            tech = ListeDesEmployes.rechercherTechnicienParMatricule(matricule);
            if (tech == null) {
               afficherMsg(MSG_ERREUR_TECH_INEXISTANT + matricule);
            } else {
            
               // Saisir le matricule du v�t�rinaire � assigner
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

         case 3: // Modification de la priorit� d'un animal dans la file d'attente

            // Saisir l'identifiant de l'animal � modifier
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

            // Saisir l'identifiant de l'animal � enlever
            identifiant = saisirValiderIdentifiant();
            animal = gestionListeUrgence.retirerAnimal(identifiant);

            if (animal != null) {
               afficherMsg(MSG_INFO_ENLEVE_SUCCES);
            } else {
               afficherMsg(MSG_INFO_ENLEVE_ECHEC + identifiant);
            }

            break;

         case 5: // La recherche d'un animal � partir de son identifiant

            // Saisir l'identifiant de l'animal � rechercher
            identifiant = saisirValiderIdentifiant();
            animal = gestionListeUrgence.rechercherParIdentifiant(identifiant);
            
            if (animal != null) {
               afficherUnAnimal(animal);;
            } else {
               afficherMsg(MSG_ERREUR_ANIMAL_INEXISTANT_2 + identifiant);
            }

            break;
            
         case 6: // La recherche d'un animal � partir de son pr�nom et de son esp�ce

            // Saisir le pr�nom de l'animal
            nom = saisirValiderPrenomAnimal();
            // Saisir l'esp�ce de l'animal
            espece = saisirValiderEspece();
            
            afficherLesAnimaux(gestionListeUrgence.rechercherParPrenomEspece(nom, espece));
            
            break;

         case 7: // Afficher les animaux dans la file d'attente

            afficherLesAnimaux(gestionListeUrgence.getListeUrgenteDesAnimaux());

            break;

         case 8: // Afficher les animaux qui ont d�j� un technicien et un v�t�rinaire

            afficherLesAnimaux(gestionListeUrgence.getListeDesAnimauxSousSoins());

            break;
            
         case 9: // Afficher les techniciens et les v�t�rinaires

            afficherLesEmployes(ListeDesEmployes.obtenirListeDesEmployes());

            break;


         case 0:

            afficherMsgRemerciement();
            sortiePrincipale = true;

         }

      } while (!sortiePrincipale);

   }

}

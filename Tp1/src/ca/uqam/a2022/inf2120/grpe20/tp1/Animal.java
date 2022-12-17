package ca.uqam.a2022.inf2120.grpe20.tp1;
import java.time.LocalDateTime;	
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Animal : Cette classe contient tous les attributs d'un animal de la clinique
 * vétérinaire 'Urgence Animale' et les méthodes pour manipuler ces attributs.
 * 
 * VOUS DEVEZ COMPLÉTER LA MÉTHODE "equals(Object obj)". VOIR LA JAVADOC DE
 * CETTE MÉTHODE POUR PLUS DE DÉTAILS SUR SON IMPLÉMENTATION.
 * 
 * VOUS NE DEVEZ FAIRE AUCUN AUTRE CHANGEMENT DANS CETTE CLASSE APRÈS LA
 * RÉDÉFINITION DE LA MÉTHODE "equals(Object obj)".
 * 
 * @author Ismael Doukoure
 * @version 4 octobre 2022
 * Modifié par : VOTRE NOM VOTRE PRÉNOM - VOTRE CODE PERMANENT
 *
 */
public class Animal {

   // Déclaration d'un attribut de classe
   private static int sequence = 1000;

   // Déclaration des attributs d'instance
   private Integer           identifiant;
   private int           priorite;
   private String        espece;
   private String        prenom;
   private String        age;
   private String        raisonUrgence;
   private LocalDateTime dateHeureArrivee;
   private Proprietaire  proprietaire;
   private Veterinaire   veterinaire;
   private Technicien    technicien;

   /**
    * @param espece l'espèce de l'animal (chien ou chat)
    * @param prenom le prénom de l'animal
    * @param age l'âge de l'animal
    * @param raisonUrgence la raison de l'urgence
    * @param priorite la priorité accordée à l'animal
    * @param proprietaire le propriétare de l'animal
    */
   public Animal(String espece, String prenom, String age, String raisonUrgence, int priorite,
		   Proprietaire proprietaire) {
      this.espece = espece;
      this.prenom = prenom;
      this.age = age;
      this.raisonUrgence = raisonUrgence;
      this.priorite = priorite;
      this.proprietaire = proprietaire;

      identifiant = sequence;
      sequence++;
      
      dateHeureArrivee = LocalDateTime.now();
   }
   
   /**
    * Constructeur de copie. Construit un nouvel animal avec des valeurs 
    * d'attributs identiques à l'animal passé en parametre. L'identifiant
    * est aussi copié.
    *
    * @param a l'animal à copier. 
    * ANTÉCÉDENT : a n'est pas null (ceci signifie qu'on assure le bon 
    *              fonctionnement de ce constructeur seulement si a n'est 
    *              pas null).
    */
    public Animal(Animal a) {
      this(a.espece, a.prenom, a.age, a.raisonUrgence, a.priorite, a.proprietaire);
      this.identifiant = a.identifiant;
      this.dateHeureArrivee = a.dateHeureArrivee;
    }

   /**
    * Retourne l'identifiant de l'animal.
    * 
    * @return identifiant
    */
   public int getIdentifiant() {
      return identifiant;
   }
   
   /**
    * Retourne le prénom de l'animal.
    * 
    * @return prenom
    */
   public String getPrenom() {
      return prenom;
   }
   
   /**
    * Retourne l'espèce de l'animal.
    * 
    * @return the espece
    */
   public String getEspece() {
      return espece;
   }

   /**
    * Retourne la date et l'heure d'arrivée de l'animal.
    * 
    * @return dateHeureArrivee
    */
   public LocalDateTime getDateHeureArrivee() {
      return dateHeureArrivee;
   }

   /**
    * Retourne la priorité de l'animal
    * 
    * @return priorite
    */
   public int getPriorite() {
      return priorite;
   }

   /**
    * Modifie la priorité de l'animal.
    * 
    * @param priorite 
    */
   public void setPriorite(int priorite) {
      this.priorite = priorite;
   }

   /**
    * Modifie l'attribut veterinaire.
    * 
    * @param veterinaire
    */
   public void setVeterinaire(Veterinaire veterinaire) {
      this.veterinaire = veterinaire;
   }

   /**
    * Modifie l'attribut technicien.
    * 
    * @param technicien
    */
   public void setTechnicien(Technicien technicien) {
      this.technicien = technicien;
   }

   @Override
   public String toString() {

      String animal = "\n    Identifiant = " + identifiant 
                              + " | Prénom = " + prenom 
                              + " | Espèce = " + espece
                              + " | Age  =  " + age 
                              + "\n    Raison d'urgence = " + raisonUrgence
                              + "\n    Priorité = " + priorite 
                              + "\n    Date et heure d'arrivée = "
                                       + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(dateHeureArrivee)
                              + "\n    Propriétaire  = " + proprietaire 
                              + "\n    Technicien    = " + ((technicien == null) ? " Aucun" : technicien) 
                              + "\n    Vétérinaire   = " + ((veterinaire == null) ? " Aucun" : veterinaire);

      return animal;

   }
   
   
   /**
    * Cette méthode doit redéfinir la méthode "equals(Object obj)" de la classe
    * Object pour comparer deux animaux.
    *
    * Deux animaux sont égaux si et seulement s'ils ont le même identifiant.
    * Vous devez retourner vrai si les deux animaux sont égaaux, sinon faux.
    */
   @Override
   public boolean equals(Object obj) {
	   boolean estEgal = false;
	   // Si les deux (2) références sont identiques
	   if (this == obj) {
	   estEgal = true;
	   } else if (obj != null &&
			   this.getClass() == obj.getClass()) {

	    // conversion de obj en Animal
	    Animal unAnimal = (Animal)obj;
	    estEgal = identifiant.equals(unAnimal.getIdentifiant());
	   }
	   return estEgal;

   }


}

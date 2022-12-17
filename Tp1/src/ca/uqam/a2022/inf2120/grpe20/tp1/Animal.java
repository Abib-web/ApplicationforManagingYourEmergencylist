package ca.uqam.a2022.inf2120.grpe20.tp1;
import java.time.LocalDateTime;	
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Animal : Cette classe contient tous les attributs d'un animal de la clinique
 * v�t�rinaire 'Urgence Animale' et les m�thodes pour manipuler ces attributs.
 * 
 * VOUS DEVEZ COMPL�TER LA M�THODE "equals(Object obj)". VOIR LA JAVADOC DE
 * CETTE M�THODE POUR PLUS DE D�TAILS SUR SON IMPL�MENTATION.
 * 
 * VOUS NE DEVEZ FAIRE AUCUN AUTRE CHANGEMENT DANS CETTE CLASSE APR�S LA
 * R�D�FINITION DE LA M�THODE "equals(Object obj)".
 * 
 * @author Ismael Doukoure
 * @version 4 octobre 2022
 * Modifi� par : VOTRE NOM VOTRE PR�NOM - VOTRE CODE PERMANENT
 *
 */
public class Animal {

   // D�claration d'un attribut de classe
   private static int sequence = 1000;

   // D�claration des attributs d'instance
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
    * @param espece l'esp�ce de l'animal (chien ou chat)
    * @param prenom le pr�nom de l'animal
    * @param age l'�ge de l'animal
    * @param raisonUrgence la raison de l'urgence
    * @param priorite la priorit� accord�e � l'animal
    * @param proprietaire le propri�tare de l'animal
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
    * d'attributs identiques � l'animal pass� en parametre. L'identifiant
    * est aussi copi�.
    *
    * @param a l'animal � copier. 
    * ANT�C�DENT : a n'est pas null (ceci signifie qu'on assure le bon 
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
    * Retourne le pr�nom de l'animal.
    * 
    * @return prenom
    */
   public String getPrenom() {
      return prenom;
   }
   
   /**
    * Retourne l'esp�ce de l'animal.
    * 
    * @return the espece
    */
   public String getEspece() {
      return espece;
   }

   /**
    * Retourne la date et l'heure d'arriv�e de l'animal.
    * 
    * @return dateHeureArrivee
    */
   public LocalDateTime getDateHeureArrivee() {
      return dateHeureArrivee;
   }

   /**
    * Retourne la priorit� de l'animal
    * 
    * @return priorite
    */
   public int getPriorite() {
      return priorite;
   }

   /**
    * Modifie la priorit� de l'animal.
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
                              + " | Pr�nom = " + prenom 
                              + " | Esp�ce = " + espece
                              + " | Age  =  " + age 
                              + "\n    Raison d'urgence = " + raisonUrgence
                              + "\n    Priorit� = " + priorite 
                              + "\n    Date et heure d'arriv�e = "
                                       + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(dateHeureArrivee)
                              + "\n    Propri�taire  = " + proprietaire 
                              + "\n    Technicien    = " + ((technicien == null) ? " Aucun" : technicien) 
                              + "\n    V�t�rinaire   = " + ((veterinaire == null) ? " Aucun" : veterinaire);

      return animal;

   }
   
   
   /**
    * Cette m�thode doit red�finir la m�thode "equals(Object obj)" de la classe
    * Object pour comparer deux animaux.
    *
    * Deux animaux sont �gaux si et seulement s'ils ont le m�me identifiant.
    * Vous devez retourner vrai si les deux animaux sont �gaaux, sinon faux.
    */
   @Override
   public boolean equals(Object obj) {
	   boolean estEgal = false;
	   // Si les deux (2) r�f�rences sont identiques
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

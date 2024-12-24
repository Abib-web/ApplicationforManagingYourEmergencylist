# Application for Managing Your Emergency List

## Description

**Application for Managing Your Emergency List** is a management system designed for veterinary clinics. This program allows efficient management of emergency animal care queues. The main functionalities include:

- **Animal Registration**:
  - Register animals for care based on the date and time of arrival.
  - Assign a priority level defined by an animal health technician.
- **Care Order Management**:
  - Treat animals according to priority and arrival time.
- **Staff Management**:
  - Assign technicians and veterinarians to animals in the queue.
  - Modify, search, and display information about animals and staff.

## Key Features

### Animal Management
1. Add animals to the waiting list.
2. Modify an animal’s priority.
3. Remove an animal from the waiting list.
4. Search for animals by ID or other criteria.

### Staff Management
1. Display the list of technicians and veterinarians.
2. Assign technicians and veterinarians to animals in need of care.

### Interactive Display
1. View all animals in the queue.
2. Display animals already assigned to a technician and veterinarian.

## Console Interaction Example

Below is an example of how the program interacts with the user through the console:

```plaintext
-------------------------------------------------------------------------------------------
  Bienvenue dans le système de gestion de liste d'urgence de la clinique Urgence Animale.
  ---------------------------------------------------------------------------------------------


  *** Gestion de la liste d'urgence de la clinique UA ***
      1. Ajouter un animal dans la file d'attente
      2. Assigner un technicien et un vétérinaire au premier animal 
         dans la file d'attente
      3. Modifier la priorité d'un animal dans la file d'attente
      4. Retirer un animal de la file d'attente
      5. Rechercher un animal à partir de son identifiant
      6. Rechercher un animal à partir de son prénom et de son espèce
      7. Afficher tous les animaux dans la file d'attente
      8. Afficher tous les animaux qui ont un technicien et un vétérinaire assignés
      9. Afficher les techniciens et les vétérinaires
      0. Quitter le programme


  Entrez votre choix : 1

  Entrez le prénom de l'animal (le prénom ne doit pas être vide): Milou

  Entrez l'espèce de l'animal (exemple : chien ou chat): chien

  Entrez l'âge de l'animal (exemple : 8 mois ou 2 ans): 4mois

  Entrez la raison de l'urgence : Triste

  Entrez la priorité (1 à 5 inclusivement): 3

  Entrez le prénom du propriétaire (le prénom ne doit pas être vide): Cristian

  Entrez le nom du propriétaire (le nom ne doit pas être vide): Kone

  Entrez le numéro de téléphone du propriétaire (format : NNN NNN-NNNN): 3232224433

  Le numéro de téléphone est invalide!

  Entrez le numéro de téléphone du propriétaire (format : NNN NNN-NNNN): 222 333-4332

  L'animal est-il assuré (O ou o = Oui, N ou n = Non) : O

  Entrez le numéro d'assurance (le numéro d'assurance ne doit pas être vide): 121123445


   --------------------------------------------------------------------------
    Voici l'identifiant de l'animal ajouté dans la file d'attente : 1000
   --------------------------------------------------------------------------


  *** Gestion de la liste d'urgence de la clinique UA ***
      1. Ajouter un animal dans la file d'attente
      2. Assigner un technicien et un vétérinaire au premier animal 
         dans la file d'attente
      3. Modifier la priorité d'un animal dans la file d'attente
      4. Retirer un animal de la file d'attente
      5. Rechercher un animal à partir de son identifiant
      6. Rechercher un animal à partir de son prénom et de son espèce
      7. Afficher tous les animaux dans la file d'attente
      8. Afficher tous les animaux qui ont un technicien et un vétérinaire assignés
      9. Afficher les techniciens et les vétérinaires
      0. Quitter le programme


  Entrez votre choix : 7


   -----------------------------------------------------------------------------
    Voici les informations demandées 
   -----------------------------------------------------------------------------
    
    Identifiant = 1000 | Prénom = Milou | Espèce = chien | Age  =  4mois
    Raison d'urgence = Triste
    Priorité = 3
    Date et heure d'arrivée = 24 déc. 2024, 14 h 53 min 13 s
    Propriétaire  = Kone Cristian | 222 333-4332 | 121123445
    Technicien    =  Aucun
    Vétérinaire   =  Aucun

   --------------------------------------------------------------------------


  *** Gestion de la liste d'urgence de la clinique UA ***
      1. Ajouter un animal dans la file d'attente
      2. Assigner un technicien et un vétérinaire au premier animal 
         dans la file d'attente
      3. Modifier la priorité d'un animal dans la file d'attente
      4. Retirer un animal de la file d'attente
      5. Rechercher un animal à partir de son identifiant
      6. Rechercher un animal à partir de son prénom et de son espèce
      7. Afficher tous les animaux dans la file d'attente
      8. Afficher tous les animaux qui ont un technicien et un vétérinaire assignés
      9. Afficher les techniciens et les vétérinaires
      0. Quitter le programme


  Entrez votre choix : 
```

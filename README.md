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
  Welcome to the emergency list management system for the Urgence Animale clinic.
-------------------------------------------------------------------------------------------

*** Emergency List Management for Urgence Animale Clinic ***
    1. Add an animal to the waiting list
    2. Assign a technician and veterinarian to the first animal 
       in the waiting list
    3. Modify the priority of an animal in the waiting list
    4. Remove an animal from the waiting list
    5. Search for an animal by ID
    6. Search for an animal by name and species
    7. Display all animals in the waiting list
    8. Display all animals assigned to a technician and veterinarian
    9. Display the list of technicians and veterinarians
    0. Exit the program

Enter your choice: 1

Enter the animal’s name (cannot be empty): Milou

Enter the animal’s species (e.g., dog or cat): dog

Enter the animal’s age (e.g., 8 months or 2 years): 4 months

Enter the reason for the emergency: Sad

Enter the priority (1 to 5): 3

Enter the owner’s first name (cannot be empty): Cristian

Enter the owner’s last name (cannot be empty): Kone

Enter the owner’s phone number (format: NNN NNN-NNNN): 3232224433

The phone number is invalid!

Enter the owner’s phone number (format: NNN NNN-NNNN): 222 333-4332

Is the animal insured (O or o = Yes, N or n = No): O

Enter the insurance number (cannot be empty): 121123445

--------------------------------------------------------------------------
Here is the animal’s ID added to the waiting list: 1000
--------------------------------------------------------------------------

Enter your choice: 7

-------------------------------------------------------------------------------
Here are the requested details:
-------------------------------------------------------------------------------

ID = 1000 | Name = Milou | Species = dog | Age = 4 months
Emergency Reason = Sad
Priority = 3
Date and Time of Arrival = Dec 24, 2024, 2:53:13 PM
Owner = Cristian Kone | 222 333-4332 | 121123445
Technician = None
Veterinarian = None
-------------------------------------------------------------------------------
```

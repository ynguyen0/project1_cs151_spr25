# Project 1: CS 151, Spring 2025
## Overview
For Project 1, we created an Animal Shelter Management Program. The shelter management class manages the employees that work at this shelter. There are two types of employees- Staff and Vets, who are responsible for ensuring that our pets are healthy and well taken care of. This shelter currently only carries Hamsters and Cats, which are adoptable by guests that visit the shelter. They can also schedule playtime appointments to decide if the pet is a perfect match for them.

## Design
This program is designed to use OOP principles in Java for organized animal shelter management. We built the system by developing key classes that represent different agents within the shelter, each with their own tasks and behaviors. The UML diagram is also attached as a png file in this repository. 

### Shelter Management Class:
This class is responsible for overseeing shelter operations. This class manages the employees, the shelter’s schedule, housing the pets, and keeping track of donations. 

### Employee Classes:
There are two types of employees, the staff and vets. The staff class is for the employees to manage their jobs by checking their tasks, calculating bonuses, requesting lunch breaks, and working. The vet class is more focused on the healthcare of the pets, allowing them to manage prescriptions and log the pets’ vitals. Both classes implement an employee interface so they can share attributes like name, ID, and role, while also supporting specialized tasks for each job.

### Pet Classes:
The shelter currently cares for two types of animals: Hamsters and Cats. Both are represented as subclasses of an abstract Pet class, which defines common attributes such as name, age, and species, which can all be viewed in the pet’s profile. Each animal subclass has specific characteristics for each pet.

### Appointment System:
Guests can interact with the pets by booking an appointment to play with them.  The program tracks which animals are available for adoption and whether playtime sessions have been scheduled.


## Installation Instructions
1. Install the program by cloning this repository onto your local environment.
2. Enter this command into your terminal: 
```git clone https://github.com/ynguyen0/project1_cs151_spr25.git```

## Usage
1. To start the program, run the Console class.
2. You will be prompted to select an option from the main menu. Enter the corresponding input to proceed.
3. From there, additional submenu options will appear based on your selection. Continue choosing options until you reach your desired command.
4. Once a command is executed, the program will verify this by printing a confirmation message to the console.
5. To exit the program, select the “Exit” option on the menu.

## Contribution
Kalyn Bui: Kalyn was in charge of the classes Pet, Hamster, and Cat, and Console. 

Ashley Roman: Ashley was in charge of the classes ShelterManagement, Guest, and Appointment.

Ynha Nguyen: Ynha was in charge of the classes Employee, Vet, Staff.

Some of these classes required us to work cross-functionally, so there was some collaboration in each class. For example, Kalyn led the development of the Console class, which required effort from the rest of the team so that it would run smoothly with all of our other classes. Essentially, we coded and led the majority of our own classes with each other’s support and feedback. 


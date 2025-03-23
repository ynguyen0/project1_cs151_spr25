package employees;
import animals.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Shelter Management class for Animal Shelter program
 *
 * @author: Ashley Roman
 * fields: capcity, donationBin, funds, staff, pets, playDates
 * methods: updateEmployees(), createNewEmployee(), removeEmployee(), 
 * updateVets(), createNewVet(), removeVet(), 
 * updatePets(), checkPetInSystem(), checkMultiplePetsInRoom(), addPetToRoom(), removePetFromRoom(), setAsAdopted(), 
 * setPlaydateAppt(), 
 * addDonations(), collectDonations();
 *
 */

public class ShelterManagement {

  private static final int capacity = 15;     // final shelter capacity of 15 pets
  private static int donationBin;
  private static int funds;
  private static ArrayList<Staff> staff;
  private static ArrayList<Vet> vets;
  private static HashSet<Pet> pets = new HashSet<Pet>(capacity);
  private static HashMap<Appointment, String> playDates;
  
  // Method to view, add, or remove employees
  public static void updateEmployees(Scanner employeesUpdating) {
    System.out.println("What would you like to update? Input corresponding number\n 1: View Employees\n 2: Add an Employee\n 3: Remove an Employee\4 4: Exit to Main Menu");
    
    try {
      switch(employeesUpdating.nextInt())
      {
        case 1:
          System.out.println("All Employees:\n" + staff.toString());
          break;
         
        case 2:
          System.out.println("First, we need some details about this Employee.");
          
          if(createNewEmployee(employeesUpdating) == null)
          {
            updateEmployees(employeesUpdating);
          }

          staff.add(createNewEmployee(employeesUpdating));
          break;

        case 3:
          Boolean removed = removeEmployee(employeesUpdating);
          if (removed = null) {
            updateEmployees(employeesUpdating);
          }
          else if (!removed) {
            System.out.println("That employee is not registered in the system. Please try again.");
            return;
          }
          break;
        case 4:
          System.out.println("Exiting Update Employees...");
          return;
        default:
          throw new IllegalArgumentException("Sorry, that is an invalid input.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  // Create Employee to add to the staff ArrayList
  private static Staff createNewEmployee(Scanner employeeCreation) {

    System.out.println("Please input the employee's name and their employee ID (in this order), separated by a space. Press 0 to exit to main menu.");
    String newEmployeeName = employeeCreation.next();

    if (newEmployeeName.equals("0")) {
      System.out.println("Exiting Create New Employee...");
      return null;
    }

    try {
      int newEmployeeID = employeeCreation.nextInt();

      System.out.printf("Please input %s's role.\n", newEmployeeName);

      employeeCreation.nextLine();
      String newEmployeeRole = employeeCreation.nextLine();

      System.out.printf("Please input %s's weekly salary and work hours per week (in this order), separated by a space.");
      
      double newEmployeeSalary = employeeCreation.nextDouble();
      double newEmployeeHours = employeeCreation.nextDouble();
    
      System.out.println("Your new employee has been added to the system.");

      return new Staff(newEmployeeName, newEmployeeID, newEmployeeSalary, newEmployeeRole, newEmployeeHours);
    } 
    catch (Exception e) {
      System.out.println("Error: Invalid input.");
    }

    return null;

  }

  // Remove Employee from staff ArrayList
  private static Boolean removeEmployee(Scanner employeeRemoval) {
    System.out.println("Please input the full name of the employee you would like to remove. Press 0 to exit to main menu.");
    String employeeToRemove = employeeRemoval.nextLine();

    if (employeeRemoval.nextLine().equals("0")) {
      return null;
    }

    for (Staff s : staff) {
      if (s.getEmployeeName().equalsIgnoreCase(employeeToRemove)) {
          System.out.println(employeeToRemove + " has been removed from the Shelter system.");
          staff.remove(s);
          return true;
      }
    }
    return false;
  }

  // Method to view, add, or remove vets
  public static void updateVets(Scanner vetsUpdating) {
    System.out.println("What would you like to update? Input corresponding number\n 1: View Vets\n 2: Add a Vet\n 3: Remove a Vet\4 4: Exit to Main Menu");
    
    try {
      switch(vetsUpdating.nextInt())
      {
        case 1:
          System.out.println("All Vets:\n" + vets.toString());
          break;
         
        case 2:
          System.out.println("First, we need some details about this Vet.");
          
          if(createNewVet(vetsUpdating) == null)
          {
            updateVets(vetsUpdating);
          }

          staff.add(createNewVet(vetsUpdating));
          break;

        case 3:
          Boolean removed = removeVet(vetsUpdating);
          if (removed = null) {
            updateVets(vetsUpdating);
          }
          else if (!removed) {
            System.out.println("That vet is not registered in the system. Please try again.");
            return;
          }
          break;
        case 4:
          System.out.println("Exiting Update Vets...");
          return;
        default:
          throw new IllegalArgumentException("Sorry, that is an invalid input.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  // Create Vet to add to the vets ArrayList
  private static Staff createNewVet(Scanner vetCreation) {

    System.out.println("Please input the vet's name and their employee ID (in this order), separated by a space. Press 0 to exit to main menu.");

    try {
      String newVetName = vetCreation.next();

      if (newVetName.equals("0")) {
        System.out.println("Exiting Create New Vet...");
        return null;
      }

      int newVetID = vetCreation.nextInt();

      System.out.printf("Please input %s's role.\n", newVetName);

      vetCreation.nextLine();
      String newVetRole = vetCreation.nextLine();

      System.out.printf("Please input %s's weekly salary and work hours per week (in this order), separated by a space.");
      
      double newVetSalary = vetCreation.nextDouble();
      double newVetHours = vetCreation.nextDouble();
    
      System.out.println("Your new vet has been added to the system.");

      return new Staff(newVetName, newVetID, newVetSalary, newVetRole, newVetHours);
    } 
    catch (Exception e) {
      System.out.println("Error: Invalid input.");
    }

    return null;

  }

  // Remove Vet from vets ArrayList
  private static Boolean removeVet(Scanner vetRemoval) {
    System.out.println("Please input the full name of the vet you would like to remove. Press 0 to exit to main menu.");
    String vetToRemove = vetRemoval.nextLine();

    if (vetRemoval.nextLine().equals("0")) {
      return null;
    }

    for (Vet v : vets) {
      if (v.getEmployeeName().equalsIgnoreCase(vetToRemove)) {
          System.out.println(vetToRemove + " has been removed from the Shelter system.");
          vets.remove(v);
          return true;
      }
    }
    return false;
  }

  // Methods to view pets, add or remove pets, or set a pet as adopted
  public static void updatePets(Scanner petsUpdating) {
    System.out.println("What would you like to do?");
    System.out.println(" 1: View Pets in Rooms\n 2: Add Pet to a Room \n 3: Remove Pet from a Room \n 4: Set Pet as Adopted\n 4: Exit to Main Menu");

    try{
      switch(petsUpdating.nextInt())
      {
        case 1:
          int index = 1;
          for (Pet p : pets) {
            if(p.roomNumber == 0) {
              System.out.println("Room #" + index + ": [No Occupying Pet]");
            } else {
              System.out.println("Room #" + index + ": " + p.getName());
            }   
            index++;
          }
          break;
        case 2:
          addPetToRoom(petsUpdating);
          break;
        case 3:
          removePetFromRoom(petsUpdating);
          break;
        case 4:
          setAsAdopted(petsUpdating);
          break;
        case 5:
          System.out.println("Exiting Update Pets...");
          return;
        default:
          throw new IllegalArgumentException("Error: Invalid input");
      }
    } 
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  // Checks if a pet is in pets HashSet. If not, return false,  else return true. 
  private static boolean checkPetInSystem(String petToSearch) {
    for (Pet p : pets) {
      if (p.getName().equalsIgnoreCase(petToSearch)) {
        return true;
      }
    }
    return false;
  }

  // Checks if a room is already occupied. If so, returns the number of occupants in room (though it should never be more than 1)
  private static int checkMultiplePetsInRoom(int roomToCheck) {
    int occurrence = 0;

    for (Pet p : pets) {
      if(p.roomNumber == roomToCheck) {
        occurrence++;
      }
    }

    return occurrence;
  }

  // Add a pet to pets HashSet
  private static void addPetToRoom(Scanner addingPet) {
    System.out.println("Please enter the name of the pet you would like to add to a room. Press 0 to exit.\n");
    String petToAdd = addingPet.nextLine();

    if (petToAdd.equals("0")) {
      System.out.println("Exiting Add Pet to a Room...");
      updatePets(addingPet);
    } 

    if(!checkPetInSystem(petToAdd)) {
      System.out.println("That pet is not currently in the system. Please try again.");
      addPetToRoom(addingPet);
    }
    else {
      System.out.printf("Which room would you like to add %s?\n", petToAdd);
      int prospectiveRoom = addingPet.nextInt();

      if(prospectiveRoom < 0 || prospectiveRoom > 15) {
        System.out.println("Error: Invalid Room Number.");
        addPetToRoom(addingPet);
      }
      
      if(checkMultiplePetsInRoom(prospectiveRoom) > 0) {
        System.out.printf("Sorry, that room is already occupied by another pet. Please move the occupying pet to another room, or choose another room for %s to move into.\n", petToAdd);
        addPetToRoom(addingPet);
      }
      
      for (Pet p : pets) {
        if (p.getName().equalsIgnoreCase(petToAdd)) {
          p.roomNumber = prospectiveRoom;
        }
      }
      
      System.out.println(petToAdd + " has been added to Room #" + prospectiveRoom);

    }

  }

  // Remove a pet to pets HashSet
  private static void removePetFromRoom(Scanner removingPet) {
    System.out.println("Please enter the name of the pet you would like to remove from a room. Press 0 to exit to main menu.\n");
    String petToRemove = removingPet.nextLine();

    if (petToRemove.equals("0")) {
      System.out.println("Exiting Remove Pet From a Room...");
      updatePets(removingPet);
    }

    if(!checkPetInSystem(petToRemove)) {
      System.out.println("That pet is not currently in the system. Please try again.");
      removePetFromRoom(removingPet);
    }

    else {
      int formerRoom = 0;

      for (Pet p : pets) {
        if (p.getName().equalsIgnoreCase(petToRemove)) {
          formerRoom = p.roomNumber;
          p.roomNumber = 0;
        }
      }
      
      System.out.println(petToRemove + " has been removed from Room #" + formerRoom);

    }
  } 

  // Set a pet's isAdopted field accordingly
  private static void setAsAdopted(Scanner adoptingPet) {

    if (pets.isEmpty()) {
      System.out.println("Error: There are no pets in the system!");
      return;
    } 

    System.out.println("Please enter the name of the pet that has been adopted. Press 0 to exit.");
    String petToBeAdopted = adoptingPet.nextLine();

    if (petToBeAdopted.equals("0")) {
      System.out.println("Exiting Set Pet as Adopted...");
      updatePets(adoptingPet);
    }

    if(!checkPetInSystem(petToBeAdopted)) {
      System.out.println("That pet is not currently in the system. Please try again.");
      setAsAdopted(adoptingPet);
    }
    
    else {
      for (Pet p: pets) {
        if (p.name.equalsIgnoreCase(petToBeAdopted)) {
          p.isAdopted = true;  
          System.out.println(petToBeAdopted + " has been set as adopted!");
        }
      }
    }

  }

  // Schedule playdate with an owner, pet, and date
  public static void setPlaydateAppt(Scanner playdateScheduler) {

    try {
      System.out.println("Enter the owner's name: ");
      String owner = playdateScheduler.nextLine();
      System.out.println("Enter the pet's name: ");
      String pet = playdateScheduler.nextLine();

      if(!checkPetInSystem(pet)) {
        System.out.println("That pet is not currently in the system. Please try again.");
        return;
      }

      System.out.println("Enter the date to be scheduled: ");
      String date = playdateScheduler.nextLine();

      playDates.put(new Appointment(pet, owner), date);
      System.out.printf("\nYou have scheduled a new playdate for $s and their pet, $s, on $s.", owner, pet, date);
    }
    catch (Exception e)
    {
      System.out.println("Error: Invalid input.");
    }

  }

  // Used from Guest class; add's Guest's donation amount to donationBin
  public static void addDonations(int i) {
    donationBin += i;
  }

  // Adds money from donationBin to funds, and resets donationBin to 0
  static void collectDonations() {
    funds += donationBin;
    System.out.println("A total of $" + donationBin + " has been collected. There is now $" + funds + "in funding for the shelter!");
    donationBin = 0;
  }
  

  public void addPet(Pet pet) {
    pets.add(pet);
  }

  public void addStaff (Staff staffMember) {
    staff.add(staffMember);
  }

  public void addVet (Vet vet) {
    vets.add(vet);
  }
}
package employees;
import animals.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// *deleted set capacity, made own capacity of 15

public class ShelterManagement {

  private static final int capacity = 15;
  private static int donationBin;
  private static int funds;
  private static ArrayList<Staff> staff;
  private static HashSet<Pet> pets = new HashSet<Pet>(capacity);
  private HashMap<Appointment, String> playDates;
  
  static String validateInput(Scanner scanner, String input, String toBeValidated) {
    while (!input.matches(toBeValidated)) {
      System.out.println("Sorry, that is an invalid input. Please try again.");
      input = scanner.next();
    }
    return input;
  }

  // method for either adding or removing an employee
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
          System.out.println("Exiting Update Employee...");
          return;
        default:
          throw new IllegalArgumentException("Sorry, that is an invalid input.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private static Staff createNewEmployee(Scanner employeeCreation) {

    System.out.println("Please input the employee's name and their employee ID (in this order), separated by a space. Press 0 to exit to main menu.");
    String newEmployeeName = employeeCreation.next();

    if (newEmployeeName.equals("0")) {
      System.out.println("Exiting Create New Employee...");
      return null;
    }

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

  public static void updatePets(Scanner petsUpdating) {
    System.out.println("What would you like to do?");
    System.out.println(" 1: View Pets in Rooms\n 2: Add Pet to a Room \n 3: Remove Pet from a Room \n 4: Set Pet as Adopted\n 4: Exit to Main Menu");

    switch(petsUpdating.nextInt())
    {
      case 1:
        for (int i = 0; i < capacity; i++) {
          if(pets.get(i) == null) {
            System.out.println("Room #" + i+1 + ": [No Occupying Pet]");
          } else {
           System.out.println("Room #" + i+1 + ": " + pets.get(i));
          }   
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
        

    }

  }

  private static boolean checkPetInSystem(String petToSearch) {
    for (Pet p : pets) {
      if (p.getName().equalsIgnoreCase(petToSearch)) {
        return true;
      }
    }
    return false;
  }

  private static int checkMultiplePetsInRoom(int roomToCheck) {
    int occurrence = 0;

    for (Pet p : pets) {
      if(p.roomNumber == roomToCheck) {
        occurrence++;
      }
    }

    return occurrence;
  }

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

  public void setPlaydateAppt(Scanner playdateScheduler) {

    System.out.println("Enter the owner's name: ");
    String owner = playdateScheduler.nextLine();
    System.out.println("Enter the pet's name: ");
    String pet = playdateScheduler.nextLine();

    System.out.println("Enter the date to be scheduled: ");
    String date = playdateScheduler.nextLine();

    playDates.put(new Appointment(pet, owner), date);
    System.out.printf("You have scheduled a new playdate for $s and their pet, $s, on $s.", owner, pet, date);

  }

  // adds donation into current donationBin amount;
  public static void addDonations(int i) {
    donationBin += i;
  }

  static void collectDonations() {
    funds += donationBin;
    System.out.println("A total of $" + donationBin + " has been collected. There is now $" + funds + "in funding for the shelter!");
    donationBin = 0;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Welcome to the Animal Shelter Employee Console. What would you like to manage?");
    System.out.println(" 1: Employees\n 2: Pets\n 3: Playdate Appointments\n 4: Donations\n 5: Exit");
    
    switch(s.nextInt()) {
      case 1:
        updateEmployees(s);
        break;
      case 2:
        updatePets(s);
        break;
    }



  }

}

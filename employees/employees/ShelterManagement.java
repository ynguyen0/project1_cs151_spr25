package employees;
import animals.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShelterManagement {

  private static int capacity, donationBin;
  private static ArrayList<Employee> employees;
  private static HashMap<Integer, String> petRoom;
  private HashMap<Appointment, String> playDates;

  // set or get capacity of shelter
  public static void setCapacity(int c) {
    capacity = c;
  }
  public static int getCapacity() {
    return capacity;
  }

  // methods for either adding or removing an employee
  public static void addEmployee(Employee e) {
    employees.add(e);
  }
  public static void removeEmployee(Employee e) {
    employees.remove(e);
  }
  public static ArrayList<Employee> viewEmployees() {
    return employees;
  }

  // methods for updating/adding a pet in a room, or removing a pet from a room
  public static void addPetRoom() {
    petRoom.put(roomNumber, p);
  }
  public static void removeFromPetRoom(int roomNumber, String p) {
    petRoom.remove(roomNumber, p);
  }

  static String validateInput(Scanner scanner, String input, String toBeValidated) {
    while (!input.matches(toBeValidated)) {
      System.out.println("Sorry, that is an invalid input. Please try again.");
      input = scanner.next();
    }
    return input;
  }

  public static void movePetToDifferentRoom() {
    Scanner movingPet = new Scanner(System.in);

    System.out.println("Here are all pet rooms and their occupancies: " + petRoom);
    System.out.println("Which pet would you like to move?");

    String movedPetName = movingPet.nextLine();
  
    if(petRoom.get(movedPetName).equals(null)) {
      System.out.println("That pet is not registered in any room currently. Would you like to add it to a room? y or n");
      String input = movingPet.nextLine();

      switch(input.toLowerCase()) 
      {
        case "y":
          System.out.println("Which room would you like to move into?");
          addPetRoom();
          break;
        case "n":
          System.out.println("Please choose another pet.");
          movingPet.close();
          movePetToDifferentRoom();
          break;
        default:
          System.out.println("Sorry, that is an invalid input. Please try again.");
      }
    }

    else if(!petRoom.get(movedPetName).equals(null)) {
      System.out.printf("Where would you like to move %s?\n", movedPetName);
    }

    int roomNumber, Pet p
    
    if(petRoom.get(p).equals(null))
    {
      addPetRoom(roomNumber, p);
    }
    else
    {
      System.out.println("The room you are trying to move into is currently occupied. Choose another room.");
    }
  }

  // if pet doesn't exist in room, return null; else get key 'p' from petRoom, and update isAdopted to true 
  public boolean setAsAdopted(Pet p) {
    if (petRoom.isEmpty() || !petRoom.containsKey(p)) {
      return false;
    } else {
    }

    return p.isAdopted;

  }

  // scheduling playdate
  public void updatePlayDate() {
    Scanner s = new Scanner(System.in);
    
    System.out.println("Enter your (owner) name: ");
    String owner = s.nextLine();
    System.out.println("Enter your pet's name: ");
    String pet = s.nextLine();

    System.out.println("Enter the date you would like to schedule: ");
    String date = s.nextLine();

    playDates.put(new Appointment(pet, owner), date);
    System.out.printf("You (%s) have scheduled a new playdate for $s on $s.", owner, pet, date);
    s.close();
  }

  // adds dontaination into current donationBin amount;
  public void collectDonations(int i) {
    donationBin += i;
    System.out.printf("You added $d to the donation bin; you now have %d total!", i, donationBin);
  }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShelterManagement {

  private int capacity, donationBin;
  private ArrayList<Employee> employees;
  private HashMap<Integer, Pet> petRoom;
  private HashMap<Appointment, String> playDates;

  // class constructor 
  public ShelterManagement(int c, int dB) {
    capacity = c;
    donationBin = dB;
  }

  // returns capacity of shelter
  public int getCapacity() {
    return capacity;
  }

  // methods for either adding or removing an employee
  public ArrayList<Employee> addEmployee(Employee e) {
    employees.add(e);
    return employees;
  }

  public ArrayList<Employee> removeEmployee(Employee e) {
    employees.remove(e);
    return employees;
  }

  // methdos for updating/adding a pet in a room, or removing a pet from a room
  public HashMap<Integer, Pet> updatePetRoom(int roomNumber, Pet p) {
    petRoom.put(roomNumber, p);
    return petRoom;
  }

  public HashMap<Integer, Pet> removeFromPetRoom(int roomNumber, Pet p) {
    petRoom.remove(roomNumber, p);
    return petRoom;
  }

  // if pet doesn't exist in room, return null; else get key 'p' from petRoom, and update isAdopted to true 
  public Pet setAsAdopted(Pet p) {
    if (petRoom.isEmpty() || !petRoom.containsKey(p)) {
      return null;
    } else {
      //petRoom.get(p).isAdopted == true;
    }

    return p;

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

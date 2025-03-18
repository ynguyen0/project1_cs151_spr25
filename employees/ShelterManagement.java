import java.util.ArrayList;
import java.util.HashMap;

public class ShelterManagement {

  private int capacity, donationBin;
  private ArrayList<Employee> employees;
  private HashMap<Integer, Pet> petRoom;
  private HashMap<Appointment, Integer> playDates;

  public ShelterManagement(int c, int dB) {
    capacity = c;
    donationBin = dB;
  }

  public int getCapacity() {
    return capacity;
  }

  public ArrayList<Employee> addEmployee(Employee e) {
    employees.add(e);
    return employees;
  }

  public ArrayList<Employee> removeEmployee(Employee e) {
    employees.remove(e);
    return employees;
  }

  public HashMap<Integer, Pet> updatePetRoom(int roomNumber, Pet p) {
    petRoom.put(roomNumber, p);
    return petRoom;
  }

  public HashMap<Integer, Pet> removeFromPetRoom(int roomNumber, Pet p) {
    petRoom.remove(roomNumber, p);
    return petRoom;
  }

  public HashMap<Appointment, Integer> updatePlayDate(Appointment a, Integer i) {
    playDates.put(a, i);
    return playDates;
  }

  public void collectDonations(int i) {
    donationBin += i;
    System.out.printf("You added $d to the donation bin; you now have %d total!", i, donationBin);
  }

}

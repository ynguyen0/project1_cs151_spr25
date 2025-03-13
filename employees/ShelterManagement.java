import java.util.ArrayList;
import java.util.HashMap;

public class ShelterManagement {

  private int capacity, donationBin;
  private ArrayList<Employee> employees;
  private HashMap<Integer, Pet> petRoom;

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

}

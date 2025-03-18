public class Appointment {
  
  private String pet;
  private String owner;

  public Appointment(String p, String o) {
    pet = p;
    owner = o;
  }

}


//       iii. This may vary for integration with the vet class since the vet class also requires an appointment
//   c. The vet class has a priority queue that will prioritize pets who have emergency conditions (ex. Broken leg) over pets who are just going in for a regular check up
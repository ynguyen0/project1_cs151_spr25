import java.util.ArrayList;
import java.util.Scanner;

public class Guest {
    
  private String firstName;
  private String lastName;
  private int phoneNumber;
  private ArrayList<Pet> pets;

  // class constructor
  public Guest(String f, String l, int i, ArrayList<Pet> p) {
    firstName = f;
    lastName = l;
    phoneNumber = i;
    pets = p;
  }

  // still need to change for last name
  public String setName(String s) {
    firstName = s;
    return firstName;
  }

  // prints guest info
  public void getGuestProfile() {
    System.out.printf("Guest Information: \nName: %s %s \nPhone Number: \n",firstName, lastName, phoneNumber);
    if (pets.size() >= 1) {
      System.out.println("Pets under ownership: " + pets);
    }

  }

  public void updateGuestProfile() {
    Scanner s = new Scanner(System.in);
    System.out.println("What would you like to change? \n 1. Name \n 2. Phone Number \n 3. Ownership of Pets");

    if (s.nextInt() == 1)                                                  // change name 
    {
      System.out.println("Enter your updated name: ");
      String first = s.next();
      String last = s.next();
      System.out.printf("Your name is now %s %s,", first, last);
    }

    if (s.nextInt() == 2)                                                  // change phone number
    {
      System.out.println("Enter your updated phone number: ");
      String number = s.nextLine();
      System.out.printf("Your phone number is now %s.", number);
    }

    if (s.nextInt() == 3)                                                  // change pet ownership 
    {
      System.out.printf("What would you like to do? \n 1. Add Pet \n 2. Remove Pet");
      switch (s.nextInt())
      {
        case 1:                                                            // add pet under ownership
          System.out.print("Adding: Enter your pet's name: ");
          String name = s.nextLine(); 
          System.out.print("Enter your pet's breed: ");
          String breed = s.nextLine(); 
          System.out.print("Enter your pet's age: ");
          int age = s.nextInt(); 
          
          pets.add(new Pet(name, breed, age));

        case 2:                                                            // remove pet under ownership                                       
          System.out.print("Removing: Enter your pet's name: ");
          String nameToRemove = s.nextLine(); 
          
          pets.remove(nameToRemove);

        default:                                                          // break if response isn't 1 or 2
          System.out.println("Invalid response.");
          break;

      }

    }

  }

  // WIP
  public void adopt(Pet p) {
    System.out.println("Congratulations on welcoming a loving furry friend into the household! Please enter the name of the pet you would like to adopt: ");
    Scanner s = new Scanner(System.in);
    String adoptName = s.nextLine();

  }

}

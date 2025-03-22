package employees;
import java.util.Scanner;

/**
 * Guest class for Animal Shelter program
 *
 * @author: Ashley Roman
 * fields: firstName, lastName, phoneNumber
 * methods: Guest(), getGuestProfile(), updateGuestProfile();
 *
 */

public class Guest {
    
  private static String firstName = "FirstName";
  private static String lastName = "LastName";
  private static String phoneNumber = "PhoneNumber"; // is a String to account for different formats (w/ or w/o dashes, etc.)

  // Class Constructor
  public Guest(String f, String l, String i) {
    firstName = f;
    lastName = l;
    phoneNumber = i;
  }
  
  // Prints Guest fields
  public static void getGuestProfile() {
    System.out.printf("\nGuest Information: \nName: %s %s \nPhone Number: %s\n", firstName, lastName, phoneNumber);  
  }
  
  // Method for updating Guest Profile
  public static void updateGuestProfile(Scanner updateProfile) {

    System.out.println("What would you like to change? \n 1. Name \n 2. Phone Number \n");

    try 
    {
      switch (updateProfile.nextInt())                                                
      {
        case 1:
          // Updating Guest's name 
          System.out.println("Enter your updated name (First and Last): ");                  
          firstName = updateProfile.next();
          lastName = updateProfile.next();
          System.out.printf("\nYour name is now %s %s.\n", firstName, lastName);
          
          break;

        case 2:                                                              
          // Updating Guest's phone number 
          updateProfile.nextLine(); // this line "resets" the Scanner (consumes previous next() call with a newline) 

          System.out.println("Enter your updated phone number: ");
          String enteredNumber = updateProfile.nextLine();

          phoneNumber = ShelterManagement.validateInput(updateProfile, enteredNumber, "^[0-9\\-\\s]+$"); // calls validation method from ShelterManagement class
          System.out.printf("Your phone number is now %s.", phoneNumber);

          break;

        default:
          throw new IllegalArgumentException("Sorry, that is not a valid input.");
      }
    }
    catch (IllegalArgumentException e)
    {
      // resets to beginning of method if an IllegalArgumentException is caught
      System.out.println("Error: " + e.getMessage());
      updateGuestProfile(updateProfile);
    }

    System.out.println("\nProfile updated!");
    
  }
        
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("\nWelcome to the Animal Shelter Program Terminal!\n");
    
    System.out.println("What would you like to do? (Type in corresponding number) \n 1: Get Guest Profile \n 2: Update Guest Profile \n 3: Exit");

    try
    {
      switch(s.nextInt()) {
        case 1:
          getGuestProfile();
          break;
        case 2:
          updateGuestProfile(s);
          break;
        case 3:
          System.out.println("\nSee you soon!");
          System.exit(0);
          break;
        default:
          throw new IllegalArgumentException("Sorry, that is an invalid input.");
      }
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("\nError: " + e.getMessage());
    }
    finally
    {
      // restarts main method in case Guest wants to do another option, unless the system has exited
      main(args);
    }

  }

}



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
  public Guest(String f, String l, String p) {
    firstName = f;
    lastName = l;
    phoneNumber = p;
  }
  
  // method for validing input for Guest's phone number
  private static String validateInput(Scanner scanner, String input, String toBeValidated) {
    while (!input.matches(toBeValidated)) {
      System.out.println("Sorry, that is an invalid input. Please try again.");
      input = scanner.next();
    }
    return input;
  }

  // Prints Guest fields
  public static void getGuestProfile() {
    System.out.printf("\nGuest Information: \nName: %s %s \nPhone Number: %s\n", firstName, lastName, phoneNumber);  
  }
  
  // Method for updating Guest Profile
  public static void updateGuestProfile(Scanner updateProfile) {

    System.out.println("What would you like to change? \n 1. Name \n 2. Phone Number \n 3: Exit Update Guest Profile");

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

          phoneNumber = validateInput(updateProfile, enteredNumber, "^[0-9\\-\\s]+$"); // calls validation method from ShelterManagement class
          System.out.printf("Your phone number is now %s.", phoneNumber);

          break;
      
        case 3:
          System.out.println("Exiting Update Guest Profile...");
          return;

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
    
  }

  public static void donateMoney(Scanner donating) {
    System.out.println("\nHow much money would you like to donate?");

    try
    { 
      int donationAmount = donating.nextInt();

      if (donationAmount < 0) {
        throw new IllegalArgumentException("Error: Invalid input.");
      }

      ShelterManagement.addDonations(donationAmount);
      System.out.println("\nThank you so much for your generous support! <3");
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

  } 
<<<<<<< HEAD
=======
        
  
>>>>>>> 2d25f1784005e4f4993188d5fe0bae788088b5fd

}



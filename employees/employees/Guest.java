package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import employees.ShelterManagement;

public class Guest {
    
  private static String firstName = null;
  private static String lastName = null;
  private static String phoneNumber = null;   // is a String to account for different formats (w/ or w/o dashes, etc.)

  // class constructor
  public Guest(String f, String l, String i) {
    firstName = f;
    lastName = l;
    phoneNumber = i;
  }

  public String setName(String f, String l) {
    firstName = f;
    lastName = l;
    return firstName + " " + lastName;
  }

  public static void makeNewProfile() {
  
    Scanner makeProfile = new Scanner(System.in);
    System.out.println("We're happy to have you on board! We just need you to answer a few questions.\n What is your first and last name?");
    
    String[] name = makeProfile.nextLine().split(" ");
    firstName = name[0];
    lastName = name[1];

    System.out.printf("Welcome %s %s! \n Next, What is your phone number?\n", firstName, lastName);
    String enteredNumber = makeProfile.next();
    phoneNumber = ShelterManagement.validateInput(makeProfile, enteredNumber, "^[0-9\\-\\s]+$");
    
    // System.out.println("Great! Finally, do you have any pets? Type Yes or No\n");

    // String hasPets = makeProfile.next();
    // hasPets = validateInput(makeProfile, hasPets, "^[a-zA-Z]+$");

    // if (hasPets.equalsIgnoreCase("yes")) 
    // {
    //   System.out.println("How many pets do you have?");
    //   String enteredPets = makeProfile.next();
    //   enteredPets = validateInput(makeProfile, enteredPets, "^[1-9]+$");

    //   System.out.println("Please enter the name of your pet, and its breed, separated by a comma (no whitespace). Press enter to move onto the next line.");

    //   for(int i = 0; i <= Integer.parseInt(enteredPets); i++) {
    //     System.out.println(i + ": ");
    //     String[] petDetails = makeProfile.nextLine().split(",");
    //     pets.add(new Pet(petDetails[0], petDetails[1]));
    //   } 
    // }
    
    System.out.println("Your profile has been created. See you around!");
    // Guest newGuest = new Guest(firstName, lastName, phone);

    makeProfile.close();

  }
  
  // prints guest info
  public static void getGuestProfile() {
    System.out.printf("Guest Information: \nName: %s %s \nPhone Number: \n",firstName, lastName, phoneNumber);  
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

    // if (s.nextInt() == 3)                                                  // change pet ownership 
    // {
    //   System.out.printf("What would you like to do? \n 1. Add Pet \n 2. Remove Pet");
    //   switch (s.nextInt())
    //   {
    //     case 1:                                                            // add pet under ownership
    //       System.out.print("Adding: Enter your pet's name: ");
    //       String name = s.nextLine(); 
    //       System.out.print("Enter your pet's breed: ");
    //       String breed = s.nextLine(); 
    //       System.out.print("Enter your pet's age: ");
    //       int age = s.nextInt(); 
          
    //       //pets.add(new Pet(name, breed, age));

    //     case 2:                                                            // remove pet under ownership                                       
    //       System.out.print("Removing: Enter your pet's name: ");
    //       String nameToRemove = s.nextLine(); 
          
    //       pets.remove(nameToRemove);

    //     default:                                                          // break if response isn't 1 or 2
    //       System.out.println("Invalid response.");
    //       break;

    //   }

    // }
  }
  
    // WIP
  public static void adopt() {
    Scanner adoptScanner = new Scanner(System.in);

    System.out.println("Congratulations on welcoming a loving furry friend into the household! To see the available pets, please press 1. To adopt, please press 2.");

    int adoptOption = adoptScanner.nextInt();

    while (adoptOption != 1 || adoptOption != 2) {
      System.out.println("Sorry, that is an invalid input. Please try again.");
      adoptOption = adoptScanner.nextInt();
    }

    switch(adoptOption) {
      case 1:
      case 2:
        System.out.println("Please enter the name of the pet you would like to adopt.");
        String petToAdopt = adoptScanner.next();

    }

  }
  
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
  
      System.out.println("Welcome to the Animal Shelter Program Terminal. First order of business: Make an account! Redirecting you to Create Account page...");
      makeNewProfile();
      
      System.out.println("What would you like to do? (Type in corresponding number) \n 1:Get Guest Profile \n2: Update Guest Profile \n3: Create Guest Profile \n4: Adopt a pet \n5: Place pet for adoption \n6: Exit");
  
      switch(s.nextInt()) {
        case 1:
          getGuestProfile();
          break;
        case 3:
          makeNewProfile();
          break;
        case 4:
          adopt();
        default:
          
        

    }

  }

}

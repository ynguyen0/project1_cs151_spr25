package employees;
import java.util.Scanner;

import animals.*;
public class Console {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("\nWelcome to the Animal Shelter Program Terminal!\n");

    System.out.println("What would you like to do? (Type in corresponding number) \n 1: Get Guest Profile \n 2: Update Guest Profile \n 3: Donate\n 4: Exit");

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
          donateMoney(s);
          break;
        case 4:
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

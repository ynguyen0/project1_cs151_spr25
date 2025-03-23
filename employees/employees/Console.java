package employees;
import java.util.Scanner;
//import employees.Guest;
import static employees.Guest.*;
import animals.*;

public class Console {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("\nWelcome to the Animal Shelter Program Terminal!\n");

    //System.out.println("What would you like to do? (Type in corresponding number) \n 1: Get Guest Profile \n 2: Update Guest Profile \n 3: Donate\n 4: Exit");

    System.out.println("Please select one of the following options:");
    System.out.println("1. I am a Guest. \n 2. I am an employee \n 3. Exit \n");

    try
    {
      switch(s.nextInt()) {
        case 1:
            System.out.println("What would you like to do today?");
            System.out.println("1. Schedule an appointment\n 2. Cancel an appointment\n 3. Check appointment time\n 4. I am here for my appointment!\n 5. Update profile\n. 6. Donate money\n 7. Exit");
            if (s.nextInt() == 1){

            }
            if (s.nextInt() == 2){
                
            }
            if (s.nextInt() == 3){
                
            }
            if (s.nextInt() == 4){
                System.out.println("Please enter your name and appointment time");
                s.next();
                System.out.println("Please wait while an employee checks on " + pet.name);
                pet.checkActivity();
                System.out.println("Would you like to adopt" + pet.name + " today? Please select one of the following: \n 1. yes!\n 2. no");
                if(s.nextInt() == 1){
                    pet.adopt();
                }
                else{
                    System.out.println("Come again soon!");
                    break;
                }
                
            }
            if (s.nextInt() == 5){
                System.out.println("Have a nice day!");
                break;
            }
            break;
        case 2:
            System.out.println("Please select role type:\n 1. General staff\n 2. Vet\n 3. Exit\n");
            if (s.nextInt() == 1){
                System.out.println("Please enter your name");
                String userName = s.nextLine();
                Staff curStaff;
                for (Staff staff: zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz) {
                    if (staff.getName() == userName) {
                        curStaff = staff; // find the current staff
                    }
                    else{
                        System.out.println(userName + " does not appear to be in the system.");
                        break;
                    }
                }
                System.out.println("Welcome back, " + userName);

                // keeps the staff logged in
                while(s.hasNextInt()){
                    System.out.println("What would you like to do today?");

                    System.out.println("1. Check tasks\n 2. Check Salary\n 3. Request lunch break\n 4. Work Shift\n 5. Exit");
                    if (s.nextInt() == 1){
                        System.out.println("Please enter your role:\n 1. Pet Groomer \n2. Pet Caregiver\n3. Volunteer\n4. Exit");
                        if (s.nextInt() == 1 || s.nextInt() == 2 || s.nextInt() == 3){
                            curStaff.checkTasks();
                        } 
                        if (s.nextInt() == 4){
                            //System.out.println("Have a nice day!");
                            continue;
                        }
                    }
                    if (s.nextInt() == 2){
                        System.out.println("Your current weekly salary is $" + curStaff.getWeeklySalary());
                        System.out.println("Would you like to check your bonus?\n 1. Yes\n 2. No");
                        if (s.nextInt() == 1){
                            curStaff.checkBonus(s);
                        }
                        else{
                            //System.out.print("Would you like to do anything else?");
                            continue;
                        }
                    }
                    if (s.nextInt() == 3){
                        curStaff.requestLunchBreak(s);
                    }
                    if (s.nextInt() == 4){
                        System.out.println("Please enter the number of hours worked today");
                        int hours = s.nextInt();
                        curStaff.workShift(hours);
                    }
                    if (s.nextInt() == 5){
                        System.out.println("Have a nice day!");
                        break;
                    }
                }
            if (s.nextInt() == 2){
                    System.out.println("Please enter your name");
                    String curVet = s.nextLine();
                    Vet currentVet;
                    for (Vet vet: zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz) {
                        if (vet.getEmployeeName() == curVet) {
                            currentVet = vet; // find the current vet
                        }
                        else{
                            System.out.println(curVet + " does not appear to be in the system.");
                            break;
                        }
                    }
                    System.out.println("Welcome back, " + curVet);

                    while(s.hasNextInt()){
                        System.out.println("What would you like to do today?");
    
                        System.out.println("1. Check tasks\n 2. Log vitals\n 3. Add prescription\n 4. List presecription\n 5. Remove prescription\n 6. Exit");

                        if (s.nextInt() == 1){
                            System.out.println("Please enter your role:\n 1. Vet \n2. Vet tech\n3. Vet assistent\n4. Exit");
                            if (s.nextInt() == 1 || s.nextInt() == 2 || s.nextInt() == 3){
                                currentVet.checkTasks();
                            } 
                            if (s.nextInt() == 4){
                                //System.out.println("Have a nice day!");
                                continue;
                            }
                        }
                        if (s.nextInt() == 2){
                            System.out.print("Please enter the name of the pet you wish to log.");
                            String petName = s.next();

                            currentVet.logVitals(Pet pet, s);
                            zzzzzzzzzzzzzzzzzzzzzzzzzzz
                            System.out.println("Would you like to to do anything else?\n 1. Yes\n 2. No");
                            if (s.nextInt() == 1){
                                continue;
                            }
                            else{
                                break;
                            }
                        }
                        if (s.nextInt() == 3){
                            System.out.print("Please enter the name of the pet you wish to log.");
                            String petName = s.nextLine();
zzzzzzzzzzzzzzzzzzzzz
                            //for loop to find the pet

                            System.out.println("Please enter the name of the prescription.");
                            String meds = s.nextLine();
                            currentVet.addPrescription(Pet pet, meds);
                        }
                        if (s.nextInt() == 4){
                            System.out.print("Please enter the name of the pet you wish to log.");
                            String petName = s.nextLine();
zzzzzzzzzzzzzzzzzz
                            //for loop to find the pet
                            currentVet.listPrescription(Pet pet);
                        }
                        if (s.nextInt() == 5){
                            System.out.print("Please enter the name of the pet you wish to log.");
                            String petName = s.nextLine();
zzzzzzzzzzzzzzzzzz
                            //for loop to find the pet
                            currentVet.removePrescription(Pet pet);
                        }
                        if (s.nextInt() == 6){
                            System.out.println("Have a nice day!");
                            break;
                        }
                    }
                    
                }
            if (s.nextInt() == 3){
                System.out.println("Have a nice day!");
                zzzzzzzzzz
                break;
            }
            }
            break;
        case 3:
          System.out.println("\nSee you soon!");
          System.exit(0);
          break;
        default:
          throw new IllegalArgumentException("Sorry, that input is invalid.");
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

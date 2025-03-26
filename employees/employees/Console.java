package employees;
import java.util.Scanner;
import static employees.Guest.*;
import animals.*;

public class Console {

    private static void exitHelper(String input){
        if (input.equalsIgnoreCase("exit")){
            System.out.println("System now exiting");
            System.out.println("Have a nice day");
            System.exit(0);
        }
    } 

    public static void main(String[] args) {
    ShelterManagement shelter = new ShelterManagement(0,0);

    shelter.addPet(new Cat("Luna", "Cat", 4, 120, true, false, true, "feisty", true, true, "Shorthair"));
    shelter.addPet(new Cat("Mittens", "Cat", 3, 130, false, false, true, "lazy", false, true, "Calico"));
    shelter.addPet(new Hamster("Nibbles", "Hamster", 140, true, false, true, 1));
    shelter.addPet(new Hamster("Greg", "Hamster", 150, false, true, true, 2));

    shelter.addStaff(new Staff("Karina", 100, 1225.21, "Pet Caregiver", 2));
    shelter.addStaff(new Staff("Winter", 101, 1240.36, "Pet Groomer", 0));
    shelter.addVet(new Vet("Giselle", 102, 1302.41, "Vet Tech", 4));
    shelter.addVet(new Vet("Ningning", 103, 1402.48, "Vet", 6));

    Scanner s = new Scanner(System.in);

    System.out.println("\nWelcome to the Animal Shelter Program Terminal!\n");
    System.out.println("To exit the program at anytime, please type 'exit'");
    System.out.println("Please select one of the following options:");
    System.out.println("1. I am a Guest.\n2. I am an employee\nPlease type 'exit' to exit the program\n");

    boolean cont = true;
    String first = s.nextLine();

    try{
      switch(first) {
    ///switch(s.nextInt()) {
        case "1":
            cont = true;
            System.out.println("Please enter your name or enter 'exit' to exit the program");
                //s.nextLine();
                String userGuest = s.nextLine();
                exitHelper(userGuest);
                System.out.print("Welcome, " + userGuest + "! ");

            while(cont){
                System.out.println("What would you like to do today?");
                System.out.println("1. Schedule an appointment\n2. Visit or Adopt a pet\n3. Update profile\n4. Donate money\n5.Please type 'exit' to exit the program");
                String selection = s.next();
                if (selection.equalsIgnoreCase("1")){
                    ShelterManagement.setPlaydateAppt(s, userGuest);  
                    continue;
                }
                if (selection.equalsIgnoreCase("2")){
                   
                    System.out.println("Please enter the name of the pet you wish to visit.");
                    s.nextLine();
                    String petName = s.nextLine();
                    exitHelper(petName);
                    Pet petGuest = null;
                
                    System.out.println("Please enter the date of your playdate appointment (MM/DD/YY):");
                    //s.nextLine();
                    String date = s.nextLine();
                    exitHelper(date);
                    
                    if(ShelterManagement.checkPetInSystem(petName) && ShelterManagement.getAppointment(petName, userGuest) != null){
                    //.containsKey(playdate)){
                   // .get(playdate) != null){
                   // if(ShelterManagement.checkPetInSystem(petName)){
                        for (Pet p : ShelterManagement.pets) {
                            if (p.getName().equalsIgnoreCase(petName)) {
                            petGuest = p;
                            }
                        }
                        
                        System.out.println("Please wait while an employee checks on " + petGuest.name);
                        petGuest.checkActivity();
                        System.out.println("Would you like to adopt " + petGuest.name + " today?\nPlease select one of the following: \n1. yes!\n2. no\nEnter 'exit' to exit the program");
                        String adoptAnswer = s.nextLine();
                        exitHelper(adoptAnswer);
                        if(adoptAnswer.equalsIgnoreCase("1")){
                            petGuest.adopt(userGuest);
                            
                        }
                        else{
                            continue;
                        }

                    }
                    else{
                        System.out.println("Pet not found");
                        continue;
                    }
                    
                }
                if (selection.equalsIgnoreCase("3")){
                    //updates guest profile
                    updateGuestProfile(s);
                    continue;
                }
                if (selection.equalsIgnoreCase("4")){
                    // donate money 
                    donateMoney(s);
                    continue;
                }
                if (selection.equalsIgnoreCase("exit")){
                    //exits 
                    System.out.println("Have a nice day!");
                    //break;
                    System.exit(0);
                }

            }// end of while loop for case 1
            
        case "2":
        while(cont){
             System.out.println("Please select role type:\n1. General staff\n2. Vet\nPlease type 'exit' to exit the program\n");
             // general staff section
             String employeeType = s.next();
             if (employeeType.equalsIgnoreCase("1")){ 
                System.out.println("Please enter your name");
                s.nextLine();
                String userName = s.nextLine();
                exitHelper(userName);
                Staff curStaff = null;
                for (Staff staff: ShelterManagement.staff) {
                    if (staff.getEmployeeName().equals(userName)) {
                        curStaff = staff; // find the current staff
                    }
                    
                }
                if (curStaff == null){
                    System.out.println(userName + " does not appear to be in the system.");
                    break;
                }
                else{
                    System.out.println("Welcome back, " + userName);
                }

                 while(cont){
                    System.out.println("What would you like to do today?");

                    System.out.println("1. Check tasks\n 2. Check Salary\n 3. Request lunch break\n 4. Work Shift\nPlease type 'exit' to exit the program");
                    
                    String command = s.next(); 

                    if (command.equalsIgnoreCase("1")){
                        System.out.println("Please enter your role:\n 1. Pet Groomer \n2. Pet Caregiver\n3. Volunteer\n4. Go back\nPlease type 'exit' to exit the program");
                        
                        String role = s.next();
                        if (role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2") || role.equalsIgnoreCase("3")){
                            curStaff.checkTasks();
                            continue;
                        } 
                        else if(role.equalsIgnoreCase("4")){
                            continue;
                        }
                        else if (role.equalsIgnoreCase("exit")) {
                            System.out.println("Have a nice day!");
                            System.exit(0);
                        }
                        else {
                            System.out.println("Please select a valid option!");
                            continue;
                        }
                     } // end of check tasks 
                    else if (command.equalsIgnoreCase("2")){
                        System.out.println("Your current weekly salary is $" + curStaff.getWeeklySalary());
                        System.out.println("Would you like to check your bonus?\n 1. Yes\n 2. No");
                        String bonus = s.nextLine();
                        exitHelper(bonus);
                        if (bonus.equalsIgnoreCase("1")){
                            curStaff.checkBonus(s);
                        }
                        else{
                            continue;
                        }
                     } // end of check salary
                    else if (command.equalsIgnoreCase("3")){
                        curStaff.requestLunchBreak(s);
                        continue;
                    }
                    else if (command.equalsIgnoreCase("4")){
                        System.out.println("Please enter the number of hours worked today");
                        int hours = s.nextInt();
                        curStaff.workShift(hours);
                        continue;
                    }
                    else if (command.equalsIgnoreCase("exit")){
                        System.out.println("Have a nice day! Exiting program...");
                        System.exit(0);
                    }
                 }// end of while loop for general staff tasks
             }// end of if statement for general staff 

             // vet section
            else if (employeeType.equalsIgnoreCase("2")){ 
                    System.out.println("Please enter your name");
                    s.nextLine();
                    String curVet = s.nextLine();
                    exitHelper(curVet);
                    Vet currentVet = null;
                    // find the vet 
                    for (Vet vet: ShelterManagement.vets) {
                        if (vet.getEmployeeName().equalsIgnoreCase(curVet)) {
                            currentVet = vet; // find the current vet
                            System.out.println("Hello, you are logged in as " + curVet);
                            break;
                        }
                    }
                    if (currentVet == null) {
                        System.out.println(curVet + " does not appear to be in the system.");
                        break;
                    }

                    while(cont){
                       
                        System.out.println("What would you like to do today?");
    
                        System.out.println("1. Check tasks\n2. Log vitals\n3. Add prescription\n4. List presecription\n5. Remove prescription\nPlease type 'exit' to exit the program");
                        //s.nextInt();
                        String vetCommand = s.nextLine();
                        exitHelper(vetCommand);
                         if (vetCommand.equalsIgnoreCase("1")){
                            System.out.println("Please enter your role:\n 1. Vet \n2. Vet tech\n3. Vet assistent\n4. Go back\nPlease type 'exit' to exit the program");
                            String role = s.nextLine();
                            exitHelper(role);
                            if (role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2") || role.equalsIgnoreCase("3")){
                                currentVet.checkTasks();
                            
                                continue;
                            } 
                            else if (role.equalsIgnoreCase("4")){
                        
                                continue;
                            }
                            else {
                                System.out.println("Please enter a valid role.");
                             
                                continue;
                            }
                         }// end of check tasks for vet
                        else if (vetCommand.equalsIgnoreCase("2")){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            //s.nextLine();
                            String petName = s.nextLine();
                            exitHelper(petName);
                             //for loop to find the pet                           
                             Pet pet = null;
                             //for loop to find the pet
                             for(Pet p: ShelterManagement.pets){
                                 if (p.name.equals(petName)){
                                     pet = p;
                                     break;
                                 }
                             }
                             if (pet != null){
                                currentVet.logVitals(pet, s);
                             }
                             else{
                                System.out.println("Could not find this pet.");
                             }
                        } //end of log vitals 
                        else if (vetCommand.equalsIgnoreCase("3")){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            //s.nextLine();
                            String petName = s.nextLine();
                            exitHelper(petName);
                            //for loop to find the pet                           
                            Pet pet = null;
                            //for loop to find the pet
                            for(Pet p: ShelterManagement.pets){
                                if (p.name.equals(petName)){
                                    pet = p;
                                    break;
                                }
                            }
                            if (pet != null){
                                System.out.println("Please enter the name of the prescription.");
                                String meds = s.nextLine();
                                currentVet.addPrescription(pet, meds);

                            } 
                            else {
                                System.out.println("Could not find this pet.");
 
                            }

                        } // end of add presctiption 
                        else if (vetCommand.equalsIgnoreCase("4")){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            //s.nextLine();
                            String petName = s.nextLine();
                            exitHelper(petName);
                            //for loop to find the pet

                            Pet pet = null;
                            //for loop to find the pet
                            for(Pet p: ShelterManagement.pets){
                                if (p.name.equalsIgnoreCase(petName)){
                                    pet = p;
                                    break;
                                }
                            }
                            if (pet != null){
                                currentVet.listPrescription(pet);
                            }
                            else {
                                System.out.println("Could not find this pet.");
                            }
                        } // end of list prescription
                        else if (vetCommand.equalsIgnoreCase("5")){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            //s.nextLine();
                            String petName = s.nextLine();
                            exitHelper(petName);
                            Pet pet = null;
                            //for loop to find the pet
                            for(Pet p: ShelterManagement.pets){
                                if (p.name.equalsIgnoreCase(petName)){
                                    pet = p;
                                    break;
                                }
                            }
                            if (pet != null){
                                System.out.println("Please enter the name of the prescription.");
                                String meds = s.nextLine();
                                currentVet.removePrescription(pet, meds);
                            }
                            else {
                                System.out.println("Could not find this pet or prescription.");
                            }
                        } // end of remove prescription                     
                 } // end of while loop for vet 
          } // end of vet 
            else if (employeeType.equalsIgnoreCase("exit")){ //exit employee
                System.out.println("Have a nice day!");
               System.exit(0);
            }
        

        }// end of the while loop for case 2

        case "3":
          System.out.println("\nSee you soon!");
          System.exit(0);
          //break;
        default:
          throw new IllegalArgumentException("Sorry, that input is invalid.");
        }// end of switch statement
    } // end of try 
    catch (IllegalArgumentException e){
      System.out.println("\nError: " + e.getMessage());
    }
    finally{
      // restarts main method in case Guest wants to do another option, unless the system has exited
      main(args);
    }

  } // end of main method
} // end of class method 
package employees;
import java.util.Scanner;
import static employees.Guest.*;
import animals.*;

public class Console {
    public static void main(String[] args) {
    ShelterManagement shelter = new ShelterManagement(0,0);

    shelter.addPet(new Cat("Luna", "Cat", 4, 120, true, false, true, "feisty", true, true, "Shorthair"));
    shelter.addPet(new Cat("Mittens", "Cat", 3, 130, false, false, true, "lazy", false, true, "Calico"));
    shelter.addPet(new Hamster("Nibbles", "Hamster", 140, true, false, 1));
    shelter.addPet(new Hamster("Greg", "Hamster", 150, false, true, 2));

    shelter.addStaff(new Staff("Karina", 100, 1225.21, "Pet Caregiver", 2));
    shelter.addStaff(new Staff("Winter", 101, 1240.36, "Pet Groomer", 0));
    shelter.addVet(new Vet("Giselle", 102, 1302.41, "Vet Tech", 4));
    shelter.addVet(new Vet("Ningning", 103, 1402.48, "Vet", 6));

    Scanner s = new Scanner(System.in);

    System.out.println("\nWelcome to the Animal Shelter Program Terminal!\n");
    System.out.println("Please select one of the following options:");
    System.out.println("1. I am a Guest.\n 2. I am an employee\n 3. Exit\n");

    boolean cont = true;
    int first = s.nextInt();

    try{
      switch(first) {
    ///switch(s.nextInt()) {
        case 1:
            cont = true;
            while(cont){
                System.out.println("What would you like to do today?");
                System.out.println("1. Schedule an appointment\n2. Visit or Adopt a pet\n3. Update profile\n4. Donate money\n5. Exit");
                int selection = s.nextInt();
                if (selection == 1){
                    ShelterManagement.setPlaydateAppt(s);  
                    continue;
                }
                if (selection == 2){
                    System.out.println("Please enter your name.");
                    String userGuest = s.nextLine();
                    System.out.println("Please enter the name of the pet you wish to visit.");
                    String petName = s.nextLine();
                    Pet petGuest = null;
                    if(ShelterManagement.checkPetInSystem(petName)){
                        for (Pet p : ShelterManagement.pets) {
                            if (p.getName().equalsIgnoreCase(petName)) {
                            petGuest = p;
                            }
                        }
                        
                        System.out.println("Please wait while an employee checks on " + petGuest.name);
                        petGuest.checkActivity();
                        System.out.println("Would you like to adopt " + petGuest.name + " today?\n Please select one of the following: \n 1. yes!\n 2. no");
                        if(s.nextInt() == 1){
                            petGuest.adopt(userGuest);
                        }
                    }
                    else{
                        System.out.println("Pet not found");
                        continue;
                    }
                    
                }
                if (selection == 3){
                    //updates guest profile
                    updateGuestProfile(s);
                    continue;
                }
                if (selection == 4){
                    // donate money 
                    donateMoney(s);
                    continue;
                }
                if (selection == 5){
                    //exits 
                    System.out.println("Have a nice day!");
                    //break;
                    System.exit(0);
                }

            }// end of while loop for case 1
            
        case 2:
        while(cont){
             System.out.println("Please select role type:\n 1. General staff\n 2. Vet\n 3. Exit\n");
             // general staff section
             int employeeType = s.nextInt();
             if (employeeType == 1){ 
                System.out.println("Please enter your name");
                s.nextLine();
                String userName = s.nextLine();
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

                    System.out.println("1. Check tasks\n 2. Check Salary\n 3. Request lunch break\n 4. Work Shift\n 5. Exit program");
                    int command = s.nextInt(); 

                    if (command == 1){
                        System.out.println("Please enter your role:\n 1. Pet Groomer \n2. Pet Caregiver\n3. Volunteer\n4. Go back\n5. Exit program");
                        int role = s.nextInt();
                        if (role == 1 || role == 2 || role == 3){
                            curStaff.checkTasks();
                            continue;
                        } 
                        else if(role == 4){
                            continue;
                        }
                        else if (role == 5) {
                            System.out.println("Have a nice day!");
                            System.exit(0);
                        }
                        else {
                            System.out.println("Please select a valid option!");
                            continue;
                        }
                     } // end of check tasks 
                    else if (command == 2){
                        System.out.println("Your current weekly salary is $" + curStaff.getWeeklySalary());
                        System.out.println("Would you like to check your bonus?\n 1. Yes\n 2. No");
                        if (s.nextInt() == 1){
                            curStaff.checkBonus(s);
                        }
                        else{
                            continue;
                        }
                     } // end of check salary
                    else if (command == 3){
                        curStaff.requestLunchBreak(s);
                        continue;
                    }
                    else if (command == 4){
                        System.out.println("Please enter the number of hours worked today");
                        int hours = s.nextInt();
                        curStaff.workShift(hours);
                        continue;
                    }
                    else if (command == 5){
                        System.out.println("Have a nice day! Exiting program...");
                        System.exit(0);
                    }
                 }// end of while loop for general staff tasks
             }// end of if statement for general staff 

             // vet section
            else if (employeeType == 2){ 
                    System.out.println("Please enter your name");
                    s.nextLine();
                    String curVet = s.nextLine();
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
    
                        System.out.println("1. Check tasks\n 2. Log vitals\n 3. Add prescription\n 4. List presecription\n 5. Remove prescription\n 6. Exit");
                        //s.nextInt();
                        int vetCommand = s.nextInt();
                         if (vetCommand == 1){
                            System.out.println("Please enter your role:\n 1. Vet \n2. Vet tech\n3. Vet assistent\n4. Go back\n 5. Exit program");
                            int role = s.nextInt();
                            if (role == 1 || role == 2 || role == 3){
                                currentVet.checkTasks();
                                continue;
                            } 
                            else if (role == 4){
                                continue;
                            }
                            else if (role == 5){
                                System.out.println("Have a nice day!");
                                System.exit(0);
                            }
                            else {
                                System.out.println("Please enter a valid role.");
                                continue;
                            }
                         }// end of check tasks for vet
                        else if (vetCommand == 2){
                            System.out.print("Please enter the name of the pet you wish to log.");
                            s.nextLine();
                            String petName = s.nextLine();
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
                        else if (vetCommand == 3){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            s.nextLine();
                            String petName = s.nextLine();
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
                                System.out.println("Could not find this prescription.");
                            }

                        } // end of add presctiption 
                        else if (vetCommand == 4){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            s.nextLine();
                            String petName = s.nextLine();
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
                        else if (vetCommand == 5){
                            System.out.println("Please enter the name of the pet you wish to log.");
                            s.nextLine();
                            String petName = s.nextLine();
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
                                System.out.println("Could not find this prescription.");
                            }
                        } // end of remove prescription 
                        else if (vetCommand == 6){ // exit program
                            System.out.println("Have a nice day!");
                            System.exit(0);
                        }

                    
                 } // end of while loop for vet 
          } // end of vet 
            else if (s.nextInt() == 3){ //exit employee
                System.out.println("Have a nice day!");
               System.exit(0);
            }
        

        }// end of the while loop for case 2










        case 3:
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
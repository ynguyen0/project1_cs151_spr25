package animals;

import java.util.Scanner;
import java.util.Random;

public class Cat extends Pet {

    
    private boolean isLitterBoxTrained;
    private String breed;
    private boolean clean;
    private String temperment;

    public Cat(String name, String species, int age, int roomNumber, boolean isHealthy, boolean isAdopted, boolean canAdopt, String temperment, Boolean trained, Boolean clean, String breed){
        this.name = name;
        this.species = species;
        this.roomNumber = roomNumber;
        this.isHealthy = isHealthy;
        this.isAdopted = isAdopted; 
        this.canAdopt = false;
        this.temperment = temperment;
        this.isLitterBoxTrained = trained;
        this.age = age;
        this.clean = clean;
        this.breed = breed;
    }
    public Cat(String name){
        this.name = name;
    }

    //Setters
    public void setAdoptionStatus(boolean isAdopted){
        this.isAdopted = isAdopted;
    }

    public void setHealth(boolean isHealthy){
        this.isHealthy = isHealthy;
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setTemperment(String temperment){
        this.temperment = temperment;
    }

    public void setisLitterBoxTrained(boolean isLitterBoxTrained){
        this.isLitterBoxTrained = isLitterBoxTrained; 
    }

    public void setClean(boolean clean){
        this.clean =  clean;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    //Getters 
    public Boolean getAdoptionStatus(){
        return isAdopted;
    }

    public Boolean getHealth(){
        return isHealthy;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public String getSpecies(){
        return species;
    }

    public String getName(){
        return name;
    }

    public String getTemperment(){
        return temperment;
    }

    public boolean getisLitterBoxTrained(){
        return isLitterBoxTrained;
    }

    public int getAge(){
        return age;
    }

    public boolean getClean(){
        return clean;
    }

    public String getBreed(){
        return breed;
    }

    public void updatePetProfile(Scanner s){
         //Scanner s = new Scanner(System.in);
         System.out.println("Please select one of the following to update the pet's profile. \n 1. Name \n 2. Species \n 4. Health Status\n 5. Adoption status\n 6. Adoptability\n 7. Age\n 8. Exit");

        while(s.hasNextInt()){
            if (s.nextInt() == 1){
                System.out.println("Enter new name: ");
                String newName = s.nextLine();
                System.out.printf("%s's name has been changed to %s.", name, newName);
                setName(newName);
            }
            else if (s.nextInt() == 2){
                System.out.println("Enter updated species: ");
                String newSpecies = s.nextLine();
                System.out.printf("%s's species has been changed to %s.", name, newSpecies);
                setSpecies(newSpecies);
            }
            else if (s.nextInt() == 3){
                System.out.println("Enter updated room number: ");
                // follow room number logic with the shelter
                int newRoomNumber = s.nextInt();
               ///// System.out.printf("%s's species has been changed to %s.", name, newSpecies);
                roomNumber = newRoomNumber;
            }
            else if (s.nextInt() == 4){
                System.out.println("Enter updated health status: \n 1. healthy \n 2. unhealthy");
                int newHealthInt = s.nextInt();
                if(newHealthInt == 1){
                    setHealth(true);
                    System.out.printf("%s's health condition has been updated to healthy.", name);
                }
                else{
                    setHealth(false);
                    System.out.printf("%s's health condition has been updated to unhealthy.", name);

                }
            }
            else if (s.nextInt() == 5){
                System.out.println("Enter updated adoption status: \n 1. Is adopted \n Is not adopted/n");
                int newAdoptInt = s.nextInt();
                if(newAdoptInt == 1){
                    setAdoptionStatus(true);
                    System.out.printf("%s's adoption status has been updated to adopted.", name);
                }
                else{
                    setAdoptionStatus(false);
                    System.out.printf("%s's health condition has been updated to not adopted.", name);

                }
            }
            else if (s.nextInt() == 6){
                // follow adoptability logic 
                System.out.println("Enter adobtability condition: \n 1. Is adoptable \n 2. Is not adoptable");
                int newAdoptInt = s.nextInt();
                if(newAdoptInt == 1){
                    if (clean && isHealthy && !isAdopted){
                        setAdoptionStatus(true);
                        System.out.printf("%s's adoption status has been updated to adoptable.", name);
                    }
                    else{
                        System.out.printf("%s is not yet adoptable. Please try again.", name);
                    }
                }
                else{
                    setAdoptionStatus(false);
                    System.out.printf("%s is not yet adoptable.", name);
                }
            }
            else if (s.nextInt() == 7){
                System.out.println("Enter updated temperment: ");
                String newTemperment = s.nextLine();
                System.out.printf("%s's temperment has been changed to %s.", name, newTemperment);
                setTemperment(newTemperment);
            }
            else if (s.nextInt() == 8){
                System.out.println("Enter litter box training status: ");
                int newLitterInt = s.nextInt();
                if(newLitterInt == 1){
                    setisLitterBoxTrained(true);
                    System.out.printf("%s is litterbox trained.", name);
                }
                else{
                    setisLitterBoxTrained(false);
                    System.out.printf("%s is not litter box trained.", name);

                }

            }
            else if (s.nextInt() == 9){
                System.out.println("Enter updated age: ");
                int newAge = s.nextInt();
                System.out.printf("%s's age has been updated to %d.", name, newAge);
                setAge(newAge);
            }
            else if (s.nextInt() == 10){
                System.out.println("Type 1 if the pet is clean and 2 if they are not clean: ");
                int newClean = s.nextInt();
                if(newClean == 1){
                    groom();
                }
                else{
                    setClean(false);
                    System.out.printf("%s is not clean.", name);
                }

            }
            else if (s.nextInt() == 11){
                System.out.println("Enter updated breed: ");
                String newBreed = s.nextLine();
                System.out.printf("%s's breed has been updated to %s.", name, newBreed);
                setBreed(newBreed);
            }
            else if (s.nextInt() == 12){
                System.out.print("Updates complete.");
                break;
            }
            else{
                System.out.println("Invalid response.");
                break;
            }
        }

    }
        
    public void getPetProfile(){ 
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Breed: " + breed);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Healthy?: " + isHealthy);
        System.out.println("Adopted?: " + isAdopted);
        System.out.println("Ready to Adopt?: " + canAdopt);
        System.out.println("Temperment: " + temperment);
        System.out.println("Litterbox Trained?: " + isLitterBoxTrained);
        System.out.println("Age: " + age);
        System.out.println("Clean?: " + clean);
    }


    public void adopt(String guestname){
        if (canAdopt){
            System.out.println("Dear " + guestname + ", Thank you for adopting" + name + "!");
            if (isLitterBoxTrained){
                System.out.println("Please take good care of them!");
            }
            else{
                System.out.println("Remember, " + name + "is not yet litterbox trained. Please take extra care to train them. Take care!");
            }
            isAdopted = true;
            canAdopt = false;
        }
        else{
            System.out.println(name + "is not yet adoptable. Please come back another time.");
        } 
       
    }
    
    public void checkActivity(){

        Random randomNumGen = new Random();
        int num = randomNumGen.nextInt(5);

        if (num == 1){
            catchMouse();
        }
        else if (num == 2){
            eat();
        }
        else if (num == 3){
            scratch();
        }
        else if (num == 4){
            meow();
        }
        else if (num == 5){
            nap();
        }
        else if (num == 0){
            play();
        }
    }

    public void play(){
        if(temperment == "lazy"){
            System.out.println(name + "looked up and went back to sleep. zzzz");
        }
        else if (temperment == "playful"){
            System.out.println(name + "started chasing a laser. They seem to be having fun.");
        }
        else if (temperment == "feisty"){
            scratch();
        }
        else{
            System.out.print(name + "is playing with a ball of yarn.");
        }
    }

    public void eat(){
        System.out.println(name + " ate and is now full.");
    }

    public void groom(){
        setClean(true);
        System.out.println(name + " got a fresh new cut.");
    }

    public void scratch(){
        System.out.println(name + " started playing at the scratching post.");
    }

    public void catchMouse(){
        if(temperment == "lazy"){
            System.out.println("A mouse passed by. " + name + " looked at it and went back to sleep. zzzz");
        }
        else if (temperment == "playful"){
            System.out.println(name + " just spotted a mouse and dashed off!");
        }
        else if (temperment == "feisty"){
            System.out.println("There's something in " + name + "'s mouth...It's a mouse?");
        }
    }

    public void meow(){
        if(temperment == "lazy"){
            System.out.println(name + "just purred");
        }
        else if (temperment == "playful"){
            System.out.println(name + "just meowed!");
        }
        else if (temperment == "feisty"){
            System.out.println(name + "just hissed!");
        }
    }

    public void nap(){
        System.out.println(name + " is taking a nap!");
    }
}

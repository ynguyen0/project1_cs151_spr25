package animals;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Hamster extends Pet {

    private Queue<String> cheek;

    public Hamster(String name, String species, int roomNumber, boolean isHealthy, boolean isAdopted, int age){
        cheek = new LinkedList<>();
        cheek.add("a piece of tv cable?");
        cheek.add("sunflower seeds");
        cheek.add("grains");
        cheek.add("string cheese");
        this.name = name;
        this.species = species;
        this.roomNumber = roomNumber;
        this.isHealthy = isHealthy;
        this.isAdopted = isAdopted; 
        this.age = age;
    }

    public Hamster(String name){
        cheek = new LinkedList<>();
        cheek.add("a piece of tv cable?");
        cheek.add("sunflower seeds");
        cheek.add("grains");
        cheek.add("string cheese");
        this.name = name;
    }

    //Setters
    public void setAdoptionStatus(Boolean isAdopted){
        this.isAdopted = isAdopted;
    }

    public void setHealth(Boolean isHealthy){
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

    public int getAge(){
        return age;
    }


    public void getPetProfile(){ 
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Healthy?: " + isHealthy);
        System.out.println("Adopted?: " + isAdopted);
        System.out.println("Ready to Adopt?: " + canAdopt);
        System.out.println("Age: " + age);
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
            // else if (s.nextInt() == 3){
            //     System.out.println("Enter updated room number: ");
            //     // follow room number logic with the shelter
            //     int newRoomNumber = s.nextInt();
            //    ///// System.out.printf("%s's species has been changed to %s.", name, newSpecies);
            //     roomNumber = newRoomNumber;
            // }
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
                    if (isHealthy && !isAdopted){
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
                System.out.println("Enter updated age: ");
                int newAge = s.nextInt();
                System.out.printf("%s's age has been updated to %d.", name, newAge);
                setAge(newAge);
            }
            else if (s.nextInt() == 8){
                System.out.print("Updates complete.");
                break;
            }
            else{
                System.out.println("Invalid response.");
                break;
            }
        }

    }

    public void adopt(String guestname){
        if (canAdopt){
            System.out.println("Dear " + guestname + ", Thank you for adopting" + name + "!");
            System.out.println("Please take good care of them!");
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
            runInMaze();
        }
        else if (num == 2){
            eat();
        }
        else if (num == 3){
            useWheel();
        }
        else if (num == 4){
            nap();
        }
        else if (num == 5){
            int snackNum = randomNumGen.nextInt(4);
            String snack;
            if (snackNum == 0){
                snack = "sunflower seeds";
                storeFood(snack);
            }
            else if (snackNum == 1){
                snack = "millet seeds";
                storeFood(snack);
            }
            else if (snackNum == 2){
                snack = "pumpkin seeds";
                storeFood(snack);
            }
            else if (snackNum == 3){
                snack = "a piece of television wire??";
                storeFood(snack);
            }
        }
        else if (num == 0){
            digtunnel();
        }
    }

    public void eat(){
        if(cheek.size() > 0){
            System.out.println(name + "ate the " + cheek.remove() + "it was storing in its cheek");
        }
        else{
            System.out.println(name + " is eating a large mouthful of seeds.");
        }
    }

    public void runInMaze(){
        System.out.println(name + "is now running in the maze!");
        if(cheek.size() == 5 || cheek.size() == 4){
            System.out.println(name + " got tired and ate a " + cheek.remove()); 
        }
    }


    public void useWheel(){
        System.out.println(name + "is now running in the wheel!");
        
        if(name.length() % 2 == 0){
            System.out.println("After five minutes, " + name + "is starting to get tired...");
            nap();
        }
        else{
            System.out.println(name + " looks really happy right now!");
        }
    }


    public void nap(){
        System.out.println(name + " is taking a nap right now. zzz.");
    }

    public void storeFood(String snack){
        if(cheek.size() <= 5){
            System.out.print(name + "is now storing ");
            for(String s: cheek){
                System.out.print(s + ", ");
            }
            cheek.add(snack);
            System.out.println("and " + snack + "in its cheek.");
        }
        else{
            System.out.println(name + " is already full!");
        }
    }
        
    public void digtunnel(){
        System.out.println(name + " just dug a tunnel.");
    }
}
    
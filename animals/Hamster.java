package animals;
import java.util.Queue;
import java.util.LinkedList;

public class Hamster extends Pet {

    private Queue<String> cheek;

    public Hamster(String name, String species, int roomNumber, boolean isHealthy, boolean isAdopted, int age){
        cheek = new LinkedList<>();
        this.name = name;
        this.species = species;
        this.roomNumber = roomNumber;
        this.isHealthy = isHealthy;
        this.isAdopted = isAdopted; 
        this.age = age;
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






    public void addNewPet(){
        
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

    public void adopt(String guestname){
        System.out.println("Dear " + guestname + ", Thank you for adopting" + name + "!");
        System.out.println("Please take good care of them!");
        isAdopted = true;
        canAdopt = false;
    }
    
    public void play(String guestName){}


    public void setAppointment(String guestName, int time){}
    public void cancelAppointment(String guestName){}
    public void checkMeetingTime(){}


    public void eat(){}

    public void vetTrip(Vet vet){}





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
    
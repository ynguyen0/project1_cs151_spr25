package animals;
import java.util.Queue;
import java.util.LinkedList;

public class Hamster extends Pet {

    // public String name;
    // public String species;
    // //public String temperment;
    // public int roomNumber;
    // public boolean isHealthy;
    // public boolean isAdopted;

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


    public void addNewPet(){
        
    }

    public void updatePetProfile(){}

    public String getPetProfile(){ 
        String profile = "Name: " + name + "  Species: " + species + "  Room: " + roomNumber;
        return profile;
    }

    public void setAdoptionStatus(){}

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
    
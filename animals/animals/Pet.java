package animals;
import java.util.Scanner;
public abstract class Pet {
    public String name;
    public String species;
    public int roomNumber;
    public boolean isHealthy;
    public boolean isAdopted;
    public boolean canAdopt;
    public int age;

    public abstract void updatePetProfile(Scanner s);
    public abstract void getPetProfile();
    // public abstract void setAdoptionStatus();
    public abstract void adopt(String guestname);

    //public abstract void play(String guestName);
    public abstract void eat();
    public abstract String getName();
    public abstract void checkActivity();
}
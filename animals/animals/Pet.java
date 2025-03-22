package animals;
public abstract class Pet {
    public String name;
    public String species;
    //public String temperment;
    public int roomNumber;
    public boolean isHealthy;
    public boolean isAdopted;
    public boolean canAdopt;
    public int age;

    //public abstract void addNewPet();
    // public abstract void updatePetProfile();
    public abstract void getPetProfile();
    // public abstract void setAdoptionStatus();
    public abstract void adopt(String guestname);

    //public abstract void play(String guestName);
    public abstract void setAppointment(String guestName, int time);
    public abstract void cancelAppointment(String guestName);
    public abstract void checkMeetingTime();
   // public abstract void eat();
    public abstract String getName();
}
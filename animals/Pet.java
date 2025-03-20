public abstract class Pet {
    public String name;
    public String breed;
    public String temperment;
    public int roomNumber;
    public boolean isHealthy;
    public boolean isAdopted;

    public abstract void addNewPet();
    public abstract void updatePetProfile();
    public abstract String getPetProfile();
    public abstract void setAdoptionStatus();
    public abstract void adopt(String guestname, String petName);

    public abstract void play(String guestName);
    public abstract void setAppointment(String guestName, int time);
    public abstract void cancelAppointment(String guestName);
    public abstract void checkMeetingTime();
    public abstract void eat();
    public abstract boolean vetTrip(Vet vet);
}
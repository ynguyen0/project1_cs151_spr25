public class Hamster extends Pet {

    String name;
    String breed;
    int age;
    int roomNumber;
    Boolean isHealthy;
    Boolean isAdopted;
    Boolean usesWheel;


    public void setAdoptionStatus(){}

    public void adopt(String guestname, String petName){}

    public void play(String guestName){}

    public void setAppointment(String guestName){}

    public void cancelAppointment(String guestName){}

    public void checkMeetingTime(){}

    public void eat(){}

    public boolean vetTrip(Vet vet){
        return false;
    }

    @Override 
    public void addNewPet(){}

    @Override 
    public void updatePetProfile(){}

    @Override 
    public String getPetProfile(){ 
        String egu = "";
        return egu;
    }

    
}

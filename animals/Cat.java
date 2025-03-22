public class Cat extends Pet {

    
    private Boolean isLitterBoxTrained;
    private int trained;
    private String breed;
    private Boolean clean;
    private String temperment;

    public Cat(String name, String species, int age, int roomNumber, boolean isHealthy, boolean isAdopted, boolean canAdopt, String temperment, int trained){
        this.name = name;
        this.species = species;
        this.roomNumber = roomNumber;
        this.isHealthy = isHealthy;
        this.isAdopted = isAdopted; 
        this.canAdopt = false;
        this.temperment = temperment;
        this.trained = trained;
        this.age = age;
    }

    public void addNewPet(){}

    public void updatePetProfile(){}
        
    public String getPetProfile(){ 
        String profile = "Name: " + name + "  Species: " + species + "  Breed: " + breed + "  Room: " + roomNumber;
        return profile;
    }
    public void setAdoptionStatus(){
        if (clean && isHealthy && !isAdopted){
            canAdopt = true;
        }
    }


    public void adopt(String guestname){
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
    
    public void play(String toy){
        if(temperment == "lazy"){
            System.out.println(name + "looked at you and went back to sleep. zzzz");
        }
        else if (temperment == "playful"){
            System.out.println(name + "started playing with the " + toy + ". They seem to be having fun.");
        }
        else if (temperment == "feisty"){
            scratch();
        }
    }

    public void setAppointment(String guestName, int time){}
    public void cancelAppointment(String guestName){}
    public void checkMeetingTime(){}

    public void eat(){
        System.out.println(name + " is now full.");
    }


    public void vetTrip(Vet vet){}

    public void train(){

    }

    public void groom(){
        clean = true;
        System.out.println(name + " got a fresh new cut.");
    }

    public void scratch(){
        if(temperment == "fiesty"){
            System.out.println("Watch out!" + name + " doesn't like to be pet.");
        }
        else{
            System.out.println(name + " started playing at the scratching post.");
        }

    }

    public void catchMouse(){
        if(temperment == "lazy"){
            System.out.println("A mouse passed by and " + name + " looked at it and went back to sleep. zzzz");
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
            System.out.println("Purr");
        }
        else if (temperment == "playful"){
            System.out.println("Meow!");
        }
        else if (temperment == "feisty"){
            System.out.println("Hiss!");
        }
    }

    public void nap(){}
}

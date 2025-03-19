package employees;
public class Staff implements Employee {
    private int hoursPerWeek;
    private double weeklySalary;
    private String employmentType;
    private String role;

    public Staff (int hoursPerWeek, double weeklySalary, String employementType, String role) {
        this.hoursPerWeek = hoursPerWeek;
        this.weeklySalary = weeklySalary;
        this.employmentType = employementType;
        this.role = role;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    @Override
    public void setEmploymentType(String employementType) {
        this.employmentType = employementType;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    public boolean assignRole() {
        return false;
    }

    public int updateHours() {
        return 0;
    }

    public void feedPet(PetTest pet) {
    
    }

    public void cleanPet(PetTest pet) {
        
    }

    public void playWithPet(PetTest pet) {
        
    }
}

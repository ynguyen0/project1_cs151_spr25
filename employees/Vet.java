package employees;
public class Vet implements Employee {
    private int hoursPerWeek;
    private double weeklySalary;
    private String employmentType;
    private String role;

    public Vet(int hoursPerWeek, double weeklySalary, String employementType, String role) {
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
}

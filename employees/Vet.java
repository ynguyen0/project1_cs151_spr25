package employees;
public class Vet implements Employee {
    private String employeeName;
    private int employeeID;
    private double weeklySalary;
    private String role;

    public Vet (String employeeName, int employeeID, double weeklySalary, String role) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.weeklySalary = weeklySalary;
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;

    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // raises the staff's weekly salary by 20%
    public double givePayRaise() {
        double increasedPay = getWeeklySalary() * 0.2;
        setWeeklySalary(increasedPay);
        return increasedPay;
    }

    // reminds the employee of their tasks based on their role
    public void assignTasks() {
        if (role.equals("Vet")) {
            System.out.println("Please examine the pets, update treatment plans, and write prescriptions.");
        }
        else if (role.equals("Vet Tech")) {
            System.out.println("Please run lab tests, monitor vitals, and complete medical reports.");
        }
        else if (role.equals("Vet Assistant")) {
            System.out.println("Please prepare the medical supplies and clean up the patient room.");
        }
        else {
            System.out.println("You have not been assigned any roles or tasks yet.");
        }
    }

}

package employees;
public class Staff implements Employee {
    private String employeeName;
    private int employeeID;
    private double weeklySalary;
    private String role;

    public Staff (String employeeName, int employeeID, double weeklySalary, String role) {
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

    // raises the staff's weekly salary by 10%
    public double givePayRaise() {
        double increasedPay = getWeeklySalary() * 0.1;
        setWeeklySalary(increasedPay);
        return increasedPay;
    }

    // reminds the employee of their tasks based on their role
    public void assignTasks() {
        if (role.equals("Pet Groomer")) {
            System.out.println("Please groom, bathe, and give the pets a haircut!");
        }
        else if (role.equals("Pet Caregiver")) {
            System.out.println("Please play with the pets, feed them, and cuddle them!");
        }
        else if (role.equals("Shelter Manager")) {
            System.out.println("Please check on the employees, help the customers, and manage the schedule.");
        }
        else {
            System.out.println("You have not been assigned any roles or tasks yet.");
        }
    }


}
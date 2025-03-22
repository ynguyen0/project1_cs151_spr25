package employees;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import animals.Pet;

public class Vet implements Employee {
    private String employeeName;
    private int employeeID;
    private double weeklySalary;
    private String role;
    private double hoursWorked;
     private Map<Pet, List<String>> prescriptions;

    public Vet (String employeeName, int employeeID, double weeklySalary, String role, double hoursWorked) {
            this.employeeName = employeeName;
            this.employeeID = employeeID;
            this.weeklySalary = weeklySalary;
            this.role = role;
            this.hoursWorked = hoursWorked;
            prescriptions = new HashMap<>();
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

    @Override
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Vet{name='" + employeeName + "', ID=" + employeeID + ", Role='" + role + "', Weekly Salary=" + weeklySalary + "}";
    }

    // reminds the employee of their tasks based on their role
    public void checkTasks() {
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

    public void logVitals() {
        Scanner s = new Scanner(System.in);

        System.out.println("How were the pet's vitals? (Please select: Critical/Normal/Healthy)");
        String vitals = s.nextLine();

        if (vitals.equals("Critical")) {
            System.out.println("The pet's vitals have been logged as critical. Please transfer to the hospital.");
        } else if (vitals.equals("Normal")) {
            System.out.println("The pet's vitals have been logged as normal. Please continue to monitor.");
        } else if (vitals.equals("Healthy")) {
            System.out.println("The pet's vitals are healthy. Please give the pet a treat!");
        } else {
            System.out.println("Could not process your input. Please select: Critical/Normal/Healthy");
        }
    }

    public void addPrescription(Pet pet, String prescription) {
        prescriptions.putIfAbsent(pet, new ArrayList<>());
        prescriptions.get(pet).add(prescription);

        System.out.println(prescription + " has been added to " + pet.getName() + "'s medication list.");
    }

    public void listPrescription(Pet pet) {
        List<String> medicationList = prescriptions.get(pet);

        if (medicationList.isEmpty()) {
            System.out.println(pet.getName() + " is not prescribed any medication. Looks like your pet is healthy!");
        } 
        else {
            System.out.println("Here is a list of all medications for " + pet.getName() + ":");
            for (String m : medicationList) {
                System.out.println(m);
            }
        }
    }
}

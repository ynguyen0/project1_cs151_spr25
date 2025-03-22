package employees;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Staff implements Employee {
    private String employeeName;
    private int employeeID;
    private double weeklySalary;
    private String role;
    private double hoursWorked;

    public Staff (String employeeName, int employeeID, double weeklySalary, String role, double hoursWorked) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.weeklySalary = weeklySalary;
        this.role = role;
        this.hoursWorked = hoursWorked;
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


    // allows the staff to check their weekly salary after receiving bonuses
    @SuppressWarnings("resource")
    public void checkBonus() {
        Scanner s = new Scanner(System.in);

        System.out.println("How much of a bonus were you granted? (Please enter a percentage): ");
        double bonusPercentage = s.nextDouble();

        if (bonusPercentage < 0) {
            throw new IllegalArgumentException("You can't have a negative bonus!");
        }

        double newSalary = getWeeklySalary() * (1 + bonusPercentage / 100);
        setWeeklySalary(newSalary);

        System.out.println("After this bonus, your weekly salary is now " + newSalary);
        s.close();
    }

    // reminds the employee of their tasks based on their role
    public void checkTasks() {
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

    // the staff can request a lunch break after the fourth hour of their shift is completed
    public void requestLunchBreak() {
        Scanner s = new Scanner(System.in);
    
        try {
            System.out.println("Please log the number of hours you worked so far: ");
            
            // throw an exception if the input is not a double
            if (!s.hasNextDouble()) {
                throw new InputMismatchException("Could not process your input. Please enter a valid double value.");
            }

            this.hoursWorked = s.nextDouble();

            // throw an exception for edge cases
            if (hoursWorked < 0 || hoursWorked > 24) { 
                throw new IllegalArgumentException("Could not process your input. Please enter a valid hour between 0 and 24.");
            }

            if (hoursWorked < 5) {
                System.out.println("It's not time for your lunch break yet.");
            }
            else if (hoursWorked >= 5 && hoursWorked <= 8) {
                System.out.println("Please take your 30 minute lunch break now!");
            }
            else if (hoursWorked > 8) {
                System.out.println("Looks like your shift is over. Time to go home for dinner!");
            }
        } 
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            s.next(); 
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            s.close(); 
        }
    }

    // increments the hours worked by an employee during a shift
    public void workShift() {
        System.out.println("Thanks for clocking into your shift.");
        
        while (hoursWorked < 10) {
            if (hoursWorked == 0) {
                System.out.println("Your shift has just started.");
            }
            else if (hoursWorked >= 1 && hoursWorked <= 8) {
                System.out.println("You have been working for " + hoursWorked + " hours. Great job!");
            }
            else if (hoursWorked == 8) {
                System.out.println("Thanks for clocking out.");
                break;
            }
            else if (hoursWorked > 8) {
                System.out.println("Looks like you're working overtime. Thanks for your hard work!");
                break;
            }
            hoursWorked++;
        }
    }
}
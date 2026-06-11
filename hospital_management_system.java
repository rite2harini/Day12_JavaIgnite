import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Parent Class
class Employee {
    int employeeId;
    String name;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public void displayRole() {
        System.out.println("Employee");
    }
}

// Child Class - Doctor
class Doctor extends Employee {
    String specialization;

    public Doctor(int employeeId, String name, String specialization) {
        super(employeeId, name);
        this.specialization = specialization;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Doctor");
    }
}

// Child Class - Nurse
class Nurse extends Employee {
    String shift;

    public Nurse(int employeeId, String name, String shift) {
        super(employeeId, name);
        this.shift = shift;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Nurse");
    }
}

// Main Class
public class HospitalEmployeeManagement {
    public static void main(String[] args) {

        // Create objects
        Doctor doctor = new Doctor(101, "Dr. Arun", "Cardiology");
        Nurse nurse = new Nurse(201, "Priya", "Night");

        // Polymorphism
        Employee e1 = doctor;
        Employee e2 = nurse;

        e1.displayRole();
        e2.displayRole();

        try {
            // Write employee details to file
            FileWriter writer = new FileWriter("employees.txt");

            writer.write("Doctor Details\n");
            writer.write("Employee ID: " + doctor.employeeId + "\n");
            writer.write("Name: " + doctor.name + "\n");
            writer.write("Specialization: " + doctor.specialization + "\n\n");

            writer.write("Nurse Details\n");
            writer.write("Employee ID: " + nurse.employeeId + "\n");
            writer.write("Name: " + nurse.name + "\n");
            writer.write("Shift: " + nurse.shift + "\n");

            writer.close();

            System.out.println("\nEmployee details saved to employees.txt");

            // Read file contents
            FileReader reader = new FileReader("employees.txt");

            int ch;
            System.out.println("\nContents of employees.txt:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Hospital Employee Management System

Create the following hierarchy:

Employee
│
| -Doctor
│
| -Nurse
Requirements:
Employee should contain:
employeeId
name
Doctor should contain:
specialization
Nurse should contain:
shift

Polymorphism:

Override:

displayRole() for Doctor and Nurse.

File Handling:

Save all employee details into:

employees.txt

using FileWriter.

Read and display contents using FileReader.

*/

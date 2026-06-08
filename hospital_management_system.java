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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Parent Class
class Employee {
    int employeeId;
    String name;

    Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    void displayRole() {
        System.out.println("Employee");
    }
}

// Child Class
class Doctor extends Employee {
    String specialization;

    Doctor(int employeeId, String name, String specialization) {
        super(employeeId, name);
        this.specialization = specialization;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Doctor");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

// Child Class
class Nurse extends Employee {
    String shift;

    Nurse(int employeeId, String name, String shift) {
        super(employeeId, name);
        this.shift = shift;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Nurse");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Shift: " + shift);
    }
}

public class Hospital_management_system {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Doctor d1 = new Doctor(101, "Rahul", "Cardiology");
        Nurse n1 = new Nurse(201, "Priya", "Night");

        // Polymorphism
        Employee e1 = d1;
        Employee e2 = n1;

        e1.displayRole();
        System.out.println();

        e2.displayRole();
        System.out.println();

        // File Writing
        try {
            FileWriter fw = new FileWriter("employees.txt");

            fw.write("Role: Doctor\n");
            fw.write("Employee ID: " + d1.employeeId + "\n");
            fw.write("Name: " + d1.name + "\n");
            fw.write("Specialization: " + d1.specialization + "\n\n");

            fw.write("Role: Nurse\n");
            fw.write("Employee ID: " + n1.employeeId + "\n");
            fw.write("Name: " + n1.name + "\n");
            fw.write("Shift: " + n1.shift + "\n");

            fw.close();

            System.out.println("Employee details saved successfully.\n");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }

        // File Reading
        try {
            FileReader fr = new FileReader("employees.txt");

            int ch;

            System.out.println("Contents of employees.txt:\n");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("Error while reading file.");
        }
    }
}

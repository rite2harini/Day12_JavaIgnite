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

import java.io.*;

class Employee {
    int employeeId;
    String name;

    Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    void displayRole() {
        System.out.println("Employee: " + name);
    }

    public String toString() {
        return employeeId + " | " + name;
    }
}

class Doctor extends Employee {
    String specialization;

    Doctor(int employeeId, String name, String specialization) {
        super(employeeId, name);
        this.specialization = specialization;
    }

    @Override
    void displayRole() {
        System.out.println(name + " is a Doctor | Specialization: " + specialization);
    }

    public String toString() {
        return "Doctor | " + super.toString() + " | " + specialization;
    }
}

class Nurse extends Employee {
    String shift;

    Nurse(int employeeId, String name, String shift) {
        super(employeeId, name);
        this.shift = shift;
    }

    @Override
    void displayRole() {
        System.out.println(name + " is a Nurse | Shift: " + shift);
    }

    public String toString() {
        return "Nurse | " + super.toString() + " | " + shift;
    }
}

public class hospital_management_system {
    public static void main(String[] args) throws IOException {

        Doctor d1 = new Doctor(201, "Dr. Arjun", "Cardiology");
        Doctor d2 = new Doctor(202, "Dr. Sneha", "Neurology");
        Nurse n1 = new Nurse(301, "Kavya", "Morning");
        Nurse n2 = new Nurse(302, "Rekha", "Night");

        // Polymorphism
        d1.displayRole();
        d2.displayRole();
        n1.displayRole();
        n2.displayRole();
        FileWriter fw = new FileWriter("employees.txt");
        fw.write(d1.toString() + "\n");
        fw.write(d2.toString() + "\n");
        fw.write(n1.toString() + "\n");
        fw.write(n2.toString() + "\n");
        fw.close();
        System.out.println("Employee details saved to employees.txt");

        System.out.println("Reading from employees.txt:");
        FileReader fr = new FileReader("employees.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
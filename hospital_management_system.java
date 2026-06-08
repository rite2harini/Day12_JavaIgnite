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
package day12_progs;
import java.io.*;

class ocupation { // Parent Class
    int empId;
    String empName;

    ocupation(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    void displayRole() {
        System.out.println("Medical Staff");
    }
}

class doctor extends ocupation { // Child Class
    String specialization;

    doctor(int empId, String empName, String specialization) {
        super(empId, empName);
        this.specialization = specialization;
    }

    @Override
    void displayRole() {
        System.out.println("Doctor");
    }
}

class nurse extends ocupation { // Child Class
    String shift;

    nurse(int empId, String empName, String shift) {
        super(empId, empName);
        this.shift = shift;
    }

    @Override
    void displayRole() {
        System.out.println("Nurse");
    }
}

public class hospital_management_system {

    public static void main(String[] args) {

        doctor d1 = new doctor(101, "Berlin", "Cardiologist");
        nurse n1 = new nurse(201, "Tokyo", "Night");

        d1.displayRole();
        n1.displayRole();

        try {

            FileWriter fw = new FileWriter("employees.txt");

            fw.write("Employee ID : " + d1.empId +", Name : " + d1.empName +", Role : Doctor" +", Specialization : " + d1.specialization + "\n");

            fw.write("Employee ID : " + n1.empId +", Name : " + n1.empName +", Role : Nurse" +", Shift : " + n1.shift + "\n");

            fw.close();

            System.out.println("\nData Written Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }

        try {

            FileReader fr = new FileReader("employees.txt");

            int ch;

            System.out.println("\nReading File:\n");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

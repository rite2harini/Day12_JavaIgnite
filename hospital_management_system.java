import java.io.*;

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

class Doctor extends Employee {
 String specialization;

 Doctor(int employeeId, String name, String specialization) {
     super(employeeId, name);
     this.specialization = specialization;
 }

 @Override
 void displayRole() {
     System.out.println("Role: Doctor");
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
     System.out.println("Role: Nurse");
 }
}


public class HospitalEmployeeManagementSystem {
	public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Rahul", "Cardiologist");
        Nurse n1 = new Nurse(201, "Priya", "Night");

        d1.displayRole();
        n1.displayRole();

        try {
            FileWriter fw = new FileWriter("employees.txt");

            fw.write("Doctor Details\n");
            fw.write("ID: " + d1.employeeId +
                     ", Name: " + d1.name +
                     ", Specialization: " + d1.specialization + "\n");

            fw.write("Nurse Details\n");
            fw.write("ID: " + n1.employeeId +
                     ", Name: " + n1.name +
                     ", Shift: " + n1.shift + "\n");

            fw.close();

            System.out.println("\nEmployee details saved to employees.txt");

            FileReader fr = new FileReader("employees.txt");
            int ch;

            System.out.println("\nContents of employees.txt:");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

}


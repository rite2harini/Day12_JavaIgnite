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
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
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
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Shift: " + shift);
    }
}

public class HospitalEmployeeManagementSystem {
    public static void main(String[] args) {

        Doctor d = new Doctor(101, "Rahul", "Cardiology");
        Nurse n = new Nurse(201, "Priya", "Night");

        // Polymorphism
        Employee e1 = d;
        Employee e2 = n;

        e1.displayRole();
        System.out.println();

        e2.displayRole();
        System.out.println();

        // File Handling - Write
        try {
            FileWriter fw = new FileWriter("employees.txt");

            fw.write("Doctor: " + d.employeeId + ", "
                    + d.name + ", "
                    + d.specialization + "\n");

            fw.write("Nurse: " + n.employeeId + ", "
                    + n.name + ", "
                    + n.shift + "\n");

            fw.close();

            System.out.println("Employee details saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }

        // File Handling - Read
        try {
            FileReader fr = new FileReader("employees.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nContents of employees.txt:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee {
    int employeeId;
    String name;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public void displayRole() {
        System.out.println("Role: General Employee");
    }

    public String getDetails() {
        return employeeId + "," + name;
    }
}

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

    @Override
    public String getDetails() {
        return super.getDetails() + "," + specialization;
    }
}

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

    @Override
    public String getDetails() {
        return super.getDetails() + "," + shift;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String role = scanner.nextLine();
            String extra = scanner.nextLine();

            Employee emp;
            if (role.equalsIgnoreCase("Doctor")) {
                emp = new Doctor(id, name, extra);
            } else {
                emp = new Nurse(id, name, extra);
            }

            emp.displayRole();

            FileWriter writer = new FileWriter("employees.txt", true);
            writer.write(emp.getDetails() + "\n");
            writer.close();
            System.out.println("File Write Successful");

            System.out.println("Reading File:");
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("File operation error");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

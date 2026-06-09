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
import java.util.*;

class Employee {
    int employeeId;
    String name;
    
    Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
    
    void displayRole() {
        System.out.println("Generic Employee Role");
    }
    
    @Override
    public String toString() {
        return employeeId + "," + name;
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
        System.out.println("Doctor - Specialization: " + specialization);
    }
    
    @Override
    public String toString() {
        return super.toString() + ",Doctor," + specialization;
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
        System.out.println("Nurse - Shift: " + shift);
    }
    
    @Override
    public String toString() {
        return super.toString() + ",Nurse," + shift;
    }
}

public class HospitalManagement {
    List<Employee> employees = new ArrayList<>();
    
    void addEmployee(Employee e) { employees.add(e); }
    
    // Save using FileWriter
    void saveToFile() {
        try (FileWriter fw = new FileWriter("employees.txt")) {
            for (Employee e : employees) {
                fw.write(e.toString() + "\n");
            }
            System.out.println("Employees saved to employees.txt");
        } catch (IOException e) { System.out.println("Save error: " + e.getMessage()); }
    }
    
    // Read using FileReader
    void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            System.out.println("\n=== Employees from File ===");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String type = parts[2];
                
                if (type.equals("Doctor")) {
                    Doctor d = new Doctor(id, name, parts[3]);
                    System.out.printf("ID: %d | Name: %s | ", id, name);
                    d.displayRole();
                } else if (type.equals("Nurse")) {
                    Nurse n = new Nurse(id, name, parts[3]);
                    System.out.printf("ID: %d | Name: %s | ", id, name);
                    n.displayRole();
                }
            }
        } catch (IOException e) { System.out.println("Read error: " + e.getMessage()); }
    }
    
    public static void main(String[] args) {
        HospitalManagement hm = new HospitalManagement();
        
        // Add employees
        hm.addEmployee(new Doctor(101, "Dr. Smith", "Cardiology"));
        hm.addEmployee(new Nurse(201, "Nurse Jane", "Morning"));
        hm.addEmployee(new Doctor(102, "Dr. Patel", "Neurology"));
        hm.addEmployee(new Nurse(202, "Nurse Mike", "Night"));
        
        // Polymorphism demonstration
        System.out.println("=== Polymorphic Role Display ===");
        for (Employee e : hm.employees) {
            System.out.printf("ID: %d | Name: %s | ", e.employeeId, e.name);
            e.displayRole(); // Calls overridden method
        }
        
        // File operations
        hm.saveToFile();
        hm.readFromFile();
    }
}

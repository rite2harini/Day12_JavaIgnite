/*
Student Result Archive

Create:

Student
│
| - GraduateStudent

Requirements:

Override:

calculateGrade()

for GraduateStudent.

Overloading:

Create:

displayResult()

displayResult(String semester)

Use:

FileOutputStream

to save student result data.

Use:

FileInputStream

to read and display the data.
  */
import java.io.*;
import java.util.*;

class Student implements Serializable {
    int rollNo;
    String name;
    double marks;
    
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    
    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
    
    // Overloaded display methods
    void displayResult() {
        System.out.printf("Roll: %d | Name: %s | Marks: %.2f | Grade: %s%n", 
                         rollNo, name, marks, calculateGrade());
    }
    
    void displayResult(String semester) {
        System.out.printf("Semester: %s | Roll: %d | Name: %s | Marks: %.2f | Grade: %s%n", 
                         semester, rollNo, name, marks, calculateGrade());
    }
}

class GraduateStudent extends Student implements Serializable {
    String thesisTopic;
    double thesisScore;
    
    GraduateStudent(int rollNo, String name, double marks, String thesisTopic, double thesisScore) {
        super(rollNo, name, marks);
        this.thesisTopic = thesisTopic;
        this.thesisScore = thesisScore;
    }
    
    @Override
    String calculateGrade() {
        double finalScore = (marks * 0.6) + (thesisScore * 0.4);
        if (finalScore >= 90) return "A+";
        else if (finalScore >= 75) return "A";
        else if (finalScore >= 60) return "B+";
        else if (finalScore >= 50) return "B";
        else return "F";
    }
    
    @Override
    void displayResult() {
        System.out.printf("Roll: %d | Name: %s | Marks: %.2f | Thesis: %s(%.2f) | Grade: %s%n", 
                         rollNo, name, marks, thesisTopic, thesisScore, calculateGrade());
    }
    
    @Override
    void displayResult(String semester) {
        System.out.printf("Semester: %s | Roll: %d | Name: %s | Thesis: %s | Grade: %s%n", 
                         semester, rollNo, name, thesisTopic, calculateGrade());
    }
}

public class StudentArchive {
    List<Student> students = new ArrayList<>();
    
    void addStudent(Student s) { students.add(s); }
    
    // Save using FileOutputStream
    void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("results.dat"))) {
            oos.writeObject(students);
            System.out.println("Results saved to results.dat");
        } catch (IOException e) { System.out.println("Save error: " + e.getMessage()); }
    }
    
    // Read using FileInputStream
    @SuppressWarnings("unchecked")
    void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("results.dat"))) {
            students = (List<Student>) ois.readObject();
            System.out.println("\n=== Archived Results ===");
            for (Student s : students) {
                s.displayResult();
            }
        } catch (IOException | ClassNotFoundException e) { 
            System.out.println("Read error: " + e.getMessage()); 
        }
    }
    
    public static void main(String[] args) {
        StudentArchive archive = new StudentArchive();
        
        // Add students
        archive.addStudent(new Student(1, "Alice", 85.5));
        archive.addStudent(new GraduateStudent(2, "Bob", 78.0, "AI Research", 92.0));
        archive.addStudent(new Student(3, "Charlie", 62.5));
        archive.addStudent(new GraduateStudent(4, "Diana", 88.0, "ML Algorithms", 85.0));
        
        // Polymorphic grade calculation
        System.out.println("=== Grade Calculation (Polymorphism) ===");
        for (Student s : archive.students) {
            System.out.printf("%s -> %s%n", s.name, s.calculateGrade());
        }
        
        // Method overloading demonstration
        System.out.println("\n=== Overloaded displayResult() ===");
        archive.students.get(0).displayResult();
        archive.students.get(0).displayResult("Spring 2026");
        
        System.out.println("\n=== Graduate Student Display ===");
        archive.students.get(1).displayResult();
        archive.students.get(1).displayResult("Spring 2026");
        
        // File operations with FileOutputStream/FileInputStream
        archive.saveToFile();
        archive.readFromFile();
    }
}

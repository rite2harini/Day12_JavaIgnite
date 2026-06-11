import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Parent Class
class Student {
    int studentId;
    String name;
    int marks;

    public Student(int studentId, String name, int marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate grade
    public void calculateGrade() {
        if (marks >= 80)
            System.out.println("Grade: A");
        else if (marks >= 60)
            System.out.println("Grade: B");
        else
            System.out.println("Grade: C");
    }

    // Overloaded Method
    public void displayResult() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    // Overloaded Method
    public void displayResult(String semester) {
        System.out.println("Semester: " + semester);
        displayResult();
    }
}

// Child Class
class GraduateStudent extends Student {

    public GraduateStudent(int studentId, String name, int marks) {
        super(studentId, name, marks);
    }

    // Overriding Method
    @Override
    public void calculateGrade() {
        if (marks >= 85)
            System.out.println("Graduate Grade: A");
        else if (marks >= 70)
            System.out.println("Graduate Grade: B");
        else
            System.out.println("Graduate Grade: C");
    }
}

// Main Class
public class StudentResultArchive {
    public static void main(String[] args) {

        GraduateStudent student =
                new GraduateStudent(101, "Arun", 88);

        // Overloaded Methods
        student.displayResult();

        System.out.println();

        student.displayResult("Semester 1");

        System.out.println();

        // Overridden Method
        student.calculateGrade();

        try {
            // Save result data using FileOutputStream
            FileOutputStream fos =
                    new FileOutputStream("student_result.txt");

            String data =
                    "Student ID: " + student.studentId + "\n" +
                    "Name: " + student.name + "\n" +
                    "Marks: " + student.marks + "\n";

            fos.write(data.getBytes());
            fos.close();

            System.out.println("\nStudent result saved successfully.");

            // Read result data using FileInputStream
            FileInputStream fis =
                    new FileInputStream("student_result.txt");

            int ch;

            System.out.println("\nStudent Result Data:");

            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }

            fis.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}/*
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

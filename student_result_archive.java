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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 80) return "A";
        if (marks >= 60) return "B";
        return "C";
    }

    public void displayResult() {
        System.out.println("Result: " + calculateGrade());
    }

    public void displayResult(String semester) {
        System.out.println("Semester: " + semester + " | Result: " + calculateGrade());
    }

    public String getDetails() {
        return id + "," + name + "," + marks + "," + calculateGrade() + "\n";
    }
}

class GraduateStudent extends Student {
    public GraduateStudent(int id, String name, double marks) {
        super(id, name, marks);
    }

    @Override
    public String calculateGrade() {
        if (marks >= 90) return "A";
        if (marks >= 70) return "B";
        return "C";
    }
}

public class StudentResultArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            double marks = Double.parseDouble(scanner.nextLine());
            String type = scanner.nextLine();
            String semester = scanner.nextLine();

            Student student;
            if (type.equalsIgnoreCase("Graduate")) {
                student = new GraduateStudent(id, name, marks);
            } else {
                student = new Student(id, name, marks);
            }

            student.displayResult();
            student.displayResult(semester);

            FileOutputStream fos = new FileOutputStream("archive.txt", true);
            fos.write(student.getDetails().getBytes());
            fos.close();
            System.out.println("File Write Successful");

            System.out.println("Reading File:");
            FileInputStream fis = new FileInputStream("archive.txt");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            fis.close();

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

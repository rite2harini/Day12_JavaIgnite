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

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    void displayResult() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks + " | Grade: " + calculateGrade());
    }

    void displayResult(String semester) {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks + " | Grade: " + calculateGrade() + " | Semester: " + semester);
    }

    public String toString() {
        return "Student | " + id + " | " + name + " | " + marks + " | " + calculateGrade();
    }
}

class GraduateStudent extends Student {
    String researchTopic;

    GraduateStudent(int id, String name, double marks, String researchTopic) {
        super(id, name, marks);
        this.researchTopic = researchTopic;
    }

    @Override
    String calculateGrade() {
        if (marks >= 95) return "A";
        else if (marks >= 85) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }

    void displayResult() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks + " | Grade: " + calculateGrade() + " | Research: " + researchTopic);
    }

    void displayResult(String semester) {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks + " | Grade: " + calculateGrade() + " | Research: " + researchTopic + " | Semester: " + semester);
    }

    public String toString() {
        return "GraduateStudent | " + id + " | " + name + " | " + marks + " | " + calculateGrade() + " | " + researchTopic;
    }
}

public class student_result_archive {
    public static void main(String[] args) throws IOException {

        Student s1 = new Student(101, "Arun", 82);
        Student s2 = new Student(102, "Priya", 55);
        GraduateStudent gs1 = new GraduateStudent(201, "Rahul", 88, "Machine Learning");
        GraduateStudent gs2 = new GraduateStudent(202, "Meena", 70, "Data Science");

        s1.displayResult();
        s2.displayResult();
        gs1.displayResult();
        gs2.displayResult();

        System.out.println();

        s1.displayResult("Semester 3");
        gs1.displayResult("Semester 5");

        String data = s1.toString() + "\n" + s2.toString() + "\n" + gs1.toString() + "\n" + gs2.toString() + "\n";

        FileOutputStream fos = new FileOutputStream("results.txt");
        fos.write(data.getBytes());
        fos.close();
        System.out.println("\nResults saved to results.txt");

        System.out.println("Reading from results.txt:");
        FileInputStream fis = new FileInputStream("results.txt");
        int ch;
        while ((ch = fis.read()) != -1) {
            System.out.print((char) ch);
        }
        fis.close();
    }
}
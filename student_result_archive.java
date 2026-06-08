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
package day12_progs;

import java.io.*;

class Student {
    String name;
    double cgpa;

    Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    void calculateGrade() {
        System.out.println("Grade calculation in Student");
    }

    void displayResult() {
        System.out.println("Name : " + name);
        System.out.println("CGPA : " + cgpa);
    }

    void displayResult(String semester) {
        System.out.println("Semester : " + semester);
        System.out.println("Name : " + name);
        System.out.println("CGPA : " + cgpa);
    }
}

class GraduateStudent extends Student {

    GraduateStudent(String name, double cgpa) {
        super(name, cgpa);
    }

    @Override
    void calculateGrade() {
        if (cgpa >= 9)
            System.out.println("Grade : O");
        else if (cgpa >= 8)
            System.out.println("Grade : A");
        else if (cgpa >= 7)
            System.out.println("Grade : B");
        else if (cgpa >= 6)
            System.out.println("Grade : C");
        else
            System.out.println("Grade : D");
    }
}

public class student_result_archive {

    public static void main(String[] args) {

        GraduateStudent s1 = new GraduateStudent("Prateek", 9.5);

        s1.displayResult();
        s1.displayResult("2nd Semester");
        s1.calculateGrade();

        try {
            // Write data to file
            FileOutputStream fout = new FileOutputStream("result.txt");

            String data = "Name : " + s1.name +"\nCGPA : " + s1.cgpa;

            fout.write(data.getBytes());
            fout.close();

            System.out.println("\nData Saved Successfully");

            // Read data from file
            FileInputStream fin = new FileInputStream("result.txt");

            int ch;
            System.out.println("\nReading File Data:");

            while ((ch = fin.read()) != -1) {
                System.out.print((char) ch);
            }

            fin.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

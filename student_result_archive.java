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

    void calculateGrade() {

        if(marks >= 80) {

            System.out.println("Grade : A");
        }
        else if(marks >= 60) {

            System.out.println("Grade : B");
        }
        else {

            System.out.println("Grade : C");
        }
    }

    void displayResult() {

        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Marks      : " + marks);
    }

    void displayResult(String semester) {

        System.out.println("Semester   : " + semester);

        displayResult();
    }
}

class GraduateStudent extends Student {

    GraduateStudent(int id, String name, double marks) {

        super(id, name, marks);
    }

    @Override
    void calculateGrade() {

        if(marks >= 85) {

            System.out.println("Grade : Distinction");
        }
        else if(marks >= 70) {

            System.out.println("Grade : First Class");
        }
        else {

            System.out.println("Grade : Pass");
        }
    }
}

public class StudentResultArchive {

    public static void main(String[] args) {

        GraduateStudent s1 =
                new GraduateStudent(101, "Aman", 88);

        System.out.println("===== STUDENT RESULT =====");

        s1.displayResult();

        s1.calculateGrade();

        System.out.println();

        s1.displayResult("Semester 2");

        try {

            FileOutputStream fos =
                    new FileOutputStream("studentResult.txt");

            String data =
                    "Student ID : " + s1.id + "\n" +
                    "Name : " + s1.name + "\n" +
                    "Marks : " + s1.marks + "\n";

            fos.write(data.getBytes());

            fos.close();

            System.out.println(
                    "\nStudent result saved in studentResult.txt");
        }

        catch(IOException e) {

            System.out.println("Error writing file.");
        }

        try {

            FileInputStream fis =
                    new FileInputStream("studentResult.txt");

            int i;

            System.out.println("\n===== FILE CONTENT =====");

            while((i = fis.read()) != -1) {

                System.out.print((char)i);
            }

            fis.close();
        }

        catch(IOException e) {

            System.out.println("Error reading file.");
        }
    }
}

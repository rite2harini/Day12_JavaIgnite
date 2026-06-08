import java.io.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void calculateGrade() {
        System.out.println("Grade Calculation for Student");
    }

    // Overloading
    void displayResult() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    void displayResult(String semester) {
        System.out.println("Semester: " + semester);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

class GraduateStudent extends Student {

    GraduateStudent(String name, int marks) {
        super(name, marks);
    }

    @Override
    void calculateGrade() {
        if (marks >= 90)
            System.out.println("Grade: A");
        else if (marks >= 75)
            System.out.println("Grade: B");
        else if (marks >= 60)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: D");
    }
}

public class StudentResultArchive {
    public static void main(String[] args) {

        GraduateStudent s1 = new GraduateStudent("Rahul", 88);

        // Method Overriding
        s1.calculateGrade();

        // Method Overloading
        s1.displayResult();
        System.out.println();

        s1.displayResult("Semester 4");

        // FileOutputStream - Save Data
        try {
            FileOutputStream fos =
                    new FileOutputStream("studentresult.txt");

            String data = "Name: " + s1.name +
                          "\nMarks: " + s1.marks;

            fos.write(data.getBytes());
            fos.close();

            System.out.println("\nStudent result saved successfully.");
        }
        catch (IOException e) {
            System.out.println(e);
        }

        // FileInputStream - Read Data
        try {
            FileInputStream fis =
                    new FileInputStream("studentresult.txt");

            int i;

            System.out.println("\nContents of File:");

            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }

            fis.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

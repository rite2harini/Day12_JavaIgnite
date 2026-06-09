import java.io.*;
 
class Student {
 int rollNo;
 String name;
 int marks;

 Student(int rollNo, String name, int marks) {
     this.rollNo = rollNo;
     this.name = name;
     this.marks = marks;
 }

 void calculateGrade() {
     if (marks >= 80)
         System.out.println("Grade: A");
     else if (marks >= 60)
         System.out.println("Grade: B");
     else
         System.out.println("Grade: C");
 }

 void displayResult() {
     System.out.println("Roll No: " + rollNo);
     System.out.println("Name: " + name);
     System.out.println("Marks: " + marks);
 }

 void displayResult(String semester) {
     System.out.println("Semester: " + semester);
     System.out.println("Roll No: " + rollNo);
     System.out.println("Name: " + name);
     System.out.println("Marks: " + marks);
 }
}

class GraduateStudent extends Student {

 GraduateStudent(int rollNo, String name, int marks) {
     super(rollNo, name, marks);
 }

 @Override
 void calculateGrade() {
     if (marks >= 85)
         System.out.println("Grade: A+");
     else if (marks >= 70)
         System.out.println("Grade: A");
     else if (marks >= 60)
         System.out.println("Grade: B");
     else
         System.out.println("Grade: C");
 }
}



public class StudentResultArchive {
	public static void main(String[] args) {

        GraduateStudent s1 =
                new GraduateStudent(101, "ARPITA", 88);

        s1.displayResult();
        s1.displayResult("Semester 4");

        s1.calculateGrade();

        try {
            FileOutputStream fos =
                    new FileOutputStream("results.txt");

            String data =
                    "Roll No: " + s1.rollNo +
                    "\nName: " + s1.name +
                    "\nMarks: " + s1.marks;

            fos.write(data.getBytes());
            fos.close();

            System.out.println("\nResult saved to file.");

            // Read File
            FileInputStream fis =
                    new FileInputStream("results.txt");

            int ch;

            System.out.println("\nFile Contents:");
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }

            fis.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}

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
package java_internship_day12;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

class student {
	int roll,marks;
	String name;
	
	student(int roll, String name,int marks) {
		this.roll = roll;
		this.name=name;
		this.marks = marks;
	}
	void calculate_grade(int marks) {
		System.out.println("Grade Calculation !!");
	}
}

class graduated_student extends student {
	
	graduated_student(int roll,String name,int marks) {
		super(roll,name,marks);
	}
	void calculate_grade(int marks) {
		if(marks > 90) 
			System.out.println("a grade");
		else if(marks < 90 && marks >80) 
			System.out.println("b grade");
		else if(marks < 70 && marks > 60) 
			System.out.println("c grade");
		else if(marks < 60) 
			System.out.println("fail");
	}
	
}
public class Student_result_archive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int marks,roll;
		String name;
		System.out.println("Enter the name of student and roll no of student");
		name=sc.nextLine();
		//sc.nextLine();
		roll=sc.nextInt();
		System.out.println("Enter the marks of the student :");
		marks = sc.nextInt();
		graduated_student s1 = new graduated_student(roll,name,marks);
		s1.calculate_grade(marks);
		
		try {
			FileWriter fw = new FileWriter("studentmark.txt",true);
			fw.write("NAME :" + name + " Mark" + marks + "\n" );
			fw.close();
			System.out.println("Sucessfully Updated\n");
			
			System.out.println("*FILE CONTENTS*");
			FileReader fr = new FileReader("studentmark.txt");
			int data;
			 while((data = fr.read ()) != -1) {
			    	System.out.print((char)data);
			    }
			 fr.close();
		}
		catch(IOException e) {
			System.out.println("Error :"+ e.getMessage());
		}
		sc.close();
	}

}

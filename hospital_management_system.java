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
package java_internship_day12;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


class Employee {
	int id;
	String name;
	
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	void role() {
		System.out.println("Employee");
	}
}
class Doctor extends Employee {
	String specialization;
	Doctor(int id,String name,String specialization){
		super(id,name);
		this.specialization=specialization;
	}
	@Override
	void role() {
		System.out.println("Doctor");
	}
}
class Nurse extends Employee {
	String shift;
	Nurse(int id,String name,String Shift){
		super(id,name);
		this.shift=Shift;
	}
	@Override
	void role() {
		System.out.println("Nurse");
	}
}
public class Hospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int id,ch;
		String name,shift = null,specialization = null;
		System.out.println("Enter 1 for nurse and 2 for Doctor :");
		ch=sc.nextInt();
		System.out.println("Enter the id and name :");
		id=sc.nextInt();
		sc.nextLine();
		name=sc.nextLine();
		if(ch==1) {
			System.out.println("Enter the shift :");
			shift = sc.nextLine();
			sc.nextLine();
		}
		else {
			System.out.println("Enter the specialization :");
			specialization = sc.nextLine();
			sc.nextLine();
		}
		if(ch == 1) {
			Nurse n = new Nurse(id,name,shift);
			n.role();
		}
		else {
			Doctor d = new Doctor(id,name,specialization);
			d.role();
		}
		try {
			FileWriter fw = new FileWriter("employees.txt");

			fw.write("\nName: " + name + " | ID: " + id);

			if (ch == 1) {
			    fw.write(" Role: Nurse , Shift: " + shift);
			} 
			else {
			    fw.write(" Role: Doctor , Specialization: " + specialization);
			}

			fw.close();
			System.out.println("Sucessfully Stored \n");
			
			System.out.println("Contents of the file are :");
		    FileReader fr = new FileReader("employees.txt");
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

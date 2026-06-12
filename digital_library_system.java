/*
Digital Library System

Create:

Book
│
| -  EBook
│
| - PrintedBook

Requirements:

Override:

showBookType()

for each child class.

Overloading:

Create:

searchBook(int id)

searchBook(String title)

Wrapper Class Requirement:

Convert:

Book Price (String)

into numeric value using Wrapper Classes.

File Handling:

Store all book details in:

library.txt
1. Create Parent Class: Book
Add variables:
bookId
title
price (Store as String)
Create a constructor to initialize values.
Create a method:
showBookType()

Hint:

Use instance variables.
Constructor should receive values from the user/program.
Create Child Class: EBook
Extend Book.
Override showBookType().

Hint:

Use extends keyword.
Use @Override annotation.
3. Create Child Class: PrintedBook
Extend Book.
Override showBookType().

Hint:

Same method name as parent class.
Display a different message.
4. Implement Method Overloading

Create:

searchBook(int id)
searchBook(String title)

Hint:

Method name should be the same.
Parameters should be different.
5. Demonstrate Wrapper Class
Store price as a String.
Convert it into a numeric value.
Display the converted value.

Hint:

Use Wrapper Class methods such as:
Integer.parseInt()
Double.parseDouble()
6. Write Book Details to File
Create a file named library.txt.
Store book details in the file.

Hint:

Use:
FileWriter
BufferedWriter
7. Read Book Details from File
Read all records from library.txt.
Display them on the console.

Hint:

Use:
FileReader
BufferedReader
Read line by line.
8. Main Method
Create an EBook object.
Create a PrintedBook object.
Call overridden methods.
Call overloaded methods.
Convert String price to numeric value.
Write details to file.
Read details from file.

Hint:

Test each feature one by one before moving to the next.
and read them back.
*/
package java_internship_day12;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
class book{
	int id;
	String name;
	String price;
	
	book(int id,String name,String price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	void showBookType()
	{
	    System.out.println("Book");
	}
}

class Ebook extends book{
		Ebook(int id,String name,String price){
			super(id,name,price);
		}
		@Override
		void showBookType()
		{
		    System.out.println("This is eBook");
		}
}
class Printedbook extends book{
	Printedbook(int id,String name,String price){
		super(id,name,price);
	}
	@Override
	void showBookType()
	{
	    System.out.println("This is Printed-Book");
	}
}

class Searchbook{
	void searchbook(int id) {
		System.out.println("searching based on id");
	}
	void searchbook(String name) {
		System.out.println("searching based on name");
	}
}
public class Digital_library_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int id,choice;
		String name,price;
		System.out.println("Enter 1 for EBook and 2 for Printed Book");
		choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name");
		name = sc.nextLine();
		System.out.println("Enter Book ID");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Price");
		price = sc.nextLine();
		
		int NumPrice = Integer.parseInt(price);
		
		if(choice ==1) {
			Ebook e = new Ebook(id,name,price);
			e.showBookType();
		}
		else if(choice ==2) {
			Printedbook p = new Printedbook(id,name,price);
			p.showBookType();
		}
		else {
			System.out.println("Invalid choice");
		}
		try {
			FileWriter fw = new FileWriter("library.txt",true);
			fw.write(id + "," + name + "," + price + "\n");
		    fw.close();
		    System.out.println("Done sucessfully");
		    System.out.println("Contents of the file are :");
		    FileReader fr = new FileReader("library.txt");
		    int data;
		    while((data = fr.read ()) != -1) {
		    	System.out.print((char)data);
		    }
		    fr.close();
		}
		catch(IOException e) {
			System.out.println("Error get message :"+ e.getMessage());
		}
		sc.close();
	}

}

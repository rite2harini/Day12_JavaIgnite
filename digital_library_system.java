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

and read them back.
*/

import java.io.*;
import java.util.Scanner;

class Book {
    int id;
    String title;
    double price;

    Book(int id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = Double.parseDouble(price);
    }

    void showBookType() {
        System.out.println("General Book");
    }
    void searchBook(int id) {
        if (this.id == id) {
            System.out.println("Book Found:");
            display();
        } else {
            System.out.println("Book ID not found");
        }
    }

    void searchBook(String title) {
        if (this.title.equalsIgnoreCase(title)) {
            System.out.println("Book Found:");
            display();
        } else {
            System.out.println("Book Title not found");
        }
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }
}
class EBook extends Book {

    EBook(int id, String title, String price) {
        super(id, title, price);
    }

    @Override
    void showBookType() {
        System.out.println("Book Type: E-Book");
    }
}
class PrintedBook extends Book {

    PrintedBook(int id, String title, String price) {
        super(id, title, price);
    }

    @Override
    void showBookType() {
        System.out.println("Book Type: Printed Book");
    }
}

public class DIGITAL_LIBRARY_SYSTEM {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        EBook b1 = new EBook(101, "JAVA PROGRAMMING(NEW EDITION)", "650.00");
        PrintedBook b2 = new PrintedBook(102, "DATA STRUCTURES(NEW EDITION WITH UPDATED VERSION)", "549.00");

        b1.showBookType();
        b2.showBookType();

        System.out.println();
        b1.searchBook(101);
        System.out.println();
        b2.searchBook(102);
        System.out.println();

        try {
            FileWriter fw = new FileWriter("library.txt");

            fw.write("ID: " + b1.id + "\n");
            fw.write("Title: " + b1.title + "\n");
            fw.write("Price: " + b1.price + "\n\n");

            fw.write("ID: " + b2.id + "\n");
            fw.write("Title: " + b2.title + "\n");
            fw.write("Price: " + b2.price + "\n");

            fw.close();

            System.out.println("Book details stored successfully.\n");

        } catch (IOException e) {
            System.out.println("File Writing Error");
        }

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("library.txt"));

            String line;

            System.out.println("Contents of library.txt:\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Reading Error");
        }

        sc.close();
    }
}

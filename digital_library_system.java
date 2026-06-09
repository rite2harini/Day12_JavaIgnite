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
import java.util.*;

class Book {

    int id;
    String title;
    double price;

    // Constructor
    Book(int id, String title, String price) {

        this.id = id;
        this.title = title;

        // Wrapper Class Conversion
        this.price = Double.parseDouble(price);
    }

    // Method to display details
    void displayBook() {

        System.out.println("Book ID : " + id);
        System.out.println("Title   : " + title);
        System.out.println("Price   : " + price);
    }

    // Overridden in child classes
    void showBookType() {

        System.out.println("General Book");
    }

    // Overloaded Method - Search by ID
    void searchBook(int id) {

        if(this.id == id) {

            System.out.println("Book Found by ID:");
            displayBook();
        }
        else {

            System.out.println("Book ID not found.");
        }
    }

    // Overloaded Method - Search by Title
    void searchBook(String title) {

        if(this.title.equalsIgnoreCase(title)) {

            System.out.println("Book Found by Title:");
            displayBook();
        }
        else {

            System.out.println("Book Title not found.");
        }
    }
}

// Child Class 1
class EBook extends Book {

    EBook(int id, String title, String price) {

        super(id, title, price);
    }

    // Method Overriding
    @Override
    void showBookType() {

        System.out.println("This is an E-Book.");
    }
}

// Child Class 2
class PrintedBook extends Book {

    PrintedBook(int id, String title, String price) {

        super(id, title, price);
    }

    // Method Overriding
    @Override
    void showBookType() {

        System.out.println("This is a Printed Book.");
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        // Creating objects
        EBook b1 = new EBook(101, "Java Basics", "499.99");

        PrintedBook b2 = new PrintedBook(102, "Data Structures", "799.50");

        // Display Details
        System.out.println("===== BOOK 1 =====");
        b1.displayBook();
        b1.showBookType();

        System.out.println();

        System.out.println("===== BOOK 2 =====");
        b2.displayBook();
        b2.showBookType();

        System.out.println();

        // Method Overloading
        b1.searchBook(101);

        System.out.println();

        b2.searchBook("Data Structures");

        System.out.println();

        // File Handling
        try {

            FileWriter fw = new FileWriter("library.txt");

            fw.write("Book ID: " + b1.id + "\n");
            fw.write("Title: " + b1.title + "\n");
            fw.write("Price: " + b1.price + "\n\n");

            fw.write("Book ID: " + b2.id + "\n");
            fw.write("Title: " + b2.title + "\n");
            fw.write("Price: " + b2.price + "\n");

            fw.close();

            System.out.println("Book details stored in library.txt");

        }
        catch(IOException e) {

            System.out.println("Error writing file.");
        }

        // Reading from file
        try {

            FileReader fr = new FileReader("library.txt");

            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n===== READING FILE =====");

            while((line = br.readLine()) != null) {

                System.out.println(line);
            }

            br.close();
        }
        catch(IOException e) {

            System.out.println("Error reading file.");
        }
    }
}

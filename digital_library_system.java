import java.io.*;

// Parent Class
class Book {
    int bookId;
    String title;
    String price; // Stored as String

    public Book(int bookId, String title, String price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }

    public void showBookType() {
        System.out.println("General Book");
    }

    // Overloaded Method - Search by ID
    public void searchBook(int id) {
        if (this.bookId == id) {
            System.out.println("Book Found: " + title);
        } else {
            System.out.println("Book ID Not Found");
        }
    }

    // Overloaded Method - Search by Title
    public void searchBook(String title) {
        if (this.title.equalsIgnoreCase(title)) {
            System.out.println("Book Found: " + this.title);
        } else {
            System.out.println("Book Title Not Found");
        }
    }
}

// Child Class - EBook
class EBook extends Book {

    public EBook(int bookId, String title, String price) {
        super(bookId, title, price);
    }

    @Override
    public void showBookType() {
        System.out.println("This is an EBook.");
    }
}

// Child Class - PrintedBook
class PrintedBook extends Book {

    public PrintedBook(int bookId, String title, String price) {
        super(bookId, title, price);
    }

    @Override
    public void showBookType() {
        System.out.println("This is a Printed Book.");
    }
}

// Main Class
public class DigitalLibrarySystem {

    public static void main(String[] args) {

        try {
            // Create Objects
            EBook ebook = new EBook(101, "Java Programming", "499.99");
            PrintedBook printedBook = new PrintedBook(102, "Data Structures", "699.50");

            // Method Overriding
            ebook.showBookType();
            printedBook.showBookType();

            System.out.println();

            // Method Overloading
            ebook.searchBook(101);
            printedBook.searchBook("Data Structures");

            System.out.println();

            // Wrapper Class Conversion
            double ebookPrice = Double.parseDouble(ebook.price);
            double printedPrice = Double.parseDouble(printedBook.price);

            System.out.println("Converted EBook Price: " + ebookPrice);
            System.out.println("Converted Printed Book Price: " + printedPrice);

            System.out.println();

            // Write Book Details to File
            BufferedWriter bw = new BufferedWriter(new FileWriter("library.txt"));

            bw.write("Book ID: " + ebook.bookId +
                    ", Title: " + ebook.title +
                    ", Price: " + ebook.price);
            bw.newLine();

            bw.write("Book ID: " + printedBook.bookId +
                    ", Title: " + printedBook.title +
                    ", Price: " + printedBook.price);

            bw.close();

            System.out.println("Book details written to library.txt");

            System.out.println();

            // Read Book Details from File
            BufferedReader br = new BufferedReader(new FileReader("library.txt"));

            String line;

            System.out.println("Reading Book Details From File:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}/*
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

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

import java.io.*;

class Book {
    int id;
    String title;
    double price;

    Book(int id, String title, String priceStr) {
        this.id = id;
        this.title = title;
        this.price = Double.parseDouble(priceStr); 
    }

    void showBookType() {
        System.out.println("Generic Book");
    }
    void searchBook(int id) {
        System.out.println("Searching by ID: " + id);
    }

    void searchBook(String title) {
        System.out.println("Searching by Title: " + title);
    }

    public String toString() {
        return id + " | " + title + " | Rs." + price;
    }
}

class EBook extends Book {
    EBook(int id, String title, String priceStr) {
        super(id, title, priceStr);
    }
    @Override
    void showBookType() {
        System.out.println(title + " is an EBook");
    }
}
class PrintedBook extends Book {
    PrintedBook(int id, String title, String priceStr) {
        super(id, title, priceStr);
    }
    @Override
    void showBookType() {
        System.out.println(title + " is a Printed Book");
    }
}

public class digital_library_system {
    public static void main(String[] args) throws IOException {

        EBook eb = new EBook(101, "Java Programming", "499.99");
        PrintedBook pb = new PrintedBook(102, "Data Structures", "350.00");
        eb.showBookType();
        pb.showBookType();
        eb.searchBook(101);
        eb.searchBook("Java Programming");
        FileWriter fw = new FileWriter("library.txt");
        fw.write(eb.toString() + "\n");
        fw.write(pb.toString() + "\n");
        fw.close();
        System.out.println("Book details saved to library.txt");
        System.out.println("Reading from library.txt:");
        BufferedReader br = new BufferedReader(new FileReader("library.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}

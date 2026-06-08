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
package day12_progs;

import java.io.*;

class Book {//parent class
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    void showBookType() {
        System.out.println("This is a Book");//may be normal or may be ebook
    }

    // Overloading to find that book
    void searchBook(int id) {//if id entered
        if (this.id == id)
            System.out.println("Book Found by ID");
        else
            System.out.println("Book Not Found");
    }

    void searchBook(String title) {// by name
        if (this.title.equalsIgnoreCase(title))
            System.out.println("Book Found by Title");
        else
            System.out.println("Book Not Found");
    }
}

class EBook extends Book { //child as Ebook 

    EBook(int id, String title) {
        super(id, title);
    }

    @Override
    void showBookType() {
        System.out.println("This is an EBook");// as its type
    }
}

class PrintedBook extends Book {//child as normal book

    PrintedBook(int id, String title) {
        super(id, title);
    }

    @Override
    void showBookType() {
        System.out.println("This is a Printed Book");
    }
}

public class digital_library_system {

    public static void main(String[] args) {

        EBook eb = new EBook(101, "Java Basics");//send through constructors
        PrintedBook pb = new PrintedBook(102, "Data Structures");

        System.out.println("___ Book Types ___");
        eb.showBookType();
        pb.showBookType();

        System.out.println("\n___ Search Demo ___");
        eb.searchBook(101); // once by id and once by name
        eb.searchBook("Java Basics");

        System.out.println("\n___ Wrapper Class Demo ___");
        String price = "499";
        double p = Double.parseDouble(price);
        System.out.println("Price = " + p);

        System.out.println("\n___ File Handling ___");

        try {//risky ones while giving name
            BufferedWriter bw = new BufferedWriter(new FileWriter("library.txt"));

            bw.write("101 Java Basics");
            bw.newLine();

            bw.write("102 Data Structures");
            bw.newLine();

            bw.close();

            System.out.println("Data Written Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {//while reading names
            BufferedReader br = new BufferedReader( new FileReader("library.txt"));

            String line;

            System.out.println("\nReading File:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

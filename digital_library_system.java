import java.io.*;

class Book {
    int id;
    String title;
    String price;

    Book(int id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    void showBookType() {
        System.out.println("General Book");
    }
}

class EBook extends Book {

    EBook(int id, String title, String price) {
        super(id, title, price);
    }

    @Override
    void showBookType() {
        System.out.println("This is an EBook");
    }
}

class PrintedBook extends Book {

    PrintedBook(int id, String title, String price) {
        super(id, title, price);
    }

    @Override
    void showBookType() {
        System.out.println("This is a Printed Book");
    }
}

public class DigitalLibrarySystem {

    // Overloading
    static void searchBook(int id) {
        System.out.println("Searching book with ID: " + id);
    }

    static void searchBook(String title) {
        System.out.println("Searching book with Title: " + title);
    }

    public static void main(String[] args) {

        EBook e1 = new EBook(101, "Java Programming", "499.50");
        PrintedBook p1 = new PrintedBook(102, "Data Structures", "599.75");

        // Overriding
        e1.showBookType();
        p1.showBookType();

        // Overloading
        searchBook(101);
        searchBook("Java Programming");

        // Wrapper Class
        double ebookPrice = Double.parseDouble(e1.price);
        double printedPrice = Double.parseDouble(p1.price);

        System.out.println("EBook Price = " + ebookPrice);
        System.out.println("Printed Book Price = " + printedPrice);

        // File Handling - Write
        try {
            FileWriter fw = new FileWriter("library.txt");

            fw.write(e1.id + "," + e1.title + "," + ebookPrice + "\n");
            fw.write(p1.id + "," + p1.title + "," + printedPrice + "\n");

            fw.close();

            System.out.println("Book details stored successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }

        // File Handling - Read
        try {
            FileReader fr = new FileReader("library.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\nStored Book Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
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

and read them back.
*/

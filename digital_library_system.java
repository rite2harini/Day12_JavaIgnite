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

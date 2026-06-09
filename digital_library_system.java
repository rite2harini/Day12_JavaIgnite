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

abstract class Book implements Serializable {
    int id;
    String title, author, priceStr;
    double price;
    
    Book(int id, String title, String author, String priceStr) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.priceStr = priceStr;
        this.price = Double.parseDouble(priceStr); // Wrapper conversion
    }
    
    abstract void showBookType();
    
    void display() {
        System.out.printf("ID: %d | Title: %s | Author: %s | Price: %.2f | ", 
                         id, title, author, price);
        showBookType();
    }
}

class EBook extends Book implements Serializable {
    double fileSizeMB;
    
    EBook(int id, String title, String author, String priceStr, double fileSizeMB) {
        super(id, title, author, priceStr);
        this.fileSizeMB = fileSizeMB;
    }
    
    @Override
    void showBookType() {
        System.out.println("Type: E-Book | Size: " + fileSizeMB + "MB");
    }
}

class PrintedBook extends Book implements Serializable {
    int pages;
    
    PrintedBook(int id, String title, String author, String priceStr, int pages) {
        super(id, title, author, priceStr);
        this.pages = pages;
    }
    
    @Override
    void showBookType() {
        System.out.println("Type: Printed | Pages: " + pages);
    }
}

public class DigitalLibrary {
    List<Book> books = new ArrayList<>();
    
    // Overloaded search methods
    Book searchBook(int id) {
        return books.stream().filter(b -> b.id == id).findFirst().orElse(null);
    }
    
    Book searchBook(String title) {
        return books.stream().filter(b -> b.title.equalsIgnoreCase(title)).findFirst().orElse(null);
    }
    
    void addBook(Book b) { books.add(b); }
    
    void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.txt"))) {
            oos.writeObject(books);
            System.out.println("Books saved to library.txt");
        } catch (IOException e) { System.out.println("Save error: " + e.getMessage()); }
    }
    
    @SuppressWarnings("unchecked")
    void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.txt"))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Books loaded from file:");
            books.forEach(Book::display);
        } catch (IOException | ClassNotFoundException e) { 
            System.out.println("Load error: " + e.getMessage()); 
        }
    }
    
    // Wrapper demonstration: Price validation
    static boolean isValidPrice(String priceStr) {
        try { Double.parseDouble(priceStr); return true; } 
        catch (NumberFormatException e) { return false; }
    }
    
    public static void main(String[] args) {
        DigitalLibrary lib = new DigitalLibrary();
        
        // Add books with String prices (Wrapper conversion in constructor)
        lib.addBook(new EBook(101, "Java Basics", "John Doe", "29.99", 5.2));
        lib.addBook(new PrintedBook(102, "Python Guide", "Jane Smith", "45.50", 350));
        lib.addBook(new EBook(103, "C++ Mastery", "Bob Wilson", "35.00", 8.1));
        
        // Display all books
        System.out.println("=== Library Books ===");
        lib.books.forEach(Book::display);
        
        // Search overloaded methods
        System.out.println("\n=== Search by ID (102) ===");
        Book b1 = lib.searchBook(102);
        if (b1 != null) b1.display();
        
        System.out.println("\n=== Search by Title ===");
        Book b2 = lib.searchBook("Java Basics");
        if (b2 != null) b2.display();
        
        // Wrapper class validation
        System.out.println("\n=== Price Validation ===");
        System.out.println("'29.99' valid? " + isValidPrice("29.99"));
        System.out.println("'abc' valid? " + isValidPrice("abc"));
        
        // File operations
        lib.saveToFile();
        System.out.println("\n=== Reading from File ===");
        DigitalLibrary lib2 = new DigitalLibrary();
        lib2.loadFromFile();
    }
}

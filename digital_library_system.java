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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Book {
    int id;
    String title;
    double price;

    public Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void showBookType() {
        System.out.println("Generic Book");
    }

    public String getDetails() {
        return id + "," + title + "," + price;
    }
}

class EBook extends Book {
    public EBook(int id, String title, double price) {
        super(id, title, price);
    }

    @Override
    public void showBookType() {
        System.out.println("Book Type: E-Book");
    }
}

class PrintedBook extends Book {
    public PrintedBook(int id, String title, double price) {
        super(id, title, price);
    }

    @Override
    public void showBookType() {
        System.out.println("Book Type: Printed Book");
    }
}

public class DigitalLibrarySystem {
    public static void searchBook(int id) {
        System.out.println("Searching by ID: Found Book " + id);
    }

    public static void searchBook(String title) {
        System.out.println("Searching by Title: Found Book '" + title + "'");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int id = Integer.parseInt(scanner.nextLine());
            String title = scanner.nextLine();
            String priceInput = scanner.nextLine();
            String bookType = scanner.nextLine();

            double price = Double.parseDouble(priceInput);

            Book book;
            if (bookType.equalsIgnoreCase("EBook")) {
                book = new EBook(id, title, price);
            } else {
                book = new PrintedBook(id, title, price);
            }

            book.showBookType();
            searchBook(id);
            searchBook(title);

            FileWriter writer = new FileWriter("library.txt");
            writer.write(book.getDetails() + "\n");
            writer.close();
            System.out.println("File Write Successful");

            BufferedReader reader = new BufferedReader(new FileReader("library.txt"));
            String line;
            System.out.println("Reading File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("File operation error");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

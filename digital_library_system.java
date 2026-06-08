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
     System.out.println("General Book");
 }


 void searchBook(int id) {
     if (this.id == id) {
         System.out.println("Book Found: " + title);
     } else {
         System.out.println("Book Not Found");
     }
 }

 void searchBook(String title) {
     if (this.title.equalsIgnoreCase(title)) {
         System.out.println("Book Found: " + this.title);
     } else {
         System.out.println("Book Not Found");
     }
 }
}


class EBook extends Book {

 EBook(int id, String title, String priceStr) {
     super(id, title, priceStr);
 }

 @Override
 void showBookType() {
     System.out.println("Book Type: E-Book");
 }
}


class PrintedBook extends Book {

 PrintedBook(int id, String title, String priceStr) {
     super(id, title, priceStr);
 }

 @Override
 void showBookType() {
     System.out.println("Book Type: Printed Book");
 }
}
public class DigitalLibrarySystem {
	public static void main(String[] args) {

        EBook b1 = new EBook(101, "Java Programming", "499.50");
        PrintedBook b2 = new PrintedBook(102, "Data Structures", "650.75");

       
        b1.showBookType();
        b2.showBookType();

      
        b1.searchBook(101);
        b2.searchBook("Data Structures");

      
        try {
            FileWriter fw = new FileWriter("library.txt");

            fw.write("ID: " + b1.id + ", Title: " + b1.title +
                    ", Price: " + b1.price + "\n");

            fw.write("ID: " + b2.id + ", Title: " + b2.title +
                    ", Price: " + b2.price + "\n");

            fw.close();

            System.out.println("\nBook details stored in library.txt");

         
            BufferedReader br = new BufferedReader(
                    new FileReader("library.txt"));

            String line;

            System.out.println("\nReading File Contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}

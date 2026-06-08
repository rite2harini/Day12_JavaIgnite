public class DigitalLibrarySystem {
	public static void main(String[] args) {

	     EBook b1 = new EBook(101, "Java Programming", "499.50");
	     PrintedBook b2 = new PrintedBook(102, "Data Structures", "650.75");

	     // Method Overriding
	     b1.showBookType();
	     b2.showBookType();

	     // Method Overloading
	     b1.searchBook(101);
	     b2.searchBook("Data Structures");

	     // File Handling
	     try {
	         FileWriter fw = new FileWriter("library.txt");

	         fw.write("ID: " + b1.id + ", Title: " + b1.title +
	                 ", Price: " + b1.price + "\n");

	         fw.write("ID: " + b2.id + ", Title: " + b2.title +
	                 ", Price: " + b2.price + "\n");

	         fw.close();

	         System.out.println("\nBook details stored in library.txt");

	         // Reading from file
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


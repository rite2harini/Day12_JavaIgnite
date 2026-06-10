package JavaIgniteDay12;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
class book{
	int id;
	String name;
	String price;
	
	book(int id,String name,String price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	void showBookType()
	{
	    System.out.println("Book");
	}
}

class Ebook extends book{
		Ebook(int id,String name,String price){
			super(id,name,price);
		}
		@Override
		void showBookType()
		{
		    System.out.println("This is eBook");
		}
}
class Printedbook extends book{
	Printedbook(int id,String name,String price){
		super(id,name,price);
	}
	@Override
	void showBookType()
	{
	    System.out.println("This is Printed-Book");
	}
}

class Searchbook{
	void searchbook(int id) {
		System.out.println("searching based on id");
	}
	void searchbook(String name) {
		System.out.println("searching based on name");
	}
}
public class Digital_library_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int id,choice;
		String name,price;
		System.out.println("Enter 1 for EBook and 2 for Printed Book");
		choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name");
		name = sc.nextLine();
		System.out.println("Enter Book ID");
		id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Price");
		price = sc.nextLine();
		
		int NumPrice = Integer.parseInt(price);
		
		if(choice ==1) {
			Ebook e = new Ebook(id,name,price);
			e.showBookType();
		}
		else if(choice ==2) {
			Printedbook p = new Printedbook(id,name,price);
			p.showBookType();
		}
		else {
			System.out.println("Invalid choice");
		}
		try {
			FileWriter fw = new FileWriter("library.txt",true);
			fw.write(id + "," + name + "," + price + "\n");
		    fw.close();
		    System.out.println("Done sucessfully");
		    System.out.println("Contents of the file are :");
		    FileReader fr = new FileReader("library.txt");
		    int data;
		    while((data = fr.read ()) != -1) {
		    	System.out.print((char)data);
		    }
		    fr.close();
		}
		catch(IOException e) {
			System.out.println("Error get message :"+ e.getMessage());
		}
		sc.close();
	}
}

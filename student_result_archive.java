public class StudentResultArchive {
	public static void main(String[] args) {

	     GraduateStudent s1 =
	             new GraduateStudent(101, "sumi", 88);

	     // Overloading
	     s1.displayResult();
	     s1.displayResult("Semester 4");

	     // Overriding
	     s1.calculateGrade();

	     // File Handling
	     try {
	         FileOutputStream fos =
	                 new FileOutputStream("results.txt");

	         String data =
	                 "Roll No: " + s1.rollNo +
	                 "\nName: " + s1.name +
	                 "\nMarks: " + s1.marks;

	         fos.write(data.getBytes());
	         fos.close();

	         System.out.println("\nResult saved to file.");

	         // Read File
	         FileInputStream fis =
	                 new FileInputStream("results.txt");

	         int ch;

	         System.out.println("\nFile Contents:");
	         while ((ch = fis.read()) != -1) {
	             System.out.print((char) ch);
	         }

	         fis.close();

	     } catch (IOException e) {
	         System.out.println("File Error: " + e.getMessage());
	     }
	 }
	}



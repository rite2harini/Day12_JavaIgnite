public class HospitalEmployeeManagementSystem {
	public static void main(String[] args) {

	     Doctor d1 = new Doctor(101, "Rahul", "Cardiologist");
	     Nurse n1 = new Nurse(201, "Priya", "Night");

	     d1.displayRole();
	     n1.displayRole();

	     // File Handling
	     try {
	         FileWriter fw = new FileWriter("employees.txt");

	         fw.write("Doctor Details\n");
	         fw.write("ID: " + d1.employeeId +
	                  ", Name: " + d1.name +
	                  ", Specialization: " + d1.specialization + "\n");

	         fw.write("Nurse Details\n");
	         fw.write("ID: " + n1.employeeId +
	                  ", Name: " + n1.name +
	                  ", Shift: " + n1.shift + "\n");

	         fw.close();

	         System.out.println("\nEmployee details saved to employees.txt");

	         // Reading File
	         FileReader fr = new FileReader("employees.txt");
	         int ch;

	         System.out.println("\nContents of employees.txt:");
	         while ((ch = fr.read()) != -1) {
	             System.out.print((char) ch);
	         }

	         fr.close();

	     } catch (IOException e) {
	         System.out.println("File Error: " + e.getMessage());
	     }
	 }
	}





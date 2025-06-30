package assignment2;
import java.util.Scanner;

/*
 * Class: CMSC203
 * Instructor: Professor Grinberg
 * Description: This class asks for the patient's details and creates a Patient Object where that information goes.  The user
 * is then asked to put in information for three procedures, with each procedure creating a Procedure object and information
 * for that procedure being stored inside that object.  After the three procedures, the program outputs all of the information 
 * clearly for the user and has the total cost of all of the procedures.
 * Due: 06/30/2025
 * Platform/Compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.  I have not
 * coped the code from any student of any source.  I have not given my code to any student.
 * Stephen Langelier
 */
public class PatientDriverApp {
	public static void main(String[] args) {
		//Create Scanner Object
		Scanner keyboard = new Scanner(System.in);
		
		//Beginning of Program Output
		//Patient's First Name
		System.out.print("Enter Patient's First Name: ");
		String fName = keyboard.nextLine();
		//Patient's Middle Name
		System.out.print("Enter Patient's Middle Name: ");
		String mName = keyboard.nextLine();
		//Patient's Last name
		System.out.print("Enter Patient's Last Name: ");
		String lName = keyboard.nextLine();
		//Patient's Address
		System.out.print("Enter Patient's Address: ");
		String pAddress = keyboard.nextLine();
		//Patient's City
		System.out.print("Enter City: ");
		String city = keyboard.nextLine();
		//Patient's State
		System.out.print("Enter State: ");
		String state = keyboard.nextLine();
		//Patient's ZIP Code
		System.out.print("Enter ZIP Code: ");
		String zCode = keyboard.nextLine();
		//Patient's Phone Number
		System.out.print("Enter Phone Number: ");
		String pNumber = keyboard.nextLine();
		//Patient's Emergency Contact Name
		System.out.print("Enter Emergency Contact Name: ");
		String eMContactName = keyboard.nextLine();
		//Patient's Emergency Contact Phone
		System.out.print("Enter Emergency Contact Phone: ");
		String eMContactNumber = keyboard.nextLine();
		
		//Creating the Patient's Object
		Patient newPatient = new Patient(fName, mName, lName, pAddress, city, state, zCode, pNumber, eMContactName, eMContactNumber);
		//Test to Confirm Class Works
		//System.out.println(newPatient.toString());

		
		//Start of User Input Procedures
		//Procedure One
		System.out.println("Enter Procedure 1 Details:");
		//Name of Procedure
		System.out.print("Name: ");
		String procedureName = keyboard.nextLine();
		//Date of Procedure
		System.out.print("Date: ");
		String procedureDate = keyboard.nextLine();
		//Name of the Practitioner
		System.out.print("Practitioner: ");
		String practitioner = keyboard.nextLine();
		//Charges of the Procedure
		int check = 0;
		double c = 0.00;
		System.out.print("Charge: ");
		while (check == 0) {
			if(keyboard.hasNextDouble()) {
				c = keyboard.nextDouble();
				check = 1;
			} else {
				System.out.println("Please enter in a valid number for cost");
				keyboard.next();
				System.out.print("Charge: ");
			}
		}
		keyboard.nextLine();
		//Creating the First Instance of the Procedure Class
		Procedure procedureOne = new Procedure(procedureName, procedureDate, practitioner, c);
		//Test to Ensure Procedure Class Works Correctly
		//System.out.println(procedureOne.toString());
		
		//Procedure Two
		System.out.println("Enter Procedure 2 Details:");
		//Name of Procedure
		System.out.print("Name: ");
		procedureName = keyboard.nextLine();
		//Date of Procedure
		System.out.print("Date: ");
		procedureDate = keyboard.nextLine();
		//Name of the Practitioner
		System.out.print("Practitioner: ");
		practitioner = keyboard.nextLine();
		//Charges of the Procedure
		check = 0;
		System.out.print("Charge: ");
		while (check == 0) {
			if(keyboard.hasNextDouble()) {
				c = keyboard.nextDouble();
				check = 1;
			} else {
				System.out.println("Please enter in a valid number for cost");
				keyboard.next();
				System.out.print("Charge: ");
			}
		}
		keyboard.nextLine();
		//Creating the Second Instance of the Procedure Class
		Procedure procedureTwo = new Procedure(procedureName, procedureDate, practitioner, c);
		//Test to Ensure Procedure Class Works Correctly
		//System.out.println(procedureTwo.toString());

		//Procedure Three
		System.out.println("Enter Procedure 3 Details:");
		//Name of Procedure
		System.out.print("Name: ");
		procedureName = keyboard.nextLine();
		//Date of Procedure
		System.out.print("Date: ");
		procedureDate = keyboard.nextLine();
		//Name of the Practitioner
		System.out.print("Practitioner: ");
		practitioner = keyboard.nextLine();
		//Charges of the Procedure
		check = 0;
		System.out.print("Charge: ");
		while (check == 0) {
			if(keyboard.hasNextDouble()) {
				c = keyboard.nextDouble();
				check = 1;
			} else {
				System.out.println("Please enter in a valid number for cost");
				keyboard.next();
				System.out.print("Charge: ");
			}
		}
		keyboard.nextLine();
		//Creating the Third Instance of the Procedure Class
		Procedure procedureThree = new Procedure(procedureName, procedureDate, practitioner, c);
		//Test to Ensure Procedure Class Works Correctly
		//System.out.println(procedureThree.toString());
		
		//Final Output Statements
		System.out.println(displayPatient(newPatient));
		System.out.println(displayProcedure(procedureOne));
		System.out.println(displayProcedure(procedureTwo));
		System.out.println(displayProcedure(procedureThree));
		System.out.printf("Total Charges: $%.2f", calculateTotalCharges(procedureOne, procedureTwo, procedureThree));
		System.out.println();
		
		//Programmer Name, M#, and Due Date
		System.out.println("Programmer Name: Stephen Langelier \nM#: M21232725\nDue Date: 06/30/2025 ");
		
		//Closing the Scanner
		keyboard.close();
	}
	//Methods
	/**
	 * Method displayPatient()
	 * Takes in a Patient Argument and returns the toString() of that object
	 * @param newPatient Name of the Patient Object
	 * @return The toString() of that Patient Object
	 */
	public static String displayPatient(Patient newPatient) {
		return newPatient.toString();
	}
	
	/**
	 * Method displayProcedure()
	 * Takes in a Procedure Argument and returns the toString() of that object
	 * @param procedureInformation Name of the Procedure Object
	 * @return The toString() of the Procedure
	 */
	public static String displayProcedure(Procedure procedureInformation) {
		return procedureInformation.toString();
	}
	
	/**
	 * Method calculateTotalCharges()
	 * Takes in all of the procedures done and calculates the total cost of all of the 
	 * procedure.  Returns the value as a double.
	 * @param one The First Procedure 
	 * @param two The Second Procedure
	 * @param three The Third Procedure
	 * @return total The total amount of the first, second, and third procedures
	 */
	public static double calculateTotalCharges(Procedure one, Procedure two, Procedure three) {
		double total = one.getCharges() + two.getCharges() + three.getCharges();
		//Test to Ensure Total is Correct
		//System.out.println(total);
		return total;
	}
}

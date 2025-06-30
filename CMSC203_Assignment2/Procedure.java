package assignment2;
/*
 * Class: CMSC203
 * Instructor: Professor Grinberg
 * Description: This class stores the information of a procedure.  It stores the name of the procedure, the date of the procedure,
 * the name of the practitioner, and the charge for the procedure.  The class contains methods to get the information or change
 * the information.
 * Due: 06/30/2025
 * Platform/Compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.  I have not
 * coped the code from any student of any source.  I have not given my code to any student.
 * Stephen Langelier
 */

public class Procedure {
	//Variables
	private String nameProcedure; //Name of the Procedure
	private String dateProcedure; //Date of the Procedure
	private String practitioner; //Name of the Practitioner
	private double charges; //Total Charge for the Procedure
	
	//Constructors
	/**
	 * Constructor
	 * A no-arg constructor that sets all of the variables to null or 0.00
	 * 
	 */
	public Procedure() {
		nameProcedure = null;
		dateProcedure = null;
		practitioner = null;
		charges = 0.00;
	}
	
	/**
	 * Constructor
	 * Sets the values for nameProcedure and dateProcedure when the object is created
	 * @param name Name of the Procedure
	 * @param date Date of the Procedure
	 */
	public Procedure(String name, String date) {
		nameProcedure = name;
		dateProcedure = date;
	}
	
	/**
	 * Constructor
	 * Sets the values for all of the variables once the object is created
	 * @param name
	 * @param date
	 * @param pract
	 * @param c
	 */
	public Procedure(String name, String date, String pract, double c) {
		nameProcedure = name;
		dateProcedure = date;
		practitioner = pract;
		charges = c;
	}
	
	//Methods
	/**
	 * Method getName()
	 * Returns the name of the procedure
	 * @return nameProcedure The name of the Procedure
	 */
	public String getName() {
		return nameProcedure;
	}
	
	/**
	 * Method getDate()
	 * Returns the date of the procedure
	 * @return dateProcedure The date of the procedure
	 */
	public String getDate() {
		return dateProcedure;
	}
	
	/**
	 * Method getPractitioner()
	 * Returns the name of the practitioner
	 * @return practitioner The name of the practitioner
	 */
	public String getPractitioner() {
		return practitioner;
	}
	
	/**
	 * Method getCharges()
	 * Returns the amount the procedure costs
	 * @return charges The charge of the procedure
	 */
	public double getCharges() {
		return charges;
	}
	
	/**
	 * Method setName()
	 * Sets the Name of the Procedure to a new name
	 * @param name Name of the Procedure
	 */
	public void setName(String name) {
		nameProcedure = name;
	}
	
	/**
	 * Method setDate()
	 * Sets the Date of the Procedure to a new date
	 * @param date Date of the Procedure
	 */
	public void setDate(String date) {
		dateProcedure = date;
	}
	
	/**
	 * Method setPractitioner
	 * Sets the name of the practitioner to a new name
	 * @param pract Name of the Practitioner
	 */
	public void setPractitioner(String pract) {
		practitioner = pract;
	}
	
	/**
	 * Method setCharges
	 * Sets the new charge to the variable charges
	 * @param c Charges
	 */
	public void setCharges(double c) {
		charges = c;
	}
	
	public String toString(){
		return "Procedure: " + getName() + "\n" + "Date: " + getDate() + "\n" + "Practitioner: " + getPractitioner() + "\n" + "Charge: $" + getCharges();
	}
	
}

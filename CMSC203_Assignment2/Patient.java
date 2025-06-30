/*
 * Class: CMSC203
 * Instructor: Professor Grinberg
 * Description: This class creates the patient profile for a singular patient.  The information stored is the patient's
 * full name, their full address, their phone number, and an emergency contact.  The methods in this class can get the information
 * of the patient and also change them.  The class also contains methods that combine the full name of the patient, and to combine the address
 * together to get a full address.
 * Due: 06/30/2025
 * Platform/Compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.  I have not
 * coped the code from any student of any source.  I have not given my code to any student.
 * Stephen Langelier
 */

public class Patient {
	//Private Variables
	private String firstName; //First Name
	private String middleName; //Middle Name
	private String lastName; //Last Name
	private String patientAddress; //Address of Patient
	private String city; //City 
	private String state; //State
	private String zipCode; //Zip Code
	private String phoneNumber; //Patient Phone Number
	private String eMName; //Emergency Contact Name
	private String eMPhoneNumber; //Emergency Contact Phone Number
	
	//no-arg Constructor
	/**
	 * no-arg constructor
	 * Sets all variables to null
	 */
	public Patient() {
		firstName = null;
		middleName = null;
		lastName = null;
		patientAddress = null;
		city = null;
		state = null; 
		zipCode = null;
		phoneNumber = null;
		eMName = null;
		eMPhoneNumber = null;
	}
	
	//Constructor with full name
	/**
	 * Constructor
	 * @param first The Patient's First name
	 * @param middle The Patient's Middle Name
	 * @param last The Patient's Last Name
	 */
	public Patient(String first, String middle, String last) {
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	//Constructor with all variables
	/**
	 * 
	 * @param first The Patient's First Name
	 * @param middle The Patient's Middle Name
	 * @param last The Patient's Last Name
	 * @param address The Patient's Address
	 * @param c The Patient's City
	 * @param s The Patient's State
	 * @param zip The Patient's Zip Code
	 * @param pN The Patient's Phone Number
	 * @param eMN The Emergency Contact Name
	 * @param eMPN The Emergency Contact Phone Number
	 */
	public Patient(String first, String middle, String last, String address, String c, String s, String zip, String pN, String eMN, String eMPN) {
		firstName = first;
		middleName = middle;
		lastName = last;
		patientAddress = address;
		city = c;
		state = s;
		zipCode = zip;
		phoneNumber = pN;
		eMName = eMN;
		eMPhoneNumber = eMPN;
	}
	
	//Methods
	
	/**
	 * getFirstName method
	 * Returns the first name of the user
	 * @return The first name user
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * getMiddleName method
	 * Returns the middle name of the user
	 * @return The middle name of the user 
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * getLastName method
	 * Returns the last name of the user
	 * @return The last name of the user 
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * getAddress method
	 * Returns the address of the user
	 * @return The address of the user 
	 */
	public String getAddress() {
		return patientAddress;
	}
	
	/**
	 * getCity method
	 * Returns the city of the user
	 * @return The city of the user 
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * getState method
	 * Returns the state of the user
	 * @return The state of the user 
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * getZipCode method
	 * Returns the zip code of the user
	 * @return The zip code of the user 
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * getPhone method
	 * Returns the Phone Number of the user
	 * @return The Phone Number of the user 
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * getEMName method
	 * Returns the name of the user's emergency contact
	 * @return The emergency contact of the user
	 */
	
	public String getEMName() {
		return eMName;
	}
	
	
	/**
	 * getEMPhone method
	 * Returns the emergency contact's phone number
	 * @return The emergency contact's phone number
	 */
	public String getEMPhone() {
		return eMPhoneNumber;
	}
	
	/**
	 * setFirstName method
	 * Sets the new first name of the user
	 * @param name The first name of the user 
	 */
	public void setFirstName(String name) {
		firstName = name;
	}
	
	/**
	 * setMiddleName method
	 * Sets the new middle name of the user
	 * @param name The middle name of the user 
	 */
	public void setMiddleName(String name) {
		middleName = name;
	}
	
	/**
	 * setLastName method
	 * Sets the new last name of the user
	 * @param name The last name of the user 
	 */
	public void setLastName(String name) {
		lastName = name;
	}
	
	/**
	 * setAddress method
	 * Sets the new address of the user
	 * @param address The address of the user 
	 */
	public void setAddress(String address) {
		patientAddress = address;
	}
	
	/**
	 * setCity method
	 * Sets the new City of the user
	 * @param name The city of the user 
	 */
	public void setCity(String name) {
		city = name;
	}
	
	/**
	 * setFirstName method
	 * Sets the new state of the user
	 * @param name The state the user lives in
	 */
	public void setState(String name) {
		state = name;
	}
	
	/**
	 * setZipCode method
	 * Sets the new zip code of the user
	 * @param zip The zip code of the user 
	 */
	public void setZipCode(String zip) {
		zipCode = zip;
	}
	
	/**
	 * setPhoneNumber method
	 * Sets the new phone number of the user
	 * @param pN The Phone Number of the User 
	 */
	public void setPhoneNumber(String pN) {
		phoneNumber = pN;
	}
	
	/**
	 * setEMName method
	 * Sets the new name for the emergency contact
	 * @param name The name of the emergency contact
	 */
	public void setEMName(String name) {
		eMName = name;
	}
	
	/**
	 * setEMPhone method
	 * Sets the new emergency contact phone number
	 * @param num The phone number for the emergency contact
	 */
	public void setEMPhone(String num) {
		eMPhoneNumber = num;
	}
	
	/**
	 * buildFullName method
	 * Takes the first, middle, and last name of the user and returns
	 * the patient's full name
	 * @return Patient's full name
	 */
	public String buildFullName() {
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	}
	
	/**
	 * buildAddress method
	 * Takes the address, city, state, and zip code and combines it all together
	 * for the patien's full address
	 * @return Patient's full address
	 */
	public String buildAddress() {
		return getAddress() + ", " + getCity() + ", " + getState() + ", " + getZipCode();
	}
	
	/**
	 * buildEmergencyContact method
	 * Takes the name and number of the emergency contact and combines it all 
	 * @return Emergency Contact Information
	 */
	public String buildEmergencyContact() {
		return getEMName() + " " + getEMPhone();
	}
	
	/**
	 * toString method
	 * Takes the full name of the patient, address of the patient, and emergency contact of the 
	 * patient and returns all of the values all at once
	 * @return Patient's full name, address, and emergency contact information
	 */
	public String toString() {
		return "Patient: " + buildFullName() + "\n" + "Address: " + buildAddress() + "\n" + "Emergency Contact: " + buildEmergencyContact();
	}
	
}

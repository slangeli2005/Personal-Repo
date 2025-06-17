package espGame;
/*
 * Class Name: CMSC203
 * Instructor: Professor Grinberg
 * Description: This program is designed to test the user's extrasensory perception, by having the user guess what color
 * the computer has selected, from the text file colors.txt.  There are three rounds for each option and the user will be
 * asked for some information about themselves that will be printed on screen and in a text file.
 * Due: 06/16/2025
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied code from a student or any source.
 * I have not given my code to any student.
 * Name: Stephen Langelier
 */
import java.util.Scanner;
import java.io.*;
import java.util.Random;


public class ESPGame {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		//Create Scanner Object for User Input
		Scanner keyboard = new Scanner(System.in);
		//Create Variable for integer to determine whick option is picked
		int optionNumber;
		//Intro Statements for the User
		System.out.println("CMSC203 Assignment 1: Test your ESP Skills");
		System.out.println("Welcome to ESP - Extrasensory Perception");
		System.out.println("Please enter in the number that goes with the corresspoding option");
			
		//User Option Menu
		//Option 1
		System.out.println("1 - Read and Display on the Screen the First 16 names of colors from a file colors.txt, so the player");
		System.out.println("can select one of the names of the colors.");
		//Option 2
		System.out.println("2 - Read and Display on the Screen the First 10 names of colors from a file colors.txt, so the player");
		System.out.println("can select one of the names of the colors.");
		//Option 3
		System.out.println("3 - Read and Display on the Screen the First 5 names of colors from a file colors.txt, so the player");
		System.out.println("can select one of the names of the colors.");
		//Option 4
		System.out.println("4 - Exit from a Program");
			
		//User inputs in the value from the prior menu
		System.out.print("Enter number here: ");
		optionNumber = keyboard.nextInt();
		keyboard.nextLine();
		
		//The number entered into the value optionNUmber is checked to ensure it is in range
		boolean checkNumber;
		if(optionNumber >= 1 && optionNumber <= 4) {
			checkNumber = true;
		} else {
			checkNumber = false;
		}
		
		while(checkNumber == false) {
			System.out.println("Invalid Response, please enter in a valid number");
			System.out.print("Enter number here: ");
			optionNumber = keyboard.nextInt();
			keyboard.nextLine();
			if(optionNumber >= 1 && optionNumber <= 4) {
				checkNumber = true;
			} else {
				checkNumber = false;
			}
			}
				
		//Test to ensure optionNumber Check Works
		//System.out.println(optionNumber);
		//While loop that runs through the main parts of the program.  Will end once optionNumber = 4
		//Variable Creation for Counting the rounds for each option
		int count = 0;
		
		//Creating a variable to help with User Viewing
		int colorCount;
		
		//Int to keep score
		int score = 0;
		//Using the Scanner Class and the File Class to Read Data from a file
		File colorFile = new File("colors.txt");
		System.out.println(colorFile.getAbsolutePath());
		//Scanner readColor = new Scanner(colorFile);
		
		//Creating a String for user input color
		String userColor;
		//Scanner uKeyboard = new Scanner(System.in);
		//Scanner secondKeyboard = new Scanner(System.in);
		
		//Creation of a Random Object
		Random randomNumber = new Random();
		String specificLine = null;
		
		//Keeps track of correct rounds for user
		int correctRounds = 0;
		
		//Beginning for all of the available options
		while(optionNumber != 4) {
			colorCount = 1;
			count = 1;
			correctRounds = 0;
			//OPTION 1
			if(optionNumber == 1) {
				System.out.println("Below, are 16 colors from a text file:");
				try(Scanner readColor = new Scanner(colorFile)){	
					while(readColor.hasNext()) {
						System.out.println(colorCount + ": " + readColor.nextLine());
						colorCount++;
				}
					}
				while(count != 4) {
					System.out.println("Round " + count);
					System.out.println("I am thinking of a color");
					int rNum = randomNumber.nextInt(16) + 1;
					//Test to figure out the random NUmber
					//System.out.println(rNum);
					int lineNum = 1;
					try(Scanner specLine = new Scanner(colorFile)){
						while(specLine.hasNext()) {
							String tempLine = specLine.nextLine();
							if(lineNum == rNum) {
								specificLine = tempLine;
								//System.out.println("Yes");
								//System.out.println(specificLine);
							}
							lineNum++;
						}
					}
					//Test for specific line
					//System.out.println(specificLine);
						System.out.print("Select the color from the list I might be thinking of: ");
						userColor = keyboard.nextLine();
						
						if(specificLine.equalsIgnoreCase(userColor)) {
							correctRounds++;
							//System.out.println(correctRounds);
						}
						System.out.println("I was thinking of: " + specificLine);
						count++;
				}
				String contPlay = null;
					System.out.println("Game Over");
					System.out.println("You got " + correctRounds + "/3 correct");
					score = correctRounds;
					System.out.println("Would you like to keep playing? Y/N");
					contPlay = keyboard.nextLine();
				//Continue Playing Statements
				//No I do not want to continue playing
				if(contPlay.equalsIgnoreCase("N")) {
					optionNumber = 4;
				} else if (contPlay.equalsIgnoreCase("Y")) {
					//Option 1
					System.out.println("1 - Read and Display on the Screen the First 16 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 2
					System.out.println("2 - Read and Display on the Screen the First 10 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 3
					System.out.println("3 - Read and Display on the Screen the First 5 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					
					//User inputs in the value from the prior menu
					optionNumber = keyboard.nextInt();
					keyboard.nextLine();
				}
		
			//OPTION 2
			} else if(optionNumber == 2) {
				System.out.println("Below, are 10 colors from a text file:");
				try(Scanner readColor = new Scanner(colorFile)){	
					for(int i = 1; i <= 10; i++) {
						System.out.println(colorCount + ": " + readColor.nextLine());
						colorCount++;
				}
					}
				while(count != 4) {
					System.out.println("Round " + count);
					System.out.println("I am thinking of a color");
					int rNum = randomNumber.nextInt(10) + 1;
					//Test to figure out the random NUmber
					//System.out.println(rNum);
					int lineNum = 1;
					try(Scanner specLine = new Scanner(colorFile)){
						while(specLine.hasNext()) {
							String tempLine = specLine.nextLine();
							if(lineNum == rNum) {
								specificLine = tempLine;
								//System.out.println("Yes");
								//System.out.println(specificLine);
							}
							lineNum++;
						}
					}
					//Test for specific line
					//System.out.println(specificLine);
						System.out.print("Select the color from the list I might be thinking of: ");
						userColor = keyboard.nextLine();
						
						if(specificLine.equalsIgnoreCase(userColor)) {
							correctRounds++;
							//System.out.println(correctRounds);
						}
						System.out.println("I was thinking of: " + specificLine);
						count++;
				}
				String contPlay = null;
					System.out.println("Game Over");
					System.out.println("You got " + correctRounds + "/3 correct");
					score = correctRounds;
					System.out.println("Would you like to keep playing? Y/N");
					contPlay = keyboard.nextLine();
				//Continue Playing Statements
				//No I do not want to continue playing
				if(contPlay.equalsIgnoreCase("N")) {
					optionNumber = 4;
				} else if (contPlay.equalsIgnoreCase("Y")) {
					//Option 1
					System.out.println("1 - Read and Display on the Screen the First 16 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 2
					System.out.println("2 - Read and Display on the Screen the First 10 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 3
					System.out.println("3 - Read and Display on the Screen the First 5 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					
					//User inputs in the value from the prior menu
					System.out.println("Enter Number Here: ");
					optionNumber = keyboard.nextInt();
					keyboard.nextLine();
				}
			//OPTION 3
			} else if (optionNumber == 3){
				System.out.println("Below, are 5 colors from a text file:");
				try(Scanner readColor = new Scanner(colorFile)){	
					for(int i = 1; i <= 5; i++) {
						System.out.println(colorCount + ": " + readColor.nextLine());
						colorCount++;
				}
					}
				while(count != 4) {
					System.out.println("Round " + count);
					System.out.println("I am thinking of a color");
					int rNum = randomNumber.nextInt(5) + 1;
					//Test to figure out the random NUmber
					//System.out.println(rNum);
					int lineNum = 1;
					try(Scanner specLine = new Scanner(colorFile)){
						while(specLine.hasNext()) {
							String tempLine = specLine.nextLine();
							if(lineNum == rNum) {
								specificLine = tempLine;
								//System.out.println("Yes");
								//System.out.println(specificLine);
							}
							lineNum++;
						}
					}
					//Test for specific line
					//System.out.println(specificLine);
						System.out.print("Select the color from the list I might be thinking of: ");
						userColor = keyboard.nextLine();
						
						if(specificLine.equalsIgnoreCase(userColor)) {
							correctRounds++;
							//System.out.println(correctRounds);
						}
						System.out.println("I was thinking of: " + specificLine);
						count++;
				}
				String contPlay = null;
					System.out.println("Game Over");
					System.out.println("You got " + correctRounds + "/3 correct");
					score = correctRounds;
					System.out.println("Would you like to keep playing? Y/N");
					contPlay = keyboard.nextLine();
				//Continue Playing Statements
				//No I do not want to continue playing
				if(contPlay.equalsIgnoreCase("N")) {
					optionNumber = 4;
				} else if (contPlay.equalsIgnoreCase("Y")) {
					//Option 1
					System.out.println("1 - Read and Display on the Screen the First 16 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 2
					System.out.println("2 - Read and Display on the Screen the First 10 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					//Option 3
					System.out.println("3 - Read and Display on the Screen the First 5 names of colors from a file colors.txt, so the player");
					System.out.println("can select one of the names of the colors.");
					
					//User inputs in the value from the prior menu
					System.out.println("Enter Number Here: ");
					optionNumber = keyboard.nextInt();
					keyboard.nextLine();
				}
			}
		}
		//keyboard.close();
		//Variable setup for final file
		PrintWriter outputFile = new PrintWriter("EspGameResults");
		
		outputFile.println("You guessed " + correctRounds + "/3 correct.");
		System.out.print("What is your name: ");
		String responseAnswers = keyboard.nextLine();
		outputFile.println("Your name is: " + responseAnswers);
		System.out.print("Write a short description about yourself: ");
		responseAnswers = keyboard.nextLine();
		outputFile.println("User Description: " + responseAnswers);
		System.out.print("When is the due date: ");
		responseAnswers = keyboard.nextLine();
		outputFile.println("Due Date: " + responseAnswers);
		System.out.print("Today's Date: ");
		responseAnswers = keyboard.nextLine();
		outputFile.println("Date:" + responseAnswers);
		
		outputFile.close();
		//outputResponses.close();
		
		File responseFile = new File("EspGameResults");
		Scanner readingFileResponses = new Scanner(responseFile);
		while(readingFileResponses.hasNext()) {
			String responseString = readingFileResponses.nextLine();
			System.out.println(responseString);
		}
		
		
		readingFileResponses.close();
 }
}

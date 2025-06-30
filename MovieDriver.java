import java.util.Scanner;

/*
 * Class: CMSC203
 * CRN: 40438
 * Name: Stephen Langelier
 * Program: Lab1_CreateDriver
 * Due Date: 06/30/2025
 * Integrity Statement: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source
 * Description of Program:  The program allows the user to enter in a movie, enter in it's rating, and the amount of tickets it sold.
 * The program will then tell the user the information back and the user can choose to repeat the sequence or end the program.
 */

public class MovieDriver {

	public static void main(String[] args) {
		//Creates the Scanner Object
		Scanner keyboard = new Scanner(System.in);
		
		//Creates a new movie object
		Movie newMovie = new Movie();
		
		//Creates an int variable that will either keep the loop running or terminate it.
		int keepRunning = 0;
		
		while(keepRunning == 0) {
		//Prompts the user to enter the title of a movie
		System.out.print("Enter the name of the movie: ");
		String userInput = keyboard.nextLine();
		//Sets the title of the movie to the user input
		newMovie.setTitle(userInput);
		
		//Prompts the user to enter in the movie's rating
		System.out.print("Enter the movie's rating: ");
		userInput = keyboard.nextLine();
		//Sets the rating to the movie object
		newMovie.setRating(userInput);
		
		//Prompts the user to enter in the number of tickets at a theater
		System.out.print("Enter the number of tickets sold for this movie: ");
		int ticketsSold = keyboard.nextInt();
		keyboard.nextLine();
		//Sets the number of tickets sold in the movie object
		newMovie.setSoldTickets(ticketsSold);
		
		System.out.println(newMovie.toString());
		
		System.out.print("Do you want to enter another? (Y or N) ");
		userInput = keyboard.nextLine();
		if(userInput.equalsIgnoreCase("N")) {
			keepRunning = 1;
		}
		}
		
		System.out.println("Good Bye!");
		
		
		keyboard.close();
		

	}

}

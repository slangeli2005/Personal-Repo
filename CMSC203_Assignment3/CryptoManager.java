/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 */

/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: (Give a brief description for each Class)
 * Due: 07/07/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Stephen Langelier
*/

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by student
    	
    	plainText = plainText.toUpperCase();
    	key = key.toUpperCase();
    	if(!(isStringInBounds(plainText))){
    		return "The selected string is not in bounds, Try Again.";
    	}
    	
    	
    	//Creates a StringBuilder Object with size of the plainText
    	StringBuilder encryptedText = new StringBuilder(plainText.length());
    	
    	//Creates an index for key to ensure that it does not go out of bounds
    	int indexForKey = 0;
    	
    	//Create a for loop to set each letter to it's encrypted purpose
    	for(int i = 0; i < plainText.length(); i++) {
    		//Creates two variables to hold character values at that index
    		char keyChar = key.charAt(indexForKey);
    		char pTChar = plainText.charAt(i);
    		
    		//Create the shift in the alphabet
    		int shift = keyChar - LOWER_RANGE;
    		
    		//Change the numerical place of the letters
    		//ci = (pi + ki) mod RANGE + LOWER_RANGE
    		//pi is the plainText Letter 
    		//ki is the shifter
    		int pTChange = ((pTChar - LOWER_RANGE) + shift) % RANGE + LOWER_RANGE;
    		
    		//Add the value to the StringBuilder
    		encryptedText.append((char) pTChange);
    		
    		
    		
    		//Set Index for Key
    		indexForKey = (indexForKey + 1) % key.length();
    	}
    	
    	//Returns the encrypted word as a String
    	return encryptedText.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
    	//Create a StringBuilder Object
    	
    	StringBuilder decryptedText = new StringBuilder(encryptedText.length());
    	int indexForKey = 0;
    	
    	//Create a for loop to decrypt the test
    	for(int i = 0; i < encryptedText.length(); i++) {
    		//Formula to decrypt: pi = (ci - ki) mod RANGE + LOWER_RANGE
    		//Where ci = encryptedText letter
    		//ki = Corresponding key letter
    		
    		//Create two characters for holding
    		char eTChar = encryptedText.charAt(i);
    		char keyChar = key.charAt(indexForKey);
    		
    		//Create the int variable that will store the shift
    		int charShift = keyChar - LOWER_RANGE;
    		//Shift the character
    		int newChar = ((eTChar - LOWER_RANGE) - charShift + RANGE) % RANGE + LOWER_RANGE;
    		
    		//Add Character to StringBuilder
    		decryptedText.append((char) newChar);
    		
    		//Set Index
    		indexForKey = (indexForKey + 1) % key.length();
    		
    	}
    	
    	
    	//Returns the decrypted string
    	return decryptedText.toString();
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
         if(!(isStringInBounds(plainText))){
        	 return "The selected String is not in bounds, Try Again.";
         }
         
         //Create a StringBuilder Object
         StringBuilder encryptedText = new StringBuilder();
         StringBuilder pairs = new StringBuilder();
         
         //Create a 8x8 Grid
         char[][] grid = createMatrix(key);
         
         //Create the Pairs for Cipher
         //index
         int index = 0;
         
         
         //While Loop to create the pairs
         while(index < plainText.length()) {
        	 char firstLetter = plainText.charAt(index);
        	 char secondLetter;
        	 if(index  + 1 < plainText.length()) {
        		 secondLetter = plainText.charAt(index + 1);
        		 if(firstLetter == secondLetter) {
        			 secondLetter = 'X';
        			 index++;
        		 } else {
        			 index += 2;
        		 }
        	 } else {
        		 secondLetter = 'X';
        		 index++;
        	 }
        	 
        	 pairs.append(firstLetter);
        	 pairs.append(secondLetter);
         }
         
         
         
         //Create the encryption
         for(int i = 0; i < pairs.length();i+=2) {
        	 //Get the characters
        	 char one = pairs.charAt(i);
        	 char two = pairs.charAt(i + 1);
        	 
        	 //Condition of the Cipher
        	 int[] characterOnePos = getPosition(grid, one);
        	 int[] characterTwoPos = getPosition(grid,two);
        	 
        	 if(characterOnePos[0] == characterTwoPos[0]) {
        		 encryptedText.append(grid[characterOnePos[0]][(characterOnePos[1] + 1) % 8]);
        		 encryptedText.append(grid[characterTwoPos[0]][(characterTwoPos[1] + 1) % 8]);
        	 } else if (characterOnePos[1] == characterTwoPos[1]) {
        		 encryptedText.append(grid[(characterOnePos[0] + 1) % 8][characterTwoPos[1]]);
        		 encryptedText.append(grid[(characterTwoPos[0] + 1) % 8][characterTwoPos[1]]);
        	 } else {
        		 encryptedText.append(grid[characterOnePos[0]][characterTwoPos[1]]);
        		 encryptedText.append(grid[characterTwoPos[0]][characterOnePos[1]]);
        	 }
        	 
         }
         
         
         return encryptedText.toString();
         
    }

    // playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
    	StringBuilder decryptedText = new StringBuilder();
    	
    	//Create the matrix
    	char[][] matrix = createMatrix(key);
    	//Create the decryption
    	for(int i = 0; i < encryptedText.length(); i += 2) {
    		char one = encryptedText.charAt(i);
    		char two = encryptedText.charAt(i + 1);
    		
    		int[] characterOnePos = getPosition(matrix, one);
    		int[] characterTwoPos = getPosition(matrix, two);
    		
    		if(characterOnePos[0] == characterTwoPos[0]) {
    			decryptedText.append(matrix[characterOnePos[0]][(characterOnePos[1] + 7) % 8]);
    			decryptedText.append(matrix[characterTwoPos[0]][(characterTwoPos[1] + 7) % 8]);
    		} else if (characterOnePos[1] == characterTwoPos[1]){
    			decryptedText.append(matrix[(characterOnePos[0] + 7) % 8][characterTwoPos[1]]);
       		    decryptedText.append(matrix[(characterTwoPos[0] + 7) % 8][characterTwoPos[1]]);
    		} else {
    			decryptedText.append(matrix[characterOnePos[0]][characterTwoPos[1]]);
       		    decryptedText.append(matrix[characterTwoPos[0]][characterOnePos[1]]);
    		}
    	}
    	
    	return decryptedText.toString();	
    }
    
    /**
     * Creates a Matrix for the PlayFair Decryption
     * @param key Inputs in the String Key from the methods
     * @return The Grid Matrix that is 8X8
     */
    public static char[][] createMatrix(String key){
    	StringBuilder matrix = new StringBuilder();
    	boolean[] characterUsed = new boolean[ALPHABET64.length()];
    	
    	//Fills in the keyword
    	for(int i = 0; i < key.length() && matrix.length() < 64;i++) {
    		char charKey = key.charAt(i);
    		if(!characterUsed[charKey]) {
    			if(matrix.length() == 64) break;
    			matrix.append(charKey);
    			characterUsed[charKey] = true;
    		}
    	}
    	
    	//Fills in the rest of the alphabet
    	for(int i = 0; i < ALPHABET64.length() && matrix.length() < 64;i++) {
    		char fillInChar = ALPHABET64.charAt(i);
    		if(!characterUsed[fillInChar]) {
    			if(matrix.length() == 64) break;
    			matrix.append(fillInChar);
    			characterUsed[fillInChar] = true;
    		}
    	}
    	
    	//Creates the matrix
    	char[][] grid = new char[8][8];
    	String trimmedMatrix = matrix.substring(0,64);
    	for(int i = 0; i < 64; i++) {
    		grid[i / 8][i % 8] = trimmedMatrix.charAt(i);
    	}
    	
    	return grid;
    }
    
    /**
     * Finds the row and column of a character in a matrix
     * @param matrix The 2D array of a matrix
     * @param characterNeed The character that it is searching for
     * @return the integer array that contains the row and columns
     * @return null if no value is found
     */
    public static int[] getPosition(char[][] matrix, char characterNeed) {
    	for(int row = 0; row < matrix.length; row++) {
    		for(int col = 0; col < matrix[row].length;col++) {
    			char characterMaybe = matrix[row][col];
    			if(characterMaybe == characterNeed) {
    				return new int[] {row, col};
    			}
    		}
    	}
    	return null;
    }
}

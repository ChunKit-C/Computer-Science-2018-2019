/*
 * Author: Chun-Kit Chung
 * Description: File is a simple recreation of the famous mastermind game.
 * The game generates a code for the user to guess, it gives feedback via 
 * coloured pegs and creates a file with the users name and info if they win 
 * Date: 06/10/2019
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class game {
	static int[] guess;
	static int[] array;
	static String[] info;
	static boolean Found;
	static int whitePeg;
	static int blackPeg;
	static int numGuess;
	static double timeSent;
	static double time;
	static boolean append;
	static String enterName;
	static String nameInfo;

	public game() {
		guess = new int[4];
		array = new int[4];
		info = new String[20];
		Found = false;
		whitePeg = 0;
		blackPeg = 0;
		numGuess = 0;
		append = true;
	}

	public static int[] codeMaker() { // method creates random code for user to guess
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (6) + 1);
			System.out.print("array value " + (i + 1) + ": " + array[i] + "\n");
		}
		return array;
	}

	public static void codeCheck(int[] array, int[] guess) { // method checks guess with generated code
		blackPeg = 0;
		whitePeg = 0;

		for (int k = 0; k < array.length; k++) {
			for (int h = 0; h < guess.length; h++) {

				if (array[h] != -1) { 
					if (array[k] == guess[h]) { // checks if array and guess have similar numbers
						Found = true;
					} else {
						Found = false;
					}
				 
					if (Found == true) { 
 						if (guess[k] == array[k]) { // if the colour and position is right, increase black peg count
							array[h] = -1;
							blackPeg++;
						} // end of if
						else { // if the colour is right but position is wrong, increase white peg count
 							array[h] = -1;
							whitePeg++;
						}
					} // end of if
				} // end of if
			} // end of for
		} // end of for
		System.out.println("\n");
		System.out.println("black pegs: " + blackPeg);
		System.out.println("white pegs: " + whitePeg);
		System.out.println("Guesses: " + numGuess);

	}

	public String WinOrLose(int blackPeg, int numGuess) throws IOException { // method displays message if user won or lost

		if (blackPeg == 4) { // if the code is correctly guessed
			time = ((double) System.currentTimeMillis() - timeSent) / 1000; // stops timer and converts to seconds
			System.out.println("\n");
			String textWin = "YOU HAVE BROKEN THE CODE IN " + numGuess + " GUESS(ES)!!\n";
			String timeTook = "You took: " + time + " seconds to break the code!!\n";
			masterMindFinal.slowPrint(textWin, 30);
			masterMindFinal.slowPrint(timeTook, 30);
			
			
			Scanner scanner = new Scanner(System.in); // creates scanner for user to
			System.out.println("\n");
			String enterName = "Enter your first name: ";
			String nameInfo = "";
			masterMindFinal.slowPrint(enterName, 30);
			nameInfo = scanner.nextLine();
			String allInfo = nameInfo + "\t\t" + numGuess + "\t\t\t\t\t" + time;
 
			fileMaker.addAtFront(allInfo); // create linked list with info
			fileMaker.appendToText(allInfo, append); // creates file
			fileMaker.SortTextFile(); // sorts file alphabetically

		} else if (numGuess == 10) { // if the number of guesses is 10
			System.out.println("\n");
			String textLose = "YOU TOOK TO MANY TRIES TO BREAK THE CODE\nYOU LOST :(\n";
			masterMindFinal.slowPrint(textLose, 30);
			System.out.println("\n");
			String rightCombo = "THE CODE TO BREAK WAS: \n";
			masterMindFinal.slowPrint(rightCombo, 30);
			for (int i = 0; i < array.length; i++) {
				System.out.print("COLOUR VALUE: " + array[i] + "\n");
			}
		}
		return "";
	} 
}

class fileMaker extends game {
	public static String userFile;
	private static Node head;
	String lString;

	public fileMaker() {
		String userFile = "Scoreboard";
		head = null;
		lString = "";
	}

	public static void addAtFront(String allInfo) { // method adds a node to the linked list
		Node newNode = new Node(allInfo);
		newNode.setNext(head);
		head = newNode;
	}
 
	public static void appendToText(String allInfo, boolean append) { // method creates file
		BufferedWriter bw = null;
 
		try {
			bw = new BufferedWriter(new FileWriter("Scoreboard", append)); // file
			bw.write(allInfo); // text to write in file
			bw.newLine(); // new line
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally { // always close the file
			if (bw != null)
				try {
					bw.close();
				} catch (IOException ioe2) {
					// just ignore it
					System.out.println(ioe2);
				}
		} // end try/catch/finally
	} // end appendToText

	public static void SortTextFile() { // method sorts file by alphabetical order
		BufferedReader reader = null;
		BufferedWriter writer = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader("Scoreboard"));
			String currentLine = reader.readLine();
			while (currentLine != null) {
				lines.add(currentLine);
				currentLine = reader.readLine();
			}
			Collections.sort(lines);
			writer = new BufferedWriter(new FileWriter("Scoreboard"));
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end try/catch/finally
	} // end SortTextFile
}

class Node {
	public String data;
	public Node next;

	public Node(String allInfo) { // constructor
		data = allInfo;
		next = null;
	}

	public Node getNext() { // method returns the node pointed by "next"
		return (next);
	}

	public void setNext(Node newNode) { // method sets next to point to newNode
		next = newNode;
	}

	public String getData() {// method returns the data from the node pointed by "next"
		return (data);
	} 
}

public class masterMindFinal {
	static String text;
	static String text1;
	static int input;

	public masterMindFinal() {

	}

	public static void main(String[] args) throws IOException {
		game gameVar = new game();
		fileMaker fileVar = new fileMaker();
		java.lang.System.currentTimeMillis();
		LinkedList list = new LinkedList();
		String format = "Name:\t\t# of guesses:\t\tTime took:";  
		fileVar.appendToText(format, gameVar.append); 
		String text = "WELCOME TO MASTERMIND\n";

		String text1 = "\n0. Exit\n1. New Game\n2. How to play\nEnter your choice: ";
		Scanner scanner = new Scanner(System.in); // creates scanner for user to input guess

		slowPrint(text, 30);

		int input = 0;

		do { // do while loop for menu
			slowPrint(text1, 30);
			input = scanner.nextInt();
			if (input == 1) { // if user inputs 1
				//resets all values for pegs and guesses
				gameVar.blackPeg = 0;
				gameVar.whitePeg = 0;
				gameVar.numGuess = 0;
				gameVar.codeMaker(); // creates random code
				
				
				gameVar.timeSent = (double) System.currentTimeMillis(); // start timer
				do { // do while loop when user inputs guess
					if (gameVar.blackPeg < 4) { // if # of black pegs is less than 4
						System.out.println(
								"\nEnter a 4 colour combination with the following colours: [RED = 1] [ORANGE = 2] [YELLOW = 3] [GREEN = 4] [BLUE = 5] [PURPLE = 6]");
						for (int i = 0; i < 4; i++) {
							System.out.print("Colour " + (i + 1) + ": ");
							gameVar.guess[i] = Math.abs(scanner.nextInt());
						}
						gameVar.numGuess++;
						gameVar.codeCheck(gameVar.guess, gameVar.array); // check guess

						if (gameVar.numGuess == 10) { // if user guesses up to 10 times
							gameVar.WinOrLose(gameVar.blackPeg, gameVar.numGuess);
							gameVar.blackPeg = 4;
						} else if (gameVar.blackPeg == 4) {  // if user guesses the right code
							gameVar.WinOrLose(gameVar.blackPeg, gameVar.numGuess);
						}
					}
				} while (gameVar.blackPeg != 4);

			} else if (input == 2) {// if user inputs 2
				String text2 = "\nThe computer has selected a secret combination of\n4 colored pegs and you have to guess the combination \nin 10 or fewer tries to win.\r\n\r\nTo create your guess, enter 4 colours until you've\nfilled the row with your combination, then the game\nwill automatically check your guess combination.\nEach time you submit a guess, the game will use\ncoloured pegs to let you know how close your guess is.\n\nFor each guess,a black peg indicates that one of your\npegs is the right color in the right position. A white\npeg indicates that one of your pegs is the right colour\nbut in the wrong position. Use the score to guide your\nnext guess. If your guess scores 4 black pegs within\n10 tries, you win.\n\nTo begin a new game return to the menu and enter [1] to start a new game\n\nGood luck!!\n";
				slowPrint(text2, 25);
			} else if (input == 0) {// if user inputs 0 exit
				System.exit(0);
			} else {// if user inputs number that is not an option
				System.out.print("Number inputted is not a choice!\n\n");
			}
		} while (input != 0);

	}

	public static void slowPrint(String message, long millisPerChar) { // method creates text animation in console
		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i));
			try {
				Thread.sleep(millisPerChar);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
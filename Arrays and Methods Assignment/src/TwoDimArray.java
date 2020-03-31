import java.util.*;

public class TwoDimArray {

	/*-----------------------------------------------------------------*/
	/*-------------------------- Question 3 ---------------------------*/
	/*-----------------------------------------------------------------*/

	static int i = 0;
	static int j = 0;
	static int[][] twoDArray = new int[4][4]; // creates 2d array
	static Random r = new Random();
	static Scanner input = new Scanner(System.in);

	public static void readTwoDArray() { // method creates 4x4 array and puts
											// inputed elements into 2d array
		System.out.print("Enter 16 intergers:\n");
		for (i = 0; i < twoDArray.length; i++) {
			for (j = 0; j < twoDArray[i].length; j++) {
				twoDArray[i][j] = input.nextInt(); // puts inputed elements into
													// 2d array
			}// end of for
		}// end of for
		input.close();
	}

	public static void printArray(int[][] a){ // method prints array in a 4x4 formatted square
	System.out.println("\nNew array is:\n");
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}// end of for
			System.out.println("\n\n");
		}// end of for
	}

	public static int maxTwoDArray(int[][] twoDArray) { // method scans array to
														// find the max value
														// and prints it out
		int max = twoDArray[0][0];
		for (i = 0; i < twoDArray.length; i++) {
			for (j = 0; j < twoDArray[i].length; j++) {
				if (twoDArray[i][j] > max) { // checks for the largest value
					max = twoDArray[i][j];
				}// end of if
			}// end of for
		}// end of for
		System.out.println("The largest value is: " + max + "\n\n\n");

		return (max);

	}

	public static int replaceEvenOdd(int[][] twoDArray) { // method scans array
															// and replaces even
															// elements with 0
															// and odd elements
															// with 1
		for (i = 0; i < twoDArray.length; i++) {
			for (j = 0; j < twoDArray[i].length; j++) {
				if (twoDArray[i][j] % 2 == 0) { // if integer is divisible by 2,
												// change the integer to 0
					twoDArray[i][j] = 0;
				}// end of if
				else { // if not, change the integer to 1
					twoDArray[i][j] = 1;
				}// end of else
			}// end of for
		}// end of for
		return (0);
	}

	public static void main(String[] args) {
		readTwoDArray(); // goes to first method
		printArray(twoDArray);// goes to second method
		maxTwoDArray(twoDArray); // goes to third method
		replaceEvenOdd(twoDArray); // goes to fourth method
		printArray(twoDArray); // goes back to second method
	}

}

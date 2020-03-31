import java.util.Scanner;

public class OneDimArray {
	static int[] oneArray = new int[10];
	static int N;

	/*-----------------------------------------------------------------*/
	/*-------------------------- Question 2 ---------------------------*/
	/*-----------------------------------------------------------------*/

	public static void readArray() { // method creates 10 element array and puts
										// inputed elements into 1d array

		Scanner input = new Scanner(System.in); // creates scanner for user to
												// input integers

		System.out.print("Enter 10 intergers:\n");
		for (int i = 0; i < 10; i++) {
			System.out.print("Element " + i + ": ");
			oneArray[i] = input.nextInt(); // puts the inputed elements into the
											// array
		}// end of for
	}

	public static int searchNumber(int[] oneArray) { // method searches for the
														// nearest lesser
														// element and prints it
														// out if found

		Scanner searchNumber = new Scanner(System.in);
		System.out.println("\nEnter an interger to search for the nearest lesser element: ");
		int N = searchNumber.nextInt();
		boolean numberFound = true;
		int closestElement = 0;

		for (int i = 0; i < oneArray.length; i++) {
			if (oneArray[i] < N) {
				if (closestElement < oneArray[i]) {
					closestElement = oneArray[i];
					numberFound = true;
				} // end of if
			} // end of if
		} // end of for

		if (numberFound == true) {
			System.out.println("The closest element to: " + N + " is " + closestElement);
		} // end of if
		else {
			System.out.println("0");
		}// end of else
		return (N);
	}

	public static int countSearch(int[] oneArray, int N) { // method scans array
															// to check how many
															// times N is found
															// in array
		int found = 0;
		boolean cannotfind = true;
		for (int i = 0; i < oneArray.length; i++) {
			if (N == oneArray[i]) { // if the inputed integer is equal to the
									// number in the array, increase the found
									// count
				found++;
			} // end of if 
			else { // if the integer is not found in array, boolean is true
				cannotfind = true;
			}// end of else
		}// end of for
		if (found >= 1) { // if found count is equal or greater than one, print
							// out how many times it was found
			System.out.println("The number of times " + N + " is found in the array is " + found);
		} // end of if
		else { // if not found, print out 0
			System.out.println("0");
		}// end of else
		return (found);
	}

	public static void swapElements(int[] oneArray) { // method swaps the first
														// element with the
														// last, the second with
														// the second last and
														// so on
		int temp = 0;
		for (int i = 0; i < oneArray.length / 2; i++) { // swap the first
														// element with the
														// last, and so on
			temp = oneArray[i];
			oneArray[i] = oneArray[oneArray.length - i - 1];
			oneArray[oneArray.length - i - 1] = temp;
		}// end of for
		System.out.println("New modified array is:\n");
		for (int i = 0; i < oneArray.length; i++) { // go through the array and
													// print out the changed
													// array
			
			System.out.print(oneArray[i]);
			System.out.print(" ");
		}// end of for
	}

	public static void main(String[] args) {
		readArray(); // goes to first method
		searchNumber(oneArray);// goes to second method
		countSearch(oneArray, N); // goes to third method
		swapElements(oneArray); // goes to fourth method
	}

}

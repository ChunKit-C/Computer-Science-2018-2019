import java.util.Scanner;

public class integerPower {

	static int integerN;
	static boolean power2 = true;
	static double power;

	/*-----------------------------------------------------------------*/
	/*-------------------------- Question 1 ---------------------------*/
	/*-----------------------------------------------------------------*/
	
	
	public static boolean checkPowerOfTwo(int integerN, boolean power2) {

		double power = (Math.log(integerN) / Math.log(2)); //checks if the number inputed is a power of 2
		if (power % 1 == 0) {
			power2 = true;
		} // end of if
		else if (power % 1 != 0) {
			power2 = false;
		}// end of else if
		return (power2);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter any interger: ");
		integerN = input.nextInt();
		checkPowerOfTwo(integerN, power2);// goes to first method
		power2 = checkPowerOfTwo(integerN, power2); //uses value of the method and initializes power2 with the variable

		if (power2 == true) { // if the number inputed is a power of 2, print it out
			System.out.println(integerN + " is a power of 2");
		} // end of if
		else if (power2 == false) {// if the number inputed is not a power of 2, print it out
			System.out.println(integerN + " is not a power of 2");
		}// end of else if
	}

}

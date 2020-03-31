import java.util.Scanner;
import java.text.DecimalFormat;

public class arrayElements {

	public static void sumElements(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("\nSum of all elements: " + sum);
	}

	public static void averageElements(int[] array) {
		int total = 0;
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		System.out.println("Average of all elements: " + decimalFormat.format(total / array.length));
	}

	public static void divisibleElements(int[] array) {
		int divisibleNumbers = 0;
		int nonDivisibleNumbers = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 3 == 0) {
				divisibleNumbers++;
			} else {
				nonDivisibleNumbers++;
			}
		}
		System.out.println("The number of elements divisible by 3 are: " + divisibleNumbers);
		System.out.println("The number elements that aren't divisible by 3 are: " + nonDivisibleNumbers);
	}

	/*public static void primeNumbers(int[] array) {
		boolean Prime = true;
		int i;
		int j = 0;
		for (i = 1; i < array.length; i++) {

			for (j = 2; j < array[i]; j++) {
				if (array[i] % j == 0) {
					Prime = false;
					break;
				}
			}
		}
		
		if (Prime) {
			System.out.println("Prime numbers in the array list are: " + array[i]);
		} if(i==1) {
			System.out.println("There are no prime numbers in the array");
		}
	}
*/
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] array = new int[10];

		Scanner elements = new Scanner(System.in);

		System.out.print("Enter 10 intergers:\n");

		for (int i = 0; i < 10; i++) {
			System.out.print("Element " + i + ": ");
			array[i] = elements.nextInt();
		}
		elements.close();
		sumElements(array);
		averageElements(array);
		divisibleElements(array);
		//primeNumbers(array);
	}

}

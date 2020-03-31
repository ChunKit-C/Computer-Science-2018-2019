import java.lang.reflect.Array;
import java.util.Scanner;

class Recursion {
	static int[] array;

	public int square(int n) {
		if (n == 1) {
			return 1;
		} else {
			return square(n - 1) + ((n * 2) - 1);
		}
	}

	public int cube(int n) {
		if (n == 1)
			return 1;
		else
			return cube(n - 1) + (3 * square(n) - (3 * n) + 1);
	}

	public long factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public int arraySum(int n, int[] array) {
		if (n <= 0) {
			return 0;
		}
		return (arraySum(n - 1, array) + array[n - 1]);
	}
	public int numSum(int n){
		if (n <= 1) {
			return n;
		}else{
			return numSum(n - 1) + n;
		} 
		
	}
}

public class RecursionTester {
	static Recursion r = new Recursion();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		r.array = new int[10];
		while (true) {
			System.out.println("1. square\n2. cube\n3. factorial\n4. fibonacci\n5. array\n6. sum of all numbers less than (n)\n7.\n8.\n9.\n\nChoose your choice:");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Select a number to be squared: ");
				int result = r.square(input = sc.nextInt());
				System.out.println("Square(" + input + ") is " + result + "\n\n");
				break;

			case 2:
				System.out.println("Select a number to be cubed: ");
				int result2 = r.cube(input = sc.nextInt());
				System.out.println("Cube(" + input + ") is " + result2 + "\n\n");
				break;

			case 3:
				System.out.println("Select a number to be cubed: ");
				long result3 = r.factorial(input = sc.nextInt());
				System.out.println("Factorial(" + input + ") is " + result3 + "\n\n");
				break;
			case 4:
				System.out.println("Select a number in the fibonacci sequence to find the value: ");
				int result4 = r.fibonacci(input = sc.nextInt());
				System.out.println("fibonacci(" + input + ") is " + result4 + "\n\n");
				break;
			case 5:
				System.out.println("Enter an array of 10 elements to calculate the sum: ");
				for (int i = 0; i < r.array.length; i++) {
					System.out.print("Interger " + (i + 1) + ": ");
					r.array[i] = sc.nextInt();
				}
				int result5 = r.arraySum(r.array.length, r.array);
				System.out.println("\nThe sum of all the elements in the array is: " + result5);
				break;
			case 6:
				System.out.println("Enter an number (n) to calculate the sum of all numbers less than (n): ");
				int result6 = r.numSum(input = sc.nextInt());
				System.out.println("sum of all numbers less than " + input + " is " + result6 + "\n\n");

				break;
			case 7:
				
				
				break;
			case 8:
				
				
				break;
			case 9:
				
				
				break;
			case 10:
				
				
				break;
			case 11:
				
				
				break;
			case 12:
				
				
				break;
				
			}
		}
	}
}
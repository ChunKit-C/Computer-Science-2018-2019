import java.util.Scanner;

public class EvenOddArray {

	public static void evenOdd(int[] array) {
		System.out.println(array);
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				int[] even = {array[i]};
				System.out.println("Array with positive intergers: " + even);
			} else if (array[i] % 2 >= 1) {
				int[] odd = {array[i]};;
				System.out.println("Array with negative intergers: " + odd);
			}

		}
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		int i;
		Scanner elements = new Scanner(System.in);

		System.out.print("Enter 10 positive intergers:\n");
		for (i = 0; i < 10; i++) {
			System.out.print("Element " + i + ": ");
			array[i] = elements.nextInt();

			if (array[i] < 0) {
				System.out.print("Interger is not positive, enter a positive interger\n");
				i--;
			}
		}
		evenOdd(array);
	}
}

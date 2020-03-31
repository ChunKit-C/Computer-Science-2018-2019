import java.util.Scanner;

class Stack1 {
	static int[] data;
	static int top;
	static int sumExtracted;
	static int elementsLeft;
	static int count;
	static int sum;

	public Stack1() {	// constructor
		data = new int[10];
		top = -1;
		sumExtracted = 0;
		elementsLeft = 0;
		count = 0;
		sum = 0;
	}

	public void push(int item) {// adds inputed element on the top
		if (top <= data.length - 1) {
			top = top + 1;
			data[top] = item;
		}
	}

	public int pop() { // method extracts numbers from the S]stack one by one until a negative number is found

		while (data[top] >= 0) {
			System.out.println(data[top]);
			top = top - 1;
			count++;
			sumExtracted();
		}
		return sumExtracted = sum;
	}

	public int sumExtracted() { // method calculates the sum of the numbers extracted
		sum = sum + data[top + 1];
		System.out.println("Sum" + sum);
		return sum;
	}

	public int sumLeft() { // method displays the number of elements that are left in the stack
		elementsLeft = 10 - count;
		return elementsLeft;
	}

}

public class Stack {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack1 stack = new Stack1();
		System.out.println("Enter 10 intergers into the stack:\n");
		for (int i = 0; i < stack.data.length; i++) { 
			System.out.print("Interger " + (i + 1) + ": ");
			stack.data[i] = input.nextInt();
			stack.push(stack.data[i]);
		}
		System.out.println("The sum of the extracted numbers is: " + stack.pop());
		System.out.println("The number of elements left in the stack is: " + stack.sumLeft());
	}

}

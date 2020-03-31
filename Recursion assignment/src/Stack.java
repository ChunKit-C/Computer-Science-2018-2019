import java.util.Scanner;

class Stack1 {
	static int[] data;
	static int top;
	static int sumInStack;
	static int maxValue;

	public Stack1() { // constructor
		data = new int[7];
		top = -1;
		sumInStack = 0;
		maxValue = 0;
	}

	public void push(int item) {// adds inputed element on the top
		if (top <= data.length - 1) {
			top = top + 1;
			data[top] = item;
		}
	}

	public int pop() { // method extracts numbers from the stack
		top = top - 1;
		return data[top + 1];
	}

	public int sumStack(int index) { // method calculates the sum of all elements in the stack and returns it
			if (index >= 0) {
				sumInStack += data[index];
			return sumStack(index - 1);
		}
		return sumInStack;
	}
}

public class Stack {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack1 stack = new Stack1();
		System.out.println("Enter 7 intergers into the stack:\n");
		for (int i = 0; i < stack.data.length; i++) {
			System.out.print("Interger " + (i + 1) + ": ");
			stack.data[i] = input.nextInt();
			stack.push(stack.data[i]);
		}
		System.out.println("The sum of all the elements in the stack is: " + stack.sumStack(stack.data.length - 1));

	}

}

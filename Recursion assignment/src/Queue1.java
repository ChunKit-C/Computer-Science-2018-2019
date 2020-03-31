import java.util.Scanner;

class Queue {
	static int[] data;
	static int front;
	static int rear;
	static long product;
	static int counter;

	public Queue() { // constructor
		data = new int[7];
		front = -1;
		rear = -1;
		product = 1;
		counter = data.length - 1;
	}

	public void enqueue(int num) { // method adds an item to the queue if there
									// is room
		if (isEmpty()) {
			rear = 0;
			front = 0;
			data[rear] = num;
		} else {
			rear = (rear + 1) % data.length;
			data[rear] = num;
		}
	}

	public int dequeue() { // method removes the front item from the queue and
							// returns it
		front = (front + 1) % data.length;
		return (data[front - 1]);
	}

	public boolean isEmpty() { // method determines if there are items on the
								// queue
		if (front == -1 && rear == -1) {
			return (true);
		} else {
			return (false);
		}
	}

	public long productQueue(int number) { // method calculates the product of all elements in 45the queue
		if (number == 0) {
			// base case
			product *= data[0];
			return product;
		} else {
			product *= data[number];
			number--;
			productQueue(number);
		}
		return product;
	}
}

public class Queue1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue queue = new Queue();
		System.out.println("Enter 7 intergers into the queue:\n");
		for (int i = 0; i < queue.data.length; i++) {
			System.out.print("Interger " + (i + 1) + ": ");
			queue.data[i] = input.nextInt();
			queue.enqueue(queue.data[i]);
		}
		System.out.println("The product of all elements in the queue is: " + queue.productQueue(queue.data.length - 1));
	}
}

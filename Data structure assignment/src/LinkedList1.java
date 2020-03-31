import java.util.Scanner;

class LinkedList {
	private Node head;
	String lString;

	public LinkedList() {// constructor
		head = null;
		lString = "";
	}

	public void addAtFront(String str) { // method adds a node to the linked list
		Node newNode = new Node(str);
		newNode.setNext(head);
		head = newNode;
	}

	public String toString() { // method prints out the strings in the linked list
		Node current = head;
		String listString;

		if (current != null) { // prints out each string line by line
			listString = current.getData() + "\n";
			while (current.getNext() != null) {
				current = current.getNext();
				listString += current.getData() + "\n";
			}
			return (listString);
		} else {
			return ("There are no strings in list.");
		}
	}

	public String longestString() { // method finds and returns the longest string

		Node current = head;
		while (current.next != null) { // while loop compares length of the strings in a loop

			if (lString.length() < current.getData().length()) { 
				lString = current.getData();
			}
			current = current.next;
		}
		return ("Longest String is: " + lString);
	}
}

class Node {
	public String data;
	public Node next;

	public Node(String newData) { // constructor
		data = newData;
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

public class LinkedList1 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 6 strings:\n");
		for (int i = 0; i < 6; i++) {
			System.out.print("String " + i + ": ");
			list.addAtFront(input.nextLine());
		}
		System.out.println(list.toString());
 		System.out.println(list.longestString());
	}
}

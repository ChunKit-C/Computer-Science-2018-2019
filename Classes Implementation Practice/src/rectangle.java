import java.util.Scanner;

class anyRectangle {
	int length;
	int width;
	boolean square;

	public anyRectangle() {
		length = 0;
		width = 0;
		square = false;
	}

	public anyRectangle(int l, int w) {
		length = l;
		width = w;
	}

	public int area(int length, int width) {
		return length * width;
	}

	public int perimeter(int length, int width) {
		return 2 * (length + width);
	}

	public boolean isSquare(int length, int width) {
		if (length == width) {
			square = true;
		} else {
			square = false;
		}
		return square;
	}
}

public class rectangle {

	public static void main(String[] args) {
		anyRectangle rect = new anyRectangle();

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the length: ");
		rect.length = input.nextInt();

		System.out.println("Enter the width: ");
		rect.width = input.nextInt();

		System.out.println("The area is " + rect.area(rect.length, rect.width));

		System.out.println("The perimeter is " + rect.perimeter(rect.length, rect.width));

		System.out.println("The rectangle is a square: " + rect.isSquare(rect.length, rect.width));
	}
}

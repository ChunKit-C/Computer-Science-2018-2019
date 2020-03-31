import java.util.Scanner;

class anyRhombus {
	double diag1;
	double diag2;
	double side1;
	double side2;
	double side3;
	double side4;

	public anyRhombus() {
		diag1 = 0;
		diag2 = 0;
		side1 = 0;
		side2 = 0;
		side3 = 0;
		side4 = 0;
	}

	public anyRhombus(double newDiag1, double newDiag2) {
		diag1 = newDiag1;
		diag2 = newDiag2;
	}

	public double Area() {
		return (this.diag1 * this.diag2) / 2;
	}

	public double side() {
		side1 = Math.sqrt((this.diag1 / 2) * (this.diag1 / 2) + (this.diag2 / 2) * (this.diag2 / 2));
		side2 = side1;
		side3 = side1;
		side4 = side1;
		return side1;
	}

	public double Perimeter() {
		return (4*side1);
	}
}

public class rhombus {

	public static void main(String[] args) {

		Scanner rhombus = new Scanner(System.in);
		anyRhombus rhomb = new anyRhombus();

		System.out.println("Enter diag1 of the rhombus:");
		rhomb.diag1 = rhombus.nextInt();

		System.out.println("Enter diag2 of the rhombus:");
		rhomb.diag2 = rhombus.nextInt();

		System.out.println("\n\nThe size of all sides are " + rhomb.side());
		
		System.out.println("The area of the rhombus is " + rhomb.Area());
		System.out.println("The perimeter of the rhombus is " + rhomb.Perimeter());

	}

}

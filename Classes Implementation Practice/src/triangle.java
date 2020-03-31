import java.util.Scanner;

class anyTriangle {

	static double side1;
	static double side2;
	static double side3;

	public anyTriangle() {
		side1 = 0;
		side2 = 0;
		side3 = 0;
	}

	public static boolean isValid() {
		boolean isTriangle = false;

		if (side1 > 0 && side2 > 0 && side3 > 0)
			if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
				isTriangle = true;
			} else {
				isTriangle = false;
			}
		return isTriangle;
	}

	public static boolean isIsosceles(boolean isosceles) {

		if (side1 == side2 && side1 != side3 && side2 != side3) {
			if (side2 == side3 && side2 != side1 && side3 != side1) {
				if (side1 == side3 && side1 != side2 && side3 != side2) {
					isosceles = true;
				}
			}
		} else {
			isosceles = false;
		}
		return isosceles;
	}

	public static boolean isEquilateral(boolean equilateral) {
		if (side1 == side2 && side1 == side3 && side2 == side3) {
			equilateral = true;
		} else {
			equilateral = false;
		}
		return equilateral;
	}
}

public class triangle {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		anyTriangle anyTriangleVar = new anyTriangle();

		System.out.println("Enter side1 of the triangle");
		anyTriangleVar.side1 = input.nextDouble();

		System.out.println("Enter side2 of the triangle");
		anyTriangleVar.side2 = input.nextDouble();

		System.out.println("Enter side3 of the triangle");
		anyTriangleVar.side3 = input.nextDouble();

		System.out.println("the triangle is " + anyTriangleVar.isValid());

		if (anyTriangleVar.isIsosceles(true)) {
			System.out.println("the triangle is an isoceles triangle");
		} else {
			System.out.println("the triangle is not an isoceles triangle");
		}

		if (anyTriangleVar.isEquilateral(true)) {
			System.out.println("the triangle is an equilateral triangle");
		} else {
			System.out.println("the triangle is not an equilateral triangle");
		}
	}

}

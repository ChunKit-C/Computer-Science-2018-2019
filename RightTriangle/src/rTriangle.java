import java.util.Scanner;

class rightTriangle {

	double side1;
	double side2;

	public rightTriangle() {
		side1 = 0;
		side2 = 0;
	}

	public rightTriangle(double leg1, double leg2) {
		side1 = leg1;
		side2 = leg2;
	}

	public double getHypotenuse(){
		return(Math.sqrt(side1*side1 + side2*side2));
	}
	
	public double area(){
		return (side1*side2)/2;
	}
	
	public double perimeter(){
		return (side1 + side2 + getHypotenuse());
	}
}
	
	public  class rTriangle{
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		rightTriangle rightTriangleVar = new rightTriangle();
		
		System.out.println("Enter side1 of the triangle");
		rightTriangleVar.side1 = input.nextDouble();
		
		System.out.println("Enter side2 of the triangle");
		rightTriangleVar.side2 = input.nextDouble();
		
		System.out.println("The hypotenuse of the triangle is " + rightTriangleVar.getHypotenuse());
		System.out.println("The area of the triangle is " + rightTriangleVar.area());
		System.out.println("The perimeter of the triangle is " + rightTriangleVar.perimeter());
	}

}
	


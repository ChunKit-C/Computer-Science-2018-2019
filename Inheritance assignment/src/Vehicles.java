import java.util.Scanner;

class Vehicle {

	 int mileage;
	 int year;

	public Vehicle() {
		mileage = 0;
		year = 0;
	}

	public static String displayInfo(int mileage, int year) {
		return "Mileage: " + mileage + "\nYear: " + year;
	}

	public int vehicleAge() {// this method calculates the vehicle's age
		int vAge;
		vAge = 2019 - year;
		return vAge;
	}

	public double averageM() {// this method calculates the average mileage
		double aMileage;
		aMileage = (double)mileage / vehicleAge();
		return aMileage;

	}
}

class Car extends Vehicle {
	static int numberOfPassangers;
	static int numberOfDoors;
	static int engineSize;
	static String Make;
	static String Model;

	public Car() {
		super();
		this.numberOfPassangers = 0;
		this.numberOfDoors = 0;
		this.engineSize = 0;
		this.Make = "";
		this.Model = "";
	}

	public int carAge() {// this method returns the car age
		return super.vehicleAge();
	}

	public String displayInfo() {// this method displays the inputed car information

		String infoCar = "\nCar Info: \n\n" + super.displayInfo(mileage, year) + "\nCar age: " + super.vehicleAge()
				+ "\nAverage mileage: " + super.averageM() + "\nNumber of passangers: " + this.numberOfPassangers
				+ "\nNumber of doors: " + this.numberOfDoors + "\nEngine size: " + this.engineSize + "\nMake: "
				+ this.Make + "\nModel: " + this.Model;
		return infoCar;
	}
}

class Motorcycle extends Vehicle {

	static String Make;
	static int capacity;

	public Motorcycle() {
		super();
		this.Make = "";
		this.capacity = 0;

	}

	public int motorcycleAge() {// this method returns the car age
		return super.vehicleAge();
	}

	public String displayInfo() {// this method displays the inputed motorcycle information
		String infoMotorcycle = "\nMotorcycle Info: \n\n" + super.displayInfo(mileage, year) + "\nMotorcycle age: "
				+ super.vehicleAge() + "\nMake: " + this.Make + "\nCapacity: " + this.capacity;
		return infoMotorcycle;
	}

}

public class Vehicles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Car CarVar = new Car();
		Motorcycle MotorcycleVar = new Motorcycle();

		for (int i = 0; i < 2; i++) { // this for loop makes it so the user inputs 2 cars and 2 motorcycles
			System.out.println("Car " + (i + 1) + ": ");
			System.out.println("Mileage:");
			CarVar.mileage = input.nextInt();
			System.out.println("Year:");
			CarVar.year = input.nextInt();
			System.out.println("Number of passangers:");
			CarVar.numberOfPassangers = input.nextInt();
			System.out.println("Number of doors:");
			CarVar.numberOfDoors = input.nextInt();
			System.out.println("Engine size:");
			CarVar.engineSize = input.nextInt();
			input.nextLine();
			System.out.println("Make:");
			CarVar.Make = input.nextLine();
			System.out.println("Model:");
			CarVar.Model = input.nextLine();
			System.out.println(CarVar.displayInfo());

			System.out.println("\n\nMotorcycle " + (i + 1) + ": ");
			System.out.println("Mileage:");
			MotorcycleVar.mileage = input.nextInt();
			System.out.println("Year:");
			MotorcycleVar.year = input.nextInt();
			input.nextLine();
			System.out.println("Make:");
			MotorcycleVar.Make = input.nextLine();
			System.out.println("Capacity:");
			MotorcycleVar.capacity = input.nextInt();
			System.out.println(MotorcycleVar.displayInfo());
			System.out.println("\n\n");
		}
	}
}

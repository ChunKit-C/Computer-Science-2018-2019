import java.text.DecimalFormat;
import java.util.Scanner;



class PiggyBank { //creates variables

	static double pennies = 0;
	static double nickels = 0;
	static double dimes = 0;
	static double quarters = 0;

	static int numberpennies = 0;
	static int numbernickels = 0;
	static int numberdimes = 0;
	static int numberquarters = 0;

	static double totalAmount = 0;
	static double withdrawAmount = 0;
	//static boolean enoughFunds = false;
	static int Ptotal = 0;

	public PiggyBank() {

	}

	public static double AddPennies (int numberOfPenniesToAdd) { 
		pennies = pennies + numberOfPenniesToAdd; 
		return pennies; //Adding pennies using methods 
	}

	public static double AddNickels (int numberOfDimesToAdd) { 
		nickels = nickels + numberOfDimesToAdd; 
		return nickels; //Adding Nickels using methods 
	}

	public static double AddDimes (int numberOfNickelsToAdd) { 
		dimes = dimes + numberOfNickelsToAdd;
		return dimes; //Adding Dimes using methods 
	}

	public static double AddQuarters (int numberOfQuartersToAdd) { 
		quarters = quarters + numberOfQuartersToAdd; 
		return quarters; //Adding quarters using methods  
	}
	
	public static double ShowAmount() {//method goes to sumAmount method to calculate the total amount
		sumAmount();
		return totalAmount;
	}

	public static void sumAmount() { //method calculates total amount
		totalAmount = (pennies * 0.01) + (nickels * 0.05) + (dimes * 0.10) + (quarters * 0.25) + totalAmount;
	}
	
	public boolean Withdraw(double pennies, double nickels, double dimes, double quarters) {
		boolean enoughFunds = false;
		int countPennies = 0;
	    int countNickles = 0;
		int countDimes = 0;
		int countQuarters = 0;
		
		Ptotal = (int)(totalAmount * 100); 
		numberquarters = (int) (Ptotal / 25);
		System.out.println("Nb Q "+ numberquarters);
		
		if (numberquarters >= quarters) {  
			quarters = numberquarters;
			Ptotal = numberquarters - Ptotal;
			countQuarters++;// increase the amount of quarters used
		}
	
		numberdimes = (int) (Ptotal / 10);
		System.out.println("Nb D "+ numberdimes);
		if (numberdimes >= dimes) { 
			dimes = numberdimes;
			Ptotal = numberdimes - Ptotal;
			countDimes++;// increase the amount of dimes used
		}
		numbernickels = (int) (Ptotal /5);
		if (numbernickels >= nickels) {
			nickels = numbernickels;
			Ptotal = numbernickels - Ptotal;
			countNickles++;// increase the amount of nickels used
		} 
		numberpennies = (int) (Ptotal / 1);
		if (numberpennies >= pennies) {
			pennies = Ptotal;
			Ptotal = numberpennies - Ptotal;
			countPennies++; // increase the amount of pennies used
		}
		if (Ptotal >= 0) { // if statement to see if the withdraw is possible
			enoughFunds = true;
		} else {
			enoughFunds = false;
		}
		return enoughFunds;
		
	}
	
	
	
	/*public boolean Withdraw(double totalAmount, int Ptotal) { //checks if the withdraw is possible
		// method takes out the least amount of coins for the withdrawl and shows how many coins were used
		boolean enoughFunds=false;
		
		
		System.out.println("total Amount "+ totalAmount);
		Ptotal = (int)(totalAmount * 100);
		numberquarters = (int) (Ptotal / 25);
		System.out.println("Nb Q "+ numberquarters);
		
		if (numberquarters >= quarters) {  
			quarters = numberquarters;
			Ptotal = numberquarters - Ptotal;
			countQuarters++;// increase the amount of quarters used
		}
	
		numberdimes = (int) (Ptotal / 10);
		System.out.println("Nb D "+ numberdimes);
		if (numberdimes >= dimes) { 
			dimes = numberdimes;
			Ptotal = numberdimes - Ptotal;
			countDimes++;// increase the amount of dimes used
		}
		numbernickels = (int) (Ptotal /5);
		if (numbernickels >= nickels) {
			nickels = numbernickels;
			Ptotal = numbernickels - Ptotal;
			countNickles++;// increase the amount of nickels used
		} 
		numberpennies = (int) (Ptotal / 1);
		if (numberpennies >= pennies) {
			pennies = Ptotal;
			Ptotal = numberpennies - Ptotal;
			countPennies++; // increase the amount of pennies used
		}
				
		if (Ptotal >= 0) { // if statement to see if the withdraw is possible
			enoughFunds = true;
		} else {
			enoughFunds = false;
		}
		
		return enoughFunds;
	}
	*/
	


}
public class mySavings {

	public static void main(String[] args) {// method creates a menu for the user which has options to choose from
		int input = 0;
		int numberOfPenniesToAdd;
		int numberOfDimesToAdd;
		int numberOfNickelsToAdd;
		int numberOfQuartersToAdd;

		PiggyBank PiggyBankVar = new PiggyBank();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		boolean enoughFunds;
		int countPennies;
	    int countNickles;
		int countDimes;
		int countQuarters;
		
		do { //creates option menu
			System.out.println(
					"0. Exit\n1. Show Total in the bank\n2. Add pennies\n3. Add nickels\n4. Add dimes\n5. Add quarters\n6. Withdrawl");
			System.out.println("\nEnter your choice: ");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextInt();
			System.out.println("");

			if (input == 1) { // if user inputs 1
				Double.toString(PiggyBankVar.totalAmount);
				System.out.println("total is :$" + decimalFormat.format(PiggyBankVar.ShowAmount()) + "\n");
			} else if (input == 2) {// if user inputs 2
				System.out.print("Pennies: ");
				numberOfPenniesToAdd = scanner.nextInt();
				PiggyBankVar.AddPennies(numberOfPenniesToAdd);
 			} else if (input == 3) {// if user inputs 3
				System.out.print("Nickels: ");
				numberOfNickelsToAdd = scanner.nextInt();
				PiggyBankVar.AddNickels(numberOfNickelsToAdd);
 			} else if (input == 4) {// if user inputs 4
				System.out.print("Dimes: ");
				numberOfDimesToAdd = scanner.nextInt();
				PiggyBankVar.AddDimes(numberOfDimesToAdd);				
 			} else if (input == 5) {// if user inputs 5
				System.out.print("Quarters: ");
				numberOfQuartersToAdd = scanner.nextInt();
				PiggyBankVar.AddQuarters(numberOfQuartersToAdd);
		 	} else if (input == 6) {// if user inputs 6

				System.out.print("Withdraw ammount: ");
				PiggyBankVar.withdrawAmount = scanner.nextDouble();
				enoughFunds=PiggyBankVar.Withdraw(PiggyBankVar.pennies, PiggyBankVar.nickels, PiggyBankVar.dimes, PiggyBankVar.quarters);
				
				if (enoughFunds == true) {
					System.out.println("The withdraw can be made");
					System.out.println("You can take out:" + PiggyBankVar.withdrawAmount);
					System.out.println("Pennies: " + PiggyBankVar.countPennies);
					System.out.println("Nickels: " + PiggyBankVar.countNickles);
					System.out.println("Dimes: " + PiggyBankVar.countDimes);
					System.out.println("Quarters: " + PiggyBankVar.countQuarters);

				}
				if(enoughFunds == false) {
					System.out.println("The withdraw cannot be made.");
				}

			} else if (input == 0) {// if user inputs 0 exit
				System.exit(0);
			} else {// if user inputs number that is not an option
				System.out.print("Number inputted is not a choice!\n\n");
			}

		} while (input != 0);

		System.out.println(" ");
		System.out.println(" ");

	}

}
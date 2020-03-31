import java.util.Scanner;
import java.text.DecimalFormat;

public class addCoins {
	public static void getDollarAmount(int pennies, int nickels, int dimes, int quarters){
		double totalValue = 0;
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		if (pennies>0){
			totalValue = pennies*0.01;
		}
		if (nickels>0){
			totalValue = totalValue + nickels*0.05;
		}
		if (dimes>0){
			totalValue = totalValue + dimes*0.10;
		}
		if (quarters>0){
			totalValue = totalValue +  quarters*0.25;
		}
		Double.toString(totalValue);
		System.out.print("Total: $" + decimalFormat.format(totalValue));
	
	
	}

	public static void main(String[] args) {
		int pennies, nickels, dimes, quarters;
		Scanner pocketChange = new Scanner(System.in);
		
		System.out.print("Enter your total coins: \n\n");
		
		System.out.print("Pennies: ");
		pennies = pocketChange.nextInt();
		
		System.out.print("Nickels: ");
		nickels = pocketChange.nextInt();
		
		System.out.print("Dimes: ");
		dimes = pocketChange.nextInt();
		
		System.out.print("Quarters: ");
		quarters = pocketChange.nextInt();
		pocketChange.close();
		getDollarAmount(pennies, nickels, dimes, quarters);
	}

}

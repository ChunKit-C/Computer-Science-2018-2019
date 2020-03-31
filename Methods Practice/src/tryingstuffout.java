import java.util.Scanner;

public class tryingstuffout {

	public static void main(String[] args) {
		int[][] array = new int[10][10];

		int row = 0;
		int col = 0;
		
		for (row = 0; row < array.length; row++) { // rows length
			for (col = 0; col < array[row].length; col++) { // col length
				array[row][col] = (int) (Math.random() * 100);
				System.out.print(array[row][col] + "\t");
			}
			System.out.println("");
		}
	}

}

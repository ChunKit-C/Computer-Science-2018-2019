import java.text.DecimalFormat;

public class Array_1D_Practice {

	public static void main(String[] args) {

		int[] array = new int[10];
		int total = 0;
		DecimalFormat decimalFormat = new DecimalFormat(".#");
		System.out.println("row number: value in row");

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * 200) - 100);
			System.out.println(i + ": " + array[i]);

		}
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		System.out.println("\nSum of all numbers: " + total);

		total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		System.out.println("Average of all numbers: " + decimalFormat.format(total / array.length));

		int max = array[0], min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("The largest value is: " + max);
		System.out.println("The smallest value is: " + min);

		int positive = 0, negative = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0) {
				positive++;
			} else {
				negative++;
			}

		}
		System.out.println("The ammount postive values are: " + positive);
		System.out.println("sThe ammount negative value are: " + negative);
	}

}

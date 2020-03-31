import java.text.DecimalFormat;
import java.util.Scanner;

public class sortingAssignment {
	public static int temp;
	public static int previousIndex;
	public static float time;
	public static int timeSent;
	public static DecimalFormat timeFormat = new DecimalFormat(".##");

	
	public static void descendingOrder(int[] items) {
		for (int i = 0; i < items.length / 2; i++) { // for loop swaps the first
			// element with the
			// last, the second with
			// the second last and
			// so on
			temp = items[i];
			items[i] = items[items.length - i - 1];
			items[items.length - i - 1] = temp;
		} // end of for

	}

	public static void Sort_Ascending_Insertion(int[] items) { // method sorts
																// array in
																// ascending
																// order

		for (int index = 1; index < items.length; index++) {
			temp = items[index];
			previousIndex = index - 1;
			while ((items[previousIndex] > temp) && (previousIndex > 0)) {
				items[previousIndex + 1] = items[previousIndex];
				previousIndex -= 1; // decrease index to compare current
			} // item with next previous item
			if (items[previousIndex] > temp) {
				/* shift item in first element up into next element */
				items[previousIndex + 1] = items[previousIndex];
				/* place current item at index 0 (first element) */
				items[previousIndex] = temp;
			} else {
				/* place current item at index ahead of previous item */
				items[previousIndex + 1] = temp;
			}
		}
	}

	public static void Sort_Descending_Insertion(int[] items) { // method sorts
																// array in
																// descending
																// order

		for (int index = 1; index < items.length; index++) { // for loop sorts
																// array in
																// ascending
																// order
			temp = items[index];
			previousIndex = index - 1;
			while ((items[previousIndex] > temp) && (previousIndex > 0)) {
				items[previousIndex + 1] = items[previousIndex];
				previousIndex -= 1;
			}
			if (items[previousIndex] > temp) {
				items[previousIndex + 1] = items[previousIndex];
				items[previousIndex] = temp;
			} else {
				items[previousIndex + 1] = temp;
			}
		}
	}

	private static void merge(int[] items, int start, int mid, int end) { // method sorts array from low to high using merge sort
		int[] temp = new int[items.length];
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;
		while (!(pos1 > mid && pos2 > end)) { // while loop sorts array
			if ((pos1 > mid) || ((pos2 <= end) && (items[pos2] < items[pos1]))) {
				temp[spot] = items[pos2];
				pos2 += 1;
			} else {
				temp[spot] = items[pos1];
				pos1 += 1;
			}
			spot += 1;
		}
		/* copy values from temp back to items */
		for (int i = start; i <= end; i++) {
			items[i] = temp[i];
		}
	}

	public static void Sort_Ascending_MergeSort(int[] items, int start, int end) { // method sorts items from low to high by calling merge method
		if (start < end) {
			int mid = (start + end) / 2;
			Sort_Ascending_MergeSort(items, start, mid);
			Sort_Ascending_MergeSort(items, mid + 1, end);
			merge(items, start, mid, end);
		}
	}

	public static void Sort_Descending_MergeSort(int[] items, int start, int end) { // method sorts items from low to high by calling merge method
		if (start < end) {
			int mid = (start + end) / 2;
			Sort_Ascending_MergeSort(items, start, mid);
			Sort_Ascending_MergeSort(items, mid + 1, end);
			merge(items, start, mid, end);
		}
	}

	public static void displayArray(int[] array) { // method displays array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n");
		time = (int) System.currentTimeMillis() - timeSent;
		System.out.println("Sorting took: " + time + " Ms");
	}

	public static void main(String[] args) {
		int[] array = new int[200];
		int input = 0;
		java.lang.System.currentTimeMillis();
		do { // creates option menu
			System.out.println("Menu:\n");
			System.out.println(
					"0. Exit\n1. Generate " + array.length + " random values \n2. Sort_Ascending (Insertion)\n3. Sort_Descending (Insertion)\n4. Sort_Ascending (MergeSort)\n5. Sort_Descending (MergeSort)\n");
			System.out.println("\nEnter your choice: ");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextInt();
			System.out.println("");

			if (input == 1) { // if user inputs 1
				for (int i = 0; i < array.length; i++) {
					array[i] = (int) ((Math.random() * 200));
					System.out.print(array[i] + ", ");
				}
				System.out.println("\n");
			} else if (input == 2) {// if user inputs 2
				timeSent = (int) System.currentTimeMillis();
				Sort_Ascending_Insertion(array);
				displayArray(array);
			} else if (input == 3) {// if user inputs 3
				timeSent = (int) System.currentTimeMillis();
				Sort_Descending_Insertion(array);
				descendingOrder(array);
				displayArray(array);
			} else if (input == 4) {// if user inputs 4
				timeSent = (int) System.currentTimeMillis();
				Sort_Ascending_MergeSort(array, 0, (array.length - 1));
				displayArray(array);
			} else if (input == 5) {// if user inputs 5
				timeSent = (int) System.currentTimeMillis();
				Sort_Descending_MergeSort(array, 0, (array.length - 1));
				descendingOrder(array);
				displayArray(array);
			} else if (input == 0) {// if user inputs 0 exit
				System.exit(0);
			} else {// if user inputs number that is not an option
				System.out.print("Number inputted is not a choice!\n\n");
			}
		} while (input != 0);
	}

}

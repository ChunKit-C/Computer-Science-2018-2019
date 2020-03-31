import java.util.Scanner;

public class gradeConverter {
	public static void Converter(int grade) {
		if (grade == 100) {
			System.out.print("Your grade for this class is an A+");
		}
		if (grade >= 89 && grade < 100) {
			System.out.print("Your grade for this class is a B+");
		}
		if (grade >= 79 && grade < 89) {
			System.out.print("Your grade for this class is a C+");
		}
		if (grade >= 69 && grade < 79) {
			System.out.print("Your grade for this class is a D+");
		}
		if (grade >= 50 && grade < 69) {
			System.out.print("Your grade for this class is a D");
		}
		if (grade < 50) {
			System.out.print("Your grade for this class is a F");
		}
	}

	
	public static void main(String[] args) {
		int grade;
		Scanner gradeinputted = new Scanner(System.in);

		System.out.print("Enter a grade mark: ");
		grade = gradeinputted.nextInt();
		gradeinputted.close();
		Converter(grade);
	}

}

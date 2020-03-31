import java.util.Scanner;

import org.w3c.dom.css.Rect;

class info {
	public static String firstName;
	public static String lastName;
	public static String hobby;
	public static int age;
	
	public info() {
		String firstName = "";
		String lastName = "";
		String hobby = "";
		String info = "";
		int age = 0;
		int mark = 0;

	}

	public static int Grade(int age) {
 		int mark = 0;
		switch (age) {
		case 1:
			mark = 10;
			break;
		case 2:
			mark = 20;
			break;
		case 3:
			mark = 30;
			break;
		case 4:
			mark = 40;
			break;
		case 5:
			mark = 50;
			break;
		case 6:
			mark = 60;
			break;
		case 7:
			mark = 70;
			break;
		case 8:
			mark = 80;
			break;
		case 9:
			mark = 85;
			break;
		case 10:
			mark = 90;
			break;
		case 11:
			mark = 95;
			break;
		case 12:
			mark = 100;
			break;

		}
 		return mark;

	}

	public static String getInfo(String firstName, String lastName, String hobby, int age, int mark) {
		String info = "First name: " + firstName + "\nLast name: " + lastName + "\nHobby: " + hobby + "\nAge: " + age + "\nMark: " + mark;
		return info;

	}

}

public class student {

	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);
		info studentInfo = new info();
		
		System.out.println("Enter first name: ");
		studentInfo.firstName = input.nextLine();

		System.out.println("Enter last name: ");
		studentInfo.lastName = input.nextLine();

		System.out.println("Enter hobby: ");
		studentInfo.hobby = input.nextLine();

		System.out.println("Enter age: ");
		studentInfo.age = input.nextInt();
 		
		System.out.println("\n\nInfo: ");
		System.out.println(studentInfo.getInfo(studentInfo.firstName,studentInfo.lastName,studentInfo.hobby,studentInfo.age,studentInfo.Grade(studentInfo.age)));
 
	}

}

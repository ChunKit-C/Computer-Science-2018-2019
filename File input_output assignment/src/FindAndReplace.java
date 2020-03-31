import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

class FindAndReplace {
	public static String fileName;
	public static String fileInput;
	public static String searchWord;
	public static String replaceWord;
	//public static File file = new File("data/data");

	public FindAndReplace() {
		String fileName = "";
		String fileInput = "";
		String searchWord = "";
		String replaceWord = "";
	}

	public static void main(String[] args) throws IOException {
 
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter file name: ");
		fileName = scanner.nextLine();
		System.out.println("Enter file info: ");
		fileInput = scanner.nextLine();
		System.out.println("Enter a search word or phrase: ");
		searchWord = scanner.nextLine();
		System.out.println("Enter a replacement word or phrase: ");
		replaceWord = scanner.nextLine();
		System.out.println("\nContent before: " + fileInput);
		appendToText();
		//readText();

		
		

		System.out.println("\n\nContent after: ");
		replacePhrase();
		//printText(fileInput);
	} // end main

	/*public static void printText(String destination) throws FileNotFoundException {
		Scanner sc = new Scanner("/" + destination); // initializes the scanner
		//System.out.println(sc.next());
		while (true) {
			try {
				String line = sc.nextLine(); // gets first line
				System.out.println(line);
			} catch (NoSuchElementException e) {
				break;
			} // end of catch
		} // end of while
		sc.close();
	}*/

	public static void replacePhrase() {// method finds and replaces inputed word
		BufferedReader reader = null;
		FileWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			// Reading all the lines of inputed text
			String line = reader.readLine();
			while (line != null) {
				fileInput = fileInput + line;
				line = reader.readLine();
			}
			// Replacing the search word if found with the new word
			String newText = fileInput.replaceAll(searchWord, replaceWord);
			// Rewriting the input text file with newText
			writer = new FileWriter(fileName);
			writer.write(newText);
			String finalText = fileInput.replaceAll(newText, newText);
			// Rewriting the input text file with newText
			writer = new FileWriter(fileName);
			writer.write(finalText);
			System.out.println(finalText);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*public static void readText() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally { // always close the file
			if (br != null)
				try {
					br.close();
				} catch (IOException ioe2) {
					// just ignore it
					System.out.println(ioe2);
				}
		}
	}*/

	public static void appendToText() { // method creates file
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName)); // file
			bw.write(fileInput); // text to write in file
			bw.newLine(); // new line
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally { // always close the file
			if (bw != null)
				try {
					bw.close();
				} catch (IOException ioe2) {
					// just ignore it
					System.out.println(ioe2);
				}
		} // end try/catch/finally
	} // end appendToText
}

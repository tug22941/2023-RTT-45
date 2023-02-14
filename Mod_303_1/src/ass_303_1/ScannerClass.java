package ass_303_1;
import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//assign input to name and age variables
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Enter your age: ");
		String age = input.nextLine();
		
		//close the Scanner object
		input.close();
		
		//display output with user input data
		System.out.println();
		System.out.println("Your name is " + name + "\n" +
						   "You are " + age + " years old");

	}

}

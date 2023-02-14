package ass_303_3;
import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Loops loops = new Loops();
		//loops.loopTable();
		loops.findGCD();
		//loops.findFutureTuition();
		
		System.out.println();
	}
	
	//Problem 1
	public void loopTable() {
		String multiString = "";
		for(int i=1; i<=12; i++) {
			for(int j=1; j<=12; j++) {
				int multiple = i * j;
				multiString += multiple + " ";
			}
			System.out.println(multiString);
			multiString = "";
		}
	}
	
	//Problem 2
	public void findGCD() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two positive integer: ");
		int val1 = input.nextInt();
		int val2 = input.nextInt();
		
		int minVal = Math.min(val1, val2);
		int GCD = 0;
		for(int i=1; i<=minVal; i++) {
			if(val1 % i == 0 && val2 % i == 0) {
				GCD = i;
			}
		}
		System.out.println("The GCD of " + val1 + " and " + val2 + " is: " + GCD );
	}
	
	//Problem 3
	public void findFutureTuition() {
		int tuition = 10000;
		int  doubTuition = tuition * 2;
		
		int year = 0;
		while (tuition < doubTuition) {
			tuition = (int)(1.07 * tuition);
			year++;
			System.out.println("After " + year + " Year Tuition will be " + tuition);
		}
		System.out.println();
		System.out.println("Tuition will be doulbed after " + year + " year(s)");

	}
	

}

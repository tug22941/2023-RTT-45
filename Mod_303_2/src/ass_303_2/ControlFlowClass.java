package ass_303_2;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ControlFlowClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 7;
		
		//Problem 1
		x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}

		
		//Problem 2
		x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}else {
			System.out.println("Greater than 10");
		}

		
		//Problem 3
		x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}else if (x > 10 && x < 20) {
			System.out.println("Between 10 and 20");
		}else {
			System.out.println("Greater than or equal to 20");
		}
		
		//Problem 4
		x = 5;
		if(x < 10 || x > 20) {
			System.out.println("Out of range");
		}else if(x >=10 && x <=20) {
			System.out.println("In range");
		}
		
		//problem 5
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Score: ");
		int grade = scanner.nextInt();
		
		if(grade >= 90 && grade <= 100) {
			System.out.println("A");
		}else if(grade >= 80 && grade <= 89) {
			System.out.println("B");
		}else if(grade >= 70 && grade <= 79) {
			System.out.println("C");
		}else if(grade >= 60 && grade <= 69) {
			System.out.println("D");
		}else if(grade < 60){
			System.out.println("F");
		}else {
			System.out.println("Score out of range");
		}
		
		//Problem 6
		System.out.println("Enter a number between 1 and 7");
		int val = scanner.nextInt();
		String day = "";
		
		switch(val) {
			case 1: day = "Sunday";
				break;
			case 2: day = "Monday";
				break;
			case 3: day = "Tuesday";
				break;
			case 4: day = "Wednesday";
				break;
			case 5: day = "Thursday";
				break;
			case 6: day = "Friday";
				break;
			case 7: day = "Saturday";
				break;
			default:  day = "Non-exsisting";
				break;
		}
		System.out.println("The " + val + " day of the week is " + day);
		
		//Problem 7
		System.out.println("Enter your filing status: ");	
		String status = scanner.next();
		System.out.println("Enter your income");
		double income = scanner.nextDouble();
		
		float taxRate = 0f;
		switch(status) {
		case "Single":
			if(income >= 0 && income <= 8350) {taxRate = 0.10f;}
			if(income >= 8351 && income <= 33950) {taxRate = 0.15f;}
			if(income >= 33981 && income <= 82250) {taxRate = 0.25f;}
			if(income >= 82251 && income <= 171550) {taxRate = 0.28f;}
			if(income >= 171551 && income <= 372950) {taxRate = 0.33f;}
			if(income >= 372951) {taxRate = 0.35f;}
			break;
		case "Married Filing Jointly":
			if(income >= 0 && income <= 16700) {taxRate = 0.10f;}
			if(income >= 16701 && income <= 67900) {taxRate = 0.15f;}
			if(income >= 67901 && income <= 137050) {taxRate = 0.25f;}
			if(income >= 137051 && income <= 208850) {taxRate = 0.28f;}
			if(income >= 208851 && income <= 372950) {taxRate = 0.33f;}
			if(income >= 372951) {taxRate = 0.35f;}
			break;
		case "Qualifying Widow(er)":
			if(income >= 0 && income <= 16700) {taxRate = 0.10f;}
			if(income >= 16701 && income <= 67900) {taxRate = 0.15f;}
			if(income >= 67901 && income <= 137050) {taxRate = 0.25f;}
			if(income >= 137051 && income <= 208850) {taxRate = 0.28f;}
			if(income >= 208851 && income <= 372950) {taxRate = 0.33f;}
			if(income >= 372951) {taxRate = 0.35f;}
			break;
		case "Married Filing Separately":
			if(income >= 0 && income <= 8350) {taxRate = 0.10f;}
			if(income >= 8351 && income <= 33950) {taxRate = 0.15f;}
			if(income >= 33981 && income <= 68525) {taxRate = 0.25f;}
			if(income >= 68526 && income <= 104425) {taxRate = 0.28f;}
			if(income >= 104426 && income <= 186475) {taxRate = 0.33f;}
			if(income >= 186476) {taxRate = 0.35f;}
			break;
		case "Head of Household":
			if(income >= 0 && income <= 11950) {taxRate = 0.10f;}
			if(income >= 11951 && income <= 45500) {taxRate = 0.15f;}
			if(income >= 45501 && income <= 117450) {taxRate = 0.25f;}
			if(income >= 117451 && income <= 190200) {taxRate = 0.28f;}
			if(income >= 190201 && income <= 372950) {taxRate = 0.33f;}
			if(income >= 372951) {taxRate = 0.35f;}
			break;
		default:
			income = 0;
			taxRate = 0;
		}
		double tax = (income * taxRate);
		System.out.printf("You owe %.2f in taxes.", tax);
		//DecimalFormat df = new DecimalFormat("0.00");
		//System.out.println("You owe " + df.format(tax) + " in taxes.");
		
		scanner.close();
		
		
	}
}

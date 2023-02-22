package sba1_worksheet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //create scanner
		Random rand = new Random(0);		 //
		
		System.out.print("Enter integer value for array size: ");
		int n = Integer.parseInt(sc.nextLine());
		String[] a = new String[n];
		
		System.out.println("Enter " + n + " lowercase Strings to fill the array");
		System.out.println("---------------------------------");
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLine();
		
		//create MyList object
		MyList obj = new ArrayToList();
		
		//convert array of string into array-list of strings
		obj.convert(a);
		
		//replace random number of array-list elements with "" string
		int x = rand.nextInt(n);
		for (int i = 0; i < x; i++)
			obj.replace(rand.nextInt(n));

		//create new array-list of strings without "" elements
		ArrayList<String> s = obj.compact();

		//iterate through the entire new array-list; start at 0
		//if the first character of every element is lower cased (ASCI 97-122) 
			//TRY to Throw custom exception with specified string
			//CATCH errors and print custom exception inherited message
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122) {
				try {
					throw new InvalidStringException("This is an invalid string");
				} catch (InvalidStringException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		sc.close();
	}
}

package ass_303_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Eric's Github Source Code
public class ArrayExamplesEx {

	public static void main(String[] args) {
		ArrayExamplesEx ae = new ArrayExamplesEx();
		//ae.createArray();
		ae.maxRandomValue(100, 0, 10);

	}

	//Method created by Eric
	public void createArray() {
		// notice that we are using a new keyword with the array even tho its a
		// primitive
		int[] values = new int[10];

		// here we use () to create a new object which is essentially call the
		// constructor of the object
		String str = new String();

		// not here when we are creating an array we are not using () because we need to
		// specify the
		// array size using []
		String[] strings = new String[10];

		strings[0] = "a"; // pos 0
		strings[1] = "b"; // pos 1
		strings[2] = "c"; // pos 2
		strings[9] = "z"; // pos 9

		// to a value from the array we use
		System.out.println(strings[2]);

		// if we do this with a list
		List<String> list = new ArrayList<>();
		list.add("a"); // pos 0
		list.add("b"); // pos 1
		list.add("c"); // pos 2

		System.out.println(list.get(2));

		// creating an array with constants
		int[] constants = { 1, 5, 7, 9, 10 };
		String[] fileExt = { ".jpg", ".txt" , ".exe" };
		
		// first we look at old for loop on array
		for ( int pos = 0 ; pos < strings.length ; pos++ ) {
			System.out.println("Position " + pos + " = " + strings[pos]);
		}
		
		System.out.println("=================================");
		
		// we can also do a new for loop on array
		for ( String s : strings ) {
			System.out.println(s);
		}
		
		// the length of the array can be defined as a variable
		int len = 10;
		int[] lenArray = new int[len];
	}
	
	//Method created by Jonah
	public void maxRandomValue(int max, int min, int size) {
		int[] arr = new int[size];
		Random rand = new Random();
		System.out.println("Random Number Generator!");
		
		//fill the list with random values
		for(int i=0; i<size; i++) {
			int n = rand.nextInt(max - min + 1) + min;
			arr[i] = n;
			System.out.println(n);
		}
		
		//find the Max Value from list
		int maxVal = min;
		for(Integer e: arr) {
			if(e > maxVal) {
				maxVal = e;
			}
		}
		System.out.println("The Maximum Value is: " + maxVal);
		System.out.println();


		
		//find the Min Value form the list
		int minVal = max;
		for(Integer e: arr) {
			if(e < minVal) {
				minVal = e;
			}
		}
		System.out.println("The Minimum Value is: " + minVal);
		System.out.println();
	}
}

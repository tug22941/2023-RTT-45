package sba1_review;

import java.util.Arrays;

public class Question2 {

	//position	: 0 1 2 3 4 5
	//values 	: a b c d e f
	
	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] avg = {1, 2, 3, 4, 5, 6, 7};
		
		//print the message setting average
		q2.calculateAverage(avg);

		//print the message setting value
		q2.setValue(4);
		q2.setValue(5);
		q2.setValue(4);
		System.out.println();

		q2.move(50, 3);
		q2.move(30, 3);
		q2.move(30, 4);
		
	}//end of main
	
	//---------------------------
	
	//they are going going to give you the size
	private static final int ARRAY_SIZE = 5;
	private int[] arr;
	
	//constructor
	Question2(){
		//make a 1-based data structure for array of size 5
		//the key is to ignore the 0th element
		int[] array = new int[ARRAY_SIZE + 1];
		
		//initialize this entire array to a value ...-1
		Arrays.fill(array, -1);
		arr = array;
		System.out.println(Arrays.toString(arr));
	}
	
	//this will be in an interface
	//this will be the same implementation in both classes
	public void calculateAverage(int[] arr) {
		//calculate the average
		//decimal format the average to two places using : %.2f - system.out.printf
		//include newline character at the end of message
		
		double total = 0;
		for(int i : arr){
			total += (double)i;
		}
		double avg = total / arr.length;
		System.out.printf("Average:  %.2f \n", avg);
		System.out.println();
	}
	
	//this will be in an interface
	public  void setValue(int i) {
		//if the value at index is equal to -1 print message saying that you set the value to 1
		//& set value to 1
		//else print message saying that value was already set
		
		if(arr[i] == -1) {
			arr[i] = 1;
			System.out.println("index ["+i+"]"+ "value set to 1");
		}else {System.out.println("index ["+i+"]"+ "value is already set to " + 1);}
	}
	
	//this will be an extra function in one of the 2 classes
	public void move(int value, int id) {
		// if the value at array[id] == -1 then print a message saying "Value with id: {id} is moved to {value}" and set the value to 1
		// otherwise print a message saying "Value is already 1"
		if(arr[id] == -1) {
			System.out.println("Value with id: " + id + " is moved to " + value);
			arr[id] = value;
		}else {System.out.println("Value with id: " + id + " is already " + 1);}
		
	}
}

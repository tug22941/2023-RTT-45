package sba1_review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
	
	//Make sure that your output is EXACT
	//know the difference between null and empty space ("")
	//--------------------------------------------------------------------
	//String x = null - no object has been created , no memory allocated
	//String y = "" - an empty space string, memory has been allocated
	
	//  ( x == null ) is true
	//  ( x.equals("") ) will throw a NullPointerException
	//  ( y.equals("") ) is true
	//  ( y == null ) is false
	//--------------------------------------------------------------------

	public static void main(String[] args) {
		//how to transfer an array into an array list
		String[] arr = {"zero", "one", "two", "three", "four", "five"};
		
		Question1 q1 = new Question1();
		q1.convert(arr);
		
		//replace index with empty string
		q1.replace(2);
		q1.replace(4);
		
		// print compacted and should produce
		// zero, one, three, five
		List<String> compacted = q1.compact();
		//System.out.println(Arrays.toString(compacted.toArray()));
		
		
	}
	
	private ArrayList<String> list;
	Question1(){
		list = new ArrayList<String>();
	}
	
	public void convert(String[] arr) {
		//add the elements in the string array to the ArrayList of strings
		list.addAll(Arrays.asList(arr));
		System.out.println(Arrays.toString(list.toArray()));

	}
	
	public void replace(int index) {
		//in the ArrayList, write the value at index to be an empty string
		//print a message saying what the value of the position in the list is 
		//as well as the value you are overwriting it with
		System.out.println("The value at index " + index + " was " + list.get(index));
		list.set(index, "");
		System.out.println("The value at index " + index + " is now " + list.get(index));

		
		
	}
	
	public ArrayList<String> compact(){
		//remove all values in the arrayList that are empty strings
		//must use.equals, not ==
		
		list.removeIf(""::equals);
		System.out.println(Arrays.toString(list.toArray()));

		return list;
	}

}

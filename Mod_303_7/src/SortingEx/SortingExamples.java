package SortingEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingExamples {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(13);
		numbers.add(7);
		numbers.add(18);
		numbers.add(5);
		numbers.add(2);
		
		System.out.println("Before: " + numbers);
		
		//Collections is a set of tools
		//Use Static Utility method on the Collection object
		Collections.sort(numbers);
		System.out.println("After: " + numbers);
		
		//Use sort function on the array itself
		numbers.sort(Comparator.reverseOrder());
		
		//....
	}

}

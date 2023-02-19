package arr_lib_ex;

import java.util.Arrays;

public class ArrayLibrary {	
	
	
	//method for appending value at the end of an array
	public int[] appendElement(int[] arr, int value) {
		int[] copy = new int[arr.length+1];
		
		for(int i = 0; i<arr.length; i++) {
			copy[i] = i+1;
			if(i == arr.length-1) {copy[i+1] = value;}
		}
		return copy;
	}
	
	//method for inserting value into an array at a position
	public int[] insertElement(int[] arr, int value, int position) throws Exception{
		if(position < 0) {throw new NegativePositionException("Position must be greater than -1");}
		if(position > arr.length) {throw new PositionTooLargeException("Position must be less than " + arr.length);}
		int[] copy = appendElement(arr,0);
		//System.out.println("Copy Init: " + Arrays.toString(copy));
		
		//move all elements the copy array [starting at position to the end]  1 space to the right
		for(int i=position; i< arr.length; i++ ) {
			copy[i+1] = arr[i];
		}
		//System.out.println("Copy Shifted Right: " + Arrays.toString(copy));
		
		//insert our number at position
		for(int i=0; i<arr.length; i++) {
			if(i == position) {copy[i] = value;}
		}
		return copy;
	}
	
	
	//method for deleting value from an array at a position
	public int[] deleteElement(int[] arr, int position) {
		int[] copy = new int[arr.length-1];
		
		//create two counters to hold position
		//counter i for copy array; counter j for original array
		for(int i=0, j=0 ; i<arr.length-1; i++, j++) {
			if(i != position) {copy[i] = arr[j];}
			else {
				//permanently increment j counter;
				j++;
				copy[i] = arr[j];
			}
		}
		return copy;
	}
	
	//method for finding index position of value; return -1 for no value
	public int findPositionOfValue(int arr[], int value) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == value) {return i;}
		}
		return -1;
	}
	
	//method for bubble sorting an array in descending order
	public int[] bubbleSort(int arr[]) {
		
        int n = arr.length;
		//outer loop to move across full array
        for (int outer = 0; outer < n - 1; outer++)
        	//inner loop to move across current position array;
            for (int inner = 0; inner < n - outer - 1; inner++)
                if (arr[inner] < arr[inner + 1]) {
                    int temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = temp;
                }
		return arr;
	}
}

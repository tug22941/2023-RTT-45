package arr_lib_ex;

import java.util.Arrays;

public class ArrayLibraryMain {

	public static void main(String[] args) {

		ArrayLibrary al = new ArrayLibrary();
		int[] numbers = new int[10];
		
		//1 - Initialize the array with numbers 1 - 10
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = i+1;
		}
		System.out.println("Default Init: " + Arrays.toString(numbers));
		
		//2 - create a function that will append a number into an array
		//numbers = al.appendElement(numbers, 88);
		//System.out.println("After Append Element: " + Arrays.toString(numbers));
		
		//3 - create a function that will insert a number into the array at a position
		try {
			numbers = al.insertElement(numbers, 10, 100);
			System.out.println("After Insert Element: " + Arrays.toString(numbers));
		}catch(NegativePositionException npe) {
			System.out.println("Negative Position Exception " + npe.getMessage());
		}catch(PositionTooLargeException ptl) {
			System.out.println("Position Too Large Exception " + ptl.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("This code will be executed no matter what");
		}
		
		//4 - create a function that will delete a number from an array position
		//numbers = al.deleteElement(numbers, 1);
		//System.out.println("After Delete Element: " + Arrays.toString(numbers));
		
		//5 - create a function that will return the position of a value in an array
		//int position = al.findPositionOfValue(numbers, 9);
		//System.out.println(position);
		
		//6 - create a function that will sort an array [from greatest to least]
		//int[] temp = {5,99,3,1,0,14,100,0,2,3};
		//numbers = al.bubbleSort(temp);
		//System.out.println(Arrays.toString(numbers));
	}

}

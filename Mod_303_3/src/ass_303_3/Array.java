package ass_303_3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	//main method
	public static void main(String[] args) {
		Array array = new Array();
		//array.printElements();
		//array.findMidElement();
		//array.printColorArr();
		//array.printRandInt();
		//array.printLinearArr();
		//array.printDoubleArr();
		//array.printNoMidArr();
		//array.printMidSwapArr();
		//array.printMaxMinSortArr();
		//array.printAllTypeArr();
		array.favoriteThings();
	}
	
	//problem 1
	public void printElements() {
		String output = "";
		int size = 3;
		for(int i=0; i<size; i++){
			output += i + " ";
		}
		System.out.println(output);
	}
	
	//problem 2
	public void findMidElement() {
		int[] arr = {13, 5, 7, 68, 2};
		int mid = (arr.length/2);
		System.out.println(arr[mid]);
	}
	
	//problem 3
	public void printColorArr() {
		String[] colors = {"red", "green", "blue", "yellow"};
		int size = colors.length;
		String[] newColors = colors.clone();
		System.out.println(Arrays.toString(newColors));
	}
	
	//problem 4
	public void printRandInt() {
		int[] arr = new int[5];
		int max = 100, min = 1;
		for(int i=0; i<arr.length-1;i++) {
			int rand = (int)(Math.random() * (max - min) + min); 
			arr[i] = rand;
		}
		System.out.println(arr[0]);
		System.out.println(arr[arr.length-1]);
		
		//System.out.println(arr[arr.length]);
		//arr[5] = 101;
	}
	
	//problem 5
	public void printLinearArr() {
		int size = 5;
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//problem 6
	public void printDoubleArr() {
		int size = 5;
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = i * 2;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//problem 7
	public void printNoMidArr() {
		int size = 5;
		int[] arr = new int[size];
		int mid = (arr.length/2);
		for(int i=0; i<size; i++) {
			arr[i] = i * 2;
			if(i != mid) {
				System.out.print(i + " ");
			}
		}
	}
	
	//problem 8
	public void printMidSwapArr() {
		int size = 5;
		int[] arr = new int[size];
		int mid = (arr.length/2);
		for(int i=0; i<size; i++) {
			arr[i] = i;
			if(i == mid) {
				int temp = arr[0];
				arr[0] = i;
				arr[i] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	//problem 9
	public void printMaxMinSortArr() {
		int[] arr = new int[] {4, 2, 9, 13, 1, 0};
		Arrays.sort(arr);

		System.out.println("Array in ascending order: " + Arrays.toString(arr));
		System.out.println("The smallest number is: " + arr[0]);
		System.out.println("The biggest number is: " + arr[arr.length-1]);
	}
	
	//problem 10
	public void printAllTypeArr() {
		Object[] arr = new Object[5];
		arr[0] = 33;
		arr[1] = "Hello";
		arr[2] = "World";
		arr[3] = "!";
		arr[4] = 19.99d;
		System.out.println(Arrays.toString(arr));
	}
	
	//problem 11
	public void favoriteThings() {
		Scanner scn = new Scanner(System.in);
		System.out.println("How many favorite things do you have? :");
		
		int favNum = scn.nextInt();
		String[] fav = new String[favNum];
		
		scn.nextLine();
		for(int i=0; i<fav.length; i++) {
			System.out.print("Enter your thing: ");
			String thing = scn.nextLine();
			fav[i] = thing;
		}
		
		String out = "";
		System.out.println("Your favorite things are: ");
		for(String s : fav) {out += s + " ";}
		System.out.println(out.trim());
		scn.close();
	}
}

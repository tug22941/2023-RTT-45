package ass_303_3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LoopIterationsEx {

	//Main method
	public static void main(String[] args) {
		LoopIterationsEx li = new LoopIterationsEx();
		//li.forLoop();
		//li.forLoopList();
		//li.forListExercise(4, 15);
		//li.whileLoop(5, 16);
		li.maxRandomValue(100, 0, 10);
		
	}
	
		//Example 1
		public void forLoop() {
			List<Integer> list2 = new ArrayList<>();
			for(int i = 0; i< 10; i++) {
				list2.add(i);
			}
			for(Integer i: list2) {
				System.out.println(i);
			}
			System.out.println();
		}
		
		//Example 2
		public void forLoopList() {
			List<String> list = new ArrayList<>();
			list.add("String 1");
			list.add("String 2");
			list.add("String 3");
			
			for(int pos=0; pos<list.size(); pos++) {
				System.out.println(list.get(pos));
			}
			System.out.println();
		}
	
		//Example 3
		public void forListExercise(int start, int end) {
			List<Integer> list = new ArrayList<>();
			
			for(int i = start; i< end; i++) {
				list.add(i);
				i = i +1;
			}
			
			for(Integer e : list) {
				System.out.println(e);
			}
			System.out.println();
		}
		
		//Example 4
		public void whileLoop(int start, int end) {
			List<Integer> list = new ArrayList<>();
			
			int i = start;
			while(i <=end) {
				list.add(i);
				i = i +1;
			}
			
			for(Integer e : list) {
				System.out.println(e);
			}
			System.out.println();
		}
		
		//Example 5
		public void maxRandomValue(int max, int min, int size) {
			List<Integer> list = new ArrayList<>();
			Random rand = new Random();
			System.out.println("Random Number Generator!");
			
			//fill the list with random values
			for(int i=0; i<size; i++) {
				int n = rand.nextInt(max - min + 1) + min;
				list.add(n);
				System.out.println(n);
			}
			
			//find the Max Value from list
			int maxVal = min;
			for(Integer e: list) {
				if(e > maxVal) {
					maxVal = e;
				}
			}
			System.out.println("The Maximum Value is: " + maxVal);
			System.out.println();


			
			//find the Min Value form the list
			int minVal = max;
			for(Integer e: list) {
				if(e < minVal) {
					minVal = e;
				}
			}
			System.out.println("The Minimum Value is: " + minVal);
			System.out.println();
		}
		

}

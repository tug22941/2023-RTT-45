package ass_303_1_2;

public class JavaBasicsMain {

	public static void main(String[] args) {
		JavaBasicsMain jbm = new JavaBasicsMain();
		jbm.addIntPrintSum();
		jbm.addDoubPrintSum();
		jbm.addIntDouble();
		jbm.addIntPrintDiv();
		jbm.addDoubPrintInt();
		jbm.printDoubDivison();
		jbm.printFinalSum();
		jbm.cafeTotal();
		
	}
	
	//problem 1
	public void addIntPrintSum() {
		int val1 = 5;
		int val2 = 10;		
		int sum = val1 + val2;
		System.out.println(sum);
	}
	
	//problem 2
	public void addDoubPrintSum() {
		double val1 = 8.6;
		double val2 = 4.9;
		double sum = val1 + val2;
		System.out.println(sum);
	}
	
	//problem 3
	public void addIntDouble() {
		int val1 = 10;
		double val2 = 5.8;
		double sum = val1 + val2;
		System.out.println(sum);
	}
	
	//problem 4
	public void addIntPrintDiv() {
		int val1 = 95;
		int val2 = 5;
		int min = Math.min(val1, val2);
		int max = Math.max(val1, val2);
		int divison = max / min;
		System.out.println(divison);
	
		double doubleMax = (double)max;
	}
	
	//problem 5
	public void addDoubPrintInt() {
		double val1 = 305.55;
		double val2 = 5.05;
		double min = Math.min(val1, val2);
		double max = Math.max(val1, val2);
		double divison = max / min;
		System.out.println(divison);
		int intDivison = (int)divison;
		System.out.println(intDivison);
	}
	
	//problem 6
	public void printDoubDivison() {
		int x = 5;
		int y = 6;
		double q = y/x;
		System.out.println(q);
		q = ((double)y)/x;
		System.out.println(q);
	}
	
	//problem 7
	public void printFinalSum() {
		final int VAL1 = 9;
		int val2 = 13;
		System.out.println(VAL1 + val2);
	}
	
	//problem 8
	public void cafeTotal() {
		double coffee = 8.99;
		double donut = 4.85;
		double tea = 7.70;
		double subtotal, total;
		subtotal = (3 * coffee) + (4 * donut) + (2 * tea);
		final double SALES_TAX = 1.99;
		total = SALES_TAX + subtotal;
		System.out.printf("%.2f", total);
	}
}

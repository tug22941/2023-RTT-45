package ass_303_6_3;

public class LibraryInterfaceDemo {

	public static void main(String[] args) {
		
		 KidUsers kid1 = new KidUsers();
		 KidUsers kid2 = new KidUsers();
		 
		 kid1.setAge(10);
		 kid2.setAge(18);
		 
		 kid1.setBookType("Kids");
		 kid2.setBookType("Fiction");
		 
		 AdultUsers adult1 = new AdultUsers();
		 AdultUsers adult2 = new AdultUsers();
		 
		 adult1.setAge(5);
		 adult2.setAge(23);
		 
		 adult1.setBookType("Kids");
		 adult2.setBookType("Fiction");
		 
		 
		 //Print
		 kid1.registerAccount();
		 kid1.requestBook();
		 System.out.println();
		 kid2.registerAccount();
		 kid2.requestBook();
		 System.out.println();
		 adult1.registerAccount();
		 adult1.requestBook();
		 System.out.println();
		 adult2.registerAccount();
		 adult2.requestBook();

	}

}

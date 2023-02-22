package sba1_worksheet;

public class InvalidStringException extends Exception{
	//required absolute variable
	private static final long serialVersionUID = 1L;
	
	
	InvalidStringException(String s){
		System.out.println(s);
	}
}

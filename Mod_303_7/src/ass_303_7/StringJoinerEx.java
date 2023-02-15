package ass_303_7;

import java.util.StringJoiner;

public class StringJoinerEx {
	
	public static void main(String[] args) {
		
		//The 1st arg is the delimiter that goes between and separate elements
		//The 2nd arg is the start character
		//The 3rd arg is the end character
		
		StringJoiner sj1 = new StringJoiner(",","[","]");		
		sj1.add("element");
		sj1.add("element2");
		sj1.add("element3");
		sj1.add("element4");
		System.out.println(sj1.toString());
		System.out.println();
		
		StringJoiner sj2 = new StringJoiner(",","[","]");		
		sj2.add("list1");
		sj2.add("list2");
		sj2.add("list3");
		sj2.add("list4");
		System.out.println(sj2.toString());
		System.out.println();
		//the merge function used the delimiter for sj1 for the sj1 elements
		//the merge function also used the delimiter for sj2 for the sj2 elements
		//then the merge function used the start and end characters of sj1
		System.out.println(sj1.merge(sj2).toString());
		
		System.out.println();
		
		//the merge function used the delimiter for sj2 for the sj2 elements
		//the merge function also used the delimiter for sj1 for the sj1 elements
		//then the merge function used the start and end characters from sj2
		System.out.println(sj2.merge(sj1).toString());
	}
}

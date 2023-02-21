package stream_ex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
       names.add("Larry");
       names.add ("Steve") ;
       names.add ("James") ;
       names.add ( "Conan") ;
       names.add ( "Ellen") ;
	   names.stream().forEach(name -> {  System.out.println (name);  } );
	   System.out.println("======================================");
	   
	   //1) sort the original names list by length of name using a stream
	   names.sort(Comparator.comparingInt(String::length));
	   System.out.println(String.join("\n",  names) + "\n");
	   System.out.println("======================================");

	   //2) When the length is the same then sort alphabetically
	   List<String> sortedNames = names.stream()
			   		.sorted(Comparator.reverseOrder())
			   		.collect(Collectors.toList());
	   System.out.println(String.join("\n", sortedNames));
	   
	   System.out.println("======================================");
	   
	   //remove all names from the list that contains an "n"
	   sortedNames.removeIf(name -> name.contains("n"));
	   System.out.print(String.join("\n", sortedNames) + "\n");
	   
	}

}

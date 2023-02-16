package sorting_ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

	public static void main(String[] args) {
		
		//Map with Key Type String & Key Type Value
		Map<String,String> dictionary = new HashMap<>();
		dictionary.put("key", "value");
		dictionary.put("concat", "To add 2 strings together");
		dictionary.put("instanciate", "to create a new object");
		dictionary.put("new","allocate new memeory location");
		
		//loop through the strMap Map
		for(String key: dictionary.keySet()) {
			System.out.println(key + " = " + dictionary.get(key));
		}
		System.out.println("===========================");
		
		//get the value of the 'concat' key from the strMap Map
		System.out.println(dictionary.get("concat"));
		
		//Map with Key Type String & Value Type Integer
		Map<String,Integer> intMap = new HashMap<>();
		intMap.put("key",1);
		
		Map<Integer,String> sIntMap = new HashMap<>();
		sIntMap.put(1, "one");
		sIntMap.put(2, "two");
		sIntMap.put(3, "three");
		System.out.println(sIntMap.get(3));
		
		//overwrite the the value of key: 3
		sIntMap.put(3,"THREE");
		System.out.println(sIntMap.get(3));
		
		//loop through the sIntMap Map
		for(Integer key : sIntMap.keySet() ) {
			System.out.print(key);
		}

		

		

	}

}

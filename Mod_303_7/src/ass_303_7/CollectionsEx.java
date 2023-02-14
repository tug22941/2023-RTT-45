package ass_303_7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsEx {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();		
		set.add("element1");
		set.add("element2");
		set.add("element3");
		//this item will override the first 'element1'
		set.add("element1");
		
		for(String e: set) {
			System.out.println(e);
		}
		
		//--------
		System.out.println();
		//--------
		
		List<String> list = new ArrayList<>();
		list.add("element1");
		list.add("element2");
		list.add("element3");
		//this item will create a duplicate 'element1'
		list.add("element1");
		
		for(String l: list) {
			System.out.println(l);
		}
		
		
		if(list.contains("element1")) {System.out.println("The list contains element1");}
		if(list.isEmpty()) {}// this is the same empty
		if(list.size() == 0) {}//this is the same as empty
		
		//this will get the first element
		//check to make sure the list is not empty before this
		System.out.println(list.get(0));
		
		//--------
		System.out.println("============ iterators ============");
		//--------
		
		//An iterator is another way of looping over a list
		//Primarily used to delete elements of a list - safe delete
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			if(element.equals("element2")) {
				iterator.remove();
			}
		}
	}
}

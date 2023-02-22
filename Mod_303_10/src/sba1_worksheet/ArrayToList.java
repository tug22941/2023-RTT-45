package sba1_worksheet;

import java.util.ArrayList;

public class ArrayToList implements MyList {
	 //class variable ArrayList
    ArrayList<String> arrayToList;
    
    //constructor that initializes  'arrayToList' arrayList
    public ArrayToList(){
        arrayToList = new ArrayList<String>();
    }
    
    public void convert(String[]a){
        for(int i=0; i<a.length; i++){
            arrayToList.add(a[i]);
            System.out.println("I have added the string: " + a[i] + " at the index: " + i);
        }
    }
    
    public void replace(int idx){
    	String temp = arrayToList.get(idx);
        arrayToList.set(idx,"");
        System.out.println("I have replaced the string: " + temp + " with a null string");
    }
    
    public ArrayList<String> compact(){
        
    	arrayToList.removeIf(""::equals);
        return arrayToList;
    }
}

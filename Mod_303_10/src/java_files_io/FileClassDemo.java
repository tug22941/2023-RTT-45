package java_files_io;

import java.io.File;
import java.io.IOException;

public class FileClassDemo {
	
	public static void main (String[] args) {
		FileClassDemo fcd = new FileClassDemo();
		//fcd.demo1();
		//fcd.demo2();
		
	}
	
	public void demo1() {
		String path = "C:/Users/Downloads/testingFile.txt";
		File f = new File(path);
		System.out.println("File Name: " + f.getName());
		System.out.println("File Path: " + f.getPath());
		System.out.println("Is path absolute: " + f.isAbsolute());
		System.out.println("Return Absolute path of the File " + f.getAbsolutePath());
		System.out.println("Return Parent folder of the given File " + f.getParent());
		System.out.println("File Exists: " + f.exists());
		System.out.println(f.exists() ? "Yes file exists" : "file does not exist");
		if(f.exists())  // return true or False
	    {
		   System.out.println("File is Found");
		   System.out.println("IS file Readable " +  f.canRead());
		   System.out.println("IS file Writeable " +  f.canWrite());
		   System.out.println("File size in a bytes " + f.length()); // file size in byte
	    }
  }//end of demo1
	
	public void demo2() {
		try {
		    File f = new File("C:/Users/ninjakid362/Downloads/Datafile.txt");
		    	if (f.createNewFile()) {
		    		System.out.println("New File created!");
		    	} else {
		    		System.out.println("The file already exists.");
		    	}
		   } catch(IOException e) { e.printStackTrace(); }
	}//end of demo2
	
}//end of main

package java_files_io;

import java.io.File;

public class FileExamples {
	
	public static void main(String[] args) {
		
		//using dot(.) means current directory
		//using double dot(..) means parent directory
		
		//relative path is where you currently are
		//absolute path starts from the root of the folder structure
		
		//create a relative file object pointing to a new directory "files"
		File file = new File("./src/files");
		
		//print the absolute path of the "files" directory
		System.out.println(file.getAbsolutePath());
		
		//if the "files" directory exist in our file structure - print
		if(file.isDirectory()) {
			System.out.println(file.getName() + " is a directory");
			
			//print the file name of all files in the "files" directory
			for(File f: file.listFiles()) {
				System.out.println(f.getName());
			}
		}
		//print the Boolean if file of variable 'code' exsist
		File code = new File("./src/java_files_io/FileExamples.java");
		System.out.println("The file exsists = " + code.exists());
		
		Buff
	}//end of main
}

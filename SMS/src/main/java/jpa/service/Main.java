package jpa.service;
import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class Main {
	Scanner scn;
	StudentService studentService;
	CourseService courseService;
	
	//main constructor: initialize field variables
	public Main() {
		scn = new Scanner(System.in);
		studentService = new StudentService();
		courseService = new CourseService();
	}
	
	//main method: begin application
	public static void main(String[] args) {
		String menu1Display = "Welcome To the Student Managemnt System (SMS)\n"
				 +"---------------------------------------------\n";
		System.out.println(menu1Display);
		
		Main main = new Main();
		main.run();

	}
	
	// run method: receive user menu1 input - call respective method
	public void run() {
		//Login or Quit
		switch(menu1()) {
		case 1:
			//if studentLogin - show register Menu
			if(studentLogin()) {
				
			}
			break;
		case 2:
			System.out.println("Goodbye. Have A Nice Day!");
			break;
		default:
			System.out.println("Invalid Entry");
		}
	}
	
	//display menu 1: receive user input;
	public int menu1() {

		 String display = "Are You A(n) Student?:\n"
		 + "1: Student Menu\n"
		 + "2: Quit";
		 System.out.print(display + "\nSelect:");
		 
		 try { return scn.nextInt();}
		 catch(Exception e){ return -1;}
	}
	
	//enter student credentials: display all courses student is taking
	public boolean studentLogin() {
	
		System.out.print("\nEnter Your Student Email: ");
		String email = scn.next();
		System.out.print("Enter Your Student Password: ");
		String password = scn.next();
		
		List<Student> students = studentService.getStudentByEmail(email);
		Student curStudent = null;
		
		if((students != null)) {
			curStudent = students.get(0);
		}
		if((curStudent != null) && (curStudent.getSPass().equals(password))) {
			int id = curStudent.getSId();
			List<Course> courses = studentService.getStudentCourses(id);
			System.out.println("My Courses:\n------------------");
			for(Course c: courses) {
				System.out.println(c.getCId() + "\t" + c.getCName());
			}
			return true;
		}
		
		System.out.println("Invalid Student Credentials Entered!\n Goodbye!");
		return false;

		
		
	}
	

}

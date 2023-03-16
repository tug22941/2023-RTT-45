package jpa.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class Main {
	Scanner scn;
	StudentService studentService;
	CourseService courseService;
	Student curStudent;
	List<Course> studentCourses;
	
	//main constructor: initialize field variables
	public Main() {
		scn = new Scanner(System.in);
		studentService = new StudentService();
		courseService = new CourseService();
		curStudent = null;
		studentCourses = null;
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
			if(studentLogin()) {
				registerMenu();
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
		 System.out.print(display + "\nSelect 1 or 2:");
		 
		 try { return scn.nextInt();}
		 catch(Exception e){ return -1;}
	}
	
	//enter student credentials: display all courses student is taking
	public boolean studentLogin() {
		//display login prompt
		System.out.print("\nEnter Your Student Email: ");
		String email = scn.next();
		System.out.print("Enter Your Student Password: ");
		String password = scn.next();
		
		List<Student> students = studentService.getStudentByEmail(email);
		
		//check student validity
		if((students != null)) {
			curStudent = students.get(0);
		}
		if((curStudent != null) && (curStudent.getSPass().equals(password))) {
			//display student courses
			int id = curStudent.getSId();
			studentCourses = studentService.getStudentCourses(id);
			if(studentCourses == null) {
				System.out.println("YOU ARE NOT REGISTERED FOR ANY COURSES!");
			}else {
				System.out.println("YOUR COURSES ARE:\n#\tCOURSE\t\tINSTRUCTOR");
				System.out.println("--------------------------------------");
				for(Course c: studentCourses) {
					System.out.println(c.getCId() + "\t" + c.getCName() + "\t\t" + c.getCInstructorName());
				}
			}
			return true;
		}
		
		System.out.println("Invalid Student Credentials Entered!\nGoodbye!");
		return false;

		
		
	}
	
	//register student for course: deny duplicate courses
	public void registerMenu() {
		System.out.print("\n1: Register For Course\n2: Logout\n"
						   +"Select 1 or 2: ");
		int selection = -1;
		try {selection = scn.nextInt();}
		catch(Exception e){System.out.println("\nInvalid Format1!");}
		
		switch(selection) {
		case 1:
			//register for course
			List<Course> allCourses = courseService.getAllCourses();	
			for(Course c : allCourses) {
				System.out.println(c.getCId()+" "+c.getCName()+" "+c.getCInstructorName());
			}
			System.out.print("\nEnter A Course #: ");
			int number = -1;
			try {number = scn.nextInt();}
			catch(Exception e) {System.out.println("Invalid Format!\nGoodbye"); break;}
			
			//assign selected course to 'newCourse' object
			Course newCourse = courseService.getCourseById(number);
			int courseId = newCourse.getCId();
			
			//if student course is null (unregistered student) initialize global variable;
			if(studentCourses == null) {studentCourses = new ArrayList<Course>();}
			boolean unregisteredCourse = studentService.canRegisterStudent(courseId, studentCourses);
			
			//check if newCourse is null 
			if(newCourse != null) {
				//check if newCourse id is present in student courses already
				if(unregisteredCourse) {
					//register new student course: display updated prompt of all student courses
					studentService.registerStudentToCourse(curStudent, newCourse);
					
					studentCourses = studentService.getStudentCourses(curStudent.getSId());
					System.out.println("YOUR COURSES ARE:\n#\tCOURSE\t\tINSTRUCTOR");
					System.out.println("--------------------------------------");
					for(Course c: studentCourses) {
						System.out.println(c.getCId() + "\t" + c.getCName() + "\t\t" + c.getCInstructorName());
					}
				}else {System.out.println("Duplicate Course Selection Entered\nGoodbye!");}
			}else {System.out.println("Invalid Course Selection Entered!\nGoodbye!");}
			
			break;
		case 2:
			//logout
			System.out.println("\nLogging Out!\nGoodbye!");
			break;
		default:
			//invalid input
			System.out.println("\nInvalid Selection Entered!\nGoodbye!");		}
	}

}

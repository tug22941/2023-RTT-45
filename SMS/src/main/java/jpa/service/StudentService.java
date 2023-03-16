package jpa.service;

import java.util.ArrayList;
import java.util.List;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

//service class for student actions

public class StudentService {

	private StudentDAO studentDAO = new StudentDAO();
	private Student student;
	
	//default constructor
	public StudentService() {
		
	}
	
	//get a list of students, containing only 1 student matching the input email
	public List<Student> getStudentByEmail(String email) {
		List<Student> students= new ArrayList<Student>();
		student = studentDAO.getStudentByEmail(email);
		students.add(student);
		return students;
	}
	
	//get a list of courses of courses belonging to the matching studentId
	public List<Course> getStudentCourses(Integer studentId){
		return studentDAO.getStudentCourses(studentId);
	}
	
	//validate that a student, matching the input id, is not already registered to a course from the input course list
	public boolean canRegisterStudent(Integer id, List<Course> stdCourses) {
		for(Course c: stdCourses) {
			if(c.getCId() == id) {
				return false;
			}
		}return true;
	}
	
	//register a student to a course
	public void registerStudentToCourse(Student student, Course course) {
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setSId(student.getSId());
		studentCourse.setCId(course.getCId());
		studentCourse.setStudent(student);
		studentCourse.setCourse(course);
		studentDAO.registerStudentToCourse(studentCourse);
	}
	
	//-- Not Used
	
	//get a list of all students form the database
	public List<Student> getAllStudents(){
		return studentDAO.getAllStudents();
	}
	
	//validate whether a student's email and password pair is present in the database
	public boolean validateStudent(String email, String password) {
		return studentDAO.validateStudent(email, password);
	}
	
	
}

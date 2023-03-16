package jpa.service;

import java.util.ArrayList;
import java.util.List;

import jpa.dao.CourseDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService {

	private StudentDAO studentDAO = new StudentDAO();
	private CourseDAO courseDAO = new CourseDAO();
	private Student student;
	
	//default constructor
	public StudentService() {
		
	}
	
	public List<Student> getStudentByEmail(String email) {
		List<Student> students= new ArrayList<Student>();
		student = studentDAO.getStudentByEmail(email);
		students.add(student);
		return students;
	}
	
	public List<Course> getStudentCourses(Integer id){
		return studentDAO.getStudentCourses(id);
	}
}

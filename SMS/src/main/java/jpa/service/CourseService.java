package jpa.service;

import java.util.List;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService {
	private CourseDAO courseDAO = new CourseDAO();
	
	//default constructor
	public CourseService() {
		
	}
	
	//get a list of all courses form the database
	public List<Course> getAllCourses(){
		return courseDAO.getAllCourses();
	}
	
	//get a single course from database matching the input id
	public Course getCourseById(Integer id) {
		
		List<Course> allCourses = getAllCourses();
		for(Course c: allCourses) {
			if(c.getCId() == id) {
				return c;
			}
		}
		return null;
	}
	
	
}

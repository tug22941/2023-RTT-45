package jpa.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;

//course data access object class

public class CourseDAO {
	//get a list of all the courses in the database
	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Course c";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		
		List<Course> result = query.getResultList();
		session.close();
		return result;
	}
}

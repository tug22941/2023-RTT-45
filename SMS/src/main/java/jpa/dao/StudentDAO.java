package jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;

public class StudentDAO {
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		
		List<Student> result = query.getResultList();
		session.close();
		return result;
	}
	
	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s where s.sEmail = :emailParam";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("emailParam", email);
		
		Student result = query.getSingleResult();
		session.close();
		return result;
	}
	
	public Boolean validateStudent(String email, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s where s.sEmail = :sEmailParam and "
					+"s.sPass = :sPassParam" ;
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("sEmailParam", email);
		query.setParameter("sPassParam", password);

		try {
			Student result = query.getSingleResult();
			session.close();
			return true;
		}catch(NoResultException e) {
			session.close();
			return false;
		}
	}
	
	//Uses StudentCourse Class!!!
	public void registerStudentToCourse(StudentCourse studentCourse) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(studentCourse);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Course> getStudentCourses(Integer studentId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		// 1st query for all student course of student
		String hql = "FROM StudentCourse sc where sc.sId = :sIdParam";
		TypedQuery<StudentCourse> query1 = session.createQuery(hql, StudentCourse.class);
		query1.setParameter("sIdParam", studentId);
		List<StudentCourse> sCResult = query1.getResultList();
		
		if(sCResult.size() >0) {
			//if student course query returns results
			List<Course> courses = new ArrayList<Course>();
			for(StudentCourse sc: sCResult) {
				//fill course list using courseId of each student course result
				int courseId = sc.getCId();
				
				hql = "FROM Course c where c.cId = :cIdParam";
				TypedQuery<Course> query2 = session.createQuery(hql, Course.class);
				query2.setParameter("cIdParam", courseId);
				Course course = query2.getSingleResult();
				courses.add(course);
			}
			
			session.close();
			return courses;
		}else{
			//if student course query returns no results - exit
			session.close();
			System.out.println("No Courses found for student");
			return null;
		}

	}
	
	
	
	
}

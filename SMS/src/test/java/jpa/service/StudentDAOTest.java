package jpa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Student;

public class StudentDAOTest {
	private static StudentDAO studentDAO;
	
	@Test
	public void getStudentByEmail() {
		studentDAO = new StudentDAO();
		
		//given -  what we know to be true
		Student expected = new Student();
		expected.setSId(3);
		expected.setSEmail("sbowden1@yellowbook.com");
		expected.setSName("Sonnnie Bowden");
		expected.setSPass("SJc4aWSU");
		
		//when - an action happens
		Student actual = studentDAO.getStudentByEmail("sbowden1@yellowbook.com");
		
		//given - test
		Assertions.assertEquals(expected.getSId(), actual.getSId());
		Assertions.assertEquals(expected.getSEmail(), actual.getSEmail());
		Assertions.assertEquals(expected.getSName(), actual.getSName());
		Assertions.assertEquals(expected.getSPass(), actual.getSPass());
	}
}

package lab_305_3_1_controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import lab_305_3_1.User;

public class CreateUserTable {
	public static void main(String[] args) {
		SessionFactory factory = new
		Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		User uone = new User();
		t.commit();
		System.out.println("successfully created user table");
		factory.close();
		session.close();
	}
}

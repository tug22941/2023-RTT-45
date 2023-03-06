package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	public Employee findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employee e where e.id = :idParam";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("idParam", id);
		Employee result = query.getSingleResult();

		session.close();

		return result;
	}

	public List<Employee> findContactFirstName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Employees e where firstname = :firstname";

		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("firstname", name);

		List<Employee> result = query.getResultList();

		session.close();

		return result;
	}

	public void insert(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Employee employee) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

}

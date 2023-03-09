package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {
	public Order findById(Integer id) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Order o where o.id = :idParam";
		TypedQuery<Order> query = session.createQuery(hql,Order.class);
		query.setParameter("idParam", id);
		Order result = query.getSingleResult();
		
		session.close();
		
		return result;
	}
	
	public void insert(Order order) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateOrder(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(order);
		session.getTransaction().commit();
		session.close();
	}

}

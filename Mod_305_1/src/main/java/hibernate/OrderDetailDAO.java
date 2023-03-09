package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

	public OrderDetail findById(Integer id) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM OrderDetail od where od.id = :idParam";
		TypedQuery<OrderDetail> query = session.createQuery(hql,OrderDetail.class);
		query.setParameter("idParam", id);
		OrderDetail result = query.getSingleResult();
		
		session.close();
		
		return result;
	}
	
	public void insert(OrderDetail orderDetail) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(orderDetail);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateOrder(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(orderDetail);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(orderDetail);
		session.getTransaction().commit();
		session.close();
	}

}

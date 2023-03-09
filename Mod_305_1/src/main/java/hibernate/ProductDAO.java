package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	
	public Product findById(Integer id) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Product p where p.id = :idParam";
		TypedQuery<Product> query = session.createQuery(hql,Product.class);
		query.setParameter("idParam", id);
		Product result = query.getSingleResult();
		
		session.close();
		
		return result;
	}
	
	public void insert(Product product) {
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateProduct(Product product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Product product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}
}

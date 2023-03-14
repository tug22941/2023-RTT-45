package hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieRentalDAO {
	public MovieRental findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM MovieRental mr where mr.id = :idParam";
		TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
		query.setParameter("idParam", id);
		MovieRental result = query.getSingleResult();

		session.close();

		return result;
	}

	public void insert(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(movieRental);
		session.getTransaction().commit();
		session.close();
	}

	public void updateOrder(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(movieRental);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(movieRental);
		session.getTransaction().commit();
		session.close();
	}
	
	//-------------Custom Classes----------------- 
	
	public Boolean checkedOut(Movie movie, User user) {
			
		try {
			//check if user is currently in possession of movie
			int userId = user.getId();
			int movieId = movie.getId();
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();

			String hql = "FROM MovieRental mr where mr.movieId = :movieIdParam and "
						+ "mr.userId = :userIdParam and mr.checkinDate is NULL";
			TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
			query.setParameter("movieIdParam", movieId);
			query.setParameter("userIdParam", userId);
			
			//existing result: CHECKED OUT - CAN NOT CHECKOUT
			MovieRental result = query.getSingleResult();
			session.close();
			return true;
			
		}catch(NoResultException e) {
			//no existing result : NOT CHECKED OUT - CAN CHECKOUT
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.close();
			return false;
			
		}
	}
	
	public MovieRental findByMovieUser(Movie movie, User user) {
		//check if user is currently in possession of movie
		int userId = user.getId();
		int movieId = movie.getId();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM MovieRental mr where mr.movieId = :movieIdParam and "
					+ "mr.userId = :userIdParam and mr.checkinDate is NULL";
		TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
		query.setParameter("movieIdParam", movieId);
		query.setParameter("userIdParam", userId);
		
		//existing result: CHECKED OUT - CAN NOT CHECKOUT
		MovieRental result = query.getSingleResult();
		session.close();
		return result;
	}
	
	public List<MovieRental> findNullMovieRentals() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM MovieRental mr where mr.checkinDate is NULL";
		TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
		
		//existing result: CHECKED OUT - CAN NOT CHECKOUT
		List<MovieRental> result = query.getResultList();
		session.close();
		return result;
	}

}

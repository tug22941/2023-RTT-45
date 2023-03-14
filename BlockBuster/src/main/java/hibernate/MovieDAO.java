package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieDAO {
	public Movie findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Movie m where m.id = :idParam";
		TypedQuery<Movie> query = session.createQuery(hql, Movie.class);
		query.setParameter("idParam", id);
		Movie result = query.getSingleResult();

		session.close();

		return result;
	}

	public void insert(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.save(movie);
		session.getTransaction().commit();
		session.close();
	}

	public void updateOrder(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(movie);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(movie);
		session.getTransaction().commit();
		session.close();
	}
	
	//-------------Custom Classes----------------- 

	public Movie findByMovieUser(Movie movie, User user) {
		//check if user is currently in possession of movie
		int userId = user.getId();
		int movieId = movie.getId();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Movie mr where mr.movieId = :movieIdParam and "
					+ "mr.userId = :userIdParam and mr.checkinDate is NULL";
		TypedQuery<Movie> query = session.createQuery(hql, Movie.class);
		query.setParameter("movieIdParam", movieId);
		query.setParameter("userIdParam", userId);
		
		//existing result: CHECKED OUT - CAN NOT CHECKOUT
		Movie result = query.getSingleResult();
		session.close();
		return result;
	}

}

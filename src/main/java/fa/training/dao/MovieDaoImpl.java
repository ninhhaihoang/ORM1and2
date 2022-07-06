package fa.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Movie;
import fa.training.utils.HibernateUtils;

public class MovieDaoImpl implements MovieDao {

	@Override
	public List<Movie> findAll() {
		Session session = null;
		Transaction transaction;
		List<Movie> movies = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "SELECT m FROM Movie m";
			movies = session.createQuery(hql, Movie.class).list();

			transaction.commit();

			return movies;
		} catch (Exception e) {
			System.out.println("Error");
			return movies;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Movie findById(String id) {
		Session session = null;
		Transaction transaction;
		Movie movie = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

            String hql = "FROM Movie m LEFT JOIN FETCH m.movieTypes mt LEFT JOIN FETCH mt.id.type WHERE m.movieId = :id";
            movie = (Movie) session.createQuery(hql).setParameter("id", id).getSingleResult();

//			movie = session.get(Movie.class, id);

			transaction.commit();

			return movie;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return movie;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void save(Movie movie) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(movie);

			transaction.commit();

			System.out.println("Saved!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void saveAll(List<Movie> movies) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			for (int i = 0; i < movies.size(); i++) {
				session.save(movies.get(i));
			}
			transaction.commit();

			System.out.println("Saved!");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void delete(String id) {
		Movie movie = findById(id);
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

//			String hql = "DELETE FROM Movie WHERE movieId = :id";
//			int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
			session.delete(movie);

			transaction.commit();
//			System.out.println(affectedRows + " rows executed");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null)
				session.close();
		}

	}

}

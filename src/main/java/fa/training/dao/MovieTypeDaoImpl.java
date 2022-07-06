package fa.training.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.MovieType;
import fa.training.utils.HibernateUtils;

public class MovieTypeDaoImpl implements MovieTypeDao{

	@Override
	public void save(MovieType movieType) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(movieType);

			transaction.commit();

			System.out.println("Saved!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null)
				session.close();
		}
	}

}

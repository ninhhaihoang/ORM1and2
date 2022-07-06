package fa.training.dao;

import fa.training.utils.HibernateUtils;
import fa.training.entities.Seat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeatDaoImpl implements SeatDao {
	@Override
	public List<Seat> findAll() {
		Session session = null;
		Transaction transaction;
		List<Seat> seats = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Seat";
			seats = session.createQuery(hql, Seat.class).list();

			transaction.commit();

			return seats;
		} catch (Exception e) {
			System.out.println(e);
			return seats;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Seat findById(int id) {
		Session session = null;
		Transaction transaction;
		Seat seat = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

//			String hql = "FROM Seat AS s WHERE s.seatId = :id";
//			seat = session.createQuery(hql, Seat.class).setParameter("id", id).uniqueResult();
			seat = session.get(Seat.class, id);

			transaction.commit();

			return seat;
		} catch (Exception e) {
			System.out.println(e);
			return seat;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void save(Seat seat) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(seat);

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
	public void saveAll(List<Seat> seats) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			for (int i = 0; i < seats.size(); i++) {
				session.save(seats.get(i));
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
	public void delete(int id) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Seat WHERE seatId = :id";
			int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();

			transaction.commit();
			System.out.println(affectedRows + " rows executed");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null)
				session.close();
		}
	}
}

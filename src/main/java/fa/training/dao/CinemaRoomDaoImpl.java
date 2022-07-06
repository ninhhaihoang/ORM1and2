package fa.training.dao;

import fa.training.entities.CinemaRoom;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CinemaRoomDaoImpl implements CinemaRoomDao {

    @Override
    public List<CinemaRoom> findAll() {
        Session session = null;
        Transaction transaction;
        List<CinemaRoom> cinemaRooms = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "select c FROM CinemaRoom c";
            cinemaRooms = session.createQuery(hql, CinemaRoom.class).list();

            transaction.commit();

            return cinemaRooms;
        } catch (Exception e) {
            System.out.println(e);
            return cinemaRooms;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public CinemaRoom findById(int id) {
        Session session = null;
        Transaction transaction;
        CinemaRoom cinemaRoom = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT c FROM CinemaRoom c LEFT JOIN FETCH c.seats WHERE c.cinemaRoomId = :id";
            cinemaRoom = session.createQuery(hql, CinemaRoom.class).setParameter("id", id).uniqueResult();
//            cinemaRoom = session.get(CinemaRoom.class, id);

            transaction.commit();

            return cinemaRoom;
        } catch (Exception e) {
            System.out.println(e);
            return cinemaRoom;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void save(CinemaRoom cinemaRoom) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(cinemaRoom);

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
    public void saveAll(List<CinemaRoom> cinemaRooms) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < cinemaRooms.size(); i++) {
                session.save(cinemaRooms.get(i));
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
        CinemaRoom c = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//            String hql = "DELETE FROM CinemaRoom WHERE cinemaRoomId = :id";
//            int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
            session.delete(c);

            transaction.commit();
//            System.out.println(affectedRows + " rows executed");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}

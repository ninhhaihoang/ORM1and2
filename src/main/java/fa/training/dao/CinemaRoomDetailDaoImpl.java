package fa.training.dao;

import fa.training.utils.HibernateUtils;
import fa.training.entities.CinemaRoomDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CinemaRoomDetailDaoImpl implements CinemaRoomDetailDao{
	@Override
    public List<CinemaRoomDetail> findAll() {
        Session session = null;
        Transaction transaction;
        List<CinemaRoomDetail> cinemaRoomDetails = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "FROM CinemaRoomDetail";
            cinemaRoomDetails = session.createQuery(hql, CinemaRoomDetail.class).list();

            transaction.commit();

            return cinemaRoomDetails;
        } catch (Exception e) {
			System.out.println(e);
			return cinemaRoomDetails;
		} finally {
            if (session != null)
                session.close();
        }
    }
	
	@Override
    public CinemaRoomDetail findById(int id) {
        Session session = null;
        Transaction transaction;
        CinemaRoomDetail cinemaRoomDetail = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//            String hql = "FROM CinemaRoomDetail AS c WHERE c.cinemaRoomDetailId = :id";
//            cinemaRoomDetail = session.createQuery(hql, CinemaRoomDetail.class).setParameter("id", id).uniqueResult();
            cinemaRoomDetail = session.get(CinemaRoomDetail.class, id);
            
            transaction.commit();

            return cinemaRoomDetail;
        } catch (Exception e) {
			System.out.println(e);
			return cinemaRoomDetail;
		} finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void save(CinemaRoomDetail cinemaRoomDetail) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(cinemaRoomDetail);

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

            String hql = "DELETE FROM CinemaRoomDetail WHERE cinemaRoomDetailId = :id";
            int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();

            transaction.commit();
            System.out.println(affectedRows + " row(s) executed");
        } catch (Exception e) {
			System.out.println(e);
		} finally {
            if (session != null)
                session.close();
        }
    }
}

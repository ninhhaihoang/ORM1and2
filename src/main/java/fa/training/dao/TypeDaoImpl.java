package fa.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Type;
import fa.training.utils.HibernateUtils;

public class TypeDaoImpl implements TypeDao{

	@Override
	public List<Type> findAll() {
		Session session = null;
		Transaction transaction;
		List<Type> types = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "select t FROM Type t";
			types = session.createQuery(hql, Type.class).list();

			transaction.commit();

			return types;
		} catch (Exception e) {
			System.out.println(e);
			return types;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Type findById(int id) {
		Session session = null;
		Transaction transaction;
		Type type = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Type t LEFT JOIN FETCH t.movieTypes mt LEFT JOIN FETCH mt.movieTypeKey.movie WHERE t.typeId = :id";
			type = (Type) session.createQuery(hql).setParameter("id", id).getSingleResult();
//			type = session.get(Type.class, id);

			transaction.commit();

			return type;
		} catch (Exception e) {
			System.out.println(e);
			return type;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void save(Type type) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.saveOrUpdate(type);

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
	public void saveAll(List<Type> types) {
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			for (int i = 0; i < types.size(); i++) {
				session.save(types.get(i));
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
		Type type = findById(id);
		Session session = null;
		Transaction transaction;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

//			String hql = "DELETE FROM Type WHERE typeId = :id";
//			int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
			session.delete(type);

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

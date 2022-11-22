package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.ThucUong;
import service.ThucUongService;

public class ThucUongDAO  extends UnicastRemoteObject  implements ThucUongService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2713013593968846122L;
	private SessionFactory sessionFactory;
	public ThucUongDAO(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	public ThucUong getThucUongTheoMa(int ma) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			ThucUong tu = session.get(ThucUong.class, ma);
			tr.commit();
			return tu;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}

	public List<ThucUong> getAllThucUong() throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from ThucUong";
			List<ThucUong> tus = session.createNativeQuery(query, ThucUong.class).getResultList();
			tr.commit();

			return tus;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}

	public boolean addThucUong(ThucUong tu) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(tu);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public boolean updateThucUong(ThucUong tu)throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			System.out.println(tu);
			tr.begin();
			session.update(tu);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public ThucUong getThucUongTheoTen(String ten) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from ThucUong where tenTU = N'"+ten+"'";
			ThucUong tu = session.createNativeQuery(query, ThucUong.class).getSingleResult();
			tr.commit();

			return tu;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}


}

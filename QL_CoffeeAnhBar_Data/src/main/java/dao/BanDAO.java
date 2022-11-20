package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import entity.Ban;
import service.BanService;

public class BanDAO  extends UnicastRemoteObject  implements BanService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 128484259121218939L;
	private SessionFactory sessionFactory;

	public BanDAO(SessionFactory sessionFactory)  throws RemoteException{
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean addBan(Ban ban) throws RemoteException {

		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public Ban getBanById(int id) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			Ban ban = session.get(Ban.class, id);
			tr.commit();
			return ban;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}

	public boolean updateBan(Ban ban) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			System.out.println(ban);
			tr.begin();
			session.update(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public boolean deleteBan(Ban ban) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(ban);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public List<Ban> getListBan() throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from Ban where not tinhTrangBan = N'Ngung hoat dong'";
			List<Ban> bans = session.createNativeQuery(query, Ban.class).getResultList();
			tr.commit();

			return bans;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}

}

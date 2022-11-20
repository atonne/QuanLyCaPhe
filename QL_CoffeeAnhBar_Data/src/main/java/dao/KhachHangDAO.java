package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import entity.KhachHang;
import service.KhachHangService;

public class KhachHangDAO extends UnicastRemoteObject implements KhachHangService{
	
	private static final long serialVersionUID = 128484259121218939L;
	private SessionFactory sessionFactory;

	public KhachHangDAO(SessionFactory sessionFactory)  throws RemoteException{
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean addKH(KhachHang kh) throws RemoteException {

		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	public KhachHang getHKById(int id) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			KhachHang kh = session.get(KhachHang.class, id);
			tr.commit();
			return kh;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}
	public boolean updateKH(KhachHang kh) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			System.out.println(kh);
			tr.begin();
			session.update(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	public boolean deleteKH(KhachHang kh) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	
	public List<KhachHang>  getListKH() throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			String query = "select * from KhachHang";
			List<KhachHang> kh = session.createNativeQuery(query, KhachHang.class).getResultList();
			tr.commit();
			return kh;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}

}

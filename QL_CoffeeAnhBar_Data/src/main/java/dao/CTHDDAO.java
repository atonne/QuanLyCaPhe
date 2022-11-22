package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.CTHD;
import entity.HoaDon;
import entity.ThucUong;
import service.CTHDService;

public class CTHDDAO extends UnicastRemoteObject  implements CTHDService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6009604866725660955L;
	private SessionFactory sessionFactory;
	public CTHDDAO(SessionFactory sessionFactory) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	public boolean addCTHD(CTHD cthd)throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	public boolean updateCTHD(int soLuong, HoaDon hd, ThucUong tu)throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			CTHD newCthd = new CTHD(hd, tu, soLuong);
			tr.begin();
			session.update(newCthd);
//			String query="update CTHD set soLuong ="+soLuong+"  where maHD="+maHD+"and maTU ="+maTU+"";
//			System.out.println(session.createNativeQuery(query));
//			session.createNativeQuery(query);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

	public List<CTHD> getCthdTheoMaHD(int maHD) throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from CTHD where maHD= " +maHD;
			List<CTHD> cthd = session.createNativeQuery(query, CTHD.class).getResultList();
			tr.commit();
			return cthd;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	};
}

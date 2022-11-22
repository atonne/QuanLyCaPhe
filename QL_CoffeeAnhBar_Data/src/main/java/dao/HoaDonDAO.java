package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.HoaDon;
import entity.LoaiThucUong;
import service.HoaDonService;

public class HoaDonDAO extends UnicastRemoteObject   implements HoaDonService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7826852998507099635L;
	private SessionFactory sessionFactory;
	public HoaDonDAO(SessionFactory sessionFactory) throws RemoteException {
		super();
		this.sessionFactory = sessionFactory;
	}

	public HoaDon getHoaDonTheoMaBan(int maBan)throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from HoaDon where maBan= " +maBan;
			HoaDon hd = session.createNativeQuery(query, HoaDon.class).getSingleResult();
			tr.commit();
//			int ma = loai.getMaLoaiTU();
			return hd;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}
	public boolean addHoaDon(HoaDon hd) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(hd);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}

}

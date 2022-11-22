package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.LoaiThucUong;
import entity.ThucUong;
import service.LoaiThucUongService;

public class LoaiThucUongDAO  extends UnicastRemoteObject implements LoaiThucUongService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -873470426863666418L;
	private SessionFactory sessionFactory;
	public LoaiThucUongDAO(SessionFactory sessionFactory)  throws RemoteException{
		super();
		this.sessionFactory = sessionFactory;
	}
	public LoaiThucUong getLoaiThucUongTheoMa(int maLoaiTU) throws RemoteException{
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			LoaiThucUong loai = session.get(LoaiThucUong.class, maLoaiTU);
			tr.commit();
			return loai;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}
	public List<ThucUong> getThucUongTheoLoai(int maLoaiTU) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from ThucUong where maLoaiTU = " + maLoaiTU;
			List<ThucUong> bans = session.createNativeQuery(query, ThucUong.class).getResultList();
			tr.commit();

			return bans;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}
	public boolean addLoaiThucUong(LoaiThucUong loai) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(loai);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	public List<LoaiThucUong> getAllLoaiThucUong() throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "select * from LoaiThucUong";
			List<LoaiThucUong> loais = session.createNativeQuery(query, LoaiThucUong.class).getResultList();
			tr.commit();

			return loais;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}
	public int getMaLoaiTheoTen(String tenLoai) throws RemoteException{
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from LoaiThucUong where tenLoaiTU= N'"+tenLoai+"'";
			LoaiThucUong loai = session.createNativeQuery(query, LoaiThucUong.class).getSingleResult();
			tr.commit();
			int ma = loai.getMaLoaiTU();
			return ma;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return 0;
	}
}

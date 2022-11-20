package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Ban;
import entity.NhanVien;
import service.NhanVienService;

public class NhanVienDAO extends UnicastRemoteObject implements NhanVienService{
	  private static final long serialVersionUID = 128484259121218939L;
		private SessionFactory sessionFactory;

		public NhanVienDAO(SessionFactory sessionFactory)  throws RemoteException{
			super();
			this.sessionFactory = sessionFactory;
		}

		public boolean addNV(NhanVien nv) throws RemoteException {

			Session session = sessionFactory.getCurrentSession();
			Transaction tr = session.getTransaction();
			try {
				tr.begin();
				session.save(nv);
				tr.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
			}
			return false;
		}
		public NhanVien getNVById(int id) throws RemoteException{
			Session session = sessionFactory.getCurrentSession();
			Transaction tr = session.getTransaction();

			try {
				tr.begin();

				NhanVien  nv = session.get(NhanVien.class, id);
				tr.commit();
				return nv;
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
			}
			return null;
		}
		public boolean updateNV(NhanVien nv) throws RemoteException{
			Session session = sessionFactory.getCurrentSession();
			Transaction tr = session.getTransaction();
			try {
				System.out.println(nv);
				tr.begin();
				session.update(nv);
				tr.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
			}
			return false;
		}
		public boolean deleteNV(NhanVien nv) throws RemoteException{
			Session session = sessionFactory.getCurrentSession();
			Transaction tr = session.getTransaction();
			try {
				tr.begin();
				session.update(nv);
				tr.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
			}
			return false;
		}
		public List<NhanVien> getListNV() throws RemoteException{
			Session session = sessionFactory.openSession();
			Transaction tr = session.getTransaction();

			try {
				tr.begin();
				String query = "select * from NhanVien";
				List<NhanVien> nvs = session.createNativeQuery(query, NhanVien.class).getResultList();
				tr.commit();

				return nvs;
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
			}
			session.close();
			return null;
		}

}

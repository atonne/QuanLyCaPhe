package app;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.MySessionFactory;
import entity.Ban;

import service.BanService;

public class App {
	public static void main(String[] args) throws RemoteException {
		SessionFactory sessionFactory = new  MySessionFactory().getSessionFactory();
		BanService banService = new BanDAO(sessionFactory);
//		Ban ban = new Ban("ban1", "Dang su dung");
//		banService.addBan(ban);
//		Ban ban1 = new Ban("ban2", "Dang su dung");
//		banService.addBan(ban1);		
//		List<Ban> ls = banService.getListBan();
//		System.out.println(ls);
	}
}

package ui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.MySessionFactory;
import entity.Ban;
import service.BanService;

public class AddObject {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/quanLyCaPhe.policy");
			System.setSecurityManager(new SecurityManager());
			}
		try {
			BanService banService = (BanService) Naming.lookup("rmi://192.168.1.99:9999/banService");
			Ban ban = new Ban("ban1", "Dang hoat dong");
			banService.addBan(ban);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//SessionFactory sessionFactory = new  MySessionFactory().getSessionFactory();
		
		new Home().setVisible(true);
	}
}

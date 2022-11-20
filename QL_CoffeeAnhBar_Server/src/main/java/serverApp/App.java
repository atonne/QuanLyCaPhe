package serverApp;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.MySessionFactory;
import service.BanService;

public class App {
public static void main(String[] args) {

	SecurityManager securityManager = System.getSecurityManager();
	if(securityManager == null) {
		System.setProperty("java.security.policy","rmi/quanLyCaPhe.policy");
		System.setSecurityManager(new SecurityManager());
	}
	
	try {

		LocateRegistry.createRegistry(9999);
		SessionFactory sessionFactory = new  MySessionFactory().getSessionFactory();
		BanService banService = new BanDAO(sessionFactory);
		
		
		
		//id
		
		Naming.bind("rmi://192.168.1.99:9999/banService", (Remote) banService);
		System.out.println("Ready...");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}

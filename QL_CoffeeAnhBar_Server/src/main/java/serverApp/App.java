package serverApp;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.KhachHangDAO;
import dao.MySessionFactory;
import dao.NhanVienDAO;
import service.BanService;
import service.KhachHangService;
import service.NhanVienService;

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
		KhachHangService khachHangService = new KhachHangDAO(sessionFactory);
		NhanVienService nhanVienService = new NhanVienDAO(sessionFactory);
		
		
		//id
		
		Naming.bind("rmi://192.168.1.3:9999/banService", (Remote) banService);
		Naming.bind("rmi://192.168.1.3:9999/khachHangService", (Remote) khachHangService);
		Naming.bind("rmi://192.168.1.3:9999/nhanVienService", (Remote) nhanVienService);
		System.out.println("Ready...");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}

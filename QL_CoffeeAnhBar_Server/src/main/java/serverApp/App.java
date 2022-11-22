package serverApp;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.CTHDDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.LoaiThucUongDAO;
import dao.MySessionFactory;
import dao.NhanVienDAO;
import dao.ThucUongDAO;
import service.BanService;
import service.CTHDService;
import service.HoaDonService;
import service.KhachHangService;
import service.LoaiThucUongService;
import service.NhanVienService;
import service.ThucUongService;

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
		LoaiThucUongService loaiThucUongService = new LoaiThucUongDAO(sessionFactory);
		ThucUongService thucUongService = new ThucUongDAO(sessionFactory);
		HoaDonService hoaDonService = new HoaDonDAO(sessionFactory);
		CTHDService cthdService = new CTHDDAO(sessionFactory);
		//id
		String ip = "192.168.1.8";
		Naming.bind("rmi://"+ip+":9999/banService", (Remote) banService);
		Naming.bind("rmi://"+ip+":9999/khachHangService", (Remote) khachHangService);
		Naming.bind("rmi://"+ip+":9999/nhanVienService", (Remote) nhanVienService);
		Naming.bind("rmi://"+ip+":9999/thucUongService", (Remote) thucUongService);
		Naming.bind("rmi://"+ip+":9999/loaiThucUongService", (Remote) loaiThucUongService);
		Naming.bind("rmi://"+ip+":9999/hoaDonService", (Remote) hoaDonService);
		Naming.bind("rmi://"+ip+":9999/cthdService", (Remote) cthdService);
		System.out.println("Ready...");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}

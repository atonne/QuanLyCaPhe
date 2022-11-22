package ui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.MySessionFactory;
import entity.Ban;
import entity.LoaiThucUong;
import entity.ThucUong;
import service.BanService;
import service.LoaiThucUongService;
import service.ThucUongService;

/*import service.CTHDService;
import service.HoaDonService;
import service.ThucUongService;
*/
public class AddObject {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/quanLyCaPhe.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
//			String ip = "192.168.1.99";
//			BanService banService = (BanService) Naming.lookup("rmi://" + ip + ":9999/banService");
//			
//			ThucUongService thucUongService = (ThucUongService) Naming.lookup("rmi://192.168.1.99:9999/thucUongService");
//			LoaiThucUongService loaiThucUongService = (LoaiThucUongService) Naming.lookup("rmi://192.168.1.99:9999/loaiThucUongService");
//			Ban ban = new Ban("ban1", "Dang hoat dong");
//			LoaiThucUong loai1 = new LoaiThucUong("pha che");
//			ThucUong tu = new ThucUong(loai1, "chanh nong", 22, 2000, "con");
//			ThucUong tu1 = new ThucUong(1, "chanh nong", 212, 2000, "con");
//			System.out.println(tu);
//			thucUongService.addThucUong(tu);
//			thucUongService.addThucUong(tu1);
//			loaiThucUongService.addLoaiThucUong(loai1);
//			loaiThucUongService.addLoaiThucUong(loai2);
//
//
//
//			banService.addBan(ban);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();

		new Home().setVisible(true);

	}
}

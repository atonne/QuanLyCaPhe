package app;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.KhachHangDAO;
import dao.MySessionFactory;
import dao.NhanVienDAO;
import entity.Ban;
import entity.KhachHang;
import entity.NhanVien;
import service.BanService;
import service.KhachHangService;
import service.NhanVienService;

public class App {
	public static void main(String[] args) throws RemoteException {
		SessionFactory sessionFactory = new  MySessionFactory().getSessionFactory();
		BanService banService = new BanDAO(sessionFactory);
		KhachHangService khachHangService = new KhachHangDAO(sessionFactory);
		NhanVienService nhanVienService = new NhanVienDAO(sessionFactory);
		
		  Ban ban = new Ban("ban3", "Dang su dung"); banService.addBan(ban); Ban ban1 =
		  new Ban("ban4", "Dang su dung"); banService.addBan(ban1); List<Ban> ls =
		  banService.getListBan(); System.out.println(ls);
		 
		 
		KhachHang kh = new KhachHang("364 Duong Quang Ham","150","0983518610","Tang Thanh Duc","22");
		khachHangService.addKH(kh);
		List<KhachHang> lss = khachHangService.getListKH();
		System.out.println(lss);
		
		NhanVien nv = new NhanVien("Quan Ly","120 Le Duan","0983156610","Le Tung Son","20");
		nhanVienService.addNV(nv);
		List<NhanVien> lsss = nhanVienService.getListNV();
		System.out.println(lsss);
	}
}

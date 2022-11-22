package app;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.BanDAO;
import dao.CTHDDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.LoaiThucUongDAO;
import dao.MySessionFactory;
import dao.NhanVienDAO;
import dao.ThucUongDAO;
import entity.Ban;
import entity.CTHD;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiThucUong;
import entity.NhanVien;
import entity.ThucUong;
import service.BanService;
import service.CTHDService;
import service.HoaDonService;
import service.KhachHangService;
import service.LoaiThucUongService;
import service.NhanVienService;
import service.ThucUongService;

public class App {
	public static void main(String[] args) throws RemoteException {
		SessionFactory sessionFactory = new  MySessionFactory().getSessionFactory();
		BanService banService = new BanDAO(sessionFactory);
		KhachHangService khachHangService = new KhachHangDAO(sessionFactory);
		NhanVienService nhanVienService = new NhanVienDAO(sessionFactory);
		LoaiThucUongService loaiThucUongService = new LoaiThucUongDAO(sessionFactory);
		ThucUongService thucUongService = new ThucUongDAO(sessionFactory);
		HoaDonService hoaDonService = new HoaDonDAO(sessionFactory);
		CTHDService cthdService = new CTHDDAO(sessionFactory);
//		  new Ban("ban4", "Dang su dung"); banService.addBan(ban1); List<Ban> ls =
//		  banService.getListBan(); System.out.println(ls);
//		 
//		 
		KhachHang kh = new KhachHang("364 Duong Quang Ham","150","0983518610","Tang Thanh Duc","22");
		khachHangService.addKH(kh);
		NhanVien nv = new NhanVien("Quan Ly","120 Le Duan","0983156610","Le Tung Son","20");
		nhanVienService.addNV(nv);
//		List<KhachHang> lss = khachHangService.getListKH();
//		System.out.println(lss);
		
		LoaiThucUong loai1 = new LoaiThucUong("pha che");
		LoaiThucUong loai2 = new LoaiThucUong("dong chai");
		loaiThucUongService.addLoaiThucUong(loai1);
		loaiThucUongService.addLoaiThucUong(loai2);
		ThucUong tu = new ThucUong(loai1, "nuoc chanh", 11, 20000, "con hang");
		ThucUong tu1 = new ThucUong(loai1, "ca phe", 11, 20000, "con hang");
		ThucUong tu2 = new ThucUong(loai2, "sting", 11, 20000, "con hang");
		ThucUong tu3 = new ThucUong(loai2, "coca cola", 31, 40000, "con hang");
		thucUongService.addThucUong(tu);
		thucUongService.addThucUong(tu1);
		thucUongService.addThucUong(tu2);
		thucUongService.addThucUong(tu3);
		Ban ban1 = new Ban("b1", "trong");
		banService.addBan(ban1);
		HoaDon hd = new HoaDon(ban1, kh, nv, 110, "", "cho thanh toan");
		hoaDonService.addHoaDon(hd);
		CTHD cthd = new CTHD(hd, tu, 2);
		cthdService.addCTHD(cthd);
		CTHD cthd1 = new CTHD(hd, tu3, 1);
		cthdService.addCTHD(cthd1);
//		cthdService.updateCTHD(5, hd, tu);
//		System.out.println(thucUongService.addThucUong(tu));
//		loaiThucUongService.addLoaiThucUong(loai2);
//		NhanVien nv = new NhanVien("Quan Ly","120 Le Duan","0983156610","Le Tung Son","20");
//		nhanVienService.addNV(nv);
//		List<NhanVien> lsss = nhanVienService.getListNV();
//		System.out.println(lsss);
	}
}

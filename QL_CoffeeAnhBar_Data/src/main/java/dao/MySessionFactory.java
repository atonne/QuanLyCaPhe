package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.Ban;
import entity.CTHD;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiThucUong;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.ThucUong;

public class MySessionFactory {
	private SessionFactory sessionFactory;

	public MySessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Ban.class)
				.addAnnotatedClass(CTHD.class)
				.addAnnotatedClass(HoaDon.class)
				.addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(LoaiThucUong.class)
				.addAnnotatedClass(NhanVien.class)
				.addAnnotatedClass(TaiKhoan.class)
				.addAnnotatedClass(ThucUong.class)
				.getMetadataBuilder()
				.build();
		
		 sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void close() {
		sessionFactory.close();
	}
}

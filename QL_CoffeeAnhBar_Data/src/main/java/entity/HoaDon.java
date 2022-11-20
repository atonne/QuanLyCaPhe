package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDon")
public class HoaDon  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 355989650484468765L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maHD;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "maBan")
	private Ban ban;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	private double donGia;
	private String phuThu;
	private String trangThai;
	public HoaDon(int maHD, Ban ban, KhachHang khachHang, NhanVien nhanVien, double donGia, String phuThu,
			String trangThai) {
		super();
		this.maHD = maHD;
		this.ban = ban;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.donGia = donGia;
		this.phuThu = phuThu;
		this.trangThai = trangThai;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public Ban getBan() {
		return ban;
	}
	public void setBan(Ban ban) {
		this.ban = ban;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getPhuThu() {
		return phuThu;
	}
	public void setPhuThu(String phuThu) {
		this.phuThu = phuThu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHD;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHD != other.maHD)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ban=" + ban + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", donGia=" + donGia + ", phuThu=" + phuThu + ", trangThai=" + trangThai + "]";
	}
	
	
}

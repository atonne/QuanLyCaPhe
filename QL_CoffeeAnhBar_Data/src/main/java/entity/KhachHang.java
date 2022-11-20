package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 787887305641974545L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maKH;
	private String tenKH;
	private String sdt;
	private String diaChi;
	private String tuoi;

	private String diemTichLuy;
	public KhachHang(int maKH, String diaChi,String diemTichLuy, String sdt,String tenKH,  String tuoi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
		this.diemTichLuy = diemTichLuy;
	}
	public KhachHang( String diaChi,String diemTichLuy, String sdt,String tenKH,  String tuoi) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
		this.diemTichLuy = diemTichLuy;
		// TODO Auto-generated constructor stub
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + ", ngaySinh="
				+ tuoi + ", tuoi="  + ", diemTichLuy=" + diemTichLuy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maKH;
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
		KhachHang other = (KhachHang) obj;
		if (maKH != other.maKH)
			return false;
		return true;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(String diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7145026730025656937L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNV;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;
	
	private String tenNhanVien;
	private String chucVu;
	private String gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String sdt;
	private String caLamViec;
	public NhanVien(int maNV, TaiKhoan taiKhoan, String tenNhanVien, String chucVu, String gioiTinh, Date ngaySinh,
			String diaChi, String sdt, String caLamViec) {
		super();
		this.maNV = maNV;
		this.taiKhoan = taiKhoan;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.caLamViec = caLamViec;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCaLamViec() {
		return caLamViec;
	}
	public void setCaLamViec(String caLamViec) {
		this.caLamViec = caLamViec;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maNV;
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
		NhanVien other = (NhanVien) obj;
		if (maNV != other.maNV)
			return false;
		return true;
	}
	
	
	
}

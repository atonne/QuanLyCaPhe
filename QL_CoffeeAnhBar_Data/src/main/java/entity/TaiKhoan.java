package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1092368840945608769L;
	@Id
	private int maTK;
	private String matKhau;
	private String loaiTK;
	@OneToOne
	@MapsId
	@JoinColumn(name="maTK") 
	private NhanVien nhanVien;
	public TaiKhoan(int maTK, String matKhau, String loaiTK, NhanVien nhanVien) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
		this.loaiTK = loaiTK;
		this.nhanVien = nhanVien;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaTK() {
		return maTK;
	}
	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", matKhau=" + matKhau + ", loaiTK=" + loaiTK + ", nhanVien=" + nhanVien
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maTK;
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maTK != other.maTK)
			return false;
		return true;
	}

	
}	

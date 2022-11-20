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
public class NhanVien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7145026730025656937L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNV;
	private String tenNhanVien;
	private String chucVu;
	private String tuoi;
	private String diaChi;
	private String sdt;

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
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

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NhanVien( String chucVu,String diaChi,  String sdt,String tenNhanVien, String tuoi) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public NhanVien(int maNV, String chucVu,String diaChi,  String sdt,String tenNhanVien, String tuoi) {
		super();
		this.maNV = maNV;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
		this.sdt = sdt;
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

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNhanVien=" + tenNhanVien + ", chucVu=" + chucVu + ", tuoi=" + tuoi
				+ ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
	}

}

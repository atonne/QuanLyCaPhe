package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ThucUong")
public class ThucUong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3322050232451129199L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maTU;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maLoaiTU")
	private LoaiThucUong loaiThucUong;
	private String tenTU;
	private int soLuongTU;
	private double giaTU;
	private String trangThai;
	public ThucUong(int maTU, LoaiThucUong loaiThucUong, String tenTU, int soLuongTU, double giaTU, String trangThai) {
		super();
		this.maTU = maTU;
		this.loaiThucUong = loaiThucUong;
		this.tenTU = tenTU;
		this.soLuongTU = soLuongTU;
		this.giaTU = giaTU;
		this.trangThai = trangThai;
	}
	public ThucUong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThucUong(LoaiThucUong loaiThucUong, String tenTU, int soLuongTU, double giaTU, String trangThai) {
		this.loaiThucUong = loaiThucUong;
		this.tenTU = tenTU;
		this.soLuongTU = soLuongTU;
		this.giaTU = giaTU;
		this.trangThai = trangThai;
	}
	public int getMaTU() {
		return maTU;
	}
	public void setMaTU(int maTU) {
		this.maTU = maTU;
	}
	public LoaiThucUong getLoaiThucUong() {
		return loaiThucUong;
	}
	public void setLoaiThucUong(LoaiThucUong loaiThucUong) {
		this.loaiThucUong = loaiThucUong;
	}
	public String getTenTU() {
		return tenTU;
	}
	public void setTenTU(String tenTU) {
		this.tenTU = tenTU;
	}
	public int getSoLuongTU() {
		return soLuongTU;
	}
	public void setSoLuongTU(int soLuongTU) {
		this.soLuongTU = soLuongTU;
	}
	public double getGiaTU() {
		return giaTU;
	}
	public void setGiaTU(double giaTU) {
		this.giaTU = giaTU;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "ThucUong [maTU=" + maTU + ", loaiThucUong=" + loaiThucUong + ", tenTU=" + tenTU + ", soLuongTU="
				+ soLuongTU + ", giaTU=" + giaTU + ", trangThai=" + trangThai + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maTU;
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
		ThucUong other = (ThucUong) obj;
		if (maTU != other.maTU)
			return false;
		return true;
	}
	
	
	
	
	
}

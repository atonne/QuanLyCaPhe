package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CTHD")
@IdClass(PKCTHD.class)
public class CTHD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1320622232109323632L;

	@Id
	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;

	@Id
	@ManyToOne
	@JoinColumn(name = "maTU")
	private ThucUong thucUong;
	
	private int soLuong;

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public ThucUong getThucUong() {
		return thucUong;
	}

	public void setThucUong(ThucUong thucUong) {
		this.thucUong = thucUong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public CTHD(HoaDon hoaDon, ThucUong thucUong, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.thucUong = thucUong;
		this.soLuong = soLuong;
	}

	public CTHD() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CTHD [hoaDon=" + hoaDon + ", thucUong=" + thucUong + ", soLuong=" + soLuong + "]";
	}
	

	
	
}

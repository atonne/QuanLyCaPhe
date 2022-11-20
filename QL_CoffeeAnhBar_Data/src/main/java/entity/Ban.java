package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ban")
public class Ban  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6268656201216901040L;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maBan;
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
		Ban other = (Ban) obj;
		if (maBan != other.maBan)
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maBan;
	private String tenBan;
	private String tinhTrangBan;
	public Ban(int maBan, String tenBan, String tinhTrangBan) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.tinhTrangBan = tinhTrangBan;
	}
	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ban(String tenBan, String tinhTrangBan) {
		super();
		this.tenBan = tenBan;
		this.tinhTrangBan = tinhTrangBan;
	}
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	public String getTenBan() {
		return tenBan;
	}
	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}
	public String getTinhTrangBan() {
		return tinhTrangBan;
	}
	public void setTinhTrangBan(String tinhTrangBan) {
		this.tinhTrangBan = tinhTrangBan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", tenBan=" + tenBan + ", tinhTrangBan=" + tinhTrangBan + "]";
	}
	
	
}

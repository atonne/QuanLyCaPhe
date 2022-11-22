package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiThucUong")
public class LoaiThucUong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6964507822200939024L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maLoaiTU;
	private String tenLoaiTU;
	public LoaiThucUong(int maLoaiTU, String tenLoaiTU) {
		super();
		this.maLoaiTU = maLoaiTU;
		this.tenLoaiTU = tenLoaiTU;
	}
	public LoaiThucUong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiThucUong(String string) {
		// TODO Auto-generated constructor stub
		this.tenLoaiTU = string;
	}
	public int getMaLoaiTU() {
		return maLoaiTU;
	}
	public void setMaLoaiTU(int maLoaiTU) {
		this.maLoaiTU = maLoaiTU;
	}
	public String getTenLoaiTU() {
		return tenLoaiTU;
	}
	public void setTenLoaiTU(String tenLoaiTU) {
		this.tenLoaiTU = tenLoaiTU;
	}
	@Override
	public String toString() {
		return "LoaiThucUong [maLoaiTU=" + maLoaiTU + ", tenLoaiTU=" + tenLoaiTU + "]";
	}

	
}

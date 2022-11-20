package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PKCTHD  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7306520809727286402L;
	/**
	 * 
	 */
	
	private int thucUong;
	private int hoaDon;
	public PKCTHD() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hoaDon;
		result = prime * result + thucUong;
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
		PKCTHD other = (PKCTHD) obj;
		if (hoaDon != other.hoaDon)
			return false;
		if (thucUong != other.thucUong)
			return false;
		return true;
	}

	
}

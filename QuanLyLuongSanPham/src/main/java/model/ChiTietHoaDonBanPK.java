package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonBanPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3631092147376716387L;
	private String sanPham;
	private String hoaDonBanHang;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDonBanHang == null) ? 0 : hoaDonBanHang.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
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
		ChiTietHoaDonBanPK other = (ChiTietHoaDonBanPK) obj;
		if (hoaDonBanHang == null) {
			if (other.hoaDonBanHang != null)
				return false;
		} else if (!hoaDonBanHang.equals(other.hoaDonBanHang))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	public ChiTietHoaDonBanPK() {
		super();
	}
	
	
}

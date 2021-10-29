package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonNhapPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004244576179007899L;

	private String hoaDonNhapHang;
	private String sanPham;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDonNhapHang == null) ? 0 : hoaDonNhapHang.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}

	public ChiTietHoaDonNhapPK() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonNhapPK other = (ChiTietHoaDonNhapPK) obj;
		if (hoaDonNhapHang == null) {
			if (other.hoaDonNhapHang != null)
				return false;
		} else if (!hoaDonNhapHang.equals(other.hoaDonNhapHang))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}

}

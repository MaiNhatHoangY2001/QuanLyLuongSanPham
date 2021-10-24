package collections;

import model.SanPham;

public class MatHang {
	private SanPham sanPham;
	private int soLuong;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MatHang other = (MatHang) obj;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}

	public MatHang(SanPham sanPham, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "MatHang [sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
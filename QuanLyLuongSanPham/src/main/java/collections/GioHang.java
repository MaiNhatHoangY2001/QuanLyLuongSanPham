package collections;

import java.io.Serializable;
import java.util.Vector;

import model.SanPham;

public class GioHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<MatHang> gioHang;

	public GioHang() {
		gioHang = new Vector<MatHang>();
	}
	/**
	 * Thêm mới một mặt hàng
	 * @param sanPham
	 * @param soLuong
	 * @return
	 */
	public boolean themMatHang(SanPham sanPham, int soLuong) {
		return gioHang.add(new MatHang(sanPham, soLuong));
	}
	/**
	 * Thêm một mặt hàng có sẵn
	 * @param matHang
	 * @return
	 */
	public boolean themMatHang(MatHang matHang) {
		if (gioHang.contains(matHang))
			return false;
		return gioHang.add(matHang);
	}
	/**
	 * Xóa mặt hàng khi biết vị trí
	 * @param index
	 * @return
	 */
	public boolean xoaMatHang(int index) {
		if (index < 0 || index >= gioHang.size())
			return false;
		gioHang.remove(index);
		return true;
	}

	/**
	 * Lấy mặt hàng khi biết vị trí
	 * @param index
	 * @return
	 */
	public MatHang getMatHang(int index) {
		if (index < 0 || index >= gioHang.size())
			return null;
		return gioHang.get(index);
	}

	/**
	 * lấy số phần tử của giỏ hàng
	 * @return
	 */
	public int getSize() {
		return gioHang.size();
	}
	/**
	 * lấy vị trí
	 * @param matHang
	 * @return
	 */
	public int getIndex(MatHang matHang) {
		return gioHang.indexOf(matHang);
	}
}



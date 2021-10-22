package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChiTietHoaDonNhapPK.class)
@Table(name = "ChiTietHoaDonNhap")
public class ChiTietHoaDonNhap {
	private double donGia;
	private int soLoHang;//so san pham
	@Id
	@ManyToOne
	@JoinColumn(name="maHoaDonNhap")
	private HoaDonNhapHang hoaDonNhapHang;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;
	public double tinhTongTien() {
		return 0;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonNhap [donGia=" + donGia + ", soLoHang=" + soLoHang + "]";
	}
	
}

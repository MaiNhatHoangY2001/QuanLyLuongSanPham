package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChiTietHoaDonBanPK.class)
@Table(name = "ChiTietHoaDonBan")
public class ChiTietHoaDonBan {
	private double donGia;
	private double soLuong;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDonBan")
	private HoaDonBanHang hoaDonBanHang;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;

	public double tinhTongTien() {
		return 0;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonBan [donGia=" + donGia + ", soLuong=" + soLuong +"]";
	}
}

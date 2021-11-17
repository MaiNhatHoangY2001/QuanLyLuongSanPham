/**
 * Chi tiết hóa đơn
 * Ngày tạo: 20/10/2021
 * Nguoi tạo: Hoàng Văn Chinh
 * Người tham gia chỉnh sửa, update : Mai Nhật Hoàng, Ngọc Long
 */
package model;

import javax.persistence.Column;
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
	@Column(columnDefinition = "money")
	private double donGia;
	private int soLuong;

	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDonBan")
	private HoaDonBanHang hoaDonBanHang;

	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;

	/**
	 * Tính tổng tiền
	 * @return
	 */
	public double tinhTongTien() {
		return donGia * soLuong + 100000;
	}

	public ChiTietHoaDonBan(double donGia, int soLuong, HoaDonBanHang hoaDonBanHang, SanPham sanPham) {
		super();
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.hoaDonBanHang = hoaDonBanHang;
		this.sanPham = sanPham;
	}

	public ChiTietHoaDonBan() {
		super();
	}


	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public HoaDonBanHang getHoaDonBanHang() {
		return hoaDonBanHang;
	}

	public void setHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
		this.hoaDonBanHang = hoaDonBanHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonBan [donGia=" + donGia + ", soLuong=" + soLuong + ", hoaDonBanHang=" + hoaDonBanHang
				+ ", sanPham=" + sanPham + "]";
	}

}

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
	private int soLuong;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDonBan")
	private HoaDonBanHang hoaDonBanHang;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;

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

	public ChiTietHoaDonBan() {
		super();
	}

	public ChiTietHoaDonBan(double donGia, int soLuong, HoaDonBanHang hoaDonBanHang, SanPham sanPham) {
		super();
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.hoaDonBanHang = hoaDonBanHang;
		this.sanPham = sanPham;
	}

	public double tinhTongTien() {
		return soLuong * donGia;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonBan [donGia=" + donGia + ", soLuong=" + soLuong +"]";
	}
}

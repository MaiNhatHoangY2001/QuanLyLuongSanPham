package model;

import javax.persistence.Column;
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
	@Column(columnDefinition = "money")
	private double donGia;
	private int soLoHang;// so san pham
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDonNhap")
	private HoaDonNhapHang hoaDonNhapHang;

	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham")
	private SanPham sanPham;

	public ChiTietHoaDonNhap(double donGia, int soLoHang) {
		super();
		this.donGia = donGia;
		this.soLoHang = soLoHang;
	}

	public double tinhTongTien() {
		return donGia * soLoHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLoHang() {
		return soLoHang;
	}

	public void setSoLoHang(int soLoHang) {
		this.soLoHang = soLoHang;
	}

	public HoaDonNhapHang getHoaDonNhapHang() {
		return hoaDonNhapHang;
	}

	public void setHoaDonNhapHang(HoaDonNhapHang hoaDonNhapHang) {
		this.hoaDonNhapHang = hoaDonNhapHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDonNhap [donGia=" + donGia + ", soLoHang=" + soLoHang + "]";
	}

}

package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "HoaDonBanHang")
public class HoaDonBanHang {
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(name = "sinhMaTheoNgay", parameters = @Parameter(name = "prefix", value = "HB"), strategy = "generator.SinhMaTheoNgay")

	private String maHoaDonBan;
	private LocalDate ngayLapHoaDon;
	private double khuyenMai;
	private double thue;
	@Column(columnDefinition = "money")
	private double thanhTien;

	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;

	@OneToMany(mappedBy = "hoaDonBanHang")
	private List<ChiTietHoaDonBan> dsChiTietHoaDonBan;

	public HoaDonBanHang(double khuyenMai, double thue, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.ngayLapHoaDon = LocalDate.now();
		this.khuyenMai = khuyenMai;
		this.thue = thue;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	public double tinhThanhTien() {
		this.thanhTien = 0;
		dsChiTietHoaDonBan.forEach(i -> {
			this.thanhTien += i.tinhTongTien();
		});
		this.thanhTien = this.thanhTien + this.thanhTien * thue / 100 - this.thanhTien * khuyenMai / 100;
		return this.thanhTien;
	}

	public double tinhThue() {
		return thanhTien * thue;
	}

	public String getMaHoaDonBan() {
		return maHoaDonBan;
	}

	public void setMaHoaDonBan(String maHoaDonBan) {
		this.maHoaDonBan = maHoaDonBan;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(double khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<ChiTietHoaDonBan> getDsChiTietHoaDonBan() {
		return dsChiTietHoaDonBan;
	}

	public void setDsChiTietHoaDonBan(List<ChiTietHoaDonBan> dsChiTietHoaDonBan) {
		this.dsChiTietHoaDonBan = dsChiTietHoaDonBan;
		this.tinhThanhTien();
	}

	public HoaDonBanHang() {
		super();
	}

	public HoaDonBanHang(String maHoaDonBan) {
		super();
		this.maHoaDonBan = maHoaDonBan;
	}

	public HoaDonBanHang(double khuyenMai, double thue) {
		super();
		this.ngayLapHoaDon = LocalDate.now();
		this.khuyenMai = khuyenMai;
		this.thue = thue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDonBan == null) ? 0 : maHoaDonBan.hashCode());
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
		HoaDonBanHang other = (HoaDonBanHang) obj;
		if (maHoaDonBan == null) {
			if (other.maHoaDonBan != null)
				return false;
		} else if (!maHoaDonBan.equals(other.maHoaDonBan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoaDonBanHang [maHoaDonBan=" + maHoaDonBan + ", ngayLapHoaDon=" + ngayLapHoaDon + ", khuyenMai="
				+ khuyenMai + ", thue=" + thue + ", thanhTien=" + thanhTien + "]";
	}
}

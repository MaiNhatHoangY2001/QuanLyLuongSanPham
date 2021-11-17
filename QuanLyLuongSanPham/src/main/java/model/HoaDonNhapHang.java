/**
 * Hóa đơn nhập hàng
 * Ngày tạo: 20/10/2021
 * Nguoi tạo: Hoàng Văn Chinh
 * người tham gia chỉnh sửa, update : Mai Nhật Hoàng, Ngọc Long
 */
package model;

import java.time.LocalDate;
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
@Table(name = "HoaDonNhapHang")
public class HoaDonNhapHang {
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(name = "sinhMaTheoNgay", parameters = @Parameter(name = "prefix", value = "HN"), strategy = "generator.SinhMaTheoNgay")
	
	private String maHoaDonNhap;
	private LocalDate ngayLapHoaDon;
	private double thue;

	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "hoaDonNhapHang")
	private List<ChiTietHoaDonNhap> dsChiTietHoaDonNhap;
	@Column(columnDefinition = "money")
	private double thanhTien;

	
	public HoaDonNhapHang(double thue, NhanVien nhanVien) {
		super();
		this.ngayLapHoaDon=LocalDate.now();
		this.thue = thue;
		this.nhanVien = nhanVien;
	}

	public double tinhThanhTien() {
		this.thanhTien = 0;
		dsChiTietHoaDonNhap.forEach(ct -> {
			this.thanhTien += ct.tinhTongTien();
		});
		this.thanhTien = this.thanhTien + this.thanhTien * thue;
		return this.thanhTien;
	}

	public HoaDonNhapHang(double thue) {
		super();
		this.thue = thue;
	}

	public HoaDonNhapHang() {
		super();
	}

	public double tinhThue() {
		return thue;
	}

	public String getMaHoaDonNhap() {
		return maHoaDonNhap;
	}

	public void setMaHoaDonNhap(String maHoaDonNhap) {
		this.maHoaDonNhap = maHoaDonNhap;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<ChiTietHoaDonNhap> getDsChiTietHoaDonNhap() {
		return dsChiTietHoaDonNhap;
	}

	public void setDsChiTietHoaDonNhap(List<ChiTietHoaDonNhap> dsChiTietHoaDonNhap) {
		this.dsChiTietHoaDonNhap = dsChiTietHoaDonNhap;
		tinhThanhTien();
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "HoaDonNhapHang [maHoaDonNhap=" + maHoaDonNhap + ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue
				+ ", thanhTien=" + thanhTien + "]";
	}
}

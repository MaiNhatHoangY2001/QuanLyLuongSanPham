package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HoaDonNhapHang")
public class HoaDonNhapHang {
	@Id
	@GeneratedValue(generator = "sinhMaHoaDonNhap")
	@GenericGenerator(name = "sinhMaHoaDonNhap", strategy = "generator.SinhMaHoaDonNhap")
	private String maHoaDonNhap;
	private LocalDate ngayLapHoaDon;
	private double thue;
	
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	@OneToMany(mappedBy = "hoaDonNhapHang")
	private List<ChiTietHoaDonNhap> dsChiTietHoaDonNhap;
	private double thanhTien;
	
	public double tinhThanhTien() {
		return thanhTien;
	}
	public double tinhThue() {
		return 0;
	}
	@Override
	public String toString() {
		return "HoaDonNhapHang [maHoaDonNhap=" + maHoaDonNhap + ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue
				+ ", thanhTien=" + thanhTien + "]";
	}
}

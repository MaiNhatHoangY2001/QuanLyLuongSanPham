package model;

/**
 * Ngày tạo: 20/10/2021
 * nguoi tạo: Hoàng Văn Chinh
 * người tham gia chỉnh sửa, update : Mai Nhật Hoàng
 */
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "BangLuong")
public class BangLuong {
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(name = "sinhMaTheoNgay", parameters = @Parameter(name = "prefix", value = "BL"), strategy = "generator.SinhMaTheoNgay")
	private String maBangLuong;
	private LocalDate thoiGian;
	private double heSoLuong;
	@Column(columnDefinition = "money")
	private double tienSanPham;
	private int soNgayCong;
	private double thuong;
	private double phat;
	private boolean datKpi;
	private double doanhThu;
	private double luong;
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;

	public String getMaBangLuong() {
		return maBangLuong;
	}

	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}

	public LocalDate getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDate thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getTienSanPham() {
		return tienSanPham;
	}

	public void setTienSanPham(double tienSanPham) {
		this.tienSanPham = tienSanPham;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public double getThuong() {
		return thuong;
	}

	public void setThuong(double thuong) {
		this.thuong = thuong;
	}

	public double getPhat() {
		return phat;
	}

	public void setPhat(double phat) {
		this.phat = phat;
	}

	public boolean isDatKpi() {
		return datKpi;
	}

	public void setDatKpi(boolean datKpi) {
		this.datKpi = datKpi;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public double getLuong() {
		return luong;
	}

	public BangLuong(LocalDate thoiGian, double heSoLuong, double tienSanPham, int soNgayCong, double thuong,
			double phat, boolean datKpi, double doanhThu, NhanVien nhanVien) {
		super();
		this.thoiGian = thoiGian;
		this.heSoLuong = heSoLuong;
		this.tienSanPham = tienSanPham;
		this.soNgayCong = soNgayCong;
		this.thuong = thuong;
		this.phat = phat;
		this.datKpi = datKpi;
		this.doanhThu = doanhThu;
		this.nhanVien = nhanVien;
		this.luong = tinhLuong();
	}

	public BangLuong() {
		super();
	}

	@Override
	public String toString() {
		return "BangLuong [maBangLuong=" + maBangLuong + ", thoiGian=" + thoiGian + ", heSoLuong=" + heSoLuong
				+ ", tienSanPham=" + tienSanPham + ", soNgayCong=" + soNgayCong + "]";
	}

	/**
	 * Tính lương 1 phần chưa có tổng doang thu Công thức tính lương: hệ số lương *
	 * mức lương * số ngày công + tiền sản phẩm * 5% + tổng doanh thu * 1% +
	 * thưởng(bao gồm nghỉ lễ) - (26 - songaycong) * 500.000
	 * 
	 * @return
	 */
	public double tinhLuong() {
		int songaynghi = soNgayCong >= 26 ? 0 : 26 - soNgayCong;
		double luong = 0;
		if (songaynghi > 10) {
			return 0;
		} else {
			if (heSoLuong == 1) {
				if (datKpi) {
					luong = nhanVien.getMucLuong() * heSoLuong * soNgayCong + tienSanPham * 0.05 + thuong - phat
							- songaynghi * 500000 + 0.0001 * doanhThu;
				} else {
					luong = nhanVien.getMucLuong() * heSoLuong * soNgayCong + thuong - phat - songaynghi * 500000
							+ 0.0001 * doanhThu;
				}

			} else {
				luong = nhanVien.getMucLuong() * heSoLuong * soNgayCong + thuong - phat - songaynghi * 500000
						+ 0.0001 * doanhThu;
			}

		}
		return luong < 0 ? 0 : luong;
	}

}

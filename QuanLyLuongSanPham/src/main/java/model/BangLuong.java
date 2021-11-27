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

	public BangLuong(LocalDate thoiGian, double heSoLuong, double tienSanPham, int soNgayCong) {
		super();
		this.thoiGian = thoiGian;
		this.heSoLuong = heSoLuong;
		this.tienSanPham = tienSanPham;
		this.soNgayCong = soNgayCong;
	}

	public BangLuong() {
		super();
	}

	@Override
	public String toString() {
		return "BangLuong [maBangLuong=" + maBangLuong + ", thoiGian=" + thoiGian + ", heSoLuong=" + heSoLuong
				+ ", tienSanPham=" + tienSanPham + ", soNgayCong=" + soNgayCong + "]";
	}

	public double tinhLuong() {
		return nhanVien.getMucLuong() * heSoLuong * soNgayCong + tienSanPham * 0.1;
	}
}

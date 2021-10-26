package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BangLuong")
public class BangLuong {
	@Id
	@GeneratedValue(generator = "sinhMaBangLuong")
	@GenericGenerator(name = "sinhMaBangLuong", strategy = "generator.SinhMaBangLuong")
	private String maBangLuong;
	private LocalDate thoiGian;
	private double mucLuong;
	private double heSoLuong;
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

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
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

	public BangLuong(String maBangLuong, LocalDate thoiGian, double mucLuong, double heSoLuong, double tienSanPham,
			int soNgayCong, NhanVien nhanVien) {
		super();
		this.maBangLuong = maBangLuong;
		this.thoiGian = thoiGian;
		this.mucLuong = mucLuong;
		this.heSoLuong = heSoLuong;
		this.tienSanPham = tienSanPham;
		this.soNgayCong = soNgayCong;
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "BangLuong [maBangLuong=" + maBangLuong + ", thoiGian=" + thoiGian + ", mucLuong=" + mucLuong
				+ ", heSoLuong=" + heSoLuong + ", tienSanPham=" + tienSanPham + ", soNgayCong=" + soNgayCong + "]";
	}

	public double tinhLuong() {
		return 0;
	}
}

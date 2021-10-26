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

	@Override
	public String toString() {
		return "BangLuong [maBangLuong=" + maBangLuong + ", thoiGian=" + thoiGian + ", mucLuong=" + mucLuong
				+ ", heSoLuong=" + heSoLuong + ", tienSanPham=" + tienSanPham + ", soNgayCong=" + soNgayCong + "]";
	}
	public double tinhLuong() {
		return 0;
	}
}

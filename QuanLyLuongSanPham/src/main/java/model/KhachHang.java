package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="KhachHang")
public class KhachHang {
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(	name = "sinhMaTheoNgay",
						parameters = @Parameter(name="prefix",value = "KH"),
						strategy = "generator.SinhMaTheoNgay")
	private String maKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private String sDT;
	
	@OneToMany(mappedBy = "khachHang")
	private List<HoaDonBanHang> dsHoaDonBanHang;

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", sDT=" + sDT + "]";
	}
}

package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="KhachHang")
public class KhachHang {
	@Id
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

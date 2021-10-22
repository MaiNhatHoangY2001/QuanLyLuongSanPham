package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	private String maSanpham;
	private String tenSanPham;
	private double giaThanh;
	private String nCC;
	private String loai;
	private LocalDate ngaySanXuat;

	@OneToMany(mappedBy = "sanPham")
	private List<ChiTietHoaDonNhap> dsChiTietHoaDonNhap;
	@OneToMany(mappedBy = "sanPham")
	private List<ChiTietHoaDonBan> dsChiTietHoaDonBan;

	@Override
	public String toString() {
		return "SanPham [maSanpham=" + maSanpham + ", tenSanPham=" + tenSanPham + ", giaThanh=" + giaThanh + ", nCC="
				+ nCC + ", loai=" + loai + ", ngaySanXuat=" + ngaySanXuat + "]";
	}
}

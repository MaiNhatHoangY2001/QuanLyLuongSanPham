package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(generator = "sinhMaSanPham")
	@GenericGenerator(name = "sinhMaSanPham",
						parameters = @Parameter(name="prefix", value = "SP"),
						strategy = "generator.SinhMaSanPham")
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

	public SanPham() {
	}

	@Override
	public String toString() {
		return "SanPham [maSanpham=" + maSanpham + ", tenSanPham=" + tenSanPham + ", giaThanh=" + giaThanh + ", nCC="
				+ nCC + ", loai=" + loai + ", ngaySanXuat=" + ngaySanXuat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSanpham == null) ? 0 : maSanpham.hashCode());
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
		SanPham other = (SanPham) obj;
		if (maSanpham == null) {
			if (other.maSanpham != null)
				return false;
		} else if (!maSanpham.equals(other.maSanpham))
			return false;
		return true;
	}

	public String getMaSanpham() {
		return maSanpham;
	}

	public void setMaSanpham(String maSanpham) {
		this.maSanpham = maSanpham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}

	public String getnCC() {
		return nCC;
	}

	public void setnCC(String nCC) {
		this.nCC = nCC;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public List<ChiTietHoaDonNhap> getDsChiTietHoaDonNhap() {
		return dsChiTietHoaDonNhap;
	}

	public void setDsChiTietHoaDonNhap(List<ChiTietHoaDonNhap> dsChiTietHoaDonNhap) {
		this.dsChiTietHoaDonNhap = dsChiTietHoaDonNhap;
	}

	public List<ChiTietHoaDonBan> getDsChiTietHoaDonBan() {
		return dsChiTietHoaDonBan;
	}

	public void setDsChiTietHoaDonBan(List<ChiTietHoaDonBan> dsChiTietHoaDonBan) {
		this.dsChiTietHoaDonBan = dsChiTietHoaDonBan;
	}

	public SanPham(String tenSanPham, double giaThanh, String nCC, String loai, LocalDate ngaySanXuat) {
		super();
		this.tenSanPham = tenSanPham;
		this.giaThanh = giaThanh;
		this.nCC = nCC;
		this.loai = loai;
		this.ngaySanXuat = ngaySanXuat;
	}
}

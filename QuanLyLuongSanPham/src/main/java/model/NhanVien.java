package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(	name = "sinhMaTheoNgay",
						parameters = @Parameter(name="prefix",value = "NV"),
						strategy = "generator.SinhMaTheoNgay")
	private String maNhanVien;
	private String tenNhanVien;
	private String diaChi;
	private String sDT;
	@Column(columnDefinition = "varchar(12)")
	private String cCCD;
	private boolean trangThaiLamViec;
	private String email;
	private LocalDate ngaySinh;

	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;

	@OneToMany(mappedBy = "nhanVien")
	private List<BangLuong> dsBangLuong;

	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDonNhapHang> dsHoaDonNhapHang;
	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDonBanHang> dsHoaDonBanHang;

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi + ", sDT="
				+ sDT + ", cCCD=" + cCCD + ", trangThaiLamViec=" + trangThaiLamViec + ", email=" + email + ", ngaySinh="
				+ ngaySinh + "]";
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public boolean gettrangThaiLamViec() {
		return trangThaiLamViec;
	}

	public void settrangThaiLamViec(boolean trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<BangLuong> getDsBangLuong() {
		return dsBangLuong;
	}

	public void setDsBangLuong(List<BangLuong> dsBangLuong) {
		this.dsBangLuong = dsBangLuong;
	}

	public List<HoaDonNhapHang> getDsHoaDonNhapHang() {
		return dsHoaDonNhapHang;
	}

	public void setDsHoaDonNhapHang(List<HoaDonNhapHang> dsHoaDonNhapHang) {
		this.dsHoaDonNhapHang = dsHoaDonNhapHang;
	}

	public List<HoaDonBanHang> getDsHoaDonBanHang() {
		return dsHoaDonBanHang;
	}

	public void setDsHoaDonBanHang(List<HoaDonBanHang> dsHoaDonBanHang) {
		this.dsHoaDonBanHang = dsHoaDonBanHang;
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}

	public NhanVien(String tenNhanVien, String diaChi, String sDT, String cCCD, boolean trangThaiLamViec, String email,
			LocalDate ngaySinh) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.cCCD = cCCD;
		this.trangThaiLamViec = trangThaiLamViec;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}
}

package services;

import java.util.List;

import dao.BangLuongDao;
import dao.ChiTietHoaDonBanDao;
import dao.NhanVienDao;
import model.BangLuong;
import model.ChiTietHoaDonBan;
import model.NhanVien;

public class QuanLyLuongService {
	private ChiTietHoaDonBanDao chiTietHoaDonBanDao = new ChiTietHoaDonBanDao();
	private BangLuongDao bangLuongDao = new BangLuongDao();
	private NhanVienDao nhanVienDao = new NhanVienDao();

	public boolean kiemTraNhanVien(String maNhanVien) {
		return nhanVienDao.kiemTraNhanVien(maNhanVien);
	}

	public boolean updateSoNgayCong(String maNhanVien, int month, int year, int soNgayCong) {
		return bangLuongDao.updateSoNgayCong(maNhanVien, month, year, soNgayCong);
	}

	public boolean updateThuong(String maNhanVien, int month, int year, double thuong) {
		return bangLuongDao.updateThuong(maNhanVien, month, year, thuong);
	}

	public boolean updatePhat(String maNhanVien, int month, int year, double phat) {
		return bangLuongDao.updatePhat(maNhanVien, month, year, phat);
	}

	public List<NhanVien> get10NhanVienTheoKhoang(int from, int month, int year) {
		return nhanVienDao.get10NhanVienTheoKhoang(from, month, year);
	}

	public List<NhanVien> get10NhanVienHanhChinh(int from, int month, int year) {
		return nhanVienDao.get10NhanVienHanhChinh(from, month, year);
	}

	public List<NhanVien> get10NhanVienBanHang(int from, int month, int year) {
		return nhanVienDao.get10NhanVienBanHang(from, month, year);
	}

	public List<NhanVien> getNhanVienTheoThoiGian(int month, int year) {
		return nhanVienDao.getNhanVienTheoThoiGian(month, year);
	}

	public List<NhanVien> getNhanVienBHTheoThoiGian(int month, int year) {
		return nhanVienDao.getNhanVienBHTheoThoiGian(month, year);
	}

	public List<NhanVien> getNhanVienHCTheoThoiGian(int month, int year) {
		return nhanVienDao.getNhanVienHCTheoThoiGian(month, year);
	}

	public List<NhanVien> getAllNhanVien() {
		return nhanVienDao.getDsNhanVien();
	}

	public NhanVien getNhanVien(String maNhanVien) {
		return nhanVienDao.getNhanVienTheoMa(maNhanVien);
	}

	public boolean deleteAllBangLuongInTime(int month, int year) {
		return bangLuongDao.deleteAllBangLuongInTime(month, year);
	}

	public boolean themBangLuong(BangLuong bangLuong) {
		return bangLuongDao.themBangLuong(bangLuong);
	}

	public double getTienSanPham(String maNhanVien, int month, int year) {
		return bangLuongDao.getTienSanPham(maNhanVien, month, year);

	}

	public BangLuong getBangLuongTheoMaNhanVien(String maNhanVien, int year, int month) {
		return bangLuongDao.getBangLuongTheoMaNhanVien(maNhanVien, year, month);
	}

	public List<ChiTietHoaDonBan> getChiTietTheoMaNV(String maNhanVien, int month, int year) {
		return chiTietHoaDonBanDao.getChiTietTheoMaNV(maNhanVien, month, year);
	}

	public int getSoLuongBangLuong(int month, int year) {
		return bangLuongDao.getSoLuongBangLuong(month, year);
	}

	public int getSoLuongBangLuongBanHang(int month, int year) {
		return bangLuongDao.getSoLuongBangLuongBanHang(month, year);
	}

	public int getSoLuongBangLuongHanhChinh(int month, int year) {
		return bangLuongDao.getSoLuongBangLuongHanhChinh(month, year);
	}

	public List<NhanVien> getNhanVienTheoMaVaThoiGian(String maNV, int month, int year) {
		return nhanVienDao.getNhanVienTheoMaVaThoiGian(maNV, month, year);
	}

	public List<NhanVien> getNhanVienTheoTenVaThoiGian(String tenNV, int month, int year) {
		return nhanVienDao.getNhanVienTheoTenVaThoiGian(tenNV, month, year);
	}

	public int getSoLuongSPCuaNV(int month, int year, String maNV) {
		return bangLuongDao.getSoLuongSPCuaNV(month, year, maNV);
	}

	public double getDoanhThu(int month, int year) {
		return bangLuongDao.getDoanhThu(month, year);
	}
}

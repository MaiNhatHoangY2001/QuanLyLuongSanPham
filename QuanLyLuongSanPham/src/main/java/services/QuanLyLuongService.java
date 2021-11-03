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

	public boolean updateSoNgayCong(String maNhanVien, int month, int year, int soNgayCong) {
		return bangLuongDao.updateSoNgayCong(maNhanVien, month, year, soNgayCong);
	}

	public List<NhanVien> getAllNhanVien() {
		return nhanVienDao.getAllNhanVien();
	}

	public NhanVien getNhanVien(String maNhanVien) {
		return nhanVienDao.getNhanVien(maNhanVien);
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
}

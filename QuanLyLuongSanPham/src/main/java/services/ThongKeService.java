package services;

import java.util.List;

import dao.BangLuongDao;
import dao.HoaDonBanHangDao;
import dao.HoaDonNhapHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import model.BangLuong;
import model.NhanVien;

public class ThongKeService {
	private HoaDonBanHangDao hoaDonBanHangDao = new HoaDonBanHangDao();
	private HoaDonNhapHangDao hoaDonNhapHangDao = new HoaDonNhapHangDao();
	private BangLuongDao bangLuongDao = new BangLuongDao();
	private NhanVienDao nhanVienDao = new NhanVienDao();
	private SanPhamDao sanPhamDao = new SanPhamDao();

//	public List<NhanVien> getNhanVienTheoThangNam(int month, int year) {
//		return nhanVienDao.getNhanVienTheoThangNam(month, year);
//	}

	public double getTongLuongNhanVien(int month, int year) {
		return bangLuongDao.getTongLuongNhanVien(month, year);
	}

	public double getTongBanTheoThoiGian(int month, int year) {
		return hoaDonBanHangDao.getThanhTienTheoThoiGian(month, year);
	}

	public double getTongNhapTheoThoiGian(int month, int year) {
		return hoaDonNhapHangDao.getThanhTienTheoThoiGian(month, year);
	}

	public BangLuong getBangLuongTheoMaNhanVien(String maNhanVien, int year, int month) {
		return bangLuongDao.getBangLuongTheoMaNhanVien(maNhanVien, year, month);
	}

	public List<NhanVien> getDsNhanVien() {
		return nhanVienDao.getDsNhanVien();
	}

	public List<?> getListSoLuongBanChay(int year) {
		return sanPhamDao.getListSoLuongBanChay(year);
	}

}

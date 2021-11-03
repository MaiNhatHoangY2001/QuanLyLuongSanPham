package services;

import java.util.List;

import dao.ChiTietHoaDonBanDao;
import dao.ChiTietHoaDonNhapDao;
import dao.HoaDonBanHangDao;
import dao.HoaDonNhapHangDao;
import model.ChiTietHoaDonNhap;
import model.HoaDonBanHang;
import model.HoaDonNhapHang;

public class QuanLyHoaDonService {
	private HoaDonBanHangDao hoaDonBanHangDao= new HoaDonBanHangDao();
	private ChiTietHoaDonBanDao chiTietHoaDonBanDao= new ChiTietHoaDonBanDao();
	private HoaDonNhapHangDao hoaDonNhapHangDao= new HoaDonNhapHangDao();
	private ChiTietHoaDonNhapDao chiTietHoaDonNhapDao= new ChiTietHoaDonNhapDao();
	
	public List<?> getHoaDonTheoNgay(int ngay,int thang,int nam) {
		return hoaDonBanHangDao.getHoaDonTheoNgay(ngay, thang, nam);
	}
	public List<?> getChiTietHoaDonBanTheoMaHoaDon(String maHoaDon) {
		return chiTietHoaDonBanDao.getChiTietTheoMaHoaDon(maHoaDon);
	}
	public List<?> getChiTietHoaDonNhapTheoMaHoaNhap(String maHoaDon) {
		return chiTietHoaDonNhapDao.getChiTietTheoMaHoaDon(maHoaDon);
	}
	public List<?> getHoaDonNhapTheoNgay(int ngay,int thang,int nam) {
		return hoaDonNhapHangDao.getHoaDonTheoNgay(ngay, thang, nam);
	}
	
}

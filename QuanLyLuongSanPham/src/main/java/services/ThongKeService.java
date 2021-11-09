package services;

import dao.HoaDonBanHangDao;

public class ThongKeService {
	private HoaDonBanHangDao hoaDonBanHang = new HoaDonBanHangDao();

	public double getThanhTienTheoThoiGian(int month, int year) {
		return hoaDonBanHang.getThanhTienTheoThoiGian(month, year);
	}
}

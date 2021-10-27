package services;

import java.util.List;

import dao.HoaDonBanHangDao;
import model.HoaDonBanHang;

public class QuanLyHoaDonService {
	private HoaDonBanHangDao hoaDonBanHangDao;

	public QuanLyHoaDonService() {
		hoaDonBanHangDao = new HoaDonBanHangDao();
	}
}

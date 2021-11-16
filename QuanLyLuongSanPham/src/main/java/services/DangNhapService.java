package services;

import dao.TaiKhoanDao;
import model.TaiKhoan;

public class DangNhapService {
	private TaiKhoanDao taiKhoanDao= new TaiKhoanDao();
	
	public TaiKhoan geTaiKhoan(String tenTaiKhoan) {
		if(tenTaiKhoan== null) {
			return null;
		}
		return taiKhoanDao.getTaiKhoan(tenTaiKhoan);
	}
}

package services;

import java.util.List;

import dao.SanPhamDao;
import model.SanPham;

public class QuanlySanPhamService {
	SanPhamDao dao = new SanPhamDao();
	
	public List<SanPham> get50SanPhamTheoViTri(int from) {
		return dao.get50SanPhamTheoViTri(from);
	}
	
	public int getTongSoSanPham() {
		return dao.getTongSoSanPham();
	}
	
	public SanPham getSanPhamTheoMa(String maSp) {
		return dao.getSanPham(maSp);
	}
	
	public List<SanPham> getDsSanPhamTheoTenSanPham(String tenSp) {
		return dao.getSanPhamThoTen(tenSp);
	}
	
	public List<SanPham> getDsSanPhamTheoGiaThanh(double from, double to) {
		return dao.getDsSanPhamTheoGia(from, to);
	}
	
}

package services;

import java.util.List;

import dao.NhanVienDao;
import model.NhanVien;

public class QuanLyNhanVienService {
	private NhanVienDao nvDao;
	
	public QuanLyNhanVienService() {
		nvDao = new NhanVienDao();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		return nvDao.themNhanVien(nv);
	}
	
	public boolean capNhatNhanVien(NhanVien nv) {
		return nvDao.capNhatNhanVien(nv);
	}
	
	public List<NhanVien> get50NhanVienTheoViTriSapXepTheoTen(int from) {
		return nvDao.get50NhanVienTheoViTri(from);
	}
	
	public int getNhanvienCount() {
		return nvDao.getNhanvienCount();
	}
	
	public NhanVien getNhanVienTheoMa(String maNV) {
		return nvDao.getNhanVienTheoMa(maNV);
	}
	
	public List<NhanVien> getNhanVienTheoTen(String tenNV) {
		return nvDao.getDsNhanVienTheoTen(tenNV);
	}
	
	public List<NhanVien> getDsNhanVienTheoTuoi(int tuoi) {
		return nvDao.getDsNhanVienTheoTuoi(tuoi);
	}
	
	public List<NhanVien> getDsNhanVienTheoTrangThai(boolean traithai) {
		return nvDao.getDsNhanVienTheoTrangThaiLamViec(traithai);
	}
	
}

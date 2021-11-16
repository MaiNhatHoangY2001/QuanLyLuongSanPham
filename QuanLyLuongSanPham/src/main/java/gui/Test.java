package gui;

import java.util.List;

import dao.NhanVienDao;
import dao.TaiKhoanDao;
import model.NhanVien;
import model.TaiKhoan;
import services.QuanLyNhanVienService;

public class Test {

	public static void main(String[] args) {
		NhanVienDao nv = new NhanVienDao();
		NhanVien nv1 = nv.getNhanVienTheoMa("NV19020002");
		TaiKhoanDao tk = new TaiKhoanDao();
		
		System.out.println(tk.themTaiKhoan(new TaiKhoan(nv1,"123")));
	}

}

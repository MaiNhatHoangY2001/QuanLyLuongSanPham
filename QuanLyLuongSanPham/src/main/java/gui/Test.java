package gui;

import java.util.List;

import dao.TaiKhoanDao;
import model.NhanVien;
import model.TaiKhoan;
import services.QuanLyNhanVienService;

public class Test {

	public static void main(String[] args) {
		TaiKhoanDao tk = new TaiKhoanDao();
		
		System.out.println(tk.themTaiKhoan(new TaiKhoan("NV11115678","11111111")));
	}

}

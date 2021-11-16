package gui;

import java.util.List;

import model.NhanVien;
import services.QuanLyNhanVienService;

public class Test {

	public static void main(String[] args) {
		QuanLyNhanVienService sv = new QuanLyNhanVienService();
		List<NhanVien> list = sv.getDsNhanVienTheoTuoi(18);
		for (NhanVien nhanVien : list) {
			System.out.println(nhanVien);
		}
	}

}

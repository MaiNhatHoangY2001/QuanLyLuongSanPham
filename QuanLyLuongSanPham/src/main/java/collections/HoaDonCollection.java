package collections;

import java.time.LocalDate;
import java.util.Vector;

import model.HoaDonBanHang;

public class HoaDonCollection {
	private Vector<HoaDonBanHang> hoaDonBanHangs;
	
//	Tạo collection rỗng
	public HoaDonCollection() {
		hoaDonBanHangs= new Vector<HoaDonBanHang>();
	}
	/**
	 * thêm một hóa đơn
	 * @param soLuong
	 * @param ngayLapHoaDon
	 * @param khuyenMai
	 * @param thue
	 */
	public void themHoaDon(int soLuong,LocalDate ngayLapHoaDon,double khuyenMai,double thue) { 
		hoaDonBanHangs.add(new HoaDonBanHang(soLuong, ngayLapHoaDon, khuyenMai, thue));
	}
	/**
	 * Thêm hóa đơn có sẵn
	 * @param hoaDonBanHang
	 * @return boolean
	 */
	public boolean themHoaDon(HoaDonBanHang hoaDonBanHang) {
		if(hoaDonBanHangs.contains(hoaDonBanHang))
			return false;
		return hoaDonBanHangs.add(hoaDonBanHang);
	}
	/**
	 * Xóa hóa đơn khi biết mã hóa đơn
	 * @param maHoaDon
	 * @return boolean
	 */
	public boolean xoaHoaDon(String maHoaDon) {
		for (HoaDonBanHang hoaDonBanHang : hoaDonBanHangs) {
			if(hoaDonBanHang.getMaHoaDonBan().equals(maHoaDon)) {
				return hoaDonBanHangs.remove(hoaDonBanHang);
			};
		}
		return false;
	}
	/**
	 * Xóa hóa đơn khi biết vị trí index
	 * @param index
	 * @return boolean
	 */
	public boolean xoaHoadon(int index) {
		if(index >=0 || index < hoaDonBanHangs.size()) {
			hoaDonBanHangs.remove(index);
			return true;
		}
		return false;
	}
	/**
	 * lấy hóa đơn khi biết vị trí index
	 * @param index
	 * @return HoaDonBanHang
	 */
	public HoaDonBanHang getHoaDon(int index) {
		return hoaDonBanHangs.get(index);
	}
	/**
	 * lấy độ lớn của danh sách hóa đơn
	 * @return
	 */
	public int getSize() {
		return hoaDonBanHangs.size();
	}
	
}

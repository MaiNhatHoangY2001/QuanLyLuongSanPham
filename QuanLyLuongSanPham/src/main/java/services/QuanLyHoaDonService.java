package services;

import java.util.List;

import dao.ChiTietHoaDonBanDao;
import dao.ChiTietHoaDonNhapDao;
import dao.HoaDonBanHangDao;
import dao.HoaDonNhapHangDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import model.ChiTietHoaDonBan;
import model.ChiTietHoaDonNhap;
import model.HoaDonBanHang;
import model.HoaDonNhapHang;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

public class QuanLyHoaDonService {
	private HoaDonBanHangDao hoaDonBanHangDao= new HoaDonBanHangDao();
	private ChiTietHoaDonBanDao chiTietHoaDonBanDao= new ChiTietHoaDonBanDao();
	private HoaDonNhapHangDao hoaDonNhapHangDao= new HoaDonNhapHangDao();
	private KhachHangDao khachHangDao= new KhachHangDao();
	private ChiTietHoaDonNhapDao chiTietHoaDonNhapDao= new ChiTietHoaDonNhapDao();
	private SanPhamDao sanPhamDao= new SanPhamDao();
	private NhanVienDao nhanVienDao= new NhanVienDao();
	
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
	public KhachHang getKhachHang(String maKhachHang) {
		return khachHangDao.getKhachHang(maKhachHang);
	}
	public HoaDonBanHang getHoaDonBanHang(String maHoaDon) {
		return hoaDonBanHangDao.getHoaDonBanHang(maHoaDon);
	}
	public HoaDonNhapHang getHoaDonNhapHang(String maHoaDon) {
		return hoaDonNhapHangDao.getHoaDonNhapHang(maHoaDon);
	}
	public Object timHoaDonTheoMa(int b,String maHoaDon) {
		if(b==0) {
			return hoaDonBanHangDao.timKiemTheoMa(maHoaDon);
		}
		else
		{
			return hoaDonNhapHangDao.timKiemTheoMa(maHoaDon);
		}
	}
	public List<?> timHoaDonTheoSdt(String sdt) {
		return hoaDonBanHangDao.timTheoSdtKhach(sdt);
	}
	public List<?> timHoaDonTheoTenKH(String tenKH) {
		return hoaDonBanHangDao.timTheoTenKhach(tenKH);
	}
	
	
	public List<SanPham> getAllSanPham() {
		return sanPhamDao.getAllSanPham();
	}
	
	public KhachHang getKhBySdt(String sdt) {
		return khachHangDao.timKiemKhachHangBangSdt(sdt);
	}
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		return nhanVienDao.getNhanVienTheoMa(maNhanVien);
	}
	
	public boolean themHoaDon(HoaDonBanHang hoaDonBanHang) {
		return hoaDonBanHangDao.themHoaDonBan(hoaDonBanHang);
	}
	public boolean themChiTietBan(ChiTietHoaDonBan chiTietHoaDonBan) {
		return chiTietHoaDonBanDao.themChiHoaDonBan(chiTietHoaDonBan);
	}
	public boolean themKhachHang(KhachHang khachHang) {
		if(khachHang!=null)
			return khachHangDao.themKhachHang(khachHang);
		return false;
	}
	public KhachHang timKhachHangBySdt(String sdt) {
		if(sdt!= null)
			return khachHangDao.timKiemKhachHangBangSdt(sdt);
		return null;
	}
	public List<SanPham> timSanPhamTheoNhaCungCap(String ncc) {
		if(ncc!=null) {
			return sanPhamDao.timTheoNhaCungCap(ncc);
		}
		else return null;
	}
	public List<SanPham> timSanPhamTheoTen(String ten) {
		if(ten!=null) {
			return sanPhamDao.getSanPhamThoTen(ten);
		}
		else return null;
	}
	public SanPham timSanPhamTheoMa(String ma) {
		if(ma!=null) {
			return sanPhamDao.getSanPham(ma);
		}
		else return null;
	}
}

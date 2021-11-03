package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.HoaDonBanHang;
import model.KhachHang;
import model.NhanVien;

public class HoaDonBanHangDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public HoaDonBanHang getHoaDonBanHang(String maHoaDon) {
		HoaDonBanHang hoaDonBanHang = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			hoaDonBanHang = session.get(HoaDonBanHang.class, maHoaDon);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return hoaDonBanHang;

	}

	public boolean themHoaDonBan(HoaDonBanHang hoaDonBanHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(hoaDonBanHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();
		return false;
	}

	public List<HoaDonBanHang> getAllHoaDonBanHang() {
		List<HoaDonBanHang> list = new ArrayList<HoaDonBanHang>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from HoaDonBanHang", HoaDonBanHang.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}

	/**
	 * Lấy hóa đơn theo ngày tháng năm
	 * 
	 * @param ngay
	 * @param thang
	 * @param nam
	 * @return
	 */
	public List<?> getHoaDonTheoNgay(int ngay, int thang, int nam) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT        d.maHoaDonBan, o.ngayLapHoaDon, o.khuyenMai, o.thue, thanhTien=Sum(d.soLuong*d.donGia) "
					+ "FROM            ChiTietHoaDonBan AS d INNER JOIN "
					+ "                         HoaDonBanHang AS o ON d.maHoaDonBan = o.maHoaDonBan "
					+ "where day(o.ngayLapHoaDon)="+ngay+" and year(o.ngayLapHoaDon)="+nam+" and MONTH(o.ngayLapHoaDon)="+thang+" "
					+ "group by d.maHoaDonBan,o.ngayLapHoaDon, o.khuyenMai,o.thue";
			List<?> list = session.createNativeQuery(query).getResultList();
			
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;

	}

	public static void main(String[] args) {
		HoaDonBanHangDao banHangDao = new HoaDonBanHangDao();
//		ChiTietHoaDonBanDao chiTietHoaDonBanDao= new ChiTietHoaDonBanDao();
//		
		HoaDonBanHang hoaDonBanHang= new HoaDonBanHang(0.1, 0.1);
//		
		KhachHang khachHang= new KhachHang();
		khachHang.setMaKhachHang("KH21100001");
		hoaDonBanHang.setKhachHang(khachHang);
		
		NhanVien nhanVien= new NhanVien();
		nhanVien.setMaNhanVien("NV21100002");
		
		hoaDonBanHang.setKhachHang(khachHang);
		hoaDonBanHang.setNhanVien(nhanVien);

		System.out.println(hoaDonBanHang.toString());
		banHangDao.themHoaDonBan(hoaDonBanHang);
	
//		banHangDao.getHoaDonTheoNgay(5, 6, 2020);
	}
}

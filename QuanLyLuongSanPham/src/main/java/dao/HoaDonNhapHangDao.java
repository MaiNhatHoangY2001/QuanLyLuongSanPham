package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.HoaDonNhapHang;
import model.KhachHang;
import model.NhanVien;

public class HoaDonNhapHangDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public HoaDonNhapHang getHoaDonNhapHang(String maHoaDon) {
		HoaDonNhapHang HoaDonNhapHang = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			HoaDonNhapHang = session.get(HoaDonNhapHang.class, maHoaDon);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return HoaDonNhapHang;

	}

	public boolean themHoaDonBan(HoaDonNhapHang HoaDonNhapHang) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(HoaDonNhapHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();
		return false;
	}

	public List<HoaDonNhapHang> getAllHoaDonNhapHang() {
		List<HoaDonNhapHang> list = new ArrayList<HoaDonNhapHang>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from HoaDonNhapHang", HoaDonNhapHang.class).getResultList();

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
			String query = "SELECT   b.maHoaDonNhap, b.ngayLapHoaDon, khuyenMai=0, b.thue, b.thanhTien "
					+ "FROM         HoaDonNhapHang AS b INNER JOIN "
					+ "                         NhanVien AS e ON b.maNhanVien = e.maNhanVien "
					+ "where day(b.ngayLapHoaDon)=" + ngay + " and MONTH(b.ngayLapHoaDon)=" + thang
					+ " and YEAR(ngayLapHoaDon)=" + nam;
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
		HoaDonNhapHangDao nhapHangDao = new HoaDonNhapHangDao();
		NhanVien nhanVien= new NhanVien();
		nhanVien.setMaNhanVien("NV21100002");
		HoaDonNhapHang HoaDonNhapHang= new HoaDonNhapHang(0.2,nhanVien);
		
		HoaDonNhapHang.setNhanVien(nhanVien);

		System.out.println(HoaDonNhapHang.toString());
		nhapHangDao.themHoaDonBan(HoaDonNhapHang);
	
//		banHangDao.getHoaDonTheoNgay(5, 6, 2020);
	}
}
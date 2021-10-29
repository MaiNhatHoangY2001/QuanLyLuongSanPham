package dao;

import java.sql.Connection;
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
		Connection connection;

		try {
			tr.begin();
			String query = "SELECT   b.maHoaDonBan, e.maNhanVien, b.ngayLapHoaDon, b.khuyenMai, b.thue, b.thanhTien "
					+ "FROM         HoaDonBanHang AS b INNER JOIN "
					+ "                         NhanVien AS e ON b.maNhanVien = e.maNhanVien "
					+ "where day(b.ngayLapHoaDon)=" + ngay + " and MONTH(b.ngayLapHoaDon)=" + thang
					+ " and YEAR(ngayLapHoaDon)=" + nam;
			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object object : list) {
				Object[] o = (Object[]) object;
				String ma = (String) o[0];
				String manv = (String) o[1];
				LocalDate ngayLap = (LocalDate) o[2];
				double km = (double) o[3];
				double thue = (double) o[4];
				double tong = (double) o[5];
				System.out.println(ngayLap);
			}
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
//		them hoa don
//		HoaDonBanHang hoaDonBanHang= new HoaDonBanHang(0.1, 0.2);
//		KhachHang khachHang= new KhachHang();
//		khachHang.setMaKhachHang("KH21100003");
//		hoaDonBanHang.setKhachHang(khachHang);
//		
//		NhanVien nhanVien= new NhanVien();
//		nhanVien.setMaNhanVien("NV21100001");
//		hoaDonBanHang.setKhachHang(khachHang);
//		hoaDonBanHang.setNhanVien(nhanVien);
//		banHangDao.themHoaDonBan(hoaDonBanHang);
		
		
//		banHangDao.getHoaDonTheoNgay(5, 6, 2020);
	}
}

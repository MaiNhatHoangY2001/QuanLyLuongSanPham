package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.HoaDonBanHang;

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
			String query = "SELECT   a.maHoaDonBan, a.ngayLapHoaDon, a.khuyenMai, a.thue, b.tenNhanVien, a.thanhTien "
					+ "FROM         HoaDonBanHang AS a INNER JOIN "
					+ "                         NhanVien AS b ON a.maNhanVien = b.maNhanVien "
					+ " where day(a.ngayLapHoaDon)=" + ngay + " and MONTH(a.ngayLapHoaDon)=" + thang
					+ " and YEAR(a.ngayLapHoaDon)=" + nam;
			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object object : list) {
				Object[] o=(Object[]) object;
				String maString= (String) o[0];
				LocalDate date= LocalDate.of(nam, thang, ngay);
				double km= (Double) o[2];
				double thue= (Double) o[3];
				String tenNhanVien=(String) o[4];
				double tt=(double) o[5];
			}
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return 		null;

	}
}

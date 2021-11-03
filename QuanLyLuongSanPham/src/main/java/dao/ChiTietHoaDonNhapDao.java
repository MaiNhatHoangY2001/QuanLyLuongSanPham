package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.ChiTietHoaDonBan;

public class ChiTietHoaDonNhapDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public boolean themChiHoaDonBan(ChiTietHoaDonBan chiTietHoaDonBan) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(chiTietHoaDonBan);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();
		return false;
	}

	public ChiTietHoaDonBan getChiTietHoaDonBan(String maChiTietHoaDonBan) {
		ChiTietHoaDonBan chiTietHoaDonBan = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			chiTietHoaDonBan = session.get(ChiTietHoaDonBan.class, maChiTietHoaDonBan);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return chiTietHoaDonBan;

	}

	/**
	 * lấy chi tiết hóa đơn theo mã sản phẩm
	 * 
	 * @param maSanPham
	 * @return
	 */
	public List<ChiTietHoaDonBan> getChiTietTheoMaNV(String maNhanVien, int month, int year) {
		List<ChiTietHoaDonBan> list = new ArrayList<>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("SELECT  c.* " + "FROM ChiTietHoaDonBan AS c "
					+ "INNER JOIN HoaDonBanHang AS h ON c.maHoaDonBan = h.maHoaDonBan " + "WHERE h.maNhanVien = '"
					+ maNhanVien + "'" + " and MONTH(h.ngayLapHoaDon) = " + month + " and YEAR(h.ngayLapHoaDon) = "
					+ year, ChiTietHoaDonBan.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return list;

	}

	public List<ChiTietHoaDonBan> getAllHoaDonBanHang() {
		List<ChiTietHoaDonBan> list = new ArrayList<ChiTietHoaDonBan>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from ChiTietHoaDonBan", ChiTietHoaDonBan.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}

	public List<?> getChiTietTheoMaHoaDon(String maHoadon) {
		List<?> list = new ArrayList<ChiTietHoaDonBan>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT   a.maSanPham, p.tenSanPham, a.soLoHang , p.giaThanh, tongTien=p.giaThanh*a.soLoHang "
					+ "FROM     ChiTietHoaDonNhap AS a INNER JOIN "
					+ "             SanPham AS p ON a.maSanPham = p.maSanpham " + "where a.maHoaDonNhap='" + maHoadon
					+ "'";
			list = session.createNativeQuery(query).getResultList();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		session.close();

		return list;
	}

	public static void main(String[] args) {
		ChiTietHoaDonNhapDao dao = new ChiTietHoaDonNhapDao();
		HoaDonBanHangDao daoHd = new HoaDonBanHangDao();
		SanPhamDao sanPhamDao = new SanPhamDao();
		ChiTietHoaDonBan hoaDonBan = new ChiTietHoaDonBan(sanPhamDao.getSanPham("SP21100002").getGiaThanh(), 5,
				daoHd.getHoaDonBanHang("HB21100001"), sanPhamDao.getSanPham("SP21100002"));
		dao.themChiHoaDonBan(hoaDonBan);
	}
}

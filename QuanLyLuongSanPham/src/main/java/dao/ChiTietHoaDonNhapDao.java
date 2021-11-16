package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.ChiTietHoaDonBan;
import model.ChiTietHoaDonNhap;

public class ChiTietHoaDonNhapDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public boolean themChiHoaDonNhap(ChiTietHoaDonNhap chiTietHoaDonNhap) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(chiTietHoaDonNhap);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();
		return false;
	}

	public ChiTietHoaDonNhap getChiTietHoaDonNhap(String maChiTietHoaDonNhap) {
		ChiTietHoaDonNhap chiTietHoaDonNhap = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			chiTietHoaDonNhap = session.get(ChiTietHoaDonNhap.class, maChiTietHoaDonNhap);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return chiTietHoaDonNhap;

	}

	/**
	 * lấy chi tiết hóa đơn theo mã sản phẩm
	 * 
	 * @param maSanPham
	 * @return
	 */
	public List<ChiTietHoaDonNhap> getChiTietTheoMaNV(String maNhanVien, int month, int year) {
		List<ChiTietHoaDonNhap> list = new ArrayList<>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("SELECT  c.* " + "FROM ChiTietHoaDonNhap AS c "
					+ "INNER JOIN HoaDonNhapHang AS h ON c.maHoaDonNhap= h.maHoaDonNhap " + "WHERE h.maNhanVien = '"
					+ maNhanVien + "'" + " and MONTH(h.ngayLapHoaDon) = " + month + " and YEAR(h.ngayLapHoaDon) = "
					+ year, ChiTietHoaDonNhap.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return list;

	}

	public List<ChiTietHoaDonNhap> getAllHoaDonBanHang() {
		List<ChiTietHoaDonNhap> list = new ArrayList<ChiTietHoaDonNhap>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			list = session.createNativeQuery("select * from ChiTietHoaDonNhap", ChiTietHoaDonNhap.class)
					.getResultList();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}

	public List<?> getChiTietTheoMaHoaDon(String maHoadon) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT   a.maSanPham, p.tenSanPham,p.giaThanh, a.soLoHang ,  tongTien=p.giaThanh*a.soLoHang "
					+ "FROM     ChiTietHoaDonNhap AS a INNER JOIN "
					+ "             SanPham AS p ON a.maSanPham = p.maSanpham " + "where a.maHoaDonNhap='" + maHoadon
					+ "'";
			List<?> list = session.createNativeQuery(query).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	public static void main(String[] args) {
//		ChiTietHoaDonNhapDao dao = new ChiTietHoaDonNhapDao();
//		HoaDonBanHangDao daoHd = new HoaDonBanHangDao();
//		SanPhamDao sanPhamDao = new SanPhamDao();
//		ChiTietHoaDonBan hoaDonBan = new ChiTietHoaDonBan(sanPhamDao.getSanPham("SP21100002").getGiaThanh(), 5,
//				daoHd.getHoaDonBanHang("HB21100001"), sanPhamDao.getSanPham("SP21100002"));
//		dao.themChiHoaDonNhap(hoaDonBan);
	}
}

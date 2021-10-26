package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.BangLuong;
import model.SanPham;

public class SanPhamDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public SanPham getSanPham(String maSanPham) {
		SanPham sanPham = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			sanPham = session.get(SanPham.class, maSanPham);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return sanPham;

	}

	/**
	 * lấy sản phẩm theo mã nhân viên và ngày tháng bên hóa đơn
	 * 
	 * @param maNhanVien
	 * @param month
	 * @param year
	 * @return
	 */

	public SanPham getSPTheoHDVaMa(String maNhanVien, int month, int year) {
		SanPham sanPham = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			sanPham = session.createNativeQuery(
					"SELECT s.* FROM ChiTietHoaDonBan AS c INNER JOIN HoaDonBanHang AS h ON "
					+ "c.maHoaDonBan = h.maHoaDonBan "
					+ "INNER JOIN SanPham AS s ON c.maSanPham = s.maSanpham "
					+ "INNER JOIN NhanVien AS n ON h.maNhanVien = n.maNhanVien "
					+ "where n.maNhanVien = " + "'" +maNhanVien+ "'"
					+ " and MONTH(h.ngayLapHoaDon) = " + month
					+ " and YEAR(h.ngayLapHoaDon) = " + year,
					SanPham.class).getSingleResult();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return sanPham;
	}

	public List<SanPham> getAllSanPham() {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from SanPham", SanPham.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}
}

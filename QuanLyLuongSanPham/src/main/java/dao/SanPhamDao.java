package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.NhanVien;
import model.SanPham;

public class SanPhamDao {
	private SessionFactory sessionFactory = null;

	public SanPhamDao() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public boolean themSanPham(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(sanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}
	public List<SanPham> timTheoNhaCungCap(String ncc) {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from SanPham\r\n" + "where nCC like '%" + ncc+ "%'";
			list = session.createNativeQuery(query, SanPham.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
		
	}
	public boolean capNhatSanPham(SanPham sp) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.update(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}

		return false;
	}

	public boolean xoaSanPhamTheoMa(String maSPCanXoa) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(SanPham.class, maSPCanXoa));
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
		session.close();
		return true;
	}

	public SanPham getSanPham(String id) {
		SanPham sanPham;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			sanPham = session.find(SanPham.class, id);
			tr.commit();
			return sanPham;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SanPham> getSanPhamThoTen(String tenSanPham) {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from SanPham\r\n" + "where tenSanPham like '%" + tenSanPham + "%'";
			list = session.createNativeQuery(query, SanPham.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SanPham> getAllSanPham() {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.openSession();
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
	
	public List<SanPham> get50SanPhamSapXepTheoTenSanPham() {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			list = session
					.createNativeQuery("select top 50 * from SanPham\r\n" + "order by tenSanPham asc", SanPham.class)
					.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * Lấy danh sách những sản phẩm bán chạy trong năm
	 * 
	 * @param year
	 * @return
	 */

	public List<?> getListSoLuongBanChay(int year) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT TOP(30) s.tenSanPham, SUM(c.soLuong) AS tongSoLuong "
					+ "FROM ChiTietHoaDonBan AS c INNER JOIN SanPham AS s "
					+ "ON c.maSanPham = s.maSanpham INNER JOIN HoaDonBanHang AS h "
					+ "ON c.maHoaDonBan = h.maHoaDonBan " + "WHERE (YEAR(h.ngayLapHoaDon) = " + year + ") "
					+ "GROUP BY s.maSanpham, s.tenSanPham " + "ORDER BY tongSoLuong DESC";
			List<?> list = session.createNativeQuery(query).getResultList();

			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;

	}

}

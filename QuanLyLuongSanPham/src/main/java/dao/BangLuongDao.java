package dao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.BangLuong;
import model.NhanVien;
import model.SanPham;

public class BangLuongDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public BangLuong getBangLuong(String maBangLuong) {
		BangLuong bangLuong = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			bangLuong = session.get(BangLuong.class, maBangLuong);
			tr.commit();
			return bangLuong;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		} finally {
			session.close();
		}

		return null;

	}

	public BangLuong getBangLuongTheoMaNhanVien(String maNhanVien, int year, int month) {
		BangLuong bangLuong = null;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			bangLuong = session
					.createNativeQuery("select * from BangLuong where maNhanVien = '" + maNhanVien
							+ "'and YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month, BangLuong.class)
					.getSingleResult();

			tr.commit();
			return bangLuong;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;

	}

	public boolean themBangLuong(BangLuong bangLuong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.save(bangLuong);
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

	public boolean suaBangLuong(BangLuong bangLuong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.update(bangLuong);
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

	/**
	 * Sửa số ngày công theo mã nhân viên và tháng năm
	 * 
	 * @param maNhanVienString
	 * @param month
	 * @param year
	 * @return
	 */
	public boolean updateSoNgayCong(String maNhanVien, int month, int year, int soNgayCong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "UPDATE BangLuong " + "SET soNgayCong = " + soNgayCong + " WHERE maNhanVien = '" + maNhanVien
					+ "'" + " and MONTH(thoiGian) = " + month + " and YEAR(thoiGian) = " + year;
			session.createSQLQuery(query).executeUpdate();
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

	/**
	 * Sửa thưởng theo mã nhân viên và tháng năm
	 * 
	 * @param maNhanVienString
	 * @param month
	 * @param year
	 * @return
	 */
	public boolean updateThuong(String maNhanVien, int month, int year, double thuong) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "UPDATE BangLuong " + "SET thuong = " + thuong + " WHERE maNhanVien = '" + maNhanVien + "'"
					+ " and MONTH(thoiGian) = " + month + " and YEAR(thoiGian) = " + year;
			session.createSQLQuery(query).executeUpdate();
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

	/**
	 * Sửa phạt theo mã nhân viên và tháng năm
	 * 
	 * @param maNhanVienString
	 * @param month
	 * @param year
	 * @return
	 */
	public boolean updatePhat(String maNhanVien, int month, int year, double phat) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "UPDATE BangLuong " + "SET phat = " + phat + " WHERE maNhanVien = '" + maNhanVien + "'"
					+ " and MONTH(thoiGian) = " + month + " and YEAR(thoiGian) = " + year;
			session.createSQLQuery(query).executeUpdate();
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

	public boolean xoaBangLuong(String id) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.delete(session.find(BangLuong.class, id));
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

	/**
	 * Lấy số lượng bảng lương theo tháng năm
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public int getSoLuongBangLuong(int month, int year) {
		List<BangLuong> list = new ArrayList<BangLuong>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"select * from BangLuong where MONTH(thoiGian) = " + month + " and YEAR(thoiGian) = " + year,
					BangLuong.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list.size() + 1;

	}

	/**
	 * Lấy số lượng bảng lương theo tháng năm và hành chính
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public int getSoLuongBangLuongHanhChinh(int month, int year) {
		List<BangLuong> list = new ArrayList<BangLuong>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from BangLuong where MONTH(thoiGian) = " + month
					+ " and YEAR(thoiGian) = " + year + " and heSoLuong = 2", BangLuong.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list.size() + 1;

	}

	/**
	 * Lấy số lượng bảng lương theo tháng năm và bán hàng
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public int getSoLuongBangLuongBanHang(int month, int year) {
		List<BangLuong> list = new ArrayList<BangLuong>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from BangLuong where MONTH(thoiGian) = " + month
					+ " and YEAR(thoiGian) = " + year + " and heSoLuong = 1", BangLuong.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list.size() + 1;

	}

	/**
	 * Tạo tiền sản phẩm
	 * 
	 * @param maNhanVien
	 * @param month
	 * @param year
	 * @return
	 */
	public double getTienSanPham(String maNhanVien, int month, int year) {
		BigDecimal tienSanPham = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT sum(thanhTien) as tienSanPham FROM HoaDonBanHang where " + "maNhanVien = '"
					+ maNhanVien + "'" + " and MONTH(ngayLapHoaDon) = " + month + " and YEAR(ngayLapHoaDon) = " + year;
			tienSanPham = (BigDecimal) session.createSQLQuery(query).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return tienSanPham == null ? 0 : tienSanPham.doubleValue();

	}

	/**
	 * Xóa tất cả bảng lương theo thời gian
	 * 
	 * @param month
	 * @param year
	 */
	public boolean deleteAllBangLuongInTime(int month, int year) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String query = "DELETE from BangLuong where MONTH(thoiGian) = " + month + " and YEAR(thoiGian) = " + year;
			session.createSQLQuery(query).executeUpdate();
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

	/**
	 * Lấy tổng lương nhân viên theo tháng năm
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public double getTongLuongNhanVien(int month, int year) {
		double tienLuong = 0.0;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT sum( bl.heSoLuong * bl.soNgayCong * nv.mucLuong + bl.tienSanPham * 0.1 ) AS tong"
					+ " FROM BangLuong AS bl INNER JOIN" + " NhanVien AS nv ON bl.maNhanVien = nv.maNhanVien"
					+ " where MONTH(bl.thoiGian) = " + month + " and YEAR(bl.thoiGian) = " + year
					+ " and nv.trangThaiLamViec = 1";
			tienLuong = (Double) session.createSQLQuery(query).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}

		return tienLuong;

	}

	/**
	 * Lấy top 10 lương nhân viên cao nhất theo năm
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public List<?> getTop10LuongNhanVien(int year) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT TOP(10) nv.maNhanVien, nv.tenNhanVien, sum( bl.heSoLuong * bl.soNgayCong * nv.mucLuong + bl.tienSanPham * 0.1 ) AS tong\r\n"
					+ "FROM BangLuong AS bl INNER JOIN NhanVien AS nv ON bl.maNhanVien = nv.maNhanVien\r\n"
					+ "where YEAR(bl.thoiGian) = " + year + " and nv.trangThaiLamViec = 1\r\n"
					+ "group by nv.maNhanVien, nv.tenNhanVien";
			List<?> list = session.createSQLQuery(query).getResultList();
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
	 * Lấy số lượng sản phẩm của nhân viên trong tháng
	 * 
	 * @param month
	 * @param year
	 * @param maNV
	 * @return
	 */
	public int getSoLuongSPCuaNV(int month, int year, String maNV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		Object list = null;

		try {
			tr.begin();
			String query = "SELECT SUM(c.soLuong) AS tongSoLuong "
					+ "FROM ChiTietHoaDonBan AS c INNER JOIN SanPham AS s "
					+ "ON c.maSanPham = s.maSanpham INNER JOIN HoaDonBanHang AS h "
					+ "ON c.maHoaDonBan = h.maHoaDonBan " + "WHERE MONTH(h.ngayLapHoaDon) = " + month
					+ " and (YEAR(h.ngayLapHoaDon) = " + year + ") and h.maNhanVien = '" + maNV + "'" + " "
					+ "GROUP BY h.maNhanVien";
			if (session.createNativeQuery(query).list().size() == 1) {
				list = session.createNativeQuery(query).getSingleResult();
			}

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return list == null ? 0 : (int) list;

	}

	/**
	 * lấy doanh thu theo thời gian
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public double getDoanhThu(int month, int year) {
		BigDecimal thu = null;
		BigDecimal chi = null;
		BigDecimal doanhthu = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query1 = "SELECT       sum(thanhTien) as thu\r\n" + "FROM              HoaDonBanHang\r\n"
					+ "where MONTH(ngayLapHoaDon) = " + month + " and YEAR(ngayLapHoaDon) = " + year;
			String query2 = "SELECT       sum(thanhTien) as chi\r\n" + "FROM              HoaDonNhapHang\r\n"
					+ "where MONTH(ngayLapHoaDon) = " + month + " and YEAR(ngayLapHoaDon) = " + year;
			thu = (BigDecimal) session.createSQLQuery(query1).getSingleResult();
			chi = (BigDecimal) session.createSQLQuery(query2).getSingleResult();

			doanhthu = BigDecimal.valueOf(thu.doubleValue() - chi.doubleValue());
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return thu == null ? 0 : doanhthu.doubleValue();

	}

	public static void main(String[] args) {
		BangLuongDao bangLuongDao = new BangLuongDao();
//		NhanVien nhanVien = new NhanVien("NV0001");
//		BangLuong bangLuong = new BangLuong(LocalDate.now(), 2, 2, 2, 2);
//		bangLuong.setNhanVien(nhanVien);
//		System.out.println(bangLuongDao.themBangLuong(bangLuong));

		System.out.println(bangLuongDao.getTongLuongNhanVien(10, 2021));

	}
}

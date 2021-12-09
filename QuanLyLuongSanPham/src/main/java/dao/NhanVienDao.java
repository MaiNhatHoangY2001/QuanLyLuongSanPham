package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import hibernateCfg.HibernateConfig;
import model.NhanVien;

public class NhanVienDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	/**
	 * Gọi Nhân Viên theo mã nhân viên
	 * 
	 * @param maNhanVien: Mã số nhân viên
	 * @return NhanVien: Trả về thông tin Nhân Viên
	 * @return null: Trả về null nếu không tìm thấy thông tin Nhân Viên
	 */
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			NhanVien nhanVien = session.find(NhanVien.class, maNhanVien);
			tr.commit();
			return nhanVien;
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		} finally {
			session.close();
		}
		return null;
	}

	/**
	 * Gọi tất cả nhân viên có trong DataBase
	 * 
	 * @return list<NhanVien>: danh sách nhân viên
	 * @return null: Trả về null nếu không tìm thấy thông tin Nhân Viên
	 */
	public List<NhanVien> getDsNhanVien() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			list = session.createNativeQuery("select * from NhanVien", NhanVien.class).getResultList();
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
	 * Gọi 50 Nhân Viên đươc sắp xếp theo tên
	 * 
	 * @return list<NhanVien> : Danh sách nhân viên
	 */
	public List<NhanVien> get50NhanVienSapXepTheoTenNhanVien() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			list = session
					.createNativeQuery("select top 50 * from NhanVien\r\n" + "order by tenNhanVien asc", NhanVien.class)
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
	 * Lấy 50 Nhân viên từ vị trí from trờ về sau 10 đơn vị và được sắp xếp theo tên
	 * nhân viên
	 * 
	 * @param from
	 * @return
	 */
	public List<NhanVien> get50NhanVienTheoViTri(int from) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from NhanVien\r\n" + "where maNhanVien in (select maNhanVien from NhanVien\r\n"
					+ "order by maNhanVien offset " + from + " rows fetch next 50 rows only)\r\n"
					+ "order by tenNhanVien asc";
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
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
	 * Lấy tổng số lượng nhân viên có trong danh sách
	 * 
	 * @return
	 */
	public int getNhanvienCount() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select COUNT(*) as count from NhanVien";
			List<?> count = session.createNativeQuery(query).getResultList();
			tr.commit();
			return (int) count.get(0);
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return -1;
	}

	/**
	 * Gọi danh sách Nhân Viên theo tên Nhân Viên
	 * 
	 * @param tenNVCanTim: Tên Nhân Viên cần tìm
	 * @return List<NhanVien>: Trả về danh sách Nhân Viên
	 * @return null: Nếu không tìm thấy tên Nhân Viên
	 */
	public List<NhanVien> getDsNhanVienTheoTen(String tenNVCanTim) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from NhanVien\r\n" + "where tenNhanVien like N'%" + tenNVCanTim + "%'\r\n"
					+ "order by tenNhanVien asc";
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
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
	 * get Danh sách Nhân Viên theo tuổi
	 * 
	 * @param tuoi
	 * @return List<NhanVien>
	 */
	public List<NhanVien> getDsNhanVienTheoTuoi(int tuoi) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select * from NhanVien\r\n" + "where YEAR(GETDATE()) - YEAR(ngaySinh) = " + tuoi;
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<NhanVien> getDsNhanVienTheoTrangThaiLamViec(boolean traithai) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			int i = (traithai == true) ? 1 : 0;
			String query = "select * from NhanVien\r\n" + "where trangThaiLamViec = " + i + "\r\n"
					+ "order by tenNhanVien asc";
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
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
	 * Cập nhật Nhân viên
	 * 
	 * @param nv: Thông tin Nhân Viên
	 * @return true: nếu cập nhật thông tin Nhân Viên thành công
	 * @return false: Nếu cập nhật thông tin Nhân Viên không thành công
	 */
	public boolean capNhatNhanVien(NhanVien nv) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	/**
	 * Thêm thông tin Nhân Viên
	 * 
	 * @param nhanVien
	 * @return true: Nếu thêm thành công
	 * @return false: Nếu thêm không thành công
	 */
	public boolean themNhanVien(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	/**
	 * Xóa 1 Nhân Viên theo mã Nhân Viên
	 * 
	 * @param maNVCanXoa: Mã số Nhân Viên
	 * @return true: Nếu xóa 1 Nhân Viên thành công
	 * @return false: Nếu xóa 1 Nhân Viên không thành công
	 */
	public boolean xoaNhanVienTheoMa(String maNVCanXoa) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(NhanVien.class, maNVCanXoa));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	/**
	 * Lấy tổng tiền lương theo tháng năm
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public double getThanhTienTheoThoiGian(int month, int year) {

		BigDecimal tongTien = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "SELECT SUM(thanhTien) AS tongtien FROM HoaDonNhapHang WHERE (MONTH(ngayLapHoaDon) = "
					+ month + ") AND (YEAR(ngayLapHoaDon) = " + year + ")";
			tongTien = (BigDecimal) session.createSQLQuery(query).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return tongTien == null ? 0 : tongTien.doubleValue();
	}

	/**
	 * get 10 Nhân Viên theo khoảng và theo thời gian
	 * 
	 * @param from
	 * @return
	 */
	public List<NhanVien> get10NhanVienTheoKhoang(int from, int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " Order by maNhanVien OFFSET " + from + " ROWS FETCH NEXT 10 ROWS ONLY",
					NhanVien.class).getResultList();
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
	 * get 10 Nhân Viên hành chính theo khoảng và theo thời gian
	 * 
	 * @param from
	 * @return
	 */
	public List<NhanVien> get10NhanVienHanhChinh(int from, int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and heSoLuong = 2" + " Order by maNhanVien OFFSET " + from
							+ " ROWS FETCH NEXT 10 ROWS ONLY",
					NhanVien.class).getResultList();
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
	 * get 10 Nhân Viên bán hàng theo khoảng và theo thời gian
	 * 
	 * @param from
	 * @return
	 */
	public List<NhanVien> get10NhanVienBanHang(int from, int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and heSoLuong = 1" + " Order by maNhanVien OFFSET " + from
							+ " ROWS FETCH NEXT 10 ROWS ONLY",
					NhanVien.class).getResultList();
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
	 * Lấy danh sách nhân viên theo thời gian bảng lương
	 * 
	 * @param maNV
	 * @param month
	 * @param year
	 * @return
	 */
	public List<NhanVien> getNhanVienTheoThoiGian(int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month,
					NhanVien.class).getResultList();
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
	 * Lấy danh sách nhân viên hành chính theo thời gian bảng lương
	 * 
	 * @param maNV
	 * @param month
	 * @param year
	 * @return
	 */
	public List<NhanVien> getNhanVienHCTheoThoiGian(int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and heSoLuong = 2",
					NhanVien.class).getResultList();
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
	 * Lấy danh sách nhân viên bán hàng theo thời gian bảng lương
	 * 
	 * @param maNV
	 * @param month
	 * @param year
	 * @return
	 */
	public List<NhanVien> getNhanVienBHTheoThoiGian(int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and heSoLuong = 1",
					NhanVien.class).getResultList();
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
	 * Lấy danh sách nhân viên theo mã và thời gian bảng lương
	 * 
	 * @param maNV
	 * @param month
	 * @param year
	 * @return
	 */
	public List<NhanVien> getNhanVienTheoMaVaThoiGian(String maNV, int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and bl.maNhanVien = '" + maNV + "'",
					NhanVien.class).getResultList();
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
	 * Lấy danh sách nhân viên theo tên và thời gian bảng lương
	 * 
	 * @param maNV
	 * @param month
	 * @param year
	 * @return
	 */
	public List<NhanVien> getNhanVienTheoTenVaThoiGian(String tenNV, int month, int year) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery(
					"SELECT nv.* FROM NhanVien AS nv INNER JOIN BangLuong AS bl ON nv.maNhanVien = bl.maNhanVien"
							+ " WHERE YEAR(thoiGian) = " + year + " and MONTH(thoiGian) = " + month
							+ " and nv.tenNhanVien = '" + tenNV + "'",
					NhanVien.class).getResultList();
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
	 * kiểm tra có phải nhân viên hành chanh không
	 * 
	 * @param maNhanVien
	 * @return
	 */
	public boolean kiemTraNhanVien(String maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		String ma = "";
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "select maNhanVien from NhanVien where maNhanVien in (SELECT tenTaiKhoan FROM TaiKhoan) and maNhanVien = "
					+ "'" + maNhanVien + "'";
			ma = (String) session.createSQLQuery(query).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return ma.equals(maNhanVien);

	}


}

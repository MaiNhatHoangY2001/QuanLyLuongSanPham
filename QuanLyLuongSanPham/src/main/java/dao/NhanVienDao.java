package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
			System.out.println(nhanVien);
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

			list = session
					.createNativeQuery("select * from nhanvien\r\n" + "where tenNhanVien like '%" + tenNVCanTim + "%'",
							NhanVien.class)
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
			String query = "SELECT SUM(thanhTien) AS tongtien FROM HoaDonNhapHang WHERE (MONTH(ngayLapHoaDon) = " + month
					+ ") AND (YEAR(ngayLapHoaDon) = " + year + ")";
			tongTien = (BigDecimal) session.createSQLQuery(query).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return tongTien == null ? 0 : tongTien.doubleValue();
	}
}

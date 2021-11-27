package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.NhanVien;
import model.TaiKhoan;

public class TaiKhoanDao {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public boolean themTaiKhoan(TaiKhoan taiKhoan) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(taiKhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return false;
	}
	public boolean capNhatTaiKhoan(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String queryString =   "select * from TaiKhoan where tenTaiKhoan like '"+tenTaiKhoan+"'";
			TaiKhoan taikhoan = session.createNativeQuery(queryString, TaiKhoan.class).getSingleResult();
			//TaiKhoan taikhoan = session.find(TaiKhoan.class, tenTaiKhoan);
			tr.commit();
			return taikhoan;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public List<TaiKhoan> getDsTaiKhoan() {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			list = session.createNativeQuery("select * from TaiKhoan", TaiKhoan.class).getResultList();
			tr.commit();
			System.out.println(list);
			return list;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	public boolean xoaTaiKhoanTheoMa(String maTKCanXoa) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(TaiKhoan.class, maTKCanXoa));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}
}

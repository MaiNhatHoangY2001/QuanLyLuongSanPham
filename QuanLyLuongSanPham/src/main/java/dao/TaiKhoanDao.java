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
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
		session.close();
		return true;
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
}

package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;

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
}

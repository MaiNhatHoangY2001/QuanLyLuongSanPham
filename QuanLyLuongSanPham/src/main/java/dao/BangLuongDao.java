package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernateCfg.HibernateConfig;
import model.BangLuong;

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
		} catch (Exception e) {
			e.printStackTrace();
			tr.commit();
		}
		session.close();

		return bangLuong;

	}

	public BangLuong getBangLuongTheoMaNhanVien(String maNhanVien, int year, int month) {
		BangLuong bangLuong = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			bangLuong = session.createNativeQuery(
					"select * from BangLuong where maNhanVien = '"+maNhanVien+
					"'and YEAR(thoiGian) = "+year+" and MONTH(thoiGian) = " + month,
					BangLuong.class).getSingleResult();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return bangLuong;
	}

	public List<BangLuong> getAllBangLuong() {
		List<BangLuong> list = new ArrayList<BangLuong>();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			list = session.createNativeQuery("select * from BangLuong", BangLuong.class).getResultList();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return list;

	}
}

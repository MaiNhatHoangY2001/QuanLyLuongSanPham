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
